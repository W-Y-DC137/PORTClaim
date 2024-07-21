package com.example.PORTClaimApp.Mapper;

import com.example.PORTClaimApp.DTO.ClientDTO;
import com.example.PORTClaimApp.DTO.ReclamationDTO;
import com.example.PORTClaimApp.Entity.Client;
import com.example.PORTClaimApp.Entity.Reclamation;
import com.example.PORTClaimApp.Service.Impl.ClientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ReclamationMapper {

    @Autowired
    private static ClientServiceImpl clientService;

    public static ReclamationDTO mapToReclamationDTO(Reclamation reclamation) {
        return new ReclamationDTO(
                reclamation.getId(),
                ClientMapper.mapToClientDTO(reclamation.getClient()),
                reclamation.getType(),
                reclamation.getTheme(),
                reclamation.getSousTheme(),
                reclamation.getUrgence(),
                reclamation.getObjet(),
                reclamation.getDescription(),
                reclamation.getPieceJointe(),
                reclamation.getDateSoumission(),
                reclamation.getStatut()
        );
    }

    public static Reclamation mapToReclamation(ReclamationDTO reclamationDto) {


        ClientDTO clientDto = reclamationDto.getClientDto();
        Client client = ClientMapper.mapToClient(clientDto);
        return new Reclamation(
                reclamationDto.getId(),
                client,
                reclamationDto.getType(),
                reclamationDto.getTheme(),
                reclamationDto.getSousTheme(),
                reclamationDto.getUrgence(),
                reclamationDto.getObjet(),
                reclamationDto.getDescription(),
                reclamationDto.getPieceJointe(),
                reclamationDto.getDateSoumission(),
                reclamationDto.getStatut()
        );
    }
}
