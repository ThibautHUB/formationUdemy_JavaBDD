package com.mycompany.tennis.controller.Controller;

import com.mycompany.tennis.core.service.TournoiService;
import com.mycompany.tennis.core.dto.TournoiDto;
import com.mycompany.tennis.core.entity.Tournoi;

import java.util.Scanner;

public class TournoiController {

    TournoiService tournoiService;

    public TournoiController(){
        tournoiService = new TournoiService();
    }

    public void afficherDetailsTournoi(){

        Scanner scanner = new Scanner(System.in);
        System.out.println("Veuillez entrer l'identifiant du tournoi à afficher : ");
        Long idTournoi = scanner.nextLong();

        TournoiDto tournoiDto = tournoiService.getTournoi(idTournoi);
        System.out.println("Ce tournoi est appellé " + tournoiDto.getNom() +" et a pour code : " + tournoiDto.getCode());
    }

    public Long creerTournoi(){
        TournoiDto tournoi = new TournoiDto();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Vous allez créer un nouveau tournoi. Entrez le nom du tournoi : ");
        tournoi.setNom(scanner.nextLine());
        System.out.println("Entrez le code du tournoi : ");
        tournoi.setCode(scanner.nextLine());

        tournoiService.createTournoi(tournoi);
        System.out.println("Caractéristiques du tournoi créé :");
        System.out.print("nom : " + tournoi.getNom());
        System.out.print(", code : " + tournoi.getCode());
        System.out.println(", identifiant : " + tournoi.getId());
        return tournoi.getId();
    }

    public void supprimerTournoi(Long id){
        tournoiService.deleteTournoi(id);
        System.out.println("Le tournoi d'identifiant " + id + " a été supprimé !");
    }

    public void supprimeTournoi(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Quel est l'identifiant du tournoi à supprimer ?");
        Long id = sc.nextLong();
        sc.nextLine();
        tournoiService.deleteTournoi(id);
        System.out.println("Le tournoi d'identifiant " + id + " a été supprimé !");
    }
}
