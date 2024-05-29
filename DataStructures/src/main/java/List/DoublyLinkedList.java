package List;

public class DoublyLinkedList extends LinkedList {

    public void doublyInsertFirst(DoublyNode newNode) {
        if (tail == null) {
            tail = newNode;
        } else {
            ((DoublyNode) head).setPrevious(newNode);
        }
        newNode.setNext(head);
        head = newNode;
    }

    public void doublyInsertMiddle(DoublyNode newNode, DoublyNode previous) {
        newNode.setNext(previous.getNext());
        newNode.setPrevious(previous);
        ((DoublyNode)previous.getNext()).setPrevious(newNode);
        previous.setNext(newNode);
    }

    public void doublyInsertLast(DoublyNode newNode) {
        if (head == null) {
            head = newNode;
        } else {
            tail.setNext(newNode);
        }
        newNode.setPrevious((DoublyNode)tail);
        tail = newNode;
    }

    public void doublyDeleteFirst() {
        head = head.getNext();
        if (head == null) {
            tail = null;
        } else {
            ((DoublyNode)head).setPrevious(null);
        }
    }

    public void doublyDeleteMiddle(DoublyNode node) {
        ((DoublyNode)node.getNext()).setPrevious(node.getPrevious());
        node.getPrevious().setNext(node.getNext());
    }

    public void doublyDeleteLast() {
        tail = ((DoublyNode)tail).getPrevious();
        if (tail == null) {
            head = null;
        } else {
            tail.setNext(null);
        }
    }

    public DoublyNode search(int value) {
        DoublyNode temp = (DoublyNode)head;
        while (temp != null) {
            if (temp.getData() == value) {
                return temp;
            }
            temp = (DoublyNode)temp.getNext();
        }
        return null;
    }

    public void deleteBefore(DoublyNode X) {
       DoublyNode temp = X.getPrevious();
       if (temp == head) {
           deleteFirst();
       } else {
           deleteMiddle(temp);
       }
    }

    public DoublyNode middle() {
        DoublyNode temp1 = (DoublyNode)head;
        int numberOfElements = 0;
        while (temp1 != null) {
            numberOfElements++;
            temp1 = (DoublyNode)temp1.getNext();
        }
        DoublyNode temp2 = (DoublyNode)head;
        if (numberOfElements == 1) {
            return temp2;
        }
        int i = 0;
        while (temp2 != null) {
            if (numberOfElements % 2 != 0 && numberOfElements / 2 == i) {
                return temp2;
            }
            temp2 = (DoublyNode)temp2.getNext();
            i++;
        }
        return null;
    }

    public void doubleList() {
        DoublyNode temp = (DoublyNode)head;
        DoublyNode previous = null;
        while (temp != null) {
            if (temp == head) {
                doublyInsertFirst(temp);
                previous = (DoublyNode)head;
            } else if (temp == tail) {
                doublyInsertLast(temp);
            } else {
                doublyInsertMiddle(temp, previous);
                previous = (DoublyNode)previous.getNext();
            }
            temp = (DoublyNode)temp.getNext();
        }
    }

    public void removeKth(int K) {
        DoublyNode temp = (DoublyNode)head;
        int i = 1;
        while (temp != null) {
            if (i == K) {
                if (temp == head) {
                    doublyDeleteFirst();
                } else if (temp == tail) {
                    doublyDeleteLast();
                } else {
                    doublyDeleteMiddle(temp);
                }
            }
            temp = (DoublyNode)temp.getNext();
            i++;
        }
    }
}
