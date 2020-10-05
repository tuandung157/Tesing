package domain;

public class Chiss extends AnimalStarWars {

    public Chiss(String name, int age, double heart, double calm, double intelligent, double strong) {
        super(name, age, heart, calm, intelligent, strong);
    }

    @Override
    public String toString() {
        return "Chiss{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", heart=" + heart +
                ", calm=" + calm +
                ", intelligent=" + intelligent +
                ", strong=" + strong +
                '}';
    }
}
