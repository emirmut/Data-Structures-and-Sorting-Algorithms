package List.Graph;

public class EdgeList {
    private Edge head;
    private Edge tail;

    public EdgeList() {
        head = null;
        tail = null;
    }

    public Edge getHead() {
        return head;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public Edge search(int to) {
        Edge temp = head;
        while (temp != null) {
            if (to == temp.getTo()) {
                return temp;
            }
            temp = temp.getNext();
        }
        return null;
    }

    public void insert(Edge newEdge) { // insertLast
        if (head == null) {
            head = newEdge;
        } else {
            tail.setNext(newEdge);
        }
        tail = newEdge;
    }
    public int numberOfElements() {
        int count = 0;
        Edge temp = head;
        while (temp != null) {
            count++;
            temp = temp.getNext();
        }
        return count;
    }

    public Edge getEdgeI(int i) { // returns the ith edge in an edge list
        Edge temp = head;
        int index = 0;
        while (temp != null) {
            if (index == i) {
                return temp;
            }
            temp = temp.getNext();
            index++;
        }
        return null;
    }
}
