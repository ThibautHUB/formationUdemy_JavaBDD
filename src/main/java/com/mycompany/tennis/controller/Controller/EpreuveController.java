package com.mycompany.tennis.controller.Controller;

import com.mycompany.tennis.core.dto.JoueurDto;
import com.mycompany.tennis.core.service.EpreuveService;
import com.mycompany.tennis.core.dto.EpreuveFullDto;
import com.mycompany.tennis.core.dto.EpreuveLightDto;
import com.mycompany.tennis.core.entity.Epreuve;
import com.mycompany.tennis.core.entity.Tournoi;

import java.util.Scanner;

public class EpreuveController {

    private EpreuveService epreuveService;

    public EpreuveController(){
        epreuveService = new EpreuveService();
    }

    public void afficheDetaillsEpreuve(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Veuillez entrer l'identifiant de l'épreuve à afficher : ");
        Long idEpreuve = scanner.nextLong();
        EpreuveFullDto epreuve = epreuveService.getEpreuveDetaillee(idEpreuve);
        System.out.println("Cette epreuve se déroule en " + epreuve.getAnnee() +
                " et il s'agit du tournoi " + epreuve.getTournoi().getNom());
        System.out.println("Voici les participants de l'épreuve : ");
        for(JoueurDto joueurDto : epreuve.getParticipants()){
            System.out.println(joueurDto.getPrenom() + " " + joueurDto.getNom());
        }
    }

    public void afficheRolandGarros(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Veuillez entrer l'identifiant de l'épreuve à afficher : ");
        Long idEpreuve = scanner.nextLong();
        EpreuveLightDto epreuve = epreuveService.getEpreuveSansTournoi(idEpreuve);
        System.out.println("Cette epreuve se déroule en " + epreuve.getAnnee());
    }

}
