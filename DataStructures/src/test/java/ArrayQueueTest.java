import Array.Element;
import Array.Queue;
import org.junit.Test;
public class ArrayQueueTest {
    @Test
    public void TestQueue() {
        Queue q = new Queue(10);
        q.enqueue(new Element(1));
        q.enqueue(new Element(3));
        q.enqueue(new Element(5));
        q.enqueue(new Element(4));
        q.enqueue(new Element(6));
        q.enqueue(new Element(9));
        q.enqueue(new Element(10));
        q.enqueue(new Element(11));
        q.enqueue(new Element(12));
        q.print();

        /*System.out.println();
        q.moveToRear();
        q.print();*/

        /*q.enlarge();
        q.enqueue(new Element(11));
        System.out.println();
        q.print();*/

        /*System.out.println();
        System.out.print(q.largest());*/

        /*q.insertSecond(new Element(10));
        System.out.println();
        q.print();*/

        /*q.shrink(6);
        System.out.println();
        q.print();*/

        /*q.insertAfterKth(new Element(15), 6);
        System.out.println();
        q.print();*/

        /*q.deleteKth(0);
        System.out.println();
        q.print();*/

        /*q.bringFront();
        System.out.println();
        q.print();*/
    }
}
