package domain;

public class Chiss extends AnimalStarWars implements Speakable {

    Thinking thinking;
    public Chiss(String name, int age, double heart, double calm, double intelligent, double strong, int team) {
        super(name, age, heart, calm, intelligent, strong, team);
    }
    public Chiss(){

    }
    public Chiss(String name){
        this.name = name;
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
                ", team=" + team +
                '}';
    }

    @Override
    public String makeSpeakTo(AnimalStarWars o) {
        return this.getName() + " said our clan will defeat " + o.getName() ;
    }

    @Override
    public String makeSpeakVote(){
        return (this.getName() + " " + thinking.Normal.s);
    }

    public void passiveIntel(AnimalStarWars o){
        double objIntel = o.getIntelligent();
        double tmp =this.intelligent - objIntel;
        if(tmp > 0) o.setIntelligent(objIntel - tmp);
        else this.intelligent ++;
    }

}
