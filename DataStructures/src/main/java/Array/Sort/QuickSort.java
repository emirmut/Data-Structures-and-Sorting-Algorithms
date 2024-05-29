package Array.Sort;

public class QuickSort implements Sort {
    // https://www.youtube.com/watch?v=Vtckgz38QHs
    private int partition(int[] A, int first, int last) {
        int pivot = A[last];
        int i = first - 1;
        for (int j = first; j < last; j++) {
            if (A[j] <= pivot) {
                i++;
                int temp = A[i];
                A[i] = A[j];
                A[j] = temp;
            }
        }
        int temp = A[i + 1];
        A[i + 1] = A[last];
        A[last] = temp;
        return i + 1; // pivot's position
    }

    private void quickSort(int[] A, int first, int last) {
        if (first < last) {
            int pivot = partition(A, first, last);
            quickSort(A, first, pivot - 1);
            quickSort(A, pivot + 1, last);
        }
    }

    public void sort(int[] A) {
        quickSort(A, 0, A.length - 1);
    }
}
