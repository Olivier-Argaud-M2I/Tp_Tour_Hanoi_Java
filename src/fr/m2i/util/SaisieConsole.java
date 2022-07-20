package fr.m2i.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SaisieConsole {

    private BufferedReader buff = null;

    private BufferedReader getBuff() {
        return buff;
    }

    private void setBuff(BufferedReader buff) {
        this.buff = buff;
    }

    public SaisieConsole(){
        if(this.getBuff() ==null){
            this.setBuff(new BufferedReader(new InputStreamReader(System.in)));
        }
    }

    /**
     *
     * @return l'entier saisie ou null si la saisie n'est pas valide
     */
    public Integer entier(){
        try
        {
            return  Integer.parseInt(this.getBuff().readLine());
        }
        catch (NumberFormatException e)
        {
//            Affichage.formatLigne("Veuillez saisir un nombre entre -2 147 483 648 et 2 147 483 647");
        }
        catch (IOException e){
//            Affichage.formatLigne("Erreur entrée");
        }
        return null;
    }

    /**
     *
     * @return un Character ou null si la saisie n'est pas valide
     */
    public Character YesOrNo(){
        try
        {
            return  this.getBuff().readLine().charAt(0);
        }
        catch (IOException e){
            Affichage.formatLigne("Erreur entrée");
        }
        return null;
    }

    /**
     *
     * @return un string ou null si la saisie n'est pas valide
     */
    public String text(){
        try
        {
            return  this.getBuff().readLine();
        }
        catch (IOException e){
//            Affichage.formatLigne("Erreur entrée");
        }
        return null;
    }

}
