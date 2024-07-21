package com.example.PORTClaimApp.Mapper;

import com.example.PORTClaimApp.DTO.ClientDTO;
import com.example.PORTClaimApp.Entity.Client;

public class ClientMapper {
    public static ClientDTO mapToClientDTO(Client client){
        return new ClientDTO(
                client.getId(),
                client.getUsername(),
                client.getPassword()
        );
    }

    public static Client mapToClient(ClientDTO clientDto){
        return new Client(
                clientDto.getId(),
                clientDto.getUsername(),
                clientDto.getPassword()
        );
    }
}
