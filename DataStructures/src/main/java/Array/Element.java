package Array;

public class Element {
    private int data;
    private char chr;

    public Element(int data) {
        this.data = data;
    }

    public Element(char chr) {
        this.chr = chr;
    }

    public int getData() {
        return data;
    }

    public char getChar() {
        return chr;
    }
}
