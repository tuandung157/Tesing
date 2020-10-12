import domain.*;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

public class domainTest {
    private BrockianUltraCricketGame game;
    private ArrayList<AnimalStarWars> list;

    @BeforeEach
    void init(){
        game = new BrockianUltraCricketGame();
        System.out.println("game on");
        list = game.initListAnimals();
    }
    @AfterEach
    void clear(){
        list.clear();
    }
    //human
    @Test
    void testCreatingCharacterHuman(){
        Humans humans = new Humans();
        assertNotNull(humans, "human should be create");
        humans.setName("tuandung");
        assertEquals("tuandung",humans.getName(), "human set name");
        assertTrue(humans.getIntelligent()>=100,"humans class intelligent should be > 100");
        assertTrue(humans.getAge() >= 0, "age should be > 0");
        assertEquals("Humans{name='tuandung', age=0, heart=0.0, calm=0.0, intelligent=100.0, strong=0.0, team=0, damageHuman=0.0}", humans.toString(),"we need to print out character figures" );
        humans.setName("changename");
        assertEquals("changename", humans.getName(),"class can change name");

    }

    //hanh dong function cua human
    @Test
    void testHumanActionMakeSpeak(){
        Humans human = new Humans();
        human.setName("tuandung");

        human.setCalm(100);
        assertEquals(human.getName() + " "+ "wanna stop that war", human.makeSpeakVote(),"stop the war when calm");
        human.setCalm(0);
        assertEquals(human.getName() + " "+ "said what ever", human.makeSpeakVote(),"human make speak when calm < 0");
    }

    @Test
    void testHumanMakeSpeakTo(){
        Humans human = new Humans();
        human.setName("tuandung");
        Humans human1 = new Humans();
        human1.setName("phuonganh");

        assertEquals("tuandung want to talk with phuonganh",human.makeSpeakTo(human1));
        assertEquals("phuonganh want to talk with tuandung",human1.makeSpeakTo(human));
    }

    @Test
    void testInitChiss(){
        Chiss chiss = new Chiss();
        assertNotNull(chiss,"create new character in class Chiss");
        Chiss justchiss = new Chiss("justChiss");
        assertNotNull(justchiss,"create new character with another constructor in class Chiss");
        chiss.setName("chiss");
        assertEquals("chiss",chiss.getName(),"check name registration");
        System.out.println(chiss.toString());
        assertEquals("Chiss{name='chiss', age=0, heart=0.0, calm=0.0, intelligent=0.0, strong=0.0, team=0}",chiss.toString(),"print out character figures");
    }

    @Test
    void testMakeSpeak(){
        Chiss chiss = new Chiss("chiss");
        String sentence = chiss.makeSpeakVote();
        System.out.println(sentence);
        assertEquals("chiss said what ever",sentence,"check make speak of chiss");
        //change calm value
        chiss.setCalm(100);
        assertEquals("chiss said what ever",chiss.makeSpeakVote(),"check make speak of chiss");
        chiss.setCalm(0);
        assertEquals("chiss said what ever",chiss.makeSpeakVote(),"check make speak of chiss");

    }
    @Test
    void testMakeSpeakTo(){
        Chiss chiss = new Chiss("chiss");
        Humans human = new Humans();
        human.setName("tuandung");
        String str = chiss.makeSpeakTo(human);
        assertNotNull(chiss.makeSpeakTo(human));
        System.out.println(str);
        assertEquals("chiss said our clan will defeat tuandung", str, "check speak alway trigger someone");
    }

    @Test
    void testpassiveIntel(){
        Chiss chiss = new Chiss("chiss");
        Humans human = new Humans("tuandung",23,100,1000,100,100,0,100);
        // same intelligent
        chiss.setIntelligent(100);
        chiss.passiveIntel(human);
        assertEquals(100, human.getIntelligent(),"not change value intelligent");
        assertEquals(101, chiss.getIntelligent(),"should be +1 when same value");

        // higher intelligent
        chiss.setIntelligent(150);
        chiss.passiveIntel(human);
        assertEquals(150,chiss.getIntelligent(),"not change value when higher intelligent");
        assertEquals(100,human.getIntelligent(),"intelligent of human always >= 100");//loss of value due to the difference in intelligence
        human.setIntelligent(140);
        chiss.passiveIntel(human);
        assertEquals(150,chiss.getIntelligent(),"not change value when higher intelligent");
        assertEquals(130,human.getIntelligent(),"loss of value due to the difference in intelligence");

        //lower intelligent
        chiss.setIntelligent(80);
        human.setIntelligent(150);
        chiss.passiveIntel(human);
        assertEquals(150, human.getIntelligent(), "human not change value intelligent when higher than chiss");
        assertEquals(81,chiss.getIntelligent(),"shold be +1 when same value");

    }

    @Test
    void testInitYoda(){
        Yodas yoda = new Yodas("masterYoda");
        assertNotNull(yoda,"create master yoda");

        Yodas yoda1 = new Yodas("yoda",800,100,1000,200,100,0);
        assertNotNull(yoda1, "create full contractor with all field");

        //check age
        assertTrue(yoda.getAge() >= 900, "age master yoda should be > 900");
        assertTrue(yoda1.getAge() >= 900,"cant set age < 800");
    }

    @Test
    void testYodaMakeSpeak(){
        Yodas yoda = new Yodas("master Yoda");
        String str = yoda.makeSpeakVote();
        assertEquals(yoda.getName() + " wanna stop that war",str,"yoda alway speak good");
        yoda.setCalm(100);
        assertEquals(yoda.getName() + " wanna stop that war",str,"yoda alway speak good");
        yoda.setCalm(-100);
        assertEquals(yoda.getName() + " wanna stop that war",str,"yoda alway speak good");
    }

    @Test
    void testYodaMakeSpeakTo(){
        Yodas yoda = new Yodas("master Yoda");
        Humans human = new Humans("tuandung",23,100,1000,100,100,0,100);

        String str = yoda.makeSpeakTo(human);
        assertEquals("master Yoda used the Force to tuandung by spell of Yodas",str,"master yoda uses force instead of talking ");
        //if same team
        assertEquals(110,human.getHeart(),"inc heart for teammate" );

        //if other team
        human.setTeam(1);
        yoda.makeSpeakTo(human);
        assertEquals(100, human.getHeart(),"dec heart for other team when he talk to him");
    }

    @Test
    void testYodaTraingFor(){
        Yodas yoda = new Yodas("master Yoda");
        //same team
        Humans human = new Humans("tuandung",23,100,1000,100,100,0,100);
        String str = yoda.traingFor(human, 10.0);
        assertEquals("i will traing for tuandung", str,"he trains people with his team");
        //other team
        Humans imposter = new Humans("imposter",23,100,1000,100,100,1,100);
        String str1 = yoda.traingFor(imposter, 10.0);
        assertEquals("sorry you chose the wrong direction", str1,"he doesn't train people on the other team");
    }


//    test function in game
    @Test
    void testInitAnimalGame(){
        ArrayList<AnimalStarWars> list = game.initListAnimals();
        assertNotNull(list,"create list Animal");
        assertEquals(11,list.size(),"create 11 object");
    }

    @Test
    void testSelectTeam(){

        ArrayList<AnimalStarWars> list = game.initListAnimals();
        ArrayList<AnimalStarWars> listSelected = game.selectTeam(list);

        listSelected.forEach(e ->{
            String clanName;
            clanName = e.getClass().getSimpleName();
            switch (clanName){
                case "Humans":
                    assertEquals(0,e.getTeam(),"human class should be team 0");
                    break;
                case "Yodas":
                    assertEquals(0,e.getTeam(),"Yoda class should be team 0");
                    break;
                case "Chiss":
                    assertNotEquals(0,e.getTeam(),"Chiss class should be team 1 or 2");
                    break;
                case "Hutts":
                    assertNotEquals(0,e.getTeam(),"Hutts class should be team 1 or 2");
                    break;
                case "Rakata":
                    assertNotEquals(0,e.getTeam(),"Rakata class should be team 1 or 2");
                    break;
            }
        });

    }
    //check age when select to team
    @Test
    void testCheckAge(){
        ArrayList<AnimalStarWars> list = game.initListAnimals();
        ArrayList<AnimalStarWars> listSelected = game.selectTeam(list);

        listSelected.forEach(e ->{
            assertTrue(e.getAge() >=18, "age of player sould be older than 18");
        });
    }

    @Test
    void testTriggerByObject(){
        ArrayList<AnimalStarWars> list = game.initListAnimals();
        ArrayList<AnimalStarWars> listSelected = game.selectTeam(list);
        AnimalStarWars a = listSelected.get(1);
        AnimalStarWars b = listSelected.get(2);
        double calmA = a.getCalm();
        double calmB = b.getCalm();
        game.triggerByObject(a,b);
        assertTrue(calmB > b.getCalm(),"After being triggered, his calm will be lower than he was originally");
        assertEquals(calmA,a.getCalm(),"must be equal,because he is the trigger proactively");
        assertEquals(100,b.getCalm(),"calm him down by the other person triggered");
    }

    @Test
    void testAttackByObject() throws NotEnoughHeartException {
        ArrayList<AnimalStarWars> list = game.initListAnimals();
        ArrayList<AnimalStarWars> listSelected = game.selectTeam(list);
        AnimalStarWars a = listSelected.get(1);
        AnimalStarWars b = listSelected.get(2);

        //game.attackByObject(a,b,false);
        assertThrows(NotEnoughHeartException.class,()->{
            game.attackByObject(a,b,false);
        });
        //a attack b but b didnt know
        b.setHeart(1000);
        a.setHeart(1000);
        double heartA = a.getHeart();
        double heartB = b.getHeart();
        assertTrue(heartB >= b.getHeart(),"After being attacked, his heart will be lower or equal than he was originally");
        assertEquals(heartA,a.getHeart(),"because the person who was beaten doesn't know who hit him.");
        //assertEquals(0,b.getHeart(),"b dead");

        //a attack b but b did know
        b.setHeart(1000);
        a.setHeart(1000);
        heartA = a.getHeart();
        heartB = b.getHeart();
        game.attackByObject(b,a,true);
        assertEquals(980,a.getHeart(),"because the person who was beaten doesn't know who hit him.");

    }
}
