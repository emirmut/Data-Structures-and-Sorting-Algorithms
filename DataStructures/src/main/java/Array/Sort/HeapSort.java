package Array.Sort;

import Array.Heap;
import Array.HeapNode;

public class HeapSort implements Sort {
    @Override
    public void sort(int[] A) { // sorts the array from largest to smallest
        Heap heap = new Heap(A.length);
        for (int i = 0; i < A.length; i++) {
            heap.insert(new HeapNode(A[i]));
        }
        for (int i = 0; i < A.length; i++) {
            HeapNode node = heap.deleteMax();
            A[i] = node.getData();
        }
    }
}
