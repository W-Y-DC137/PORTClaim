package com.example.PORTClaimApp.Entity;

import com.example.PORTClaimApp.Enums.NiveauUrgence;
import com.example.PORTClaimApp.Enums.StatutDemande;
import com.example.PORTClaimApp.Enums.TypeDemande;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Reclamation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @Enumerated(EnumType.STRING)
    private TypeDemande type; // Enum: DEMANDE, RECLAMATION

    private String theme;
    private String sousTheme;

    @Enumerated(EnumType.STRING)
    private NiveauUrgence urgence; // Enum: FAIBLE, MOYEN, ELEVE

    private String objet;

    @Column(length = 1000)
    private String description;

    private String pieceJointe; // Vous pouvez stocker le chemin du fichier ou utiliser un type plus approprié pour les fichiers

    @Temporal(TemporalType.TIMESTAMP)
    private Date dateSoumission;

    @Enumerated(EnumType.STRING)
    private StatutDemande statut; // Enum: NOUVEAU, EN_COURS, EN_ATTENTE, RESOLU, CLOTURE
}

