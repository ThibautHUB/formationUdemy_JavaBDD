package com.mycompany.tennis.controller;

import com.mycompany.tennis.controller.Controller.*;
import com.mycompany.tennis.core.HibernateUtil;
import com.mycompany.tennis.core.entity.Epreuve;
import org.hibernate.Session;

public class UI {

    public static void main(String args[]){
        //testerJoueur();
        //testerTournoi();
        //testerScore();
        //testerEpreuve();
        //testerMatch();
    }

    public static void testerJoueur(){
        JoueurController joueurController = new JoueurController();
        joueurController.afficherDetailsJoueur();
        //On crée un joueur et on récupère son id
        Long idJoueurCree = joueurController.creerJoueur();
        //On supprime ce nouveau joueur grâce à l'id
        joueurController.supprimerJoueur(idJoueurCree);
        joueurController.rennomerJoueur();
        joueurController.changerSexeJoueur();
        joueurController.supprimeJoueur();
        joueurController.afficherListeJoueurs();
    }

    public static void testerTournoi(){
        TournoiController tournoiController = new TournoiController();
        //On affiche un tournoi
        tournoiController.afficherDetailsTournoi();
        //On crée un tournoi puis ol le supprime
        Long idTournoiCree = tournoiController.creerTournoi();
        tournoiController.supprimerTournoi(idTournoiCree);
        tournoiController.supprimeTournoi();
    }

    public static void testerScore(){
        ScoreController scoreController = new ScoreController();
        scoreController.afficheDetailsScore();
        scoreController.supprimerScore();
    }

    public static void testerEpreuve(){
        EpreuveController epreuveController = new EpreuveController();
        epreuveController.afficheDetaillsEpreuve();
        epreuveController.afficheRolandGarros();
    }

    public static void testerMatch(){
        MatchController matchController = new MatchController();
        matchController.afficheDetailsMatch();
        matchController.ajouterMatch();
        matchController.supprimerMatch();
    }


}
