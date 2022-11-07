# ATM
### 1. CARD
Har bir card ning:
maxsus 16 xonali raqami;
Qaysi bankka tegishli ekanligi
3 xonali CVV code
Mijozning familya va ismi
card ning amal qilish muddati
4 xonali maxsus paroli
Plastik turi (HUMO, UZCARD, VISA)
Agar cardning amal qilish muddati tugagan bo’lsa undan foydalana olmaslik kerak. Aktivlashtirish uchun bank oficedagi mas’ul bu ishni qila oladi.
<br />
### 2. Security
1. CREATE JWT FOR ADMIN AND BOSS
2. SECURITY FOR CARD
<br />

### 3. BANKOMAT
<br />

Bankomatda quyidagi xususiyatlari bo’ladi:
1.  Qanday turdagi card lar uchun mo’ljallanganligi (UZCARD, HUMO, VISA)
2.  Yechiladigan max pul miqdori (Bu bank tomonidan o’rnatiladi. Bank tomonidan har bir bankomat uchun alohida yoki hamma bankomalatlar uchun bir-xil qo’yilishi mumkin)
3.  Pul yechayotgan card bankomatni o’rnatgan bankga tegishli bo’lsa pul yechayotgandagi commission miqdori va card hisobi to’ldirilayotgandagi comission miqdori
4.  Pul yechayotgan card bankomatni o’rnatgan bankga tegishli bo’lmasa pul yechayotgandagi commission miqdori va card hisobi to’ldirilayotgandagi comission miqdori
5.  Bankomat joylashgan manzil
6.  Bankomatda mablag’lar kupyuralar bo’yicha turadi (1000 so’mlik, 5000 so’mlik, 10 000 so’mlik, 50 000 ming so’mlik, 100 000 ming so’mlik, 1$, 5$, 10$, 20$, 50$,100$  kabi alohida qutilarda saqlanadi).
7.  Mijoz pul bankomatda har qanday amal bajarishidan oldin cardning pin kodini kiritadi. Agar parol va login to’g’ri bo’lsa, card sistemaga “Basic” authentication orqali kiradi. Login card ning 16 xonali raqami hisoblanadi, uni bankomatni o’zi o’qib oladi, parol card ning pin kodi hisoblanadi.
8.  Mijozga pul berilganda qaysi kupyuradan nechi dona berilganligi, card hisobi to’ldirilganda esa qaysi kupyuradan nechta solinganligi saqlanib boriladi.
9.  Bankda bankomatlarni hisobini haqiqatan real naqd pul bilan to’ldiriladi va sistemaga bu haqida ma’lumot kiritadi. Ya’ni bankomat hisobi to’ldirildi deb. Bu jarayon uchun mas’ul xodim biriktiriladi. Bunda qaysi kupyuradan nechta solinganligi kiritiladi.
10. Agar pul yechish jarayonida card ning pin kodi 2 martadan ortiq noto’g’ri kiritilsa card block holatiga o’tkaziladi va card ning egasini bank officega borib bu blokdan chiqaradi.
11. Agar mijoz yechmoqchi bo’lgan summa kupyuralar bo’yicha hisob-kitob qilinganda bunday miqdorda kupyura chiqmasa, mijzoga bu haqida xabar qaytarishi kerak.
12. Agar mijoz cardni to’ldirmoqchi bo’lganda, kiritgan kupyurasi uchun bankomatda bunday kupyura qutisi bo’lmasa, mijzoga bu haqida xabar qaytarishi kerak va kupyura mijozga qaytariladi.
