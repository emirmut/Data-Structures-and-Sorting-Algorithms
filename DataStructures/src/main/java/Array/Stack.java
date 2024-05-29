package Array;

public class Stack {
    private Element[] array;
    private int N;
    private int top;

    public Stack(int N) {
        this.N = N;
        top = -1;
        array = new Element[N];
    }

    public boolean isFull() {
        return top == N - 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public Element peek() {
        return array[top];
    }

    public void push(Element e) {
        if (!isFull()) {
            top++;
            array[top] = e;
        }
    }

    public Element pop() {
        if (!isEmpty()) {
            top--;
            return array[top + 1];
        }
        return null;
    }

    public boolean isBalanced(String s) {
        Stack stack = new Stack(1000);
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(new Element(c));
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                Element top = stack.pop();
                if ((top.getChar() == '(' && c != ')') ||
                    (top.getChar() == '[' && c != ']') ||
                    (top.getChar() == '{' && c != '}')) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public boolean palindrom(String s) {
        Stack stack = new Stack(1000);
        for(char c : s.toCharArray()) {
            stack.push(new Element(c));
        }
        for (char c : s.toCharArray()) {
            if (stack.pop().getChar() != c) {
                return false;
            }
        }
        return true;
    }


}
