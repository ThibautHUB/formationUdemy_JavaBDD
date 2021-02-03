package com.mycompany.tennis.controller.Controller;

import com.mycompany.tennis.core.dto.JoueurDto;
import com.mycompany.tennis.core.service.JoueurService;
import com.mycompany.tennis.core.entity.Joueur;

import java.util.Scanner;

public class JoueurController {

    private JoueurService joueurService;

    public JoueurController(){
        joueurService = new JoueurService();
    }

    public void afficherDetailsJoueur(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Quel est l'identifiant du joueur dont vous voulez afficher les informations ?");
        long identifiant = scanner.nextLong();
        Joueur joueur = joueurService.getJoueur(identifiant);
        System.out.println("Le joueur sélectionné s'appelle " + joueur.getPrenom() + " " + joueur.getNom());
    }

    public Long creerJoueur(){

        Joueur joueur = new Joueur();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Vous allez créer un nouveau joueur !");
        System.out.println("Entrez son nom : ");
        joueur.setNom(scanner.nextLine());
        System.out.println("Entrez son prénom : ");
        joueur.setPrenom(scanner.nextLine());
        System.out.println("Entrez son sexe (H ou F) : ");
        joueur.setSexe(scanner.nextLine().charAt(0));

        joueurService.createJoueur(joueur);
        System.out.println("Caractéristiques du joueur créé :");
        System.out.print("nom : " + joueur.getNom());
        System.out.print(", prenom : " + joueur.getPrenom());
        System.out.print(", sexe : " + joueur.getSexe());
        System.out.println(", identifiant : " + joueur.getId());
        return joueur.getId();
    }

    public void supprimerJoueur(Long id){
        joueurService.deleteJoueur(id);
        System.out.println("Le joueur d'identifiant " + id + " a été supprimé !");
    }

    public void supprimeJoueur(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Quel est l'identifiant du joueur à supprimer ?");
        Long id = sc.nextLong();
        sc.nextLine();
        joueurService.deleteJoueur(id);
        System.out.println("Le joueur d'identifiant " + id + " a été supprimé !");
    }

    public void rennomerJoueur(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Quel est l'identifiant du joueur que vous voulez renommer ?");
        long id = sc.nextLong();
        sc.nextLine();
        System.out.println("Quel est le nouveau nom ?");
        String nom = sc.nextLine();
        joueurService.renommerJoueur(id, nom);
        System.out.println("Le joueur d'identifiant " + id + " a été renommé !");
    }

    public void changerSexeJoueur(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Quel est l'identifiant du joueur dont vous voulez changer le sexe ?");
        long id = sc.nextLong();
        sc.nextLine();
        System.out.println("Quel est le nouveau sexe (H ou F) ?");
        Character sexe = sc.nextLine().charAt(0);
        joueurService.changerSexeJoueur(id, sexe);
        System.out.println("Le joueur d'identifiant " + id + " a changé de sexe !");
    }

    public void afficherListeJoueurs(){
        System.out.println("Voulez-vous une liste hommes (H) ou femmes (F)");
        Scanner sc = new Scanner(System.in);
        char sexe = sc.nextLine().charAt(0);
        for(JoueurDto joueurDto : joueurService.getListeJoueurs(sexe)){
            System.out.println(joueurDto.getPrenom() + " " + joueurDto.getNom());
        }
    }
}
