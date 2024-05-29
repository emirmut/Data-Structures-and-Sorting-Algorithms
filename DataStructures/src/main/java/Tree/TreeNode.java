package Tree;

public class TreeNode {

    protected int data;
    protected TreeNode left;
    protected TreeNode right;

    public TreeNode(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    public int getData() {
        return data;
    }

    public TreeNode getLeft() {
        return left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    public TreeNode recursiveSearch(int value) {
        if (value == data) {
            return this;
        }
        if (value < data) {
            if (left != null) {
                return left.recursiveSearch(value);
            } else {
                return null;
            }
        } else {
            if (right != null) {
                return right.recursiveSearch(value);
            } else {
                return null;
            }
        }
    }

    public TreeNode recursiveMinSearch() {
        if (left == null) {                                     // public TreeNode recursiveMinSearch() {
            return this;                                        //   if (left != null) {
        }                                                       //      return left.recursiveMinSearch();
        return left.recursiveMinSearch();                       //   }
    }                                                           //   return this;
                                                                // }
    public TreeNode recursiveMaxSearch() {
        if (right == null) {
            return this;
        }
        return right.recursiveMaxSearch();
    }

    public void preorder() { // NLR
        System.out.print(data + " ");
        if (left != null) {
            left.preorder();
        }
        if (right != null) {
            right.preorder();
        }
    }

    public void inorder() { // LNR
        if (left != null) {
            left.inorder();
        }
        System.out.print(data + " ");
        if (right != null) {
            right.inorder();
        }
    }

    public void postorder() { // LRN
        if (left != null) {
            left.postorder();
        }
        if (right != null) {
            right.postorder();
        }
        System.out.print(data + " ");
    }

    public void prettyPrint(int level) { // the method which is used for printing the tree.
        for (int i = 0; i < level; i++) {
            System.out.print("\t");
        }
        System.out.println(data);
        if (left != null) {
            left.prettyPrint(level + 1);
        }
        if (right != null) {
            right.prettyPrint(level + 1);
        }
    }

    public void recursiveInsert(TreeNode node) {
        if (node.getData() < data) {
            if (left != null) {
                left.recursiveInsert(node);
            } else {
                left = node;
            }
        } else {
            if (right != null) {
                right.recursiveInsert(node);
            } else {
                right = node;
            }
        }
    }

    public int recursiveLeafCount() {
        int count = 0;
        if (left != null && right != null) {
            count = count + left.recursiveLeafCount() + right.recursiveLeafCount();
            return count;
        } else if (left != null && right == null) {
            count = count + left.recursiveLeafCount();
            return count;
        } else if (left == null && right != null) {
            count = count + right.recursiveLeafCount();
            return count;
        } else {
            count++;
            return count;
        }
    }

    public void recursivePrintSorted() { // inorder traversal
        if (left != null) {
            left.recursivePrintSorted();
        }
        System.out.print(data + " ");
        if (right != null) {
            right.recursivePrintSorted();
        }
    }

    public int recursiveNumberOfFullNodes() {
        if (left != null && right != null) {
            return 1 + left.recursiveNumberOfFullNodes() + right.recursiveNumberOfFullNodes();
        } else if (left == null && right == null) {
            return 0;
        } else if (left != null && right == null) {
            return left.recursiveNumberOfFullNodes();
        } else {
            return right.recursiveNumberOfFullNodes();
        }
    }

    public int recursiveNumberOfChildren() {
        if (left != null && right != null) {
            return 2 + left.recursiveNumberOfChildren() + right.recursiveNumberOfChildren();
        } else if (left == null && right == null) {
            return 0;
        } else if (left != null && right == null) {
            return left.recursiveNumberOfChildren() + 1;
        } else {
            return right.recursiveNumberOfChildren() + 1;
        }
    }

    public int recursiveNumberOfSingletonNodes() {
        if (left != null && right != null) {
            return left.recursiveNumberOfSingletonNodes() + right.recursiveNumberOfSingletonNodes();
        } else if (left != null && right == null) {
            return 1 + left.recursiveNumberOfSingletonNodes();
        } else if (left == null && right != null) {
            return 1 + right.recursiveNumberOfSingletonNodes();
        } else {
            return 0;
        }
    }

    public int recursiveLessThanX(int X) {
        int count = 0;
        if (data < X) {
            count++;
        }
        if (left != null && right != null) {
            if (left.getData() < X && right.getData() < X) {
                return 2 + count + left.recursiveLessThanX(X) + right.recursiveLessThanX(X);
            } else if (left.getData() < X && right.getData() >= X) {
                return 1 + count + left.recursiveLessThanX(X) + right.recursiveLessThanX(X);
            } else if (left.getData() >= X && right.getData() < X) {
                return 1 + count + left.recursiveLessThanX(X) + right.recursiveLessThanX(X);
            } else if (left.getData() >= X && right.getData() >= X) {
                return count + left.recursiveLessThanX(X) + right.recursiveLessThanX(X);
            }
        } else if (left != null && right == null) {
            if (left.getData() < X) {
                return 1 + left.recursiveLessThanX(X);
            } else {
                return left.recursiveLessThanX(X);
            }
        } else if (left == null && right != null) {
            if (right.getData() < X) {
                return 1 + right.recursiveLessThanX(X);
            } else {
                return right.recursiveLessThanX(X);
            }
        } else {
            return count;
        }
        return count;
    }

    public void recursiveDeleteLeafNodes() {
        if (left != null) {
            if (left.left == null && left.right == null) {
                left = null;
            } else {
                left.recursiveDeleteLeafNodes();
            }
        }
        if (right != null) {
            if (right.left == null && right.right == null) {
                right = null;
            } else {
                right.recursiveDeleteLeafNodes();
            }
        }
    }

    public int recursiveSumOfTree() {
        if (left != null && right != null) {
            return data + left.recursiveSumOfTree() + right.recursiveSumOfTree();
        } else if (left != null && right == null) {
            return data + left.recursiveSumOfTree();
        } else if (left == null && right != null) {
            return data + right.recursiveSumOfTree();
        } else {
            return data;
        }
    }

    public boolean recursiveSatisfyTreeProperty() {
        if (left != null && right != null) {
            return data > left.getData() && data <= right.getData() && left.recursiveSatisfyTreeProperty() && right.recursiveSatisfyTreeProperty();
        } else if (left != null && right == null) {
            return data > left.getData() && left.recursiveSatisfyTreeProperty();
        } else if (left == null && right != null) {
            return data <= right.getData() && right.recursiveSatisfyTreeProperty();
        } else {
            return true;
        }
    }

    public void recursiveSwapChildren() {
        if (left != null && right != null) {
            TreeNode temp = left;
            left = right;
            right = temp;
        } else if (left != null && right == null) {
            left.recursiveSwapChildren();
        } else if (left == null && right != null) {
            right.recursiveSwapChildren();
        }
    }

    public int recursiveHeight() {
        if (left != null && right != null) {
            return 1 + Math.max(left.recursiveHeight(), right.recursiveHeight());
        } else if (left != null && right == null) {
            return 1 + left.recursiveHeight();
        } else if (left == null && right != null) {
            return 1 + right.recursiveHeight();
        } else {
            return 1;
        }
    }

    public void recursivePrintBetween(int k1, int k2) {
        if (left != null && right != null) {
            if ((left.getData() > k1 && left.getData() < k2) && (right.getData() > k1 && right.getData() < k2)) {
                System.out.print(left.getData() + " " + right.getData() + " ");
            } else if ((left.getData() > k1 && left.getData() < k2) && !(right.getData() > k1 && right.getData() < k2)) {
                System.out.print(left.getData() + " ");
            } else if (!(left.getData() > k1 && left.getData() < k2) && (right.getData() > k1 && right.getData() < k2)) {
                System.out.print(right.getData() + " ");
            } else {
                return; // do nothing
            }
            left.recursivePrintBetween(k1, k2);
            right.recursivePrintBetween(k1, k2);
        } else if (left != null && right == null) {
            if (left.getData() > k1 && left.getData() < k2) {
                System.out.print(left.getData() + " ");
            } else {
                return; // do nothing
            }
            left.recursivePrintBetween(k1, k2);
        } else if (left == null && right != null) {
            if (right.getData() > k1 && right.getData() < k2) {
                System.out.print(right.getData() + " ");
            } else {
                return; // do nothing
            }
            right.recursivePrintBetween(k1, k2);
        } else {
            return; // do nothing
        }
    }

    public int recursiveTotalHeight() {
        int height = recursiveHeight();
        if (left != null && right != null) {
            height = height + left.recursiveTotalHeight() + right.recursiveTotalHeight();
        } else if (left != null && right == null) {
            height = height + left.recursiveTotalHeight();
        } else if (left == null && right != null) {
            height = height + right.recursiveTotalHeight();
        } else {
            return height;
        }
        return height;
    }

    public void recursiveChangeChildOfSingleton() {
        if (left == null && right == null) {
            return; // do nothing.
        } else if (left != null && right != null) {
            left.recursiveChangeChildOfSingleton();
            right.recursiveChangeChildOfSingleton();
        } else if (left != null && right == null) {
            left.recursiveChangeChildOfSingleton();
            right = left;
            left = null;
        } else {
            right.recursiveChangeChildOfSingleton();
            left = right;
            right = null;
        }
    }

    public boolean recursiveCheckSame() {
        if (left == null && right == null) {
            return false;
        } else if (left == null && right != null) {
            return data == right.getData() || right.recursiveCheckSame();
        } else if (left != null && right == null) {
            return data == left.getData() || left.recursiveCheckSame();
        } else {
            return (data == left.getData() || left.recursiveCheckSame()) || (data == right.getData() || right.recursiveCheckSame());
        }
    }

    public int recursiveDivisibleBy3() {
        if (left != null && right != null) {
            if (left.getData() % 3 != 0 && right.getData() % 3 != 0) {
                return left.recursiveDivisibleBy3() + right.recursiveDivisibleBy3();
            } else if (left.getData() % 3 == 0 && right.getData() % 3 == 0) {
                return 2 + left.recursiveDivisibleBy3() + right.recursiveDivisibleBy3();
            } else {
                return 1 + left.recursiveDivisibleBy3() + right.recursiveDivisibleBy3();
            }
        } else if (left != null && right == null) {
            if (left.getData() % 3 == 0) {
                return 1 + left.recursiveDivisibleBy3();
            } else {
                return left.recursiveDivisibleBy3();
            }
        } else if (left == null && right != null) {
            if (right.getData() % 3 == 0) {
                return 1 + right.recursiveDivisibleBy3();
            } else {
                return right.recursiveDivisibleBy3();
            }
        } else {
            return 0;
        }
    }
}
