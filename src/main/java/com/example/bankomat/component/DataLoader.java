package com.example.bankomat.component;

import com.example.bankomat.model.*;
import com.example.bankomat.model.enums.CardTypes;
import com.example.bankomat.repository.*;
import com.example.bankomat.service.AtmService;
import com.example.bankomat.service.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {
    final UserRepo userRepo;
    final BankRepo bankRepo;
    final AddressRepo addressRepo;
    final CardService cardService;

    final CardRepo cardRepo;
    final AtmRepo atmRepo;

    @Value("${spring.sql.init.mode}")
    String mode;

    @Override
    public void run(String... args) throws Exception {
        if (mode.equals("always")) {
            User boss = new User();
            boss.setName("John");
            boss.setMidName("Smid");
            boss.setLastName("Adom");
            boss.setPassword("johnSmid3");
            boss.setEmail("john233@gmail.com");
            userRepo.save(boss);

            Addresses addresses = new Addresses();
            addresses.setDistrictName("New York");
            addresses.setZipCode("zz12");
            addressRepo.save(addresses);


            Bank bank = new Bank();
            bank.setName("Agro");
            bank.setAddress(addresses);
            bank.setBoss(boss);
            bankRepo.save(bank);

            Cards cards = new Cards();
            cards.setOwner(boss);
            cards.setCardNumber(Long.valueOf(cardService.random16DigitForCard(8600)));
            cards.setCvv(cardService.random3DigitForCvv());
            cards.setCardTypes(CardTypes.UZCARD);
            cards.setBranch(bank);
            cards.setPinCode(1243);
            cardRepo.save(cards);

            Atm atm = new Atm();

            User admin = new User();
            admin.setName("Kevin");
            admin.setMidName("Makkar");
            admin.setLastName("Lazer");
            admin.setPassword("kevin3242342");
            admin.setEmail("kevinL@gmail.com");
            userRepo.save(admin);

            Addresses addressForAtm = new Addresses();
            addressForAtm.setDistrictName("Wolk");
            addressForAtm.setZipCode("ss33");
            addressRepo.save(addressForAtm);

            atm.setSumBalance(AtmService.sumBalance(
                    atm.getNumberOF1000sum(),atm.getNumberOF5000sum(),atm.getNumberOF10000sum(),
                    atm.getNumberOF50000sum(),atm.getNumberOF100000sum()));
            atm.setDollarBalance(AtmService.dollarBalance(atm.getNumberOF1$(),atm.getNumberOF5$()
                    ,atm.getNumberOF10$(),atm.getNumberOF50$(),atm.getNumberOF100$()));

            atm.setBranch(bank);
            atm.setAdminForAtm(admin);
            atm.setAddress(addressForAtm);
            atmRepo.save(atm);
        }
    }
}
