package com.realestate.services.impl;

import com.realestate.entities.Rent;
import com.realestate.exception.ResourceNotFoundException;
import com.realestate.repositories.RentRepository;
import com.realestate.services.RentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentServiceImpl implements RentService {

        private RentRepository rentRepository;

        @Autowired
        public RentServiceImpl(RentRepository rentRepository) {
            this.rentRepository = rentRepository;
        }

        @Override
        public List<Rent> getAllRents() {
            return rentRepository.findAll();
        }

        @Override
        public Rent getRentById(Long id) {
            Rent rent = rentRepository.findById(id).orElseThrow(() ->
                    new ResourceNotFoundException("Rent", "id", id));
            return rent;
        }

        @Override
        public Rent saveRent(Rent rent) {
            return rentRepository.save(rent);
        }

        @Override
        public void deleteRentById(Long id) {
            rentRepository.findById(id).orElseThrow(() ->
                    new ResourceNotFoundException("Rent", "id", id));
            rentRepository.deleteById(id);
        }

}
