package Array;

public class DisjointSet {
    private Set[] sets;
    private int count;

    public DisjointSet(int count) {
        sets = new Set[count];
        for (int i = 0; i < count; i++) {
            sets[i] = new Set(i, i);
        }
        this.count = count;
    }

    public DisjointSet(int[] elements, int count) {
        sets = new Set[count];
        for (int i = 0; i < count; i++) {
            sets[i] = new Set(elements[i], i);
        }
        this.count = count;
    }

    public int findSetRecursive(int current) {
        int parent = sets[current].getParent();
        if (parent != current) {
            return findSetRecursive(parent);
        }
        return parent;
    }

    public int findSetIterative(int current) {
        int parent = sets[current].getParent();
        while (parent != current) {
            current = parent;
            parent = sets[current].getParent();
        }
        return parent; // could also have been "return current;".
    }

    public void unionOfSets(int index1, int index2) {
        int x = findSetIterative(index1);
        int y = findSetIterative(index2);
        if (sets[x].getDepth() < sets[y].getDepth()) {
            sets[x].setParent(y);
        } else {
            sets[y].setParent(x);
            if (sets[x].getDepth() == sets[y].getDepth()) {
                sets[x].incrementDepth();
            }
        }
    }

    public int height(int index) {
        int h = 1;
        int parent = sets[index].getParent();
        while (parent != index) {
            index = parent;
            parent = sets[index].getParent();
            h++;
        }
        return h;
    }

    public int numberOfDisjointSets() {
        int counter = 0;
        for (int i = 0; i < count; i++) {
            if (sets[i].getParent() == i) {
                counter++;
            }
        }
        return counter;
    }

    public int depth(int index) {
        int d = 0;
        int parent = sets[index].getParent();
        while (parent != index) {
            index = parent;
            parent = sets[index].getParent();
            d++;
        }
        return d;
    }

    public int numberOfChildren(int index) {
        int counter = 0;
        for (int i = 0; i < count; i++) {
            if (i == index) {
                continue;
            }
            if (sets[i].getParent() == index) {
                counter = 1 + counter + numberOfChildren(i);
            }
        }
        return counter;
    }

    public int sumOfAncestors(int index) {
        int sum = 0;
        int parent = sets[index].getParent();
        if (parent == index) {
            sum = sets[index].getData();
        }
        while (parent != index) {
            index = parent;
            parent = sets[index].getParent();
            sum = sum + sets[index].getData();
        }
        return sum;
    }

    public void getSets() {
        for (int i = 0; i < count; i++) {
            if (sets[i].getParent() == i) {
                System.out.print(sets[i].getParent() + " ");
            }
        }
    }

    public int numberOfSingletons() {
        int counter = 0;
        for (int i = 0; i < count; i++) {
            boolean isSingleton = true;
            for (int j = 0; j < count; j++) {
                if (i == j) {
                    continue;
                }
                if (sets[j].getParent() == i) {
                    isSingleton = false;
                }
            }
            if (isSingleton) {
                counter++;
            }
        }
        return counter;
    }

    public int numberOfPairs() {
        int counter = 0;
        for (int i = 0; i < count; i++){
            if (numberOfChildren(i) == 1) {
                counter ++;
            }
        }
        return counter;
    }
}
