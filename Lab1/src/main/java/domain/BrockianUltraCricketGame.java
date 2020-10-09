package domain;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

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
                //talk
                this.conversation(listAnimal);
                break;

            case Triggered:
                System.out.println("in state Triggered");

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
        Humans tuandung = new Humans("tuandung",23,100,1000,200,100,0,100);
        Chiss chissExample = new Chiss("chiss", 10,100,500,20,20,0);

        listAnimal.add(humans1);
        listAnimal.add(tuandung);
        listAnimal.add(chissExample);

        this.trigger(tuandung, humans1);
        return listAnimal;
    }
    public void conversation(ArrayList<AnimalStarWars> listAnimal){
        int numberSpeech = new Random().nextInt(10);
        int random;
        for(int i =0;i<numberSpeech;i++){
            random = new Random().nextInt(listAnimal.size());
            listAnimal.get(random).speak();
        }
    }

    public void trigger(AnimalStarWars a, AnimalStarWars b){
        System.out.println(a.getName() + "trigger to" + b.getName());

        double calmDamage = a.getIntelligent() - b.getIntelligent();
        if(calmDamage < 0) calmDamage = 1.0;
        double tmp = b.getCalm() - calmDamage;
        b.setCalm(tmp);
        System.out.println("clam " + b.calm);
    }
}
