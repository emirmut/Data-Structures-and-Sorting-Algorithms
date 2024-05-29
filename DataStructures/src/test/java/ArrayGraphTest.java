import Array.Graph.Graph;
import org.junit.Test;
import java.util.Arrays;

public class ArrayGraphTest {
    @Test
    public void TestGraph() {
        Graph g = new Graph(6);
        g.addEdge(1, 2, 3);
        g.addEdge(2, 4, 6);
        g.addEdge(3, 2, 2);
        g.addEdge(5, 3, 5);
        g.addEdge(1, 3, 8);
        g.addEdge(3, 4, 1);
        g.print();
        System.out.println();

        Graph h = new Graph(6);
        h.addEdge(1, 2, 3);
        h.addEdge(2, 1, 3);
        h.addEdge(3, 2, 2);
        h.addEdge(2, 3, 2);
        h.addEdge(1, 3, 1);
        h.addEdge(3, 1, 1);
        h.print();
        System.out.println();

        //System.out.print(g.edgeCount());

        //System.out.print(g.degree(3));

        /*System.out.println(g.isUndirected());
        System.out.print(h.isUndirected());*/

        /*g.matrixToList();
        System.out.println();
        h.matrixToList();*/

        /*g.reverseGraph();
        g.print();*/

        /*System.out.println(g.islands());
        System.out.print(h.islands());*/

        /*System.out.println(g.numberOfSources());
        System.out.print(h.numberOfSources());*/

        /*System.out.println(g.numberOfHubs());
        System.out.print(h.numberOfHubs());*/
    }
}
