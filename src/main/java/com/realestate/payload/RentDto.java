package com.realestate.payload;

import com.realestate.entities.ClientReg;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class RentDto {
    private Long rentId;
    private Date rentStartDate;
    private Date rentEndDate;
    private BigDecimal rentPrice;


}
