package Array;

public class DHeap extends Heap {
    private int d;

    public DHeap(int N, int d) {
        super(N);
        this.d = d;
    }

    public void percolateDown(int current) {
        int child, largestChild;
        int value;
        do {
            largestChild = -1;
            value = array[current].getData();
            for (int i = 1; i <= d && d * current + i < count; i++) {
                child = d * current + i;
                if (value < array[child].getData()){
                    largestChild = child;
                    value = array[child].getData();
                }
            }
            if (largestChild != -1) {
                swapNode(current, largestChild);
                current = largestChild;
            } else {
                break;
            }
        } while (true);
    }

   public void percolateUp(int current) {
       int parent = (current - 1) / d;
       while (parent >= 0 && array[current].getData() > array[parent].getData()) {
           swapNode(parent, current);
           current = parent;
           parent = (current - 1) / d;
       }
    }
}
