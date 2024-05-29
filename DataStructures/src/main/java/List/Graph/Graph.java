package List.Graph;

import List.LinkedList;
import List.Node;

public class Graph {
    private EdgeList[] edges;
    private int vertexCount;

    public Graph(int vertexCount) {
        edges = new EdgeList[vertexCount];
        for (int i = 0; i < vertexCount; i++) {
            edges[i] = new EdgeList();
        }
        this.vertexCount = vertexCount;
    }

    public void addEdge(int from, int to) {
        edges[from].insert(new Edge(from, to, 1));
    }

    public void addEdge(int from, int to, int weight) {
        edges[from].insert(new Edge(from, to, weight));
    }

    public int edgeCount() {
        int count = 0;
        for (int i = 0; i < vertexCount; i++) {
            int numberOfElements = 0;
            Edge temp = edges[i].getHead();
            while (temp != null) {
                numberOfElements++;
                temp = temp.getNext();
            }
            if (!edges[i].isEmpty()) {
                count = count + numberOfElements;
            }
        }
        return count;
    }

    public int degree(int index) {
        int count = 0;
        Edge temp1 = edges[index].getHead();
        while (temp1 != null) {
            count++;
            temp1 = temp1.getNext();
        }
        for (int i = 0; i < vertexCount; i++) {
            Edge temp2 = edges[i].getHead();
            while (temp2 != null) {
                if (index == temp2.getTo()) {
                    count++;
                }
                temp2 = temp2.getNext();
            }
        }
        return count;
    }

    public boolean isUndirected() {
        for (int i = 0; i < vertexCount; i++) {
            for (int j = 0; j < vertexCount; j++) {
                if (edges[i].search(j) != null && edges[j].search(i) != null) {
                    if (edges[i].search(j).getTo() != edges[j].search(i).getTo()) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public void listToMatrix() {
        for (int i = 1; i < vertexCount; i++) {
            for (int j = 1; j < vertexCount; j++) {
                if (edges[i].search(j) != null) {
                    System.out.print(edges[i].search(j).getWeight() + " ");
                } else {
                    System.out.print(0 + " ");
                }
            }
            System.out.println();
        }
    }

    public void reverseGraph() {
        for (int i = 0; i < vertexCount; i++) {
            for (int j = 0; j < vertexCount; j++) {
                if (edges[i].search(j) != null) {
                    if (edges[j].search(i) == null) {
                        edges[j].insert(new Edge(j, i, edges[i].search(j).getWeight()));
                    }
                }
            }
        }
    }

    public LinkedList incomingNodes(int i) {
        LinkedList list = new LinkedList();
        for (int j = 0; j < vertexCount; j++) {
            Edge temp = edges[j].getHead();
            while (temp != null) {
                if (i == temp.getTo()) {
                    list.insertLast(new Node(temp.getFrom()));
                }
                temp = temp.getNext();
            }
        }
        return list;
    }

    public int numberOfSources() {
        int result = -1;
        int j = 0;
        while (j != vertexCount) {
            int x = 0;
            for (int i = 0; i < vertexCount; i++) {
                if (edges[i].search(j) == null) {
                    x++;
                }
            }
            if (x == vertexCount) {
                result++;
            }
            j++;
        }
        return result;
    }

    public int numberOfHubs() {
        int result = 0;
        for (int i = 0; i < vertexCount; i++) {
            int incomingCounter = 0;
            int outgoingCounter = 0;
            for (int j = 0; j < edges[i].numberOfElements(); j++) { // numberofElements method has been implemented as extra in EdgeList class.
                outgoingCounter++;
            }
            for (int k = 0; k < vertexCount; k++) {
                if (edges[k].search(i) != null) {
                    incomingCounter++;
                }
            }
            if (incomingCounter > outgoingCounter) {
                result++;
            }
        }
        return result;
    }
}
