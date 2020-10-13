package domain;

import java.util.ArrayList;
import java.util.Random;

    //физическое проявление в их всемерной вселенной практически не отличается от нашего)
    //так устала от постоянных споров о смысле жизни, которые отвлекали их от их
    //излюбленного времяпрепровождения -- брокианского ультра-крикета (забавная игра,
    //заключающаяся в том, чтобы неожиданно ударить человека без видимой на то причины и
    //убежать) -- что решила сесть и решить все вопросы раз и навсегда.

public class BrockianUltraCricketGame{

    public ArrayList<AnimalStarWars> team0 = new ArrayList<>();
    public ArrayList<AnimalStarWars> team1 = new ArrayList<>();
    public ArrayList<AnimalStarWars> team2 = new ArrayList<>();

    public void phaseTheGame(ArrayList<AnimalStarWars> listAnimal, StatePlay state) {
        switch (state) {

            case Idle:
                System.out.println("in state Idle");
                //init
                this.selectTeam(listAnimal);
                //talk
                this.conversation(listAnimal);
                break;

            case Triggered:
                System.out.println("in state Triggered");
                int teamWin = this.triggerByTeam(team0,team1,team2);
                System.out.println(teamWin);
                break;

            case Played:
                System.out.println("in state Played");
                //attack with team;

                break;
        }
    }


    public ArrayList<AnimalStarWars> selectTeam(ArrayList<AnimalStarWars> listAnimal){
        int size = listAnimal.size();
        ArrayList<AnimalStarWars> teamSelected = new ArrayList<>();
        System.out.println(size);
        listAnimal.forEach(e -> {
            if(e.getAge() <18) {
                System.out.println("You are not old enough to play the game");
            }
            else{
                int temp = (Math.random() <= 0.5) ? 1 : 2;
                //choose team
                String name = e.getClass().getSimpleName();
                if(name.equals("Humans") || name.equals("Yodas") || name.equals("Wookiees")){
                    e.setTeam(0);
                }else e.setTeam(temp);
                teamSelected.add(e);
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
        });
//        teamSelected.forEach(e ->{
//            System.out.println(e.toString());
//        });
        return teamSelected;
    }

    public ArrayList<AnimalStarWars> initListAnimals(){
        ArrayList<AnimalStarWars> listAnimal = new ArrayList<>();
        Humans phuonganh = new Humans("phuonganh",22,100,1000,200,100,0,100);
        Humans tuandung = new Humans("tuandung",23,100,1000,200,100,0,100);
        Chiss chiss0 = new Chiss("chiss", 10,100,500,100,20,0);
        Chiss chiss1 = new Chiss("chiss0",22,100,200,100,20,0);
        Yodas yoda = new Yodas("yoda", 900,100,200,100,20,0);
        Hutts hutt0 = new Hutts("hutt0",33,100,200,80,30,0);
        Hutts hutt1 = new Hutts("hutt1",30,100,200,100,20,0);
        Hutts hutt2 = new Hutts("hutt2",40,100,200,60,20,0);
        Rakata rakata0 = new Rakata("rakata0",20,100,200,60,20,0);
        Rakata rakata1 = new Rakata("rakata1",23,100,300,80,30,0);
        Rakata rakata2 = new Rakata("rakata2",24,100,400,100,40,0);


        listAnimal.add(phuonganh);
        listAnimal.add(tuandung);
        listAnimal.add(chiss0);
        listAnimal.add(chiss1);
        listAnimal.add(yoda);
        listAnimal.add(hutt0);
        listAnimal.add(hutt1);
        listAnimal.add(hutt2);
        listAnimal.add(rakata0);
        listAnimal.add(rakata1);
        listAnimal.add(rakata2);

        //int

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
    public void attackByObject(AnimalStarWars a, AnimalStarWars b,boolean hitback) throws NotEnoughHeartException {
        System.out.println(a.getName() + " hit to " + b.getName());

        double tmp = b.getHeart() - a.getStrong();
        if(tmp >0) {
            b.setHeart(tmp);
            System.out.println(a.getName() +" deal " + a.getStrong() + "to " + b.getName());
            System.out.println(b.getName() + " heart : " + b.getHeart());

        }
        else {
            System.out.println(a.getName() + " just kill " + b.getName());
            b.setHeart(0);
            throw new NotEnoughHeartException(b.getName() +" dead");
        }
        if(hitback) attackByObject(b,a,false);
    }

}
