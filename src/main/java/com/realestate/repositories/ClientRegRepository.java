package com.realestate.repositories;

import com.realestate.entities.ClientReg;
import com.realestate.entities.Sale;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRegRepository extends JpaRepository<ClientReg,Long> {
    Sale findByClientId(Long clientId);
}
