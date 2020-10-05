package domain;

public class Humans extends AnimalStarWars implements Attackable, Triggerable {

    double damageHuman;

    public Humans(String name, int age, double heart, double calm, double intelligent, double strong, int team, double damageHuman) {
        super(name, age, heart, calm, intelligent, strong, team);
        this.damageHuman = damageHuman;
    }

    public void makeDamage(int damage) {
        System.out.println("hit " + damage);
    }

    public void makeSpeak(AnimalStarWars o) {
        System.out.println("tricker some one " + intelligent);
        o.setCalm(o.calm - this.intelligent/100);
        System.out.println("show calm " + o.getCalm());
    }

    @Override
    public String toString() {
        return "Humans{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", heart=" + heart +
                ", calm=" + calm +
                ", intelligent=" + intelligent +
                ", strong=" + strong +
                ", team=" + team +
                ", damageHuman=" + damageHuman +
                '}';
    }
}
