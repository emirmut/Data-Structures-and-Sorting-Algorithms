import List.Hash;
import org.junit.Test;

public class LinkedListHashTest {

    @Test
    public void TestHash() {
        Hash h = new Hash(10);
        h.insert(3);
        h.insert(7);
        h.insert(42);
        h.insert(109);
        h.insert(31);
        h.insert(66);
        h.insert(41);
        h.insert(44);
        h.insert(19);
        h.insert(11);
        h.insert(4);
        h.insert(106);
        h.insert(54);
        h.insert(78);
        h.insert(6);
        h.insert(75);
        h.insert(10);
        h.insert(8);
        h.insert(33);
        h.insert(99);
        h.insert(20);
        h.insert(30);
        h.print();

        /*System.out.println();
        System.out.print(h.maximum().getData());*/

        /*System.out.println();
        System.out.print(h.loadFactor());*/

        /*System.out.println();
        System.out.print(h.numberOfEmptySlots());*/
    }
}
