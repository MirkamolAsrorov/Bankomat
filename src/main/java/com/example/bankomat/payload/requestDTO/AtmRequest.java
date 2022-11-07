package com.example.bankomat.payload.requestDTO;

import com.example.bankomat.payload.AddressDto;
import com.example.bankomat.payload.BranchDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AtmRequest {
    @Null(message = "if you update object, you should write the object's id")
    private Long id;
    @Null
    private Long adminId;

    @Null
    private UserRequest newAdmin;

    @NotNull
    private AddressDto address;

}
