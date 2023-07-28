package com.realestate.services.impl;

import com.realestate.entities.ClientReg;
import com.realestate.payload.ClientRegDto;
import com.realestate.repositories.ClientRegRepository;
import com.realestate.services.ClientRegService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class ClientRegServiceImpl implements ClientRegService {

    private PasswordEncoder passwordEncoder;
    private ClientRegRepository clientRegRepository;

    public ClientRegServiceImpl(PasswordEncoder passwordEncoder, ClientRegRepository clientRegRepository) {
        this.passwordEncoder = passwordEncoder;
        this.clientRegRepository = clientRegRepository;
    }

    @Override
    public void saveUser(ClientRegDto clientRegDto) {
        ClientReg client = mapToEntity(clientRegDto);
        clientRegRepository.save(client);
    }

    ClientReg mapToEntity(ClientRegDto clientRegDto){
        ClientReg client = new ClientReg();
        client.setClientAddress(clientRegDto.getClientAddress());
        client.setClientName(clientRegDto.getClientName());
        client.setGender(clientRegDto.getGender());
        client.setEmail(clientRegDto.getEmail());
        client.setPhoneNumber(clientRegDto.getPhoneNumber());
        client.setUsername(clientRegDto.getUsername());
        client.setPassword(passwordEncoder.encode(clientRegDto.getPassword()));
        return client;
    }
}
