package domain;

public class Chiss extends AnimalStarWars implements Speakable {

    Thinking thinking;
    public Chiss(String name, int age, double heart, double calm, double intelligent, double strong, int team) {
        super(name, age, heart, calm, intelligent, strong, team);
    }

    @Override
    public String makeSpeakTo(AnimalStarWars o) {
        return this.getName() + " said our clan will defeat " + o.getName() ;
    }

    @Override
    public String makeSpeak(){
        return (name + thinking.Normal);
    }
}
