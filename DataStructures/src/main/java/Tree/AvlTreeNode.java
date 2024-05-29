package Tree;

public class AvlTreeNode extends TreeNode {
    private int height;

    public AvlTreeNode(int data) {
        super(data);
        height = 1;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
