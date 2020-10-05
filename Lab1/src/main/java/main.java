import domain.*;

import java.util.LinkedList;

public class main {

    public static void main(String[] args){
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
        Humans tuandung = new Humans("tuandung",23,100,1000,100,100,100);
        Chiss chissExample = new Chiss("chiss", 1,100,500,20,20);
        tuandung.makeSpeak(chissExample);

        //result
        System.out.println(tuandung.toString());
        System.out.println(chissExample.toString());


    }

}
