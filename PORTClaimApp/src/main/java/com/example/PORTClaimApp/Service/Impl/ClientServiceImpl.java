package com.example.PORTClaimApp.Service.Impl;

import com.example.PORTClaimApp.DTO.ClientDTO;
import com.example.PORTClaimApp.Exception.RessourceNotFoundException;
import com.example.PORTClaimApp.Mapper.ClientMapper;
import com.example.PORTClaimApp.Repository.ClientRepository;
import com.example.PORTClaimApp.Service.ClientService;
import com.example.PORTClaimApp.Entity.Client;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ClientServiceImpl implements ClientService {


    private ClientRepository clientRepository;

    @Override
    public ClientDTO createClient(ClientDTO clientDto) {
        Client client = ClientMapper.mapToClient(clientDto);
        Client savedClient = clientRepository.save(client);
        return ClientMapper.mapToClientDTO(savedClient);
    }

    @Override
    public ClientDTO getClientById(Long ClientId) {
       Client client = clientRepository.findById(ClientId)
                .orElseThrow(() ->
                         new RessourceNotFoundException("Client non trouvé avec l'id"+ClientId));
       return ClientMapper.mapToClientDTO(client);
    }

    @Override
    public List<ClientDTO> getAllClients() {
        List<Client> clients = clientRepository.findAll();

        return clients.stream().map((client) -> ClientMapper.mapToClientDTO(client))
                .collect(Collectors.toList())
                ;
    }

    @Override
    public ClientDTO updateClient(Long clientId, ClientDTO updatedClient) {

        Client client = clientRepository.findById(clientId).orElseThrow(
                () -> new RessourceNotFoundException("Client non trouvé avec l'id"+clientId)
        );
        client.setUsername(updatedClient.getUsername());
        client.setPassword(updatedClient.getPassword());

        Client updatedClientObj = clientRepository.save(client);

        return ClientMapper.mapToClientDTO(updatedClientObj);
    }

    @Override
    public void deleteClient(Long clientId) {
        Client client = clientRepository.findById(clientId).orElseThrow(
                () -> new RessourceNotFoundException("Client non trouvé avec l'id"+clientId)
        );
        clientRepository.deleteById(clientId);
    }
}
