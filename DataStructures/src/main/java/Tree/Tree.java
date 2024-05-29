package Tree;

public class Tree {

    protected TreeNode root;

    public Tree() {
        root = null;
    }

    public TreeNode getRoot() {
        return root;
    }

    public void setRoot(TreeNode root) {
        this.root = root;
    }

    public TreeNode recursiveSearch(int value) {
        if (root != null) {
            return root.recursiveSearch(value);
        } else {
            return null;
        }
    }

    public TreeNode iterativeSearch(int value) {
        TreeNode temp = root;
        while (temp != null) {
            if (value < temp.getData()) {
                temp = temp.getLeft();
            } else if (value > temp.getData()) {
                temp = temp.getRight();
            } else {
                return temp;
            }
        }
        return null;
    }

    public TreeNode iterativeMinSearch() {
        TreeNode temp = root;
        TreeNode followsTemp = null;
        while (temp != null) {
            followsTemp = temp;
            temp = temp.getLeft();
        }
        return followsTemp;
    }

    public TreeNode iterativeMaxSearch() {     // public TreeNode iterativeMaxSearch() {   Alternative solution for iterativeMaxSearch method.
        TreeNode temp = root;                  //        TreeNode temp = root;
        TreeNode followsTemp = null;           //        while (temp != null) {
        while (temp != null) {                 //            if (temp.getRight() == null) {
            followsTemp = temp;                //                return temp;
            temp = temp.getRight();            //            }
        }                                      //            temp = temp.getRight();
        return followsTemp;                    //        }
    }                                          //        return null;
                                               // }
    public TreeNode recursiveMinSearch() {
        if (root != null) {
            return root.recursiveMinSearch();
        }
        return null;
    }

    public TreeNode recursiveMaxSearch() {
        if (root != null) {
            return root.recursiveMaxSearch();
        }
        return null;
    }

    public void preorder() { // NLR
        if (root != null) {
            root.preorder();
        }
    }

    public void inorder() { // LNR
        if (root != null) {
            root.inorder();
        }
    }

    public void postorder() { // LRN
        if (root != null) {
            root.postorder();
        }
    }

    public void prettyPrint() {
        if (root != null){
            root.prettyPrint(0);
        }
    }

    protected void insertChild(TreeNode parent, TreeNode child) {
        if (parent == null) {
            root = child;
        } else {
            if (child.getData() < parent.getData()) {
                parent.setLeft(child);
            } else {
                parent.setRight(child);
            }
        }
    }

    public void iterativeInsert(TreeNode node) {
        TreeNode parent = null;
        TreeNode temp = root;
        while (temp != null) {
            parent = temp;
            if (node.getData() < temp.getData()) {
                temp = temp.getLeft();
            } else {
                temp = temp.getRight();
            }
        }
        insertChild(parent, node);
    }

    public void recursiveInsert(TreeNode node) {
        if (root == null) {
            root = node;
        } else {
            root.recursiveInsert(node);
        }
    }

    public int nodeCountWithStack(){
        TreeNode tmp;
        int count = 0;
        Stack c = new Stack(100);
        if (root != null){
            c.push(new Element(root));
        }
        while (!c.isEmpty()){
            Element e = c.pop();
            count++;
            tmp = e.getData();
            if (tmp.getLeft() != null){
                c.push(new Element(tmp.getLeft()));
            }
            if (tmp.getRight() != null){
                c.push(new Element(tmp.getRight()));
            }
        }
        return count;
    }

    public int nodeCountWithQueue() {
        int count = 0;
        Queue q = new Queue(100);
        if (root != null) {
            q.enqueue(new Element(root));
        }
        TreeNode temp;
        while (!q.isEmpty()) {
            Element e = q.dequeue();
            count++;
            temp = e.getData();
            if (temp.getLeft() != null) {
                q.enqueue(new Element(temp.getLeft()));
            }
            if (temp.getRight() != null) {
                q.enqueue(new Element(temp.getRight()));
            }
        }
        return count;
    }

    public int recursiveLeafCount() {
        if (root == null) {
            return 0;
        } else {
            return root.recursiveLeafCount();
        }
    }

    public void levelOrder() {
        Queue q = new Queue(100);
        if (root != null) {
            q.enqueue(new Element(root));
        }
        TreeNode temp;
        while (!q.isEmpty()) {
            Element e = q.dequeue();
            temp = e.getData();
            System.out.print(temp.getData() + " ");
            if (temp.getLeft() != null) {
                q.enqueue(new Element(temp.getLeft()));
            }
            if (temp.getRight() != null) {
                q.enqueue(new Element(temp.getRight()));
            }
        }
    }

    public void recursivePrintSorted() {
        if (root != null) {
            root.recursivePrintSorted();
        }
    }

    public int numberOfFullNodes() {
        int count = 0;
        Queue q = new Queue(100);
        if (root != null) {
            q.enqueue(new Element(root));
        }
        TreeNode temp;
        while (!q.isEmpty()) {
            Element e = q.dequeue();
            temp = e.getData();
            if (temp.getLeft() != null && temp.getRight() != null) {
                count++;
            }
            if (temp.getLeft() != null) {
                q.enqueue(new Element(temp.getLeft()));
            }
            if (temp.getRight() != null) {
                q.enqueue(new Element(temp.getRight()));
            }
        }
        return count;
    }

    public int recursiveNumberOfFullNodes() {
        if (root != null) {
            return root.recursiveNumberOfFullNodes();
        } else {
            return 0;
        }
    }

    public int numberOfSingletonNodes() {
        int count = 0;
        Queue q = new Queue(100);
        if (root != null) {
            q.enqueue(new Element(root));
        }
        TreeNode temp;
        while (!q.isEmpty()) {
            Element e = q.dequeue();
            temp = e.getData();
            if ((temp.getLeft() != null && temp.getRight() == null) || (temp.getLeft() == null && temp.getRight() != null)) {
                count++;
            }
            if (temp.getLeft() != null) {
                q.enqueue(new Element(temp.getLeft()));
            }
            if (temp.getRight() != null) {
                q.enqueue(new Element(temp.getRight()));
            }
        }
        return count;
    }

    public int recursiveNumberOfSingletonNodes() {
        if (root != null) {
            return root.recursiveNumberOfSingletonNodes();
        } else {
            return 0;
        }
    }

    public void recursiveDeleteLeafNodes() {
        if (root != null) {
            root.recursiveDeleteLeafNodes();
        }
    }

    public int sumOfTree() {
        int sum = 0;
        Queue q = new Queue(100);
        if (root != null) {
            q.enqueue(new Element(root));
        }
        TreeNode temp;
        while (!q.isEmpty()) {
            Element e = q.dequeue();
            temp = e.getData();
            sum = sum + temp.getData();
            if (temp.getLeft() != null) {
                q.enqueue(new Element(temp.getLeft()));
            }
            if (temp.getRight() != null) {
                q.enqueue(new Element(temp.getRight()));
            }
        }
        return sum;
    }

    public int height() {
        Queue q = new Queue(100);
        if (root != null) {
            q.enqueue(new Element(root));
        }
        if (root != null && (root.getLeft() == null && root.getRight() == null)) {
            return 1;
        }
        TreeNode temp;
        int h1 = -1;
        int h2 = -1;
        while (!q.isEmpty()) {
            Element e = q.dequeue();
            temp = e.getData();
            if (temp.getLeft() != null) {
                q.enqueue(new Element(temp.getLeft()));
                h1++;
            }
            if (temp.getRight() != null) {
                q.enqueue(new Element(temp.getRight()));
                h2++;
            }
        }
        return Math.max(h1, h2);
    }

    public int recursiveHeight() {
        if (root != null) {
            return root.recursiveHeight();
        }
        return 0;
    }

    public void recursivePrintBetween(int k1, int k2) {
        if (root != null) {
            root.recursivePrintBetween(k1, k2);
            if (root.getData() > k1 && root.getData() < k2) {
                System.out.print(root.getData() + " ");
            }
        }
    }

    public int recursiveTotalHeight() {
        if (root != null) {
            return root.recursiveTotalHeight();
        }
        return 0;
    }

    public int lessThanX(int X) {
        int count = 0;
        Queue q = new Queue(100);
        if (root != null) {
            q.enqueue(new Element(root));
        }
        TreeNode temp;
        while (!q.isEmpty()) {
            Element e = q.dequeue();
            temp = e.getData();
            if (temp.getData() < X) {
                count++;
            }
            if (temp.getLeft() != null) {
                q.enqueue(new Element(temp.getLeft()));
            }
            if (temp.getRight() != null) {
                q.enqueue(new Element(temp.getRight()));
            }
        }
        return count;
    }

    public int recursiveLessThanX(int X) {
        if (root != null) {
            return root.recursiveLessThanX(X);
        } else {
            return 0;
        }
    }

    public void recursiveChangeChildOfSingleton() {
        if (root != null) {
            root.recursiveChangeChildOfSingleton();
        }
    }

    public boolean recursiveCheckSame() {
        if (root != null) {
            return root.recursiveCheckSame();
        } else {
            return false;
        }
    }

    public int recursiveDivisibleBy3() {
        if (root != null) {
            return root.recursiveDivisibleBy3();
        } else {
            return 0;
        }
    }

    public boolean satisfyTreeProperty() {
        if (root != null) {
            TreeNode temp = root;
            while (temp.getLeft() != null) {
                if (temp.getLeft().getData() > temp.getData()) {
                    return false;
                }
                temp = temp.getLeft();
            }
            temp = root;
            while (temp.getRight() != null) {
                if (temp.getRight().getData() < temp.getData()) {
                    return false;
                }
                temp = temp.getRight();
            }
        }
        return true;
    }

    public boolean recursiveSatisfyTreeProperty() {
        if (root == null) {
            return true;
        } else {
            return root.recursiveSatisfyTreeProperty();
        }
    }

    public void swapNumbers(int a, int b) {
        int temp = a;
        a = b;
        b = temp;
    }

    public void swapChildren() {
        Queue q = new Queue(100);
        if (root != null) {
            q.enqueue(new Element(root));
        }
        TreeNode temp;
        while (!q.isEmpty()) {
            Element e = q.dequeue();
            temp = e.getData();
            if (temp.getLeft() != null && temp.getRight() != null) {
                swapNumbers(temp.getLeft().getData(), temp.getRight().getData());
            }
            if (temp.getLeft() != null) {
                q.enqueue(new Element(temp.getLeft()));
            }
            if (temp.getRight() != null) {
                q.enqueue(new Element(temp.getRight()));
            }
        }
    }

    public void recursiveSwapChildren() {
        if (root != null) {
            root.recursiveSwapChildren();
        }
    }

    public int recursiveNumberOfChildren() {
        if (root != null) {
            return root.recursiveNumberOfChildren();
        } else {
            return 0;
        }
    }

    public int recursiveSumOfTree() {
        if (root != null) {
            return root.recursiveSumOfTree();
        } else {
            return 0;
        }
    }
}
