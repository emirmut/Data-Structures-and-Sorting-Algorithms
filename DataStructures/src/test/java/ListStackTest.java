import List.Node;
import List.Stack;
import org.junit.Test;

public class ListStackTest {
    @Test
    public void TestSwapTopmost2() {
        Stack stack = new Stack();
        stack.push(new Node(5));
        stack.push(new Node(4));
        stack.push(new Node(3));
        stack.push(new Node(1));
        System.out.println(stack.toString());
        stack.swapTopmost2();
        System.out.println(stack.toString());
    }

    @Test
    public void TestMultiply() {
        Stack stack = new Stack();
        stack.push(new Node(5));
        stack.push(new Node(4));
        stack.push(new Node(3));
        stack.push(new Node(6));
        System.out.println(stack.toString());
        System.out.println(stack.multiply());
        System.out.println(stack.toString());
    }

    @Test
    public void TestRemoveBottom() {
        Stack stack = new Stack();
        stack.push(new Node(5));
        stack.push(new Node(4));
        stack.push(new Node(3));
        stack.push(new Node(6));
        System.out.println(stack.toString());
        stack.removeBottom();
        System.out.println(stack.toString());
    }
}
