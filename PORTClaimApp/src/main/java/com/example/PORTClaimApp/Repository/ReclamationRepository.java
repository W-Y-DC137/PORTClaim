package com.example.PORTClaimApp.Repository;

import com.example.PORTClaimApp.DTO.ReclamationDTO;
import com.example.PORTClaimApp.Entity.Reclamation;
import com.example.PORTClaimApp.Enums.StatutDemande;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReclamationRepository extends JpaRepository<Reclamation,Long> {
    List<Reclamation> findByClient_Id(Long clientId);

    // Méthode pour compter les réclamations par statut
    long countByStatut(StatutDemande statut);
}
