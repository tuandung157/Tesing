package domain;

import java.util.ArrayList;
import java.util.LinkedList;

public class BrockianUltraCricketGame {

    public void playGame(){

    }
    public void chooseTeam(ArrayList<AnimalStarWars> list){
        int size = list.size();
        System.out.println(size);
        list.forEach(e -> {
            //random team
            System.out.println(e.getClass().getSimpleName());
            int temp = (Math.random() <= 0.5) ? 1 : 2;
            //choose team
            String name = e.getClass().getSimpleName();
            if(name.equals("Humans") || name.equals("Yodas") || name.equals("Wookiees")){
                e.setTeam(0);
            }else e.setTeam(temp);
        });
        list.forEach(e -> {
            e.toString();
            System.out.println(e.toString());
        });
    }

    public ArrayList<AnimalStarWars> initAnimal(){
        ArrayList<AnimalStarWars> listAnimal = new ArrayList<>();
        Humans humans1 = new Humans("tuandung1",22,100,1000,100,100,1,100);
        Humans tuandung = new Humans("tuandung",23,100,1000,100,100,1,100);
        Chiss chissExample = new Chiss("chiss", 10,100,500,20,20,1);

        listAnimal.add(humans1);
        listAnimal.add(tuandung);
        listAnimal.add(chissExample);

        listAnimal.forEach(e -> {
            e.toString();
            System.out.println(e.toString());
        });

        return listAnimal;
    }
}
