package domain;

public class Yodas extends AnimalStarWars implements Speakable {
    Thinking thinking;
    public Yodas(String name, int age, double heart, double calm, double intelligent, double strong, int team) {
        super(name, age, heart, calm, intelligent, strong, team);
    }

    @Override
    public String makeSpeakTo(AnimalStarWars o) {
        System.out.println(this.name + "curesd that " + o.getName() + " by spell of Yodas");
        return this.name + "curesd that " + o.getName() + " by spell of Yodas";
    }

    public String makeSpeak(){
        return(this.name + thinking.Normal);
    }
}
