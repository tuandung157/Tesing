package domain;

public class Humans extends AnimalStarWars implements Speakable {

    double damageHuman;
    Thinking thinking;
    public Humans(String name, int age, double heart, double calm, double intelligent, double strong, int team, double damageHuman) {
        super(name, age, heart, calm, intelligent, strong, team);
        this.damageHuman = damageHuman;
        if(this.intelligent < 100) this.intelligent = 100;
    }
    public Humans(){
        if(this.intelligent < 100) this.intelligent = 100;
    }

    public String makeSpeakTo(AnimalStarWars o) {
        return this.getName() + " want to talk with " + o.getName() ;
    }
    public String makeSpeak() {
        if(this.calm <= 0) return (this.name +" "+ thinking.Normal.s);
        else return (this.name +" "+ thinking.Good.s);
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

    @Override
    public void setIntelligent(double intelligent) {
        if(intelligent >= 100){
            super.setIntelligent(intelligent);
        }else {
            //throw exception
            System.out.println("human must be >= 100");
        }
    }
}
