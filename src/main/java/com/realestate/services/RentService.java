package com.realestate.services;

import com.realestate.entities.Rent;

import java.util.List;

public interface RentService {

        List<Rent> getAllRents();

        Rent getRentById(Long id);

        Rent saveRent(Rent rent);

        void deleteRentById(Long id);

}
