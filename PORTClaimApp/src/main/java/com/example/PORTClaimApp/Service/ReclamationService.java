package com.example.PORTClaimApp.Service;

import com.example.PORTClaimApp.DTO.ReclamationDTO;
import com.example.PORTClaimApp.Entity.Reclamation;
import com.example.PORTClaimApp.Enums.StatutDemande;

import java.util.List;
import java.util.Map;

public interface ReclamationService {
    ReclamationDTO creerReclamation(ReclamationDTO reclamationDto);
    ReclamationDTO mettreAJourReclamation(Long reclamationId, ReclamationDTO reclamationDto);
    ReclamationDTO getReclamationById(Long reclamationId);
    void supprimerReclamation(Long reclamationId);
    List<ReclamationDTO> getReclamationsParClient(Long clientId);
    List<ReclamationDTO> getToutesReclamations();
    /*List<Reclamation> rechercherReclamations(Map<String, Object> criteres);
    Reclamation mettreAJourStatut(Long id, StatutDemande statut);
    Map<String, Long> getStatistiquesTableauDeBord();*/
}
