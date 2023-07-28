package com.realestate.services.impl;

import com.realestate.entities.ClientReg;
import com.realestate.entities.Sale;
import com.realestate.payload.SaleDto;
import com.realestate.repositories.ClientRegRepository;
import com.realestate.repositories.SaleRepository;
import com.realestate.services.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Date;

@Service
public class SaleServiceImpl implements SaleService {

    @Autowired
    private SaleRepository saleRepository;
    @Autowired
    private ClientRegRepository clientRegRepository;

    @Autowired
    public SaleServiceImpl(SaleRepository saleRepository, ClientRegRepository clientRegRepository) {
        this.saleRepository = saleRepository;
        this.clientRegRepository = clientRegRepository;
    }

    @Override
    public SaleDto saveSale(SaleDto saleDto) {
        ClientReg clientReg = clientRegRepository.findById(saleDto.getClientId())
                .orElseThrow(() -> new EntityNotFoundException("Client Not Found with id " + saleDto.getClientId()));


        Sale sale = new Sale();
        sale.setClientId(sale.getClientId());

        sale.setClientReg(clientReg);
        sale.setAgentId(saleDto.getAgentId());
        sale.setSaleDate(saleDto.getSaleDate());

        Sale savedSale = saleRepository.save(sale);


        SaleDto dto = new SaleDto();
        dto.setClientReg(clientReg);
        dto.setAgentId(saleDto.getAgentId());
        dto.setSaleDate(savedSale.getSaleDate());

        return dto;

    }
}
//!= null ? saleDto.getSaleDate() : new Date()
