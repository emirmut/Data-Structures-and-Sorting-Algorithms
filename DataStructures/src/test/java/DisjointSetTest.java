import Array.DisjointSet;
import Array.Set;
import org.junit.Test;
public class DisjointSetTest {
    @Test
    public void testDisjointSet() {
        DisjointSet a = new DisjointSet( 8);
        a.unionOfSets(0, 2);
        a.unionOfSets(1, 3);
        a.unionOfSets(2, 5);
        a.unionOfSets(1, 7);
        a.unionOfSets(4, 0);
        /*System.out.println("Is 0 and 2 in the same set? " + (a.findSetIterative(0) == a.findSetIterative(2)));
        System.out.println("Is 3 and 5 in the same set? " + (a.findSetIterative(1) == a.findSetIterative(3)));
        System.out.println("Is 1 and 4 in the same set? " + (a.findSetIterative(1) == a.findSetIterative(4)));*/

        //System.out.print(a.depth(7));

        //System.out.print(a.numberOfChildren(1));

        //System.out.print(a.sumOfAncestors(5));

        //a.getSets();

        //System.out.print(a.numberOfDisjointSets());

        //System.out.print(a.height(7));

        //System.out.print(a.numberOfSingletons());

        //System.out.print(a.numberOfPairs());
    }
}
