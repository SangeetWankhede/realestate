package com.realestate.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "rent")
public class Rent {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long rentId;

        @Temporal(TemporalType.DATE)
        @Column(name = "rent_start_date")
        private Date rentStartDate;

        @Temporal(TemporalType.DATE)
        @Column(name = "rent_end_date")
        private Date rentEndDate;

        @Column(name = "rent_price")
        private BigDecimal rentPrice;

        @OneToOne
        @JoinColumn(name = "client_id")
        private ClientReg clientReg;
}
