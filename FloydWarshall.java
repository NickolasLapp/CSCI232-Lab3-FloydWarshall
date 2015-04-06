public class FloydWarshall {
    public int adjacencyMatrix[][];
    public static final int INFINITY = Integer.MAX_VALUE / 2;

    public FloydWarshall(int adjacencyMatrix[][]) {
        this.adjacencyMatrix = adjacencyMatrix;
    }

    public void processArray() {
        for (int iteration = 0; iteration < adjacencyMatrix.length; iteration++) {
            for (int i = 0; i < adjacencyMatrix[0].length; i++)
                for (int j = 0; j < adjacencyMatrix[0].length; j++)
                    if (adjacencyMatrix[iteration][j] + adjacencyMatrix[i][iteration] < adjacencyMatrix[i][j]) {
                        adjacencyMatrix[i][j] = adjacencyMatrix[iteration][j] + adjacencyMatrix[i][iteration];
                        printAdjacencyMatrix();
                    }
        }
    }

    public void printAdjacencyMatrix() {
        for (int i = 0; i < adjacencyMatrix.length; i++) {
            System.out.print((char) (i + (int) 'A') + " ");
        }
        System.out.println();
        for (int i = 0; i < adjacencyMatrix.length; i++) {
            System.out.print("==");
        }
        System.out.println();

        for (int row = 0; row < adjacencyMatrix.length; row++) {
            System.out.print((char) (row + (int) 'A') + " ");
            for (int col = 0; col < adjacencyMatrix.length; col++)
                if (adjacencyMatrix[row][col] != INFINITY)
                    System.out.print(String.format("% 3d ", adjacencyMatrix[row][col]));
                else
                    System.out.print("Inf ");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int testMatrix[][] = { { 0, 50, FloydWarshall.INFINITY, 80, FloydWarshall.INFINITY },
                { FloydWarshall.INFINITY, 0, 60, 90, FloydWarshall.INFINITY },
                { FloydWarshall.INFINITY, FloydWarshall.INFINITY, 0, FloydWarshall.INFINITY, 40 },
                { FloydWarshall.INFINITY, FloydWarshall.INFINITY, 20, 0, 70 },
                { FloydWarshall.INFINITY, 50, FloydWarshall.INFINITY, FloydWarshall.INFINITY, 0 } };
        FloydWarshall testWarshall = new FloydWarshall(testMatrix);

        for (int i = 0; i < testMatrix.length; i++)
            testWarshall.processArray(i);
    }
}
