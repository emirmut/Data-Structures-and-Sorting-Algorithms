package Array.Graph;

public class Graph {
    private int[][] edges;
    private int vertexCount;

    public Graph(int vertexCount) {
        this.vertexCount = vertexCount;
        edges = new int[vertexCount][vertexCount];
        for (int i = 0; i < vertexCount; i++){
            for (int j = 0; j < vertexCount; j++){
                edges[i][j] = 0;
            }
        }
    }

    public void print() {
        for (int i = 1; i < vertexCount; i++) {
            for (int j = 1; j < vertexCount; j++) {
                System.out.print(edges[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void addEdge(int from, int to) {
        edges[from][to] = 1;
    }

    public void addEdge(int from, int to, int weight) {
        edges[from][to] = weight;
    }

    public int edgeCount() {
        int count = 0;
        for (int i = 0; i < vertexCount; i++) {
            for (int j = 0; j < vertexCount; j++) {
                if (edges[i][j] != 0) {
                    count++;
                }
            }
        }
        return count;
    }

    public int degree(int index) {
        int degree = 0;
        for (int i = 0; i < vertexCount; i++) {
            if (edges[index][i] != 0) {
                degree++;
            }
            if (edges[i][index] != 0) {
                degree++;
            }
        }
        return degree;
    }

    public boolean isUndirected() { // check if the adjacency matrix is symmetric or not
        for (int i = 0; i < vertexCount; i++) {
            for (int j = 0; j < vertexCount; j++) {
                if (edges[i][j] != edges[j][i]) {
                    return false;
                }
            }
        }
        return true;
    }

    public void matrixToList() {
        for (int i = 0; i < vertexCount; i++) {
            System.out.print(i + "-> ");
            for (int j = 0; j < vertexCount; j++) {
                if (edges[i][j] != 0) {
                    System.out.print(j + " ");
                }
            }
            System.out.println();
        }
    }

    public void reverseGraph() {
        for (int i = 0; i < vertexCount; i++) {
            for (int j = 0; j < vertexCount; j++) {
                int temp = edges[i][j];
                edges[i][j] = edges[j][i];
                edges[j][i] = temp;
            }
        }
    }

    public int islands() {
        int count = -1;
        for (int i = 0; i < vertexCount; i++) {
            int identifier = 0;
            for (int j = 0; j < vertexCount; j++) {
                if (edges[i][j] != 0 || edges[j][i] != 0) {
                    identifier++;
                }
            }
            if (identifier == 0) {
                count++;
            }
        }
        return count;
    }

    public int numberOfSources() {
        int toBeReturned = -1;
        for (int i = 0; i < vertexCount; i++) {
            int zeroCounter = 0;
            for (int j = 0; j < vertexCount; j++) {
                if (edges[j][i] == 0) {
                    zeroCounter++;
                }
            }
            if (zeroCounter == vertexCount) {
                toBeReturned++;
            }
        }
        return toBeReturned;
    }

    public int numberOfHubs() {
        int result = 0;
        for (int i = 0; i < vertexCount; i++) {
            int incomingCounter = 0;
            int outgoingCounter = 0;
            for (int j = 0; j < vertexCount; j++) {
                if (edges[j][i] != 0) {
                    incomingCounter++;
                }
                if (edges[i][j] != 0) {
                    outgoingCounter++;
                }
            }
            if (incomingCounter > outgoingCounter) {
                result++;
            }
        }
        return result;
    }
}
