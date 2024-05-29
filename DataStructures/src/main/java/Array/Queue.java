package Array;

public class Queue {
    private Element[] array;
    private int first;
    private int last;
    private int N;

    public Queue(int N) {
        this.N = N;
        array = new Element[N];
        first = 0;
        last = 0;
    }

    public boolean isFull() {
        return (last + 1) % N == first;
    }

    public boolean isEmpty() {
        return first == last;
    }

    public void enqueue(Element element) {
        if (!isFull()) {
            array[last] = element;
            last = (last + 1) % N;
        }
    }

    public Element dequeue() {
        if (!isEmpty()) {
            Element temp = array[first];
            first = (first + 1) % N;
            return temp;
        }
        return null;
    }

    public void print() {
        for (int i = first; i < last; i++) {
            System.out.print(array[i].getData() + " ");
        }
    }

    public void moveToRear() {
        Element e = dequeue();
        enqueue(e);
    }

    public void enlarge() {
        N = N * 2;
        Queue q = new Queue(N);
        for (int i = first; i < last; i++) {
            q.enqueue(array[i]);
        }
    }

    public int largest() {
        int max;
        Queue q = new Queue(100);
        if (isEmpty()) {
            return -1;
        } else {
            max = dequeue().getData();
            q.enqueue(new Element(max));
            while (!isEmpty()) {
                int k = dequeue().getData();
                q.enqueue(new Element(k));
                if (k > max) {
                    max = k;
                }
            }
            while (!q.isEmpty()) {
                enqueue(q.dequeue());
            }
        }
        return max;
    }

    public void insertSecond(Element newElement) {
        Queue q = new Queue(100);
        if (!isFull()) {
            while (!isEmpty()) {
                q.enqueue(dequeue());
            }
            enqueue(q.dequeue());
            enqueue(newElement);
            while (!q.isEmpty()) {
                enqueue(q.dequeue());
            }
        }
    }

    public void shrink(int M) {
        Queue q1 = new Queue(N - (M - 1));
        while (!q1.isFull()) {
            q1.enqueue(dequeue());
        }
    }

    public void insertAfterKth(Element newElement, int k) {
        Queue q = new Queue(100);
        if (!isFull()) {
            while (!isEmpty()) {
                q.enqueue(dequeue());
            }
            for (int i = 0; i <= k; i++) {
                enqueue(q.dequeue());
            }
            enqueue(newElement);
            while (!q.isEmpty()) {
                enqueue(q.dequeue());
            }
        }
    }

    public void deleteKth(int K) {
        Queue q = new Queue(100);
        if (!isEmpty()) {
            for (int i = 0; i < K; i++) {
                q.enqueue(dequeue());
            }
            Element e = dequeue(); // Kth element
            while (!isEmpty()) {
                q.enqueue(dequeue());
            }
            while (!q.isEmpty()) {
                enqueue(q.dequeue());
            }
        }
    }

    public void bringFront() {
        Queue q = new Queue(100);
        if(!isEmpty()) {
            for (int i = 0; i < last - 1; i++) {
                q.enqueue(dequeue());
            }
            while (!q.isEmpty()) {
                enqueue(q.dequeue());
            }
        }
    }
}
