package com.mycompany.tennis.controller.Controller;

import com.mycompany.tennis.core.dto.EpreuveFullDto;
import com.mycompany.tennis.core.dto.JoueurDto;
import com.mycompany.tennis.core.dto.ScoreFullDto;
import com.mycompany.tennis.core.service.MatchService;
import com.mycompany.tennis.core.dto.MatchDto;
import com.mycompany.tennis.core.repository.MatchRepositoryImpl;

import java.util.Scanner;

public class MatchController {

    private MatchService matchService;

    public MatchController(){
        this.matchService = new MatchService();
    }

    public void supprimerMatch(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Saisissez l'identifiant du match à supprimer : ");
        Long id = scanner.nextLong();
        matchService.deleteMatch(id);
    }

    public void tapisVert(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Saisissez l'identifiant du match à annuler : ");
        Long id = scanner.nextLong();
        matchService.tapisVert(id);
    }

    public void ajouterMatch(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Saisissez l'identifiant de l'épreuve : ");
        Long idEpreuve = scanner.nextLong();
        scanner.nextLine();
        System.out.println("Saisissez l'identifiant du vainqueur : ");
        Long idVainqueur = scanner.nextLong();
        scanner.nextLine();
        System.out.println("Saisissez l'identifiant du finaliste : ");
        Long idFinaliste = scanner.nextLong();
        scanner.nextLine();

        MatchDto matchDto = new MatchDto();
        matchDto.setEpreuve(new EpreuveFullDto());
        matchDto.getEpreuve().setId(idEpreuve);
        matchDto.setVainqueur(new JoueurDto());
        matchDto.getVainqueur().setId(idVainqueur);
        matchDto.setFinaliste(new JoueurDto());
        matchDto.getFinaliste().setId(idFinaliste);

        System.out.println("Saisissez la valeur du 1er set : ");
        byte set1 = scanner.nextByte();
        scanner.nextLine();
        System.out.println("Saisissez la valeur du 2ème set : ");
        byte set2 = scanner.nextByte();
        scanner.nextLine();
        System.out.println("Saisissez la valeur du 3ème set : ");
        byte set3 = scanner.nextByte();
        scanner.nextLine();
        System.out.println("Saisissez la valeur du 4ème set : ");
        byte set4 = scanner.nextByte();
        scanner.nextLine();
        System.out.println("Saisissez la valeur du 5ème set : ");
        byte set5 = scanner.nextByte();
        scanner.nextLine();

        ScoreFullDto scoreFullDto = new ScoreFullDto();
        scoreFullDto.setSet1(set1);
        scoreFullDto.setSet2(set2);
        scoreFullDto.setSet3(set3);
        scoreFullDto.setSet4(set4);
        scoreFullDto.setSet5(set5);
        matchDto.setScore(scoreFullDto);
        matchService.createMatch(matchDto);
    }

    public void afficheDetailsMatch(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Saisissez l'identifiant du match à afficher : ");
        Long id = scanner.nextLong();
        scanner.nextLine();
        MatchDto matchDto = matchService.getMatch(id);
        ScoreFullDto scoreFullDto = matchDto.getScore();
        System.out.println("Il s'agit d'un match de " + matchDto.getEpreuve().getAnnee()
                + " qui s'est déroulé à " + matchDto.getEpreuve().getTournoi().getNom()
                + ". Le vainqueur de ce match est " + matchDto.getVainqueur().getPrenom() + " " + matchDto.getVainqueur().getNom()
                + " et le finaliste est " + matchDto.getFinaliste().getPrenom() + " " + matchDto.getFinaliste().getNom());
        System.out.println("Score : ");
        System.out.println("Set 1 : " + scoreFullDto.getSet1());
        System.out.println("Set 2 : " + scoreFullDto.getSet2());
        if (scoreFullDto.getSet3() != null) {
            System.out.println("Set 3 : " + scoreFullDto.getSet3());
        }
        if (scoreFullDto.getSet4() != null) {
            System.out.println("Set 4 : " + scoreFullDto.getSet4());
        }
        if (scoreFullDto.getSet5() != null) {
            System.out.println("Set 5 : " + scoreFullDto.getSet5());
        }
    }
}
