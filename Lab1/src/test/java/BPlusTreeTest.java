import BPlusTree.BPlusTree;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BPlusTreeTest {
    private BPlusTree bpt;

    @BeforeEach
    void setUp() {
        bpt = new BPlusTree();
        bpt.initialize(6);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void insert() {
        bpt.insert(1, "number 1");
        bpt.insert(2, "number 2");
    }

    @Test
    void search() {
    }

    @Test
    void testSearch() {
    }
    @Test
    void testTree(){

        for(int i = 1; i< 22;i++){
            double a = (double) i;
            bpt.insert(i,"number "+i);
        }
        bpt.search(1,3);
        bpt.printTree();
    }
}