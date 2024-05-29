package Array;

public class Hash {
    private Element[] table;
    private boolean[] deleted;
    private int N;

    public Hash(int N) {
        table = new Element[N];
        deleted = new boolean[N];
        this.N = N;
    }

    private int hashFunction(int value) {
        return value % N;
    }

    /*public int hashFunction(String value) {   // Hash function for strings
        int pos = 0;
        for (int i = 0; i < value.length(); i++) {
            pos = 36 * pos + value.charAt(i);
        }
        pos = pos % N;
        return pos;
    }*/

    public Element linearSearch(int value) {
        int address = hashFunction(value);
        while (table[address] != null) {
            if (!deleted[address] && table[address].getData() == value) {
                break;
            }
            address = (address + 1) % N;
        }
        return table[address];
    }

    public void deleteValue(int value) {
        int address = hashFunction(value);
        while (table[address] != null) {
            if (!deleted[address] && table[address].getData() == value) {
                break;
            }
            address = (address + 1) % N;
        }
        deleted[address] = true;
    }

    public void insert(int value) {
        int address = hashFunction(value);
        while (table[address] != null && !deleted[address]) {
            address = (address + 1) % N;
        }
        if (table[address] != null) {
            deleted[address] = false;
        }
        table[address] = new Element(value);
    }

    public void print() {
        for (int i = 0; i < N; i++) {
            if (table[i] != null) {
                System.out.println(table[i].getData() + " ");
            } else {
                System.out.println();
            }
        }
    }

    public Element quadraticSearch(int value) {
        int address = hashFunction(value);
        int i = 1;
        while (table[address] != null) {
            if (!deleted[address] && table[address].getData() == value) {
                break;
            }
            address = (address + i * i) % N;
            i++;
        }
        return table[address];
    }

    public double loadFactor() {
        double count = 0;
        if (N != 0) {
            for (int i = 0; i < N; i++) {
                if (table[i] != null) {
                    count++;
                }
            }
        }
        return count / N;
    }

    public int between(int X, int Y) {
        int count = 0;
        for (int i = 0; i < N; i++) {
            if (table[i].getData() > X && table[i].getData() < Y) {
                count++;
            }
        }
        return count;
    }

    public void undelete(int value) {
        int address = hashFunction(value);
        while (table[address] == null) {
            if (deleted[address]) {
                break;
            }
            address = (address + 1) % N;
        }
        insert(value);
        deleted[address] = false;
    }

    public Element minimum() {
        int min = 999999999;
        for (int i = 0; i < N; i++) {
            if (table[i] != null && table[i].getData() < min) {
                min = table[i].getData();
            }
        }
        return new Element(min);
    }

    public int numberOfEmptySlots() {
        int count = 0;
        for (int i = 0; i < N; i++) {
            if (table[i] == null || deleted[i]) {
                count++;
            }
        }
        return count;
    }
}
