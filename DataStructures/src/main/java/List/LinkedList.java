package List;

public class LinkedList {
    protected Node head;
    protected Node tail;

    public LinkedList() { // Constructor
        head = null;
        tail = null;
    }

    public Node getHead() {
        return head;
    }

    public Node getTail() {
        return tail;
    }

    public void insertFirst(Node newNode) { // inserts a node at the beginning of a linked list
        if (tail == null) {
            tail = newNode;
        }
        newNode.setNext(head);
        head = newNode;
    }

    public void insertLast(Node newNode) { // inserts a node at the end of a linked list
        if (head == null) {
            head = newNode;
        } else {
            tail.setNext(newNode);
        }
        tail = newNode;
    }

    public void insertMiddle(Node newNode, Node previous) { // inserts a node to middle of a linked list
        newNode.setNext(previous.getNext());
        previous.setNext(newNode);
    }

    /**
     * @param value The value to be searched.
     * @return The node that has the data value. If no node exists, returns null.
     */
    public Node search(int value) { // searches and afterwards finds the desired node in a linked list
        Node temp = head;
        while (temp != null) {
            if (value == temp.getData()) {
                return temp;
            }
            temp = temp.getNext();
        }
        return null;
    }

    public Node getNodeI(int i) { // returns the ith node in a linked list
        Node temp = head;
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

    public int numberOfElements() { // finds the number of elements in a linked list
        Node temp = head;
        int count = 0;
        while (temp != null) {
            count++;
            temp = temp.getNext();
        }
        return count;
    }

    public String toString() {
        StringBuilder result = new StringBuilder();
        Node tmp = head;
        while (tmp != null) {
            result.append(tmp).append(" ");
            tmp = tmp.getNext();
        }
        return result.toString();
    }

    public Node getPrevious(Node node) { // returns the previous node of the desired node
        Node temp = head;
        Node previous = null;
        while (temp != node) {
            previous = temp;
            temp = temp.getNext();
        }
        return previous;
    }

    public void deleteFirst() { // deletes the first element of a linked list
        head = head.getNext();
        if (head == null) {
            tail = null;
        }
    }

    public void deleteLast() { // deletes the last element of a linked list
        tail = getPrevious(tail);
        if (tail == null) {
            head = null;
        } else {
            tail.setNext(null);
        }
    }

    public void deleteMiddle(Node node) { // deletes an element which is neither first element nor last element of a linked list
        getPrevious(node).setNext(node.getNext());
    }

    public int smallest() {
        Node temp = head;
        int small = temp.getData();
        while (temp != null) {
            if (temp.getData() < small) {
                small = temp.getData();
            }
            temp = temp.getNext();
        }
        return small;
    }

    public void deleteSecond() {
        if (head.getNext() != null) {
            getPrevious(head.getNext()).setNext(head.getNext().getNext());
        }
    }

    public LinkedList prime(int N) {
        LinkedList l = new LinkedList();
        boolean isPrime;
        for (int i = 2; i <= N; i++) {
            isPrime = true;
            for (int j = 2; j < N; j++) {
                if (i == j) {
                    continue;
                }
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                l.insertLast(new Node(i));
            }
        }
        return l;
    }

    public void insertSecond(Node newNode) {
        if (head.getNext() != null) {
            newNode.setNext(head.getNext());
            head.setNext(newNode);
        }
    }

    public LinkedList deleteOddIndexedElements() {
        LinkedList l = new LinkedList();
        Node temp = head;
        int index = 0;
        while (temp != null) {
            if (index % 2 == 0) {
                l.insertLast(temp);
                if (temp == head) {
                    deleteFirst();
                } else if (temp == tail) {
                    deleteLast();
                } else {
                    deleteMiddle(temp);
                }
            }
            index++;
            temp = temp.getNext();
        }
        return l;
    }

    public void deleteEvenIndexedElements() {
        Node temp = head;
        int index = 0;
        while (temp != null) {
            if (index % 2 == 0) {
                if (temp == head) {
                    deleteFirst();
                } else if (temp == tail) {
                    deleteLast();
                } else {
                    deleteMiddle(temp);
                }
            }
            index++;
            temp = temp.getNext();
        }
    }

    public void insertBeforeLast(Node newNode) {
        if (head == null) {
            head = newNode;
        } else {
            newNode.setNext(tail);
            getPrevious(tail).setNext(newNode);
        }
    }

    public void AddToSortedList(int x) {
        Node temp = head;
        while (temp != null) {
            if (x <= temp.getData()) {
                if (temp == head) {
                    insertFirst(new Node(x));
                } else if (temp == tail) {
                    insertLast(new Node(x));
                } else {
                    insertMiddle(new Node(x), getPrevious(temp));
                }
                break;
            }
            temp = temp.getNext();
        }
    }

    public void deleteKth(int k) {
        Node temp = head;
        int i = 1;
        while (temp != null) {
            if (i == k) {
                if (temp == head) {
                    head = head.getNext(); // deleteFirst
                } else if (temp == tail) {
                    tail = getPrevious(tail); // deleteLast
                    tail.setNext(null);
                } else {
                    getPrevious(temp).setNext(temp.getNext()); // deleteMiddle
                }
            }
            temp = temp.getNext();
            i++;
        }
    }

    public void move(Node X, int n) {
        Node temp = head;
        while (temp != null) {
            if (temp == X) {
                Node originalNode = temp;
                for (int i = 0; i < n; i++) {
                    temp = temp.getNext();
                }
                if (temp == tail) {
                    insertLast(originalNode);
                } else {
                    insertMiddle(originalNode, getPrevious(temp));
                }
                break;
            }
            temp = temp.getNext();
        }
    }

    public LinkedList primeFactors(int N) {
        LinkedList l = new LinkedList();
        boolean isPrime = true;
        for (int i = 2; i < N; i++) {
            if (N % i == 0) {
                isPrime = false;
                break;
            }
        }
        if (isPrime) {
            l.insertLast(new Node(N));
            return l;
        } else {
            for (int i = 2; i <= N; i++) {
                if (N % i == 0) {
                    if (i % 2 != 0 || i == 2) {
                        l.insertLast(new Node(i));
                    }
                    N = N / i;
                }
            }
            return l;
        }
    }

    public LinkedList removeDivisibleByN(int N) {
        LinkedList l = new LinkedList();
        Node temp = head;
        while (temp != null) {
            if (N % temp.getData() == 0) {
                l.insertLast(temp);
                if (temp == head) {
                    deleteFirst();
                } else if (temp == tail) {
                    deleteLast();
                } else {
                    deleteMiddle(temp);
                }
            }
            temp = temp.getNext();
        }
        return l;
    }

    public LinkedList reverse() {
        LinkedList l = new LinkedList();
        if (head != null && tail != null) {
            Node temp = head;
            while (temp != null) {
                l.insertFirst(temp);
                temp = temp.getNext();
            }
        }
        return l;
    }

    public boolean palindrome() {
        Node temp1 = head;
        int numberOfElements = 0;
        while (temp1 != null) {
            numberOfElements++;
            temp1 = temp1.getNext();
        }
        Node temp2 = head;
        int x = 1;
        while (x != numberOfElements / 2) {
            if (temp2.getData() != tail.getData()) {
                return false;
            }
            temp2 = temp2.getNext();
            tail = getPrevious(tail);
            x++;
        }
        return true;
    }

    public void deleteAll(int X) {
        Node temp = head;
        while (temp != null) {
            if (temp.getData() == X) {
                if (temp == head) {
                    deleteFirst();
                } else if (temp == tail) {
                    deleteLast();
                } else {
                    deleteMiddle(temp);
                }
            }
            temp = temp.getNext();
        }
    }

    public LinkedList intersection(LinkedList l1, LinkedList l2) {
        if (l1.numberOfElements() == 0 && l2.numberOfElements() == 0) {
            return null;
        }
        LinkedList l3 = new LinkedList();
        if (l1.numberOfElements() <= l2.numberOfElements()) {
            for (int indexOfl1 = 0; indexOfl1 < l1.numberOfElements(); indexOfl1++) {
                for (int indexOfl2 = 0; indexOfl2 < l2.numberOfElements(); indexOfl2++) {
                    if (l2.getNodeI(indexOfl2) == l1.getNodeI(indexOfl1)) {
                        l3.insertLast(l1.getNodeI(indexOfl1));
                    }
                }
            }
        }
        if (l1.numberOfElements() > l2.numberOfElements()) {
            for (int indexOfl2 = 0; indexOfl2 < l2.numberOfElements(); indexOfl2++) {
                for (int indexOfl1 = 0; indexOfl1 < l1.numberOfElements(); indexOfl1++) {
                    if (l1.getNodeI(indexOfl1) == l2.getNodeI(indexOfl2)) {
                        l3.insertLast(l2.getNodeI(indexOfl2));
                    }
                }
            }
        }
        return l3;
    }

    public void removeDuplicates(LinkedList A) {
        Node temp = head.getNext();
        Node previous = head;
        while (temp != null) {
            for (int index = 0; index < A.numberOfElements(); index++) {
                if (previous.getData() == temp.getData()) {
                    deleteNode(previous);
                }
                temp = temp.getNext();
                previous = previous.getNext();
            }
        }
    }

    public void printOddNodes() {
        Node temp = head;
        while (temp != null) {
            for (int index = 0; index < numberOfElements(); index++) {
                if (index % 2 != 0) {
                    System.out.print(temp.getData() + " ");
                }
                temp = temp.getNext();
            }
        }
    }

    public void deleteNode(Node node) {
        if (node == head) {
            deleteFirst();
        } else if (node == tail) {
            deleteLast();
        } else {
            deleteMiddle(node);
        }
    }

    public void sortList() {
        Node current = head; //Node current will point to head
        Node index = null;
        int temp;
        if (head == null) {
            return;
        } else {
            while (current != null) {
                //Node index will point to node next to current
                index = current.next;
                while (index != null) {
                    //If current node's data is greater than index's node data, swap the data between them
                    if (current.data > index.data) {
                        temp = current.data;
                        current.data = index.data;
                        index.data = temp;
                    }
                    index = index.next;
                }
                current = current.next;
            }
        }
    }

    public void deleteValue(int value) {
        Node temp = head;
        Node previous = null;
        while (temp != null) {
            if (temp.getData() == value) {
                if (previous != null) {
                    previous.setNext(temp.next);
                    if (temp.next == null) {
                        tail = previous;
                    }
                } else {
                    head = temp.next;
                    if (head == null) {
                        tail = null;
                    }
                }
                break;
            }
            previous = temp;
            temp = temp.getNext();
        }
    }
}
