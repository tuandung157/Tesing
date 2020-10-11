import domain.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

public class domainTest {
    private BrockianUltraCricketGame game;
    private ArrayList<AnimalStarWars> list;
    @BeforeEach
    void init(){
        game = new BrockianUltraCricketGame();
        System.out.println("game on");
        //list = game.initAnimal();
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
        assertEquals(human.getName() + " "+ "wanna stop that war", human.makeSpeak(),"stop the war when calm");
        human.setCalm(0);
        assertEquals(human.getName() + " "+ "said what ever", human.makeSpeak(),"human make speak when calm < 0");
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
        String sentence = chiss.makeSpeak();
        System.out.println(sentence);
        assertEquals("chiss said what ever",sentence,"check make speak of chiss");
        //change calm value
        chiss.setCalm(100);
        assertEquals("chiss said what ever",chiss.makeSpeak(),"check make speak of chiss");
        chiss.setCalm(0);
        assertEquals("chiss said what ever",chiss.makeSpeak(),"check make speak of chiss");

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
        String str = yoda.makeSpeak();
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

}
