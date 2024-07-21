package com.example.PORTClaimApp.DTO;

import com.example.PORTClaimApp.Enums.NiveauUrgence;
import com.example.PORTClaimApp.Enums.StatutDemande;
import com.example.PORTClaimApp.Enums.TypeDemande;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ReclamationDTO {
    private Long id;
    private ClientDTO clientDto; // Assuming you want to transfer only the client ID and not the entire Client object
    private TypeDemande type; // Enum: DEMANDE, RECLAMATION
    private String theme;
    private String sousTheme;
    private NiveauUrgence urgence; // Enum: FAIBLE, MOYEN, ELEVE
    private String objet;
    private String description;
    private String pieceJointe; // You can store the file path or use a more appropriate type
    private Date dateSoumission;
    private StatutDemande statut; // Enum: NOUVEAU, EN_COURS, EN_ATTENTE, RESOLU, CLOTURE
}
