package Array.Sort;

import List.DoublyLinkedList;

public class InsertionSort implements Sort {
    // https://www.youtube.com/watch?v=8mJ-OhcfpYg mantığı için izleyebilirsin ama implementationlar farklı
    @Override
    public void sort(int[] A) {
        for (int j = 1; j < A.length; j++) {
            int t = A[j];
            int i = j - 1;
            while (i >= 0 && t < A[i]) {
                A[i + 1] = A[i];
                i--;
            }
            A[i + 1] = t;
        }
    }
}
