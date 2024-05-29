import Tree.Tree;
import Tree.TreeNode;
import org.junit.Test;
public class TreeTest {
    @Test
    public void TestTree() {
        Tree tree = new Tree();
        tree.iterativeInsert(new TreeNode(6));
        tree.iterativeInsert(new TreeNode(4)); // you can change it to 12 when lower one is 8 to do tests more accurately.
        tree.iterativeInsert(new TreeNode(8)); // you can change it to 3 when upper one is 4 to do tests more accurately.
        tree.iterativeInsert(new TreeNode(1));
        tree.iterativeInsert(new TreeNode(5));
        tree.iterativeInsert(new TreeNode(7));
        tree.iterativeInsert(new TreeNode(10));
        tree.prettyPrint();
        tree.levelOrder();
        System.out.println();

        //System.out.println(tree.nodeCountWithStack());

        //System.out.println(tree.nodeCountWithQueue());

        //System.out.println(tree.recursiveLeafCount());

        //tree.recursivePrintSorted();

        //System.out.print(tree.numberOfFullNodes());

        //System.out.print(tree.numberOfSingletonNodes());

        //System.out.print(tree.lessThanX(5));

        /*tree.recursiveDeleteLeafNodes();
        tree.levelOrder();*/

        //System.out.print(tree.recursiveSumOfTree());

        //System.out.print(tree.recursiveSatisfyTreeProperty());

        /*tree.recursiveSwapChildren();
        tree.levelOrder();*/

        //System.out.print(tree.recursiveHeight());

        //tree.recursivePrintBetween(2, 8);

        //System.out.print(tree.recursiveTotalHeight());

        /*tree.recursiveChangeChildOfSingleton();
        tree.levelOrder();*/

        //System.out.print(tree.satisfyTreeProperty());

        /*tree.levelOrder();
        tree.swapChildren();
        System.out.println();
        tree.levelOrder();*/

        //System.out.print(tree.recursiveCheckSame());

        //System.out.print(tree.recursiveNumberOfFullNodes());

        //System.out.print(tree.recursiveNumberOfSingletonNodes());

        //System.out.print(tree.recursiveNumberOfChildren());

        //System.out.print(tree.recursiveLessThanX(7));

        //System.out.print(tree.recursiveDivisibleBy3());


    }
}
