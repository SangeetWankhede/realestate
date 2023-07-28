package com.realestate.controller;

import com.realestate.payload.ClientRegDto;
import com.realestate.services.ClientRegService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/clientreg")
public class ClientRegController {

    private ClientRegService clientRegService;

    public ClientRegController(ClientRegService clientRegService) {
        this.clientRegService = clientRegService;
    }

    //http://localhost:8080/api/clientreg/create
    @PostMapping("/create")
    public ResponseEntity<String> createClientReg(@RequestBody ClientRegDto clientRegDto) {

        clientRegService.saveUser(clientRegDto);

        return new ResponseEntity<>("user created successfully",HttpStatus.OK);
    }
}










//    ClientReg clientReg = new ClientReg();
//        clientReg.setClientName(clientRegDto.getClientName());
//        clientReg.setClientAddress(clientRegDto.getClientAddress());
//        clientReg.setPhoneNumber(clientRegDto.getPhoneNumber());
//        clientReg.setEmail(clientRegDto.getEmail());
//        clientReg.setGender(clientRegDto.getGender());
//        clientReg.setUsername(clientRegDto.getUsername());
//        String encodedPassword = passwordEncoder.encode(clientRegDto.getPassword());
//        clientReg.setPassword(encodedPassword);
//        clientRegService.createClientReg(clientReg);