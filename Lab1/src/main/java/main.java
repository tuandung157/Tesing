import domain.*;

import java.util.ArrayList;

public class main {

    public static void main(String[] args) throws GameAlreadyException {
/*
        //test func
        FuncSec sec = new FuncSec();
        double radian = 1.57;
        double res = sec.calc(radian);

        //test tree
        BPlusTree bpt = new BPlusTree(3);
        bpt.insert(5,10);
        bpt.insert(6,10);

        if(bpt.search(6) != null){
            System.out.println("found");
        }
*/
        //test domain

        //game
        BrockianUltraCricketGame game = new BrockianUltraCricketGame();
        ArrayList<AnimalStarWars> listAnimal = game.initAnimal();
        game.phaseTheGame(listAnimal, StatePlay.Idle);
        game.phaseTheGame(listAnimal, StatePlay.Triggered);



    }

}
