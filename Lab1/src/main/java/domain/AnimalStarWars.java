package domain;

public abstract class AnimalStarWars {
    String name;
    int age;
    double heart;
    double calm;

    double intelligent;
    double strong;
    int team;

    public AnimalStarWars(String name, int age, double heart, double calm, double intelligent, double strong, int team) {
        this.name = name;
        this.age = age;
        this.heart = heart;
        this.calm = calm;
        this.intelligent = intelligent;
        this.strong = strong;
        this.team = team;
    }
    public AnimalStarWars(){
    }


    @Override
    public String toString() {
        return "AnimalStarWars{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", heart=" + heart +
                ", calm=" + calm +
                ", intelligent=" + intelligent +
                ", strong=" + strong +
                ", team=" + team +
                '}';
    }
    public void speak(){
        System.out.println(this.name+ " say something");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if(this.age <= 0) this.age = 18;
        else this.age = age;
    }

    public double getHeart() {
        return heart;
    }

    public void setHeart(double heart) {
        this.heart = heart;
    }

    public double getCalm() {
        return calm;
    }

    public void setCalm(double calm) {
        this.calm = calm;
    }

    public double getIntelligent() {
        return intelligent;
    }

    public void setIntelligent(double intelligent) {
        this.intelligent = intelligent;
    }

    public double getStrong() {
        return strong;
    }

    public void setStrong(double strong) {
        this.strong = strong;
    }

    public int getTeam() {
        return team;
    }

    public void setTeam(int team) {
        this.team = team;
    }
}
