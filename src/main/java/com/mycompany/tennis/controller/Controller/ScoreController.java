package com.mycompany.tennis.controller.Controller;

import com.mycompany.tennis.core.dto.ScoreFullDto;
import com.mycompany.tennis.core.service.ScoreService;
import com.mycompany.tennis.core.entity.Score;

import java.util.Scanner;

public class ScoreController {

    private ScoreService scoreService;

    public ScoreController(){
        scoreService = new ScoreService();
    }

    public void afficheDetailsScore() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Saisissez l'identifiant du score à afficher : ");
        Long id = sc.nextLong();
        ScoreFullDto scoreFullDto = scoreService.getScore(id);
        String typeEpreuve = scoreFullDto.getMatchDto().getEpreuve().getTypeEpreuve() == 'H'? "hommes" : "femmes";
        System.out.println("Ce score a été réalisé lors d'une épreuve " + typeEpreuve + " en "
                            + scoreFullDto.getMatchDto().getEpreuve().getAnnee()
                            + " à " + scoreFullDto.getMatchDto().getEpreuve().getTournoi().getNom());
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

    public void supprimerScore(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Saisissez l'identifiant du score à supprimer : ");
        Long id = scanner.nextLong();
        scoreService.deleteScore(id);
    }
}
