package Array;

public class HeapNode {
    private int data;
    private int name;

    public HeapNode(int data, int name) {
        this.data = data;
        this.name = name;
    }

    public HeapNode(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public int getName() {
        return name;
    }

    public void setData(int data) {
        this.data = data;
    }
}
