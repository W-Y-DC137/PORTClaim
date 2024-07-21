package com.example.PORTClaimApp.Controller;

import com.example.PORTClaimApp.DTO.ClientDTO;
import com.example.PORTClaimApp.Service.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
//import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/clients")
public class ClientController {
    private ClientService clientService;

    //Create Client REST API .
    @PostMapping
    public ResponseEntity<ClientDTO> createClient(@RequestBody ClientDTO clientDto){
        ClientDTO savedClient =  clientService.createClient(clientDto);
        return new ResponseEntity<>(savedClient, HttpStatus.CREATED);
    }

    //Get Client REST API .
    @GetMapping("{id}")
    public ResponseEntity<ClientDTO> getClientById(@PathVariable("id") Long clientId){
        ClientDTO clientDto = clientService.getClientById(clientId);
        return ResponseEntity.ok(clientDto);
    }

    //Get All Clients REST API .
    @GetMapping
    public ResponseEntity<List<ClientDTO>> getAllClients(){
        List<ClientDTO> clients = clientService.getAllClients();
        return ResponseEntity.ok(clients);
    }

    //Update Client REST API .
    @PutMapping("{id}")
    public ResponseEntity<ClientDTO> updateClient(@PathVariable("id") Long clientId , @RequestBody ClientDTO updatedClient){
        ClientDTO clientDto = clientService.updateClient(clientId,updatedClient);
        return ResponseEntity.ok(clientDto);
    }

    //Delete Client REST API .
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteClient(@PathVariable("id") Long clientId){
        clientService.deleteClient(clientId);
        return ResponseEntity.ok("Client suprimé avec succé");
    }




}
