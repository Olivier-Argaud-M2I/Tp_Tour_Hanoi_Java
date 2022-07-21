package fr.m2i;

import fr.m2i.util.SaisieConsole;

public class MainTp6 {


    public static void main (String ...arg){


//      regle une palette a la fois
//      pas de palette plus grosse au dessus de plus petite
//      programme qui demande combien de pallette
//      indique le nombre de tour pour ressoudre le probleme
//      bonus indiquer a chaque tour ce que ca m'affiche l'action au tour par tour

//      lance une demande de saisie pour la hauteur de la tour
        SaisieConsole saisieConsole = new SaisieConsole();
        System.out.println("Veuillez saisir la hauteur de votre tour");
        Integer hauteur = saisieConsole.entier();

        new HanoiTower(hauteur);

    }
}
