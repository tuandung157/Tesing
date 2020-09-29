package domain;

public class Humans extends AnimalStarWars implements Attackable{

    int damageHuman;

    @Override
    public void makeDamage(int damage) {
        System.out.println("hit " + damage);
    }


}
