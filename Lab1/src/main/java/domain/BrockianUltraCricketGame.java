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
                int teamWin = this.triggerByTeam(team0,team1,team2);
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
            if(e.getAge() <18) System.out.println("You are not old enough to participate");
            else{
                int temp = (Math.random() <= 0.5) ? 1 : 2;
                //choose team
                String name = e.getClass().getSimpleName();
                if(name.equals("Humans") || name.equals("Yodas") || name.equals("Wookiees")){
                    e.setTeam(0);
                }else e.setTeam(temp);
            }
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
        //fast test
        this.triggerByObject(tuandung, humans1);
        AttackByObject(tuandung, chissExample);

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

    public void triggerByObject(AnimalStarWars a, AnimalStarWars b){
        System.out.println(a.getName() + "trigger to" + b.getName());

        double calmDamage = a.getIntelligent() - b.getIntelligent();
        if(calmDamage < 0) calmDamage = 1.0;
        double tmp = b.getCalm() - calmDamage;
        b.setCalm(tmp);
        System.out.println("clam " + b.calm);
    }
    //compare sum intel and calm
    public int triggerByTeam(ArrayList<AnimalStarWars> teamA,ArrayList<AnimalStarWars> teamB,ArrayList<AnimalStarWars> teamC){
        double calmTeamA = 0;
        double calmTeamB = 0;
        double calmTeamC = 0;
        for(int i = 0; i < teamA.size();i++){
            calmTeamA += teamA.get(i).getCalm();
        }
        System.out.println(calmTeamA);

        for(int i = 0; i < teamB.size();i++){
            calmTeamB += teamB.get(i).getCalm();
        }
        System.out.println(calmTeamB);

        for(int i = 0; i < teamC.size();i++){
            calmTeamC += teamC.get(i).getCalm();
        }
        System.out.println(calmTeamC);

        if(calmTeamA > calmTeamB){
            if(calmTeamA > calmTeamC) {

                System.out.println("team A win in trigger round");
                return 0;
            }
            else {
                System.out.println("team C win in trigger round");
                return 2;
            }
        }else{
            if(calmTeamB > calmTeamC) {
                System.out.println("team B win in trigger round");
                return 1;
            }
            else {
                System.out.println("team C win in trigger round");
                return 2;
            }
        }
    }

    // attack
    public void AttackByObject(AnimalStarWars a, AnimalStarWars b){
        System.out.println(a.getName() + "hit to" + b.getName());
        double tmp = b.getHeart() - a.getStrong();
        if(tmp >0) {
            b.setHeart(tmp);
            System.out.println(a.getName() +" deal" + a.getStrong() + "to" + b.getName());
            System.out.println(b.getName() + " heart : " + b.getHeart());
        }
        else System.out.println(a.getName()+ " just kill "  + b.getName());
    }

}
