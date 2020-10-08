package domain;

import java.util.ArrayList;
import java.util.LinkedList;

public class BrockianUltraCricketGame {
    public ArrayList<AnimalStarWars> team0 = new ArrayList<>();
    public ArrayList<AnimalStarWars> team1 = new ArrayList<>();
    public ArrayList<AnimalStarWars> team2 = new ArrayList<>();

    public void playGame(ArrayList<AnimalStarWars> listAnimal, StatePlay state){
        switch (state) {

            case Idle:
                System.out.println("in state Idle");
                //init
                this.chooseTeam(listAnimal);
                listAnimal.get(1).speak();

                break;

            case Triggered:


                break;

            case Played:
                System.out.println("in state Played");
                //attack with team;
                break;
        }
    }


    public void chooseTeam(ArrayList<AnimalStarWars> listAnimal){
        int size = listAnimal.size();
        System.out.println(size);
        listAnimal.forEach(e -> {
            //random team
            //System.out.println(e.getClass().getSimpleName());
            int temp = (Math.random() <= 0.5) ? 1 : 2;
            //choose team
            String name = e.getClass().getSimpleName();
            if(name.equals("Humans") || name.equals("Yodas") || name.equals("Wookiees")){
                e.setTeam(0);
            }else e.setTeam(temp);
        });

        //set team
        listAnimal.forEach(e -> {
            if(e.getTeam() == 0){
                team0.add(e);
            }if(e.getTeam() == 1){
                team1.add(e);
            }if(e.getTeam() == 2){
                team2.add(e);
            }
            //System.out.println(e.toString());
        });
//        list.forEach(e -> {
//            e.toString();
//            System.out.println(e.toString());
//        });
    }

    public ArrayList<AnimalStarWars> initAnimal(){
        ArrayList<AnimalStarWars> listAnimal = new ArrayList<>();
        Humans humans1 = new Humans("tuandung1",22,100,1000,100,100,0,100);
        Humans tuandung = new Humans("tuandung",23,100,1000,100,100,0,100);
        Chiss chissExample = new Chiss("chiss", 10,100,500,20,20,0);

        listAnimal.add(humans1);
        listAnimal.add(tuandung);
        listAnimal.add(chissExample);




        return listAnimal;
    }
}
