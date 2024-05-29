import Array.Element;
import List.Node;
import List.Queue;
import org.junit.Test;
public class LinkedListQueueTest {
    @Test
    public void TestQueue() {
        Queue q = new Queue();
        q.enqueue(new Node(1));
        q.enqueue(new Node(3));
        q.enqueue(new Node(5));
        q.enqueue(new Node(4));
        q.enqueue(new Node(6));
        q.enqueue(new Node(9));
    }
}
