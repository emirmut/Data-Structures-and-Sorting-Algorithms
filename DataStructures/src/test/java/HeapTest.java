import Array.Element;
import Array.HeapNode;
import Array.Heap;
import Array.DHeap;
import org.junit.Test;
public class HeapTest {
    @Test
    public void TestHeap() {
        Heap h = new Heap(100);
        h.insert(new HeapNode(1));
        h.insert(new HeapNode(3));
        h.insert(new HeapNode(5));
        h.insert(new HeapNode(4));
        h.insert(new HeapNode(6));
        h.insert(new HeapNode(9));
        h.insert(new HeapNode(10));
        h.insert(new HeapNode(11));
        h.insert(new HeapNode(12));
        h.insert(new HeapNode(2));
        h.insert(new HeapNode(8));
        h.insert(new HeapNode(7));
        h.print();
        System.out.println();

        //System.out.println(h.smallest());

        //System.out.println(h.kthLargest(new int[] {5, 3, 2, 45, 4, 21, 34}, 3)); // h is here because if it is not here, I get an error.

        //h.printLargerThanX(7);

        //System.out.println(h.kthMaximum(7).getData());

        /*System.out.println(h.heapOrder(new int[] {17, 23, 43, 16, 3, 2, 5, 1, 8, 6}));
        System.out.println(h.heapOrder(new int[] {43, 23, 16, 17, 8, 6, 5, 3, 2, 1}));*/

        //System.out.println(h.largestChild(3).getData());

        /*h.swapWithSmallest(5);
        h.print();*/

        //System.out.println(h.maxGrandChild(2));

        //System.out.print(h.grandParent(3));

        //System.out.print(h.depth(9));

        //System.out.print(h.height(0));

        //System.out.print(h.sumOfDescendants(5));
    }
}
