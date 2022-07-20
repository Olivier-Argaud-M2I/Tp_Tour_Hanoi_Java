package fr.m2i;

import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;

public class HanoiTower {

    Queue<Integer> tourA = new PriorityQueue<>();
    Queue<Integer> tourB = new PriorityQueue<>();
    Queue<Integer> tourC = new PriorityQueue<>();

    Integer turn = 0;

    public HanoiTower(Integer hauteur){

        init(hauteur);
        while (tourC.size()<hauteur){
            if(hauteur%2==0){
                movePaletRight();
            }else{
                movePaletLeft();
            }
            turn++;
            System.out.println(turn);
            System.out.println("tourA "+afficheTourDansLOrdre(tourA));
            System.out.println("tourB "+afficheTourDansLOrdre(tourB));
            System.out.println("tourC "+afficheTourDansLOrdre(tourC));
        }

    }

    private void init(Integer hauteur){

        for (int i=0;i<hauteur;i++){
            tourA.add(i+1);
        }
        turn = 0;

    }

    private void describe(Queue<Integer>tour){
        Queue<Integer> tampon = tour;
        while(!tampon.isEmpty()){
            System.out.println(tampon.poll());
        }
    }

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

    private String afficheTourDansLOrdre(Queue<Integer> tour){

        StringBuilder sb = new StringBuilder();
        Queue<Integer> test =  new PriorityQueue<Integer>(tour);

        while(!test.isEmpty()){
            sb.append(test.poll()).append(" ");

        }
        return sb.toString();
    }


}
