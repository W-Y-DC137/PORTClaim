package com.example.PORTClaimApp.Service.Impl;

import com.example.PORTClaimApp.DTO.ReclamationDTO;
import com.example.PORTClaimApp.Entity.Reclamation;
import com.example.PORTClaimApp.Enums.StatutDemande;
import com.example.PORTClaimApp.Exception.RessourceNotFoundException;
import com.example.PORTClaimApp.Mapper.ReclamationMapper;
import com.example.PORTClaimApp.Repository.ReclamationRepository;
import com.example.PORTClaimApp.Service.ReclamationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ReclamationServiceImpl implements ReclamationService {

    private ReclamationRepository reclamationRepository;
    @Override
    public ReclamationDTO creerReclamation(ReclamationDTO reclamationDto) {
        Reclamation reclamation = ReclamationMapper.mapToReclamation(reclamationDto);
        Reclamation savedReclamation = reclamationRepository.save(reclamation);
        return ReclamationMapper.mapToReclamationDTO(savedReclamation);

    }

    @Override
    public ReclamationDTO mettreAJourReclamation(Long reclamationId, ReclamationDTO updatedReclamation) {
        Reclamation reclamation =reclamationRepository.findById(reclamationId)
                .orElseThrow(()-> new RessourceNotFoundException("Réclamation non trouvé avec l'id"+reclamationId));
        reclamation.setType(updatedReclamation.getType());
        reclamation.setTheme(updatedReclamation.getTheme());
        reclamation.setSousTheme(updatedReclamation.getSousTheme());
        reclamation.setUrgence(updatedReclamation.getUrgence());
        reclamation.setObjet(updatedReclamation.getObjet());
        reclamation.setDescription(updatedReclamation.getDescription());
        reclamation.setPieceJointe(updatedReclamation.getPieceJointe());
        reclamation.setStatut(updatedReclamation.getStatut());
        reclamation.setDateSoumission(updatedReclamation.getDateSoumission());
        Reclamation updatedReclamationObj = reclamationRepository.save(reclamation);
        return ReclamationMapper.mapToReclamationDTO(updatedReclamationObj);
    }

    @Override
    public ReclamationDTO getReclamationById(Long reclamationId) {
        Reclamation reclamation = reclamationRepository.findById(reclamationId)
                .orElseThrow(()-> new RessourceNotFoundException("Réclamation non trouvé avec l'id"+reclamationId));
        return ReclamationMapper.mapToReclamationDTO(reclamation);
    }

    @Override
    public void supprimerReclamation(Long reclamationId) {
        Reclamation reclamation = reclamationRepository.findById(reclamationId)
                .orElseThrow(()-> new RessourceNotFoundException("Réclamation non trouvé avec l'id"+reclamationId));
        reclamationRepository.deleteById(reclamationId);
    }

    @Override
    public List<ReclamationDTO> getReclamationsParClient(Long clientId) {
        List<Reclamation> reclamations = reclamationRepository.findByClient_Id(clientId);
        return reclamations.stream().map((reclamation) ->
                ReclamationMapper.mapToReclamationDTO(reclamation))
        .collect(Collectors.toList());
    }

    @Override
    public List<ReclamationDTO> getToutesReclamations() {
        List<Reclamation> reclamations = reclamationRepository.findAll();
        return reclamations.stream().map((reclamation) ->ReclamationMapper.mapToReclamationDTO(reclamation))
                .collect(Collectors.toList());
    }

    /*@Override
    public List<Reclamation> rechercherReclamations(Map<String, Object> criteres) {
        return null;
    }

    @Override
    public Reclamation mettreAJourStatut(Long id, StatutDemande statut) {
        return null;
    }

    @Override
    public Map<String, Long> getStatistiquesTableauDeBord() {
        return null;
    }*/
}
