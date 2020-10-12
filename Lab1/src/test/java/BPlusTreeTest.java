import BPlusTree.BPlusTree;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BPlusTreeTest {
    private BPlusTree bpt;

    @BeforeEach
    void setUp() {
        bpt = new BPlusTree();
        bpt.initialize(6);
    }
    @Test
    void testEmplyCheck(){
        assertTrue(bpt.isEmpty, "isEmpty should be true");
        bpt.insert(1,"value");
        assertFalse(bpt.isEmpty, "isEmpty should be true");
    }
    @Test
    void testPrint(){
        for(int i = 1; i<16;i++){
            bpt.insert(i,"");
        }bpt.printTree();
        //      B+ Tree Initialized. Degree is 6
        //      Printing level 1 :                                            4.0:();7.0:();10.0:();13.0:(); ||
        //      Printing level 2 : 1.0:();2.0:();3.0:(); || 4.0:();5.0:();6.0:(); || 7.0:();8.0:();9.0:(); || 10.0:();11.0:();12.0:(); || 13.0:();14.0:();15.0:(); ||
    }
    @Test
    void testInsert() {
        bpt.insert(1, "value 1");
        bpt.insert(2, "value 2");
        bpt.insert(3, "value 3");
        bpt.insert(4, "value 4");
        bpt.insert(5, "value 5");
        bpt.printTree();
        assertEquals(5,bpt.root.getKeys().size(),"should be 5 key in root");
        assertEquals(1,bpt.levelNumber,"level Number should be level 1");
        bpt.insert(6, "value 6");
        bpt.printTree();
        assertEquals(2,bpt.levelNumber,"level Number should be level 2");
        for(int i = 7; i<22;i++){
            bpt.insert(i,"value " + i);
        }bpt.printTree();
        assertEquals(3,bpt.levelNumber,"level Number should be level 3");
    }
    @Test
    void testInsertListInKey(){
        //insert 2 value in key
        bpt.insert(1, "value 1.0");
        bpt.insert(1,"value 1.1");
        List<String> list = new ArrayList<>();
        list.add("value 1.0");
        list.add("value 1.1");
        assertEquals(list, bpt.search(1),"error to get 2 value in key");
        //insert 3 value in key
        bpt.insert(1,"value 1.2");
        list.add("value 1.2");
        assertEquals(list, bpt.search(1),"error to get 3 value in key");

    }
    @Test
    void testSearch() {
        bpt.insert(1, "value 1");
        bpt.insert(2, "value 2");
        bpt.insert(3, "value 3");
        bpt.insert(4, "value 4");
        bpt.insert(5, "value 5");
        bpt.insert(6, "value 6");
        for(int i = 7; i<22;i++){
            bpt.insert(i,"value " + i);
        }

        assertEquals("value 1",bpt.search(1).get(0),"error when search key 1");
        assertEquals("value 5",bpt.search(5).get(0),"error when search key 5");
        assertEquals("value 7",bpt.search(7).get(0),"error when search key 7");
        assertEquals("value 12",bpt.search(12).get(0),"error when search key 12");
        assertEquals("value 13",bpt.search(13).get(0),"error when search key 13");
        assertEquals("value 17",bpt.search(17).get(0),"error when search key 17");

        assertThrows(NullPointerException.class,()->{
            assertEquals("value 22",bpt.search(22).get(0),"error when search key 22");
            assertEquals("value 27",bpt.search(27).get(0),"error when search key 27");
        });
        bpt.printTree();

    }
    @Test
    void testSearchKeyMiddle(){
        bpt.insert(1, "value 1");
        bpt.insert(2, "value 2");
        bpt.insert(4, "value 4");
        bpt.insert(5, "value 5");
        bpt.insert(3, "value 3");
        bpt.insert(6, "value 6");
        for(int i = 7; i<22;i++){
            bpt.insert(i,"value " + i);
        }

        assertEquals(4,bpt.search(3,6).size(),"error in get number key from 3 to 6");
        assertEquals(6,bpt.search(2,7).size(),"error in get number key from 2 to 7");
        assertEquals("[2.0, 3.0, 4.0, 5.0, 6.0, 7.0]",bpt.getKeyListMiddle(2,7), "get all keys between key from 2 to 7");
        assertEquals("[[value 2], [value 3], [value 4], [value 5], [value 6], [value 7]]",bpt.getValueListMiddle(2,7), "get all values between key from 2 to 7");

    }
    @Test
    void testRemoveKey(){
        bpt.insert(0, "value 0");
        bpt.insert(1, "value 1");
        bpt.insert(4, "value 4");
        bpt.insert(3, "value 3");
        bpt.insert(2, "value 2");
        bpt.insert(0, "value 0.1");
        bpt.insert(1, "value 1.1");
        bpt.insert(4, "value 4.1");
        bpt.insert(3, "value 3.1");
        bpt.insert(2, "value 2.1");

        bpt.removeKey(3);
        assertNull(bpt.search(3),"error method delete key");
        assertEquals("value 1",bpt.search(1).get(0),"key must be exist");

        bpt.removeKey(1);
        assertNull(bpt.search(1),"error method delete key");
    }




}