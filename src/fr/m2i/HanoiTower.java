package fr.m2i;

import java.util.PriorityQueue;
import java.util.Queue;

public class HanoiTower {

    /**
     * Declaration de trois PriorityQueue representant nos trois tours
     * et d'un Integer turn comptabilsant le nombre de tour de jeux
     */
    Queue<Integer> tourA = new PriorityQueue<>();
    Queue<Integer> tourB = new PriorityQueue<>();
    Queue<Integer> tourC = new PriorityQueue<>();

    Integer turn = 0;

    public HanoiTower(Integer hauteur){

        // on initialise le jeux en remplissant la tour A et en mettant le compteur de tour de jeux a zero
        init(hauteur);
        // tant que la tour C n'est pas pleine on continu la boucle
        while (tourC.size()<hauteur){
            // si la hauteur de la tour est paire on deplacera les palets vers la droite A->B->C->A
            if(hauteur%2==0){
                movePaletRight();
            }
            // sinon on deplacera les palets vers la gauche A->C->B->A
            else{
                movePaletLeft();
            }
            // on incremente le nombre de tour de jeux
            turn++;
            // on affiche l'etat du jeux
            System.out.println(turn);
            System.out.println("tourA "+afficheTourDansLOrdre(tourA));
            System.out.println("tourB "+afficheTourDansLOrdre(tourB));
            System.out.println("tourC "+afficheTourDansLOrdre(tourC));
        }

    }

    /**
     * Methode pour initialiser le jeux en fonction de la hauteur
     * @param hauteur
     */
    private void init(Integer hauteur){

        for (int i=0;i<hauteur;i++){
            tourA.add(i+1);
        }
        turn = 0;

    }

    /**
     * methode pour deplacer les palets vers la gauche
     */
    private void movePaletLeft(){

        if (turn % 2 == 0){
            Queue<Integer> tour1 = findTower();
            if (tour1.equals(tourA)){
                tourC.add(tourA.poll());
            }
            if (tour1.equals(tourB)){
                tourA.add(tourB.poll());
            }
            if (tour1.equals(tourC)){
                tourB.add(tourC.poll());
            }
        }
        else{

            Queue<Integer> tour = findTowerWithLowestPalet();

            if (tour.equals(tourA)){
                if(tourC.peek()==null || tour.peek()<tourC.peek()){
                    tourC.add(tourA.poll());
                }
                else{
                    tourB.add(tourA.poll());
                }
            }

            if (tour.equals(tourB)){
                if(tourA.peek()==null || tour.peek()<tourA.peek()){
                    tourA.add(tourB.poll());
                }
                else{
                    tourC.add(tourB.poll());
                }
            }

            if (tour.equals(tourC)){
                if(tourB.peek()==null || tour.peek()<tourB.peek()){
                    tourB.add(tourC.poll());
                }
                else{
                    tourA.add(tourC.poll());
                }
            }

        }

    }

    /**
     * methode pour deplacer les palets vers la droite
     */
    private void movePaletRight(){
        if (turn % 2 == 0){
            Queue<Integer> tour1 = findTower();
            if (tour1.equals(tourA)){
                tourB.add(tourA.poll());
            }
            if (tour1.equals(tourB)){
                tourC.add(tourB.poll());
            }
            if (tour1.equals(tourC)){
                tourA.add(tourC.poll());
            }
        }
        else{

            Queue<Integer> tour = findTowerWithLowestPalet();

            if (tour.equals(tourA)){
                if(tourB.peek()==null || tour.peek()<tourB.peek()){
                    tourB.add(tourA.poll());
                }
                else{
                    tourC.add(tourA.poll());
                }
            }

            if (tour.equals(tourB)){
                if(tourC.peek()==null || tour.peek()<tourC.peek()){
                    tourC.add(tourB.poll());
                }
                else{
                    tourA.add(tourB.poll());
                }
            }

            if (tour.equals(tourC)){
                if(tourA.peek()==null || tour.peek()<tourA.peek()){
                    tourA.add(tourC.poll());
                }
                else{
                    tourB.add(tourC.poll());
                }
            }

        }

    }

    /**
     * methode qui renvoi la tour dans laquelle ce situe le palet 1
     * @return la tour ciblé
     */
    private Queue<Integer> findTower(){

        if(tourA.contains(1)){
            return tourA;
        }

        if(tourB.contains(1)){
            return tourB;
        }

        if(tourC.contains(1)){
            return tourC;
        }
        return null;
    }

    /**
     * methode qui renvoi la tour avec le plus petit palet disponible (hors palet 1)
     * @return
     */
    private Queue<Integer> findTowerWithLowestPalet(){
        Integer number = 2;
        Queue<Integer> tourSelection;
        while (true){
            tourSelection = testTowerWithLowestPalet(number);
            number++;
            if(tourSelection!=null){
                return tourSelection;
            }
        }
    }

    /**
     * Cherche la tour avec le palet numero palet et la renvoi si ce palet est bien en haut de la tour
     * sinon renvoi null
     * @param palet valeur du palet a rechercher
     * @return la tour dans laquelle se situe le palet si ce dernier est au sommet sinon renvoi null
     */
    private Queue<Integer> testTowerWithLowestPalet(Integer palet){

        if(tourA.contains(palet) && tourA.peek()==palet){
            return tourA;
        }

        if(tourB.contains(palet) && tourB.peek()==palet){
            return tourB;
        }

        if(tourC.contains(palet) && tourC.peek()==palet){
            return tourC;
        }
        return null;
    }

    /**
     * methode qui renvoi un string de la tour avec les palets trié
     * @param tour la tour a renvoyer
     * @return
     */
    private String afficheTourDansLOrdre(Queue<Integer> tour){

        StringBuilder sb = new StringBuilder();
        Queue<Integer> test =  new PriorityQueue<Integer>(tour);

        while(!test.isEmpty()){
            sb.append(test.poll()).append(" ");
        }
        return sb.toString();
    }


}
