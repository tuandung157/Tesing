package domain;

import java.util.LinkedList;

public class BrockianUltraCricketGame {

    public void playGame(){

    }
    public void chooseTeam(LinkedList<AnimalStarWars> objectList){

    }

    public LinkedList<AnimalStarWars> initAnimal(){
        LinkedList<AnimalStarWars> listAnimal = new LinkedList<>();
        Humans humans1 = new Humans("tuandung",23,100,1000,100,100,100);
        listAnimal.add(humans1);
        System.out.println(listAnimal.toArray());
        return listAnimal;
    }
}
