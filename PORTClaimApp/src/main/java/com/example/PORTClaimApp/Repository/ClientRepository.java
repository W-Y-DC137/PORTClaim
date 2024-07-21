package com.example.PORTClaimApp.Repository;

import com.example.PORTClaimApp.Entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client,Long> {

}
