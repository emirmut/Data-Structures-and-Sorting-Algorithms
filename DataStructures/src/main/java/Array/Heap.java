package Array;

public class Heap { //  Priority queue
    protected HeapNode[] array;
    protected int count;
    protected int N;

    public Heap(int N) {
        array = new HeapNode[N];
        count = 0;
        this.N = N;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public boolean isFull() {
        return count == N;
    }

    public void print() {
        for (int i = 0; i < count; i++) {
            System.out.print(array[i].getData() + " ");
        }
    }

    public void swapNode(int index1, int index2) {
        HeapNode temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    public void percolateDown(int current) {
        int left = 2 * current + 1;
        int right = 2 * current + 2;
        while ((left < count && array[current].getData() < array[left].getData()) ||
                (right < count && array[current].getData() < array[right].getData())) {
            if (array[left].getData() > array[right].getData() || right >= count) {
                swapNode(current, left);
                current = left;
            } else {
                swapNode(current, right);
                current = right;
            }
            left = 2 * current + 1;
            right = 2 * current + 2;
        }
    }

    public HeapNode deleteMax() {
        HeapNode temp = array[0];
        array[0] = array[count - 1];
        percolateDown(0);
        count--;
        return temp;
    }

    public void percolateUp(int current) {
        int parent = (current - 1) / 2;
        while (parent >= 0 && array[current].getData() > array[parent].getData()) {
            swapNode(parent, current);
            current = parent;
            parent = (current - 1) / 2;
        }
    }

    public void insert(HeapNode node) {
        count++;
        array[count - 1] = node;
        percolateUp(count - 1);
    }

    public void update(int indexToBeChanged, int newValue) {
        int oldValue = array[indexToBeChanged].getData();
        array[indexToBeChanged].setData(newValue);
        if (oldValue > newValue) {
            percolateDown(indexToBeChanged);
        } else {
            percolateUp(indexToBeChanged);
        }
    }

    public int smallest() {
        if (!isEmpty()) {
            int smallest = array[0].getData();
            for (int i = 0; i < count; i++) {
                if (array[i].getData() < smallest) {
                    smallest = array[i].getData();
                }
            }
            return smallest;
        }
        return -1; // like an error code if the heap is empty.
    }

    public int kthLargest(int[] A, int k) {
        Heap h = new Heap(100);
        HeapNode node = null;
        for (int i = 0; i < A.length; i++) {
            node = new HeapNode(A[i]);
            h.insert(node);
        }
        for (int i = 0; i < k; i++) {
            node = h.deleteMax();
        }
        return node.getData();
    }

    public void printLargerThanX(int X) {
        if (!isEmpty()) {
            for (int i = 0; i < count; i++) {
                if (array[i].getData() > X) {
                    System.out.print(array[i].getData() + " ");
                }
            }
        }
    }

    public HeapNode kthMaximum(int k) {
        if (!isEmpty()) {
            HeapNode temp = null;
            for (int i = 0; i < k; i++) {
                temp = deleteMax();
            }
            return temp;
        }
        return null;
    }

    public boolean heapOrder(int[] A) {
        Heap h = new Heap(100);
        HeapNode node;
        for (int i = 0; i < A.length; i++) {
            node = new HeapNode(A[i]);
            h.insert(node);
        }
        for (int i = 0; i < h.count; i++) {
            if (h.array[i].getData() != A[i]) {
                return false;
            }
        }
        return true;
    }

    public HeapNode largestChild(int index) {
        int left = 2 * index + 1;
        int right = 2 * index + 2;
        if ((left < count && right < count && array[left].getData() > array[right].getData()) || (right >= count && left < count)) {
            return array[left];
        }
        if ((right < count && left < count && array[right].getData() >= array[left].getData())) {
            return array[right];
        }
        return null;
    }

    public void swapWithSmallest(int index) {
        int left = 2 * index + 1;
        int right = 2 * index + 2;
        if (!isEmpty()) {
            if ((left < count && right < count && array[left].getData() < array[right].getData()) || (right >= count && left < count)) {
                swapNode(index, left);
                index = left;
                left = 2 * index + 1;
                right = 2 * index + 2;
            }
            if ((right < count && left < count && array[right].getData() <= array[left].getData())) {
                swapNode(index, right);
                index = right;
                right = 2 * index + 2;
                left = 2 * index + 1;
            }
        }
    }

    public int maxGrandChild(int current) {
        int left = 2 * current + 1;
        int right = 2 * current + 2;
        int leftleftchild = 4 * current + 3;
        int leftrightchild = 4 * current + 4;
        int rightleftchild = 4 * current + 5;
        int rightrightchild = 4 * current + 6;
        if (!isEmpty()) {
            if (left < count && right < count) {
                if ((leftleftchild < count && leftrightchild < count && array[leftleftchild].getData() > array[leftrightchild].getData()) ||
                        (leftrightchild >= count && leftleftchild < count)) {
                    return leftleftchild;
                }
                if ((leftrightchild < count && leftleftchild < count && array[leftrightchild].getData() > array[leftleftchild].getData()) ||
                        (leftleftchild >= count && leftrightchild < count)) {
                    return leftrightchild;
                }
                if ((rightleftchild < count && rightrightchild < count && array[rightleftchild].getData() > array[rightrightchild].getData()) ||
                        (rightrightchild >= count && rightleftchild < count)) {
                    return rightleftchild;
                }
                if ((rightrightchild < count && rightleftchild < count && array[rightrightchild].getData() > array[rightleftchild].getData()) ||
                        (rightleftchild >= count && rightrightchild < count)) {
                    return rightrightchild;
                }
            }
            if (left < count && right >= count) {
                if ((leftleftchild < count && leftrightchild < count && array[leftleftchild].getData() > array[leftrightchild].getData()) ||
                        (leftrightchild >= count && leftleftchild < count)) {
                    return leftleftchild;
                }
                if ((leftrightchild < count && leftleftchild < count && array[leftrightchild].getData() > array[leftleftchild].getData()) ||
                        (leftleftchild >= count && leftrightchild < count)) {
                    return leftrightchild;
                }
            }
        }
        return -1; // like an error code if the heap is empty.
    }

    public int grandParent(int current) {
        int grandParent = (current - 3) / 4;
        if (!isEmpty() && grandParent >= 0) {
            return grandParent;
        }
        return -1; // like an error code if the heap is empty.
    }

    public int depth(int index) {
        int depth = 0;
        while (index != 0) {
            index = (index - 1) / 2;
            depth++;
        }
        return depth;
    }

    public int height(int index) {
        int height = -1;
        while (index < count) {
            index = 2 * index + 1;
            height++;
        }
        return height;
    }

    public int sumOfDescendants(int index) {
        if (index * 2 + 2 < count) {
            return array[index * 2 + 1].getData() + array[index * 2 + 2].getData()
                    + sumOfDescendants(index * 2 + 1) + sumOfDescendants(index * 2 + 2);
        } else if (index * 2 + 1 < count - 1) {
            return array[index * 2 + 1].getData();
        } else {
            return 0;
        }
    }
}
