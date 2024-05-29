import Array.Hash;
import org.junit.Test;
public class ArrayHashTest {

    @Test
    public void TestHash() {
        Hash h = new Hash(10);
        h.insert(0);
        h.insert(12);
        h.insert(1);
        h.insert(2);
        h.insert(11);
        h.insert(10);
        h.insert(44);
        h.insert(4);
        h.insert(33);
        h.insert(32);
        h.print();

        /*System.out.println();
        System.out.print(h.quadraticSearch(44).getData());*/

        /*System.out.println();
        System.out.print(h.loadFactor());*/

        /*System.out.println();
        System.out.print(h.between(15, 50));*/

        /*System.out.println();
        System.out.print(h.minimum().getData());*/

        /*System.out.println();
        System.out.print(h.numberOfEmptySlots());*/
    }
}
