package List;

import Array.Element;

public class Stack {
    private Node top;

    public Stack() {
        top = null;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public Node peek() {
        return top;
    }

    public void push(Node node) {
        node.setNext(top);
        top = node;
    }

    public Node pop() {
        if (!isEmpty()) {
            Node topNode = top;
            top = top.next;
            return topNode;
        }
        return null;
    }

    public String toString() {
        StringBuilder result = new StringBuilder();
        Node tmp = top;
        while (tmp != null) {
            result.append(tmp).append(" ");
            tmp = tmp.getNext();
        }
        return result.toString();
    }

    public void swapTopmost2() {
        if (!isEmpty()) {
            Node top1 = peek();
            pop();
            Node top2 = peek();
            pop();
            push(top1);
            push(top2);
        }
    }

    public int multiply() {
        if (!isEmpty()) {
            int topNodeData = top.getData();
            int topNextNodeData = top.next.getData();
            pop();
            pop();
            return topNodeData * topNextNodeData;
        } else {
            return 0;
        }
    }

    public void removeBottom() {
        if (!isEmpty()) {
            Stack temp = new Stack();
            while (!isEmpty()) {
                temp.push(top);
                pop();
            }
            temp.pop();
            while (!(temp.isEmpty())) {
                push(temp.peek());
                temp.pop();
            }
        }
    }
}
