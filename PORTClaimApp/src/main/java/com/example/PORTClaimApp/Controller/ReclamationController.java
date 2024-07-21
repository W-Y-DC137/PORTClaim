package com.example.PORTClaimApp.Controller;

import com.example.PORTClaimApp.DTO.ReclamationDTO;
import com.example.PORTClaimApp.Enums.StatutDemande;
import com.example.PORTClaimApp.Service.ReclamationService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@AllArgsConstructor
@RestController
@RequestMapping("/api/reclamations")
public class ReclamationController {

    private final ReclamationService reclamationService;

    // Create Reclamation REST API.
    @PostMapping
    public ResponseEntity<ReclamationDTO> createReclamation(@RequestBody ReclamationDTO reclamationDto) {
        ReclamationDTO savedReclamation = reclamationService.creerReclamation(reclamationDto);
        return new ResponseEntity<>(savedReclamation, HttpStatus.CREATED);
    }

    // Get Reclamation by ID REST API.
    @GetMapping("{id}")
    public ResponseEntity<ReclamationDTO> getReclamationById(@PathVariable("id") Long reclamationId) {
        ReclamationDTO reclamationDto = reclamationService.getReclamationById(reclamationId);
        return ResponseEntity.ok(reclamationDto);
    }

    // Get All Reclamations REST API.
    @GetMapping
    public ResponseEntity<List<ReclamationDTO>> getAllReclamations() {
        List<ReclamationDTO> reclamations = reclamationService.getToutesReclamations();
        return ResponseEntity.ok(reclamations);
    }

    // Update Reclamation REST API.
    @PutMapping("{id}")
    public ResponseEntity<ReclamationDTO> updateReclamation(@PathVariable("id") Long reclamationId,
                                                            @RequestBody ReclamationDTO updatedReclamation) {
        ReclamationDTO reclamationDto = reclamationService.mettreAJourReclamation(reclamationId, updatedReclamation);
        return ResponseEntity.ok(reclamationDto);
    }

    // Delete Reclamation REST API.
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteReclamation(@PathVariable("id") Long reclamationId) {
        reclamationService.supprimerReclamation(reclamationId);
        return ResponseEntity.ok("Réclamation supprimée avec succès");
    }

}