package List;

public class Hash {
    private LinkedList[] table;
    private int N;

    public Hash(int N) {
        table = new LinkedList[N];
        for (int i = 0; i < N; i++) {
            table[i] = new LinkedList();
        }
        this.N = N;
    }

    private int hashFunction(int value) {
        return value % N;
    }

    public Node search(int value) {
        int address = hashFunction(value);
        return table[address].search(value); // search method in linked-list class
    }

    public void insert(int value) {
        int address = hashFunction(value);
        table[address].insertLast(new Node(value));
    }

    public void insert(Node node) {
        int address = hashFunction(node.getData());
        table[address].insertLast(node);
    }

    public void deleteValue(int value) {
        if (search(value) != null) {
            int address = hashFunction(value);
            table[address].deleteValue(value); // deleteValue method in linked-list class
        }
    }

    public void print() {
        for (int i = 0; i < N; i++) {
            System.out.println(table[i] + " ");
        }
    }

    public Node maximum() {
        int max = -1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < table[i].numberOfElements(); j++) {
                if (table[i].getNodeI(j).getData() > max) {
                    max = table[i].getNodeI(j).getData();
                }
            }
        }
        return new Node(max);
    }

    public double loadFactor() {
        double count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < table[i].numberOfElements(); j++) {
                count++;
            }
        }
        return count / N;
    }

    public int numberOfEmptySlots() {
        int count = 0;
        for (int i = 0; i < N; i++) {
            if (table[i].numberOfElements() == 0) {
                count++;
            }
        }
        return count;
    }
}
