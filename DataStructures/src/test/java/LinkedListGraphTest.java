import List.Graph.Graph;
import java.util.Arrays;
import org.junit.Test;

public class LinkedListGraphTest {
    @Test
    public void TestGraph() {
        Graph g = new Graph(6);
        g.addEdge(1, 2, 3);
        g.addEdge(2, 4, 6);
        g.addEdge(3, 2, 2);
        g.addEdge(5, 3, 5);
        g.addEdge(1, 3, 8);
        g.addEdge(3, 4, 1);

        Graph h = new Graph(6);
        h.addEdge(1, 2, 3);
        h.addEdge(2, 1, 3);
        h.addEdge(3, 2, 2);
        h.addEdge(2, 3, 2);
        h.addEdge(1, 3, 1);
        h.addEdge(3, 1, 1);

        //System.out.print(g.edgeCount());

        //System.out.print(g.degree(3));

        //System.out.print(g.isUndirected());

        /*g.listToMatrix();
        System.out.println();
        h.listToMatrix();*/

        //System.out.print(g.incomingNodes(3));

        /*System.out.println(g.numberOfHubs());
        System.out.print(h.numberOfHubs());*/

        /*System.out.println(g.numberOfSources());
        System.out.print(h.numberOfSources());*/
    }
}
