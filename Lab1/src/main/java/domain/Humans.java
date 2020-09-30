package domain;

public class Humans extends AnimalStarWars implements Attackable,Speakable{

    double damageHuman;

    public Humans(String name, int age, double heart, double calm, double intelligent, double strong) {
        super(name, age, heart, calm, intelligent, strong);
    }



    @Override
    public void makeDamage(int damage) {
        System.out.println("hit " + damage);
    }


    @Override
    public void makeSpeak(int intelligent) {
        System.out.println("tricker some one" + intelligent);
    }

}
