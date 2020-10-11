package domain;

public class Yodas extends AnimalStarWars implements Speakable {
    Thinking thinking;

    public Yodas(String name, int age, double heart, double calm, double intelligent, double strong, int team) {
        super(name, age, heart, calm, intelligent, strong, team);
        if(age < 900) this.age = 900;
    }
    public Yodas(String name){
        this.name = name;
        this.age = 900;
    }
    public String traingFor(AnimalStarWars o,double power) {
        if(this.team == o.getTeam()){
            double curStrong = o.getStrong();
            double incStrong = curStrong + power;
            o.setStrong(incStrong);
            return "i will traing for " + o.getName();
        }else return "sorry you chose the wrong direction";
    }
    @Override
    public String makeSpeakTo(AnimalStarWars o) {
        System.out.println("trapped: used the Force");
        double objHeart = o.getHeart();

        if(this.team == o.getTeam()){
            o.setHeart(objHeart + 10);
        }else o.setHeart(objHeart - 10);

        return this.name + " used the Force to " + o.getName() + " by spell of Yodas";
    }

    public String makeSpeakVote(){
        return(this.name +" "+ thinking.Good.s);
    }
}
