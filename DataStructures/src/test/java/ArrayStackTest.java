import Array.Element;
import Array.Stack;
import org.junit.Test;

public class ArrayStackTest {
    @Test
    public void TestIsBalanced() {
        Stack stack = new Stack(100);
        String s = "({()[{}]}())";
        System.out.println(stack.isBalanced(s));
    }

    @Test
    public void TestPalindrom() {
        Stack stack = new Stack(100);
        String s1 = "ababa";
        System.out.println(stack.palindrom(s1));
        String s2 = "djvhqnc";
        System.out.println(stack.palindrom(s2));
    }
}
