package domain;

public class Hutts extends AnimalStarWars implements Speakable {

    Thinking thinking ;
    public Hutts(String name, int age, double heart, double calm, double intelligent, double strong, int team) {
        super(name, age, heart, calm, intelligent, strong, team);
    }


    public String makeSpeakTo(AnimalStarWars o) {
        return this.getName() + "trigger to " + o.getName() ;
    }

    @Override
    public String makeSpeak() {
        if(this.calm < 0) return (this.name + thinking.Bad);
        else return (this.name + thinking.Good);
    }
}
