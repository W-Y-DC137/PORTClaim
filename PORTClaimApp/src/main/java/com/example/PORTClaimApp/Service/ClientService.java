package com.example.PORTClaimApp.Service;

import com.example.PORTClaimApp.DTO.ClientDTO;

import java.util.List;

public interface ClientService {
    ClientDTO createClient(ClientDTO clientDto);

    ClientDTO getClientById(Long clientId);

    List<ClientDTO> getAllClients();

    ClientDTO  updateClient(Long clientId , ClientDTO updatedClient);

    void deleteClient(Long clientId);
}
