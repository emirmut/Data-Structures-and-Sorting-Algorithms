package Array.Sort;

import List.DoublyLinkedList;
import List.DoublyNode;
import List.LinkedList;
import List.Node;
import org.junit.jupiter.api.Test;
import java.util.Arrays;

public class BubbleSort implements Sort {

    @Test
    public void test() {
        // System.out.print(misplacedPairs(new int[] {2, 4, 9, 13, 1, 7, 0, 6, 8, 11, 31}));
        // System.out.print(Arrays.toString(sort01(new int[] {0, 1, 1, 0, 1, 0, 0, 1, 0, 0, 1, 1, 1, 0, 1, 0, 0, 1})));
        /*int[] array = {0, 1, 2, 4, 6, 7, 8, 9, 11, 31, 14, 13};
        addMore(array);
        System.out.print(Arrays.toString(array));*/
        // System.out.print(Arrays.toString(union(new int[] {3, 4, 11, 16, 21}, new int[] {1, 2, 3, 8, 10, 15, 20})));
        // System.out.print(Arrays.toString(intersection(new int[] {1, 3, 5, 6, 7, 9, 13, 14, 17}, new int[] {0, 1, 2, 4, 5, 8, 12, 13, 15, 16, 19})));
        // System.out.print(Arrays.toString(nearestTwoNumbers(new int[] {1, 5, 9, 16, 36, 39, 64, 81, 100})));
        // System.out.print(existsFour(new int[] {0, 1, 2, 4, 5, 8, 12, 13, 15, 16, 19}, 43));
        /*LinkedList l1 = new LinkedList();
        l1.insertLast(new Node(1));
        l1.insertLast(new Node(5));
        l1.insertLast(new Node(8));
        l1.insertLast(new Node(12));
        l1.insertLast(new Node(16));
        l1.insertLast(new Node(21));
        l1.insertLast(new Node(22));
        LinkedList l2 = new LinkedList();
        l2.insertLast(new Node(2));
        l2.insertLast(new Node(3));
        l2.insertLast(new Node(7));
        l2.insertLast(new Node(16));
        l2.insertLast(new Node(18));
        l2.insertLast(new Node(20));
        l2.insertLast(new Node(24));
        System.out.print(merge(l1, l2).toString());*/
        // System.out.print(Arrays.toString(difference(new int[] {1, 3, 5, 6, 7, 9, 13, 14, 17}, new int[] {0, 1, 2, 4, 5, 8, 12, 13, 15, 16, 19})));
        /*LinkedList l = new LinkedList();
        l.insertLast(new Node(1));
        l.insertLast(new Node(2));
        l.insertLast(new Node(3));
        l.insertLast(new Node(5));
        l.insertLast(new Node(5));
        l.insertLast(new Node(6));
        l.insertLast(new Node(7));
        System.out.print(isSorted(l));*/
        // System.out.print(Arrays.toString(symmetric(new int[] {1, 3, 5, 6, 7, 9, 13, 14, 17}, new int[] {0, 1, 2, 4, 5, 8, 12, 13, 15, 16, 19})));
        // System.out.print(minDifference(new int[] {14, 10, 2, 6, 22, 45}));

    }
    @Override
    public void sort(int[] A) {
        boolean exchanged = true;
        while (exchanged) { // while exchange is on
            exchanged = false;
            for (int i = 0; i < A.length - 1; i++) {
                if (A[i] > A[i + 1]) {
                    exchanged = true;
                    int temp = A[i];
                    A[i] = A[i + 1];
                    A[i + 1] = temp;
                }
            }
        }
    }

    public int misplacedPairs(int[] A) {
        int count = 0;
        for (int i = 0; i < A.length - 1; i++) {
            if (A[i] > A[i + 1]) {
                count++;
            }
        }
        return count;
    }

    public int[] sort01(int[] A) {
        int[] B = new int[A.length];
        int j = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] == 0) {
                B[j] = 0;
                j++;
            }
        }
        for (int i = 0; i < A.length; i++) {
            if (A[i] == 1) {
                B[j] = 1;
                j++;
            }
        }
        return B;
    }

    public void addMore(int[] A) {
        for (int j = 1; j < A.length; j++) {
            int t = A[j];
            int i = j - 1;
            while (i >= 0 && A[i] > t) {
                A[i + 1] = A[i];
                i--;
            }
            A[i + 1] = t;
        }
    }

    public int[] union(int[] A, int[] B) {
        int[] C = new int[A.length + B.length];
        int k = 0, j = 0;
        for (int i = 0; i < C.length; i++) {
            if (k == A.length - 1) {
                C[i] = A[k];
            }
            if (j == B.length - 1) {
                C[i] = B[j];
            }
            if (k < A.length && j < B.length && A[k] <= B[j]) {
                C[i] = A[k];
                k++;
            } else if (k < A.length && j < B.length && B[j] <= A[k]){
                C[i] = B[j];
                j++;
            }
        }
        return C;
    }

    public int[] intersection(int[] A, int[] B) {
        int indexA = 0;
        int indexB = 0;
        int length = 0;
        while (indexA < A.length && indexB < B.length) {
            if (A[indexA] == B[indexB]) {
                length++;
                indexA++;
                indexB++;
            } else if (A[indexA] < B[indexB]) {
                indexA++;
            } else {
                indexB++;
            }
        }
        indexA = 0;
        indexB = 0;
        int[] C = new int[length];
        for (int i = 0; i < C.length; i++) {
            if (A[indexA] == B[indexB]) {
                C[i] = A[indexA];
                indexA++;
                indexB++;
            } else if (A[indexA] < B[indexB]) {
                indexA++;
                i--;
            } else {
                indexB++;
                i--;
            }
        }
        return C;
    }

    public int[] nearestTwoNumbers(int[] A) {
        for (int i = 0; i < A.length - 1; i++) { // selection sort
            int min = A[i];
            int pos = i;
            for (int j = i + 1; j < A.length; j++) {
                if (A[j] < min) {
                    min = A[j];
                    pos = j;
                }
            }
            if (pos != i) {
                A[pos] = A[i];
                A[i] = min;
            }
        }
        int[] C = new int[2];
        C[0] = A[0];
        C[1] = A[1];
        int nearestTwoNumbers = C[1] - C[0];
        for (int i = 1; i < A.length - 1; i++) {
            if (A[i + 1] - A[i] < nearestTwoNumbers) {
                nearestTwoNumbers = A[i + 1] - A[i];
                C[0] = A[i];
                C[1] = A[i + 1];
            }
        }
        return C;
    }

    public boolean existsFour(int[] A, int K) {
        for (int i = 1; i < A.length; i++) { // insertion sort
            int t = A[i];
            int j = i - 1;
            while (j >= 0 && t < A[j]) {
                A[j + 1] = A[j];
                j--;
            }
            A[j + 1] = t;
        }
        for (int i = 0; i < A.length - 3; i++) {
            for (int j = i + 1; j < A.length - 2; j++) {
                for (int k = j + 1; k < A.length - 1; k++) {
                    for (int l = k + 1; l < A.length; l++) {
                        if (A[i] + A[j] + A[k] + A[l] == K) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public LinkedList merge(LinkedList A, LinkedList B) {
        LinkedList C = new LinkedList();
        Node tempA = A.getHead();
        Node tempB = B.getHead();
        while (tempA != null || tempB != null) {
            if (tempA == null) {
                C.insertLast(tempB);
                tempB = tempB.getNext();
            } else if (tempB == null) {
                C.insertLast(tempA);
                tempA = tempA.getNext();
            } else if (tempA.getData() <= tempB.getData()) {
                C.insertLast(tempA);
                tempA = tempA.getNext();
            } else {
                C.insertLast(tempB);
                tempB = tempB.getNext();
            }
        }
        return C;
    }

    public int[] difference(int[] A, int[] B) {
        int length = 0;
        int indexA = 0;
        int indexB = 0;
        while (indexA < A.length && indexB < B.length) {
            if (A[indexA] == B[indexB]) {
                indexA++;
                indexB++;
            } else if (A[indexA] < B[indexB]) {
                length++;
                indexA++;
            } else {
                indexB++;
            }
        }
        int[] C = new int[length];
        indexA = 0;
        indexB = 0;
        for (int i = 0; i < C.length; i++) {
            if (indexA < A.length && (indexB == B.length || A[indexA] < B[indexB])) {
                C[i] = A[indexA];
                indexA++;
            } else if (indexB < B.length && (indexA == A.length || A[indexA] > B[indexB])) {
                indexB++;
                i--;
            } else {
                indexA++;
                indexB++;
                i--;
            }
        }
        return C;
    }

    public boolean isSorted(LinkedList A) {
        Node temp = A.getHead();
        while (temp.getNext() != null) {
            if (temp.getData() > temp.getNext().getData()) {
                return false;
            }
            temp = temp.getNext();
        }
        return true;
    }

    public int[] symmetric(int[] A, int[] B) {
        int length = 0;
        int indexA = 0;
        int indexB = 0;
        while (indexA < A.length && indexB < B.length) {
            if (A[indexA] < B[indexB]) {
                length++;
                indexA++;
            } else if (B[indexB] < A[indexA]) {
                length++;
                indexB++;
            } else {
                indexA++;
                indexB++;
            }
        }
        int[] C = new int[length];
        int i = 0, k = 0;
        int x = 0;
        while (i < A.length) {
            for (int j = 0; j < B.length; j++) {
                if (A[i] == B[j]) {
                    x = B[j];
                    break;
                }
            }
            if (A[i] != x) {
                C[k] = A[i];
                k++;
            }
            i++;
        }
        i = 0;
        x = 0;
        while (i < B.length) {
            for (int j = 0; j < A.length; j++) {
                if (B[i] == A[j]) {
                    x = A[j];
                    break;
                }
            }
            if (B[i] != x) {
                C[k] = B[i];
                k++;
            }
            i++;
        }
        return C;
    }

    public int minDifference(int[] A) {
        boolean exchanged = true;
        while (exchanged) {
            exchanged = false;
            for (int i = 0; i < A.length - 1; i++) {
                if (A[i] > A[i + 1]) {
                    exchanged = true;
                    int temp = A[i];
                    A[i] = A[i + 1];
                    A[i + 1] = temp;
                }
            }
        }
        if (A.length == 0) {
            return -1; // like an error code if number of elements of A is zero.
        } else if (A.length == 1) {
            return A[0];
        } else {
            int minDifference = A[1] - A[0];
            for (int i = 1; i < A.length - 1; i++) {
                if (A[i + 1] - A[i] < minDifference) {
                    minDifference = A[i + 1] - A[i];
                }
            }
            return minDifference;
        }
    }
}
