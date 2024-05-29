import List.DoublyLinkedList;
import List.DoublyNode;
import List.LinkedList;
import List.Node;
import org.junit.Test;

public class LinkedListTest {
    @Test
    public void TestInsertFirst() {
        LinkedList list = new LinkedList();
        list.insertFirst(new Node(4));
        list.insertFirst(new Node(5));
        list.insertFirst(new Node(6));
        System.out.println(list.toString());
    }

    @Test
    public void TestInsertLast() {
        LinkedList list = new LinkedList();
        list.insertLast(new Node(4));
        list.insertLast(new Node(5));
        list.insertLast(new Node(6));
        System.out.println(list.toString());
    }

    @Test
    public void TestDeleteFirst() {
        LinkedList list = new LinkedList();
        list.insertFirst(new Node(4));
        list.insertFirst(new Node(5));
        list.insertFirst(new Node(6));
        System.out.println(list.toString());
        list.deleteFirst();
        System.out.println(list.toString());
        list.deleteFirst();
        System.out.println(list.toString());
        list.deleteFirst();
        System.out.println(list.toString());
    }

    @Test
    public void TestDeleteLast() {
        LinkedList list = new LinkedList();
        list.insertFirst(new Node(4));
        list.insertFirst(new Node(5));
        list.insertFirst(new Node(6));
        System.out.println(list.toString());
        list.deleteLast();
        System.out.println(list.toString());
        list.deleteLast();
        System.out.println(list.toString());
        list.deleteLast();
        System.out.println(list.toString());
    }

    @Test
    public void TestDeleteMiddle() {
        LinkedList list = new LinkedList();
        list.insertFirst(new Node(4));
        list.insertFirst(new Node(5));
        list.insertFirst(new Node(6));
        list.insertFirst(new Node(7));
        list.insertFirst(new Node(8));
        list.insertFirst(new Node(9));
        list.insertFirst(new Node(10));
        list.insertFirst(new Node(11));
        System.out.println(list.toString());
        list.deleteMiddle(list.search(6));
        System.out.println(list.toString());
        list.deleteMiddle(list.search(8));
        System.out.println(list.toString());
        list.deleteMiddle(list.search(7));
        System.out.println(list.toString());
    }

    @Test
    public void TestInsertFirstInDoublyLinkedList() {
        DoublyLinkedList doublyList = new DoublyLinkedList();
        doublyList.doublyInsertFirst(new DoublyNode(4));
        doublyList.doublyInsertFirst(new DoublyNode(5));
        doublyList.doublyInsertFirst(new DoublyNode(6));
        System.out.println(doublyList.toString());
    }

    @Test
    public void TestInsertMiddleInDoublyLinkedList() {
        DoublyLinkedList doublyList = new DoublyLinkedList();
        doublyList.doublyInsertFirst(new DoublyNode(4));
        doublyList.doublyInsertFirst(new DoublyNode(5));
        doublyList.doublyInsertFirst(new DoublyNode(6));
        System.out.println(doublyList.toString());
        doublyList.doublyInsertMiddle(new DoublyNode(7), doublyList.search(6));
        System.out.println(doublyList.toString());
        doublyList.doublyInsertMiddle(new DoublyNode(8), doublyList.search(5));
        System.out.println(doublyList.toString());
    }

    @Test
    public void TestInsertLastInDoublyLinkedList() {
        DoublyLinkedList doublyList = new DoublyLinkedList();
        doublyList.doublyInsertLast(new DoublyNode(4));
        doublyList.doublyInsertLast(new DoublyNode(5));
        doublyList.doublyInsertLast(new DoublyNode(6));
        System.out.println(doublyList.toString());
    }

    @Test
    public void TestSmallest() {
        LinkedList list = new LinkedList();
        list.insertLast(new Node(9));
        list.insertLast(new Node(5));
        list.insertLast(new Node(2));
        list.insertLast(new Node(7));
        list.insertLast(new Node(8));
        System.out.println(list.toString());
        System.out.println(list.smallest());
    }

    @Test
    public void TestDeleteSecond() {
        LinkedList list = new LinkedList();
        list.insertLast(new Node(9));
        list.insertLast(new Node(5));
        list.insertLast(new Node(5));
        list.insertLast(new Node(7));
        list.insertLast(new Node(8));
        System.out.println(list.toString());
        list.deleteSecond();
        System.out.println(list.toString());
        list.deleteSecond();
        System.out.println(list.toString());
    }

    @Test
    public void TestInsertSecond() {
        LinkedList list = new LinkedList();
        list.insertLast(new Node(9));
        list.insertLast(new Node(5));
        list.insertLast(new Node(5));
        list.insertLast(new Node(7));
        list.insertLast(new Node(8));
        System.out.println(list.toString());
        list.insertSecond(new Node(2));
        System.out.println(list.toString());
        list.insertSecond(new Node(3));
        System.out.println(list.toString());
    }

    @Test
    public void TestPrime() {
        LinkedList list = new LinkedList();
        System.out.println(list.prime(31));
    }

    @Test
    public void TestDeleteOddIndexedElements() {
        LinkedList list = new LinkedList();
        list.insertLast(new Node(4));
        list.insertLast(new Node(5));
        list.insertLast(new Node(6));
        list.insertLast(new Node(7));
        list.insertLast(new Node(8));
        list.insertLast(new Node(9));
        list.insertLast(new Node(10));
        list.insertLast(new Node(11));
        System.out.println(list.toString());
        System.out.println(list.deleteOddIndexedElements());
        System.out.println(list.toString());
    }

    @Test
    public void TestDeleteEvenIndexedElements() {
        LinkedList list = new LinkedList();
        list.insertLast(new Node(4));
        list.insertLast(new Node(5));
        list.insertLast(new Node(6));
        list.insertLast(new Node(7));
        list.insertLast(new Node(8));
        list.insertLast(new Node(9));
        list.insertLast(new Node(10));
        list.insertLast(new Node(11));
        System.out.println(list.toString());
        list.deleteEvenIndexedElements();
        System.out.println(list.toString());
    }

    @Test
    public void TestInsertBeforeLast() {
        LinkedList list = new LinkedList();
        list.insertLast(new Node(9));
        list.insertLast(new Node(5));
        list.insertLast(new Node(5));
        list.insertLast(new Node(7));
        list.insertLast(new Node(8));
        System.out.println(list.toString());
        list.insertBeforeLast(new Node(15));
        System.out.println(list.toString());
        list.insertBeforeLast(new Node(11));
        System.out.println(list.toString());
    }

    @Test
    public void TestAddToSortedList() {
        LinkedList list1 = new LinkedList();
        list1.insertLast(new Node(4));
        list1.insertLast(new Node(5));
        list1.insertLast(new Node(6));
        list1.insertLast(new Node(7));
        list1.insertLast(new Node(8));
        list1.insertLast(new Node(9));
        list1.insertLast(new Node(10));
        list1.insertLast(new Node(11));
        System.out.println(list1.toString());
        list1.AddToSortedList(7);
        System.out.println(list1.toString());
    }

    @Test
    public void TestDeleteKth() {
        LinkedList list1 = new LinkedList();
        list1.insertLast(new Node(4));
        list1.insertLast(new Node(5));
        list1.insertLast(new Node(6));
        list1.insertLast(new Node(7));
        list1.insertLast(new Node(8));
        list1.insertLast(new Node(9));
        list1.insertLast(new Node(10));
        list1.insertLast(new Node(11));
        System.out.println(list1.toString());
        list1.deleteKth(6);
        System.out.println(list1.toString());
    }

    @Test
    public void TestMove() {
        LinkedList list1 = new LinkedList();
        list1.insertLast(new Node(4));
        list1.insertLast(new Node(5));
        list1.insertLast(new Node(6));
        list1.insertLast(new Node(7));
        list1.insertLast(new Node(8));
        list1.insertLast(new Node(9));
        list1.insertLast(new Node(10));
        list1.insertLast(new Node(11));
        System.out.println(list1.toString());
        list1.move(list1.search(6), 3);
        System.out.println(list1.toString());
    }

    @Test
    public void TestPrimeFactors() {
        LinkedList list1 = new LinkedList();
        System.out.print(list1.primeFactors(400));
    }

    @Test
    public void TestRemoveDivisibleByN() {
        LinkedList list1 = new LinkedList();
        list1.insertLast(new Node(4));
        list1.insertLast(new Node(5));
        list1.insertLast(new Node(6));
        list1.insertLast(new Node(7));
        list1.insertLast(new Node(8));
        list1.insertLast(new Node(9));
        list1.insertLast(new Node(10));
        list1.insertLast(new Node(11));
        System.out.println(list1.toString());
        System.out.println(list1.removeDivisibleByN(120));
        System.out.println(list1.toString());
    }

    @Test
    public void TestReverse() {
        LinkedList list1 = new LinkedList();
        list1.insertLast(new Node(4));
        list1.insertLast(new Node(5));
        list1.insertLast(new Node(6));
        list1.insertLast(new Node(7));
        list1.insertLast(new Node(8));
        list1.insertLast(new Node(9));
        list1.insertLast(new Node(10));
        list1.insertLast(new Node(11));
        System.out.println(list1.toString());
        System.out.println(list1.reverse());
    }

    @Test
    public void TestMiddle() {
        DoublyLinkedList doublyList1 = new DoublyLinkedList();
        doublyList1.doublyInsertLast(new DoublyNode(4));
        doublyList1.doublyInsertLast(new DoublyNode(5));
        doublyList1.doublyInsertLast(new DoublyNode(6));
        doublyList1.doublyInsertLast(new DoublyNode(14));
        doublyList1.doublyInsertLast(new DoublyNode(21));
        doublyList1.doublyInsertLast(new DoublyNode(1));
        doublyList1.doublyInsertLast(new DoublyNode(2));
        System.out.println(doublyList1.toString());
        System.out.println(doublyList1.middle().toString());
    }

    @Test
    public void TestDoubleList() {
        DoublyLinkedList doublyList1 = new DoublyLinkedList();
        doublyList1.doublyInsertLast(new DoublyNode(4));
        doublyList1.doublyInsertLast(new DoublyNode(5));
        doublyList1.doublyInsertLast(new DoublyNode(6));
        doublyList1.doublyInsertLast(new DoublyNode(14));
        doublyList1.doublyInsertLast(new DoublyNode(21));
        doublyList1.doublyInsertLast(new DoublyNode(1));
        doublyList1.doublyInsertLast(new DoublyNode(2));
        System.out.println(doublyList1.toString());
        doublyList1.doubleList();
        System.out.println(doublyList1.toString());
    }

    @Test
    public void TestDeleteBefore() {
        DoublyLinkedList doublyList1 = new DoublyLinkedList();
        doublyList1.doublyInsertLast(new DoublyNode(4));
        doublyList1.doublyInsertLast(new DoublyNode(5));
        doublyList1.doublyInsertLast(new DoublyNode(6));
        doublyList1.doublyInsertLast(new DoublyNode(14));
        doublyList1.doublyInsertLast(new DoublyNode(21));
        doublyList1.doublyInsertLast(new DoublyNode(13));
        System.out.println(doublyList1.toString());
        doublyList1.deleteBefore(doublyList1.search(5));
        System.out.println(doublyList1.toString());
        DoublyLinkedList doublyList2 = new DoublyLinkedList();
        doublyList2.doublyInsertLast(new DoublyNode(4));
        doublyList2.doublyInsertLast(new DoublyNode(5));
        doublyList2.doublyInsertLast(new DoublyNode(6));
        doublyList2.doublyInsertLast(new DoublyNode(14));
        doublyList2.doublyInsertLast(new DoublyNode(21));
        doublyList2.doublyInsertLast(new DoublyNode(13));
        System.out.println(doublyList2.toString());
        doublyList2.deleteBefore(doublyList2.search(13));
        System.out.println(doublyList2.toString());
    }

    @Test
    public void TestPrintOddNodes() {
        LinkedList list1 = new LinkedList();
        list1.insertFirst(new Node(4));
        list1.insertFirst(new Node(5));
        list1.insertFirst(new Node(6));
        list1.insertFirst(new Node(7));
        list1.insertFirst(new Node(8));
        list1.insertFirst(new Node(9));
        list1.insertFirst(new Node(10));
        list1.insertFirst(new Node(11));
        System.out.println(list1.toString());
        list1.printOddNodes();
        System.out.println();
        LinkedList list2 = new LinkedList();
        list2.insertFirst(new Node(9));
        list2.insertFirst(new Node(5));
        list2.insertFirst(new Node(3));
        list2.insertFirst(new Node(7));
        list2.insertFirst(new Node(8));
        System.out.println(list2.toString());
        list2.printOddNodes();
    }

    @Test
    public void TestDeleteNode() {
        LinkedList list1 = new LinkedList();
        list1.insertLast(new Node(4));
        list1.insertLast(new Node(5));
        list1.insertLast(new Node(5));
        list1.insertLast(new Node(6));
        list1.insertLast(new Node(8));
        list1.insertLast(new Node(9));
        System.out.println(list1.toString());
        list1.deleteNode(list1.search(9));
        System.out.println(list1.toString());
    }

    @Test
    public void TestRemoveKth() {
        DoublyLinkedList doublyList1 = new DoublyLinkedList();
        doublyList1.doublyInsertLast(new DoublyNode(4));
        doublyList1.doublyInsertLast(new DoublyNode(5));
        doublyList1.doublyInsertLast(new DoublyNode(6));
        System.out.println(doublyList1.toString());
        doublyList1.removeKth(1);
        System.out.println(doublyList1.toString());
        DoublyLinkedList doublyList2 = new DoublyLinkedList();
        doublyList2.doublyInsertLast(new DoublyNode(4));
        doublyList2.doublyInsertLast(new DoublyNode(5));
        doublyList2.doublyInsertLast(new DoublyNode(6));
        doublyList2.doublyInsertLast(new DoublyNode(14));
        doublyList2.doublyInsertLast(new DoublyNode(21));
        doublyList2.doublyInsertLast(new DoublyNode(1));
        doublyList2.doublyInsertLast(new DoublyNode(2));
        System.out.println(doublyList2.toString());
        doublyList2.removeKth(3);
        System.out.println(doublyList2.toString());
    }

    @Test
    public void TestPalindrome() {
        LinkedList list1 = new LinkedList();
        list1.insertLast(new Node(4));
        list1.insertLast(new Node(5));
        list1.insertLast(new Node(6));
        list1.insertLast(new Node(7));
        list1.insertLast(new Node(6));
        list1.insertLast(new Node(5));
        list1.insertLast(new Node(4));
        System.out.println(list1.toString());
        System.out.println(list1.palindrome());
    }

    @Test
    public void TestDeleteAll() {
        LinkedList list1 = new LinkedList();
        list1.insertLast(new Node(4));
        list1.insertLast(new Node(5));
        list1.insertLast(new Node(6));
        list1.insertLast(new Node(7));
        list1.insertLast(new Node(6));
        list1.insertLast(new Node(5));
        list1.insertLast(new Node(4));
        System.out.println(list1.toString());
        list1.deleteAll(7);
        System.out.println(list1.toString());
    }

    @Test
    public void TestIntersection() {
        LinkedList list1 = new LinkedList();
        list1.insertLast(new Node(4));
        list1.insertLast(new Node(5));
        list1.insertLast(new Node(5));
        list1.insertLast(new Node(6));
        list1.insertLast(new Node(8));
        list1.insertLast(new Node(9));
        System.out.println(list1.toString());
        LinkedList list2 = new LinkedList();
        list2.insertLast(new Node(4));
        list2.insertLast(new Node(5));
        list2.insertLast(new Node(3));
        list2.insertLast(new Node(6));
        list2.insertLast(new Node(7));
        list2.insertLast(new Node(9));
        System.out.println(list2.toString());
        LinkedList list3 = new LinkedList();
        System.out.println(list3.intersection(list1, list2).toString());
    }

    @Test
    public void TestSortList() {
        LinkedList list1 = new LinkedList();
        list1.insertLast(new Node(9));
        list1.insertLast(new Node(4));
        list1.insertLast(new Node(8));
        list1.insertLast(new Node(14));
        list1.insertLast(new Node(1));
        list1.insertLast(new Node(0));
        System.out.println(list1.toString());
        list1.sortList();
        System.out.println(list1.toString());
    }
}
