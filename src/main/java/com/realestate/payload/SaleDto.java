package com.realestate.payload;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.realestate.entities.ClientReg;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor

public class SaleDto {

    private Long clientId;

//    @NotNull(message = "Agent ID is required")
    private Long agentId;

//    @NotNull(message = "Property ID is required")
    private Long propertyId;

    @JsonFormat( pattern = "yyyy-MM-dd")
//    @NotNull(message = "Sale date is required")shape = JsonFormat.Shape.STRING,
    private Date saleDate;
    private ClientReg clientReg;
}

