import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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
                        if (iteration < adjacencyMatrix[0].length)
                            getInput();
                    }
        }
    }

    public String getInput() {
        System.out.println("Press enter to continue:");
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = null;
        try {
            s = br.readLine();
        } catch (IOException e) {
            System.out.println("Unable to read input. Please retry.");
        }
        return s;
    }

    public void printAdjacencyMatrix() {

        System.out.print("  ");
        for (int i = 0; i < adjacencyMatrix.length; i++) {
            System.out.print("   " + (char) (i + (int) 'A') + " ");
        }
        System.out.println();
        System.out.print("  ");
        for (int i = 0; i < adjacencyMatrix.length; i++) {
            System.out.print("=====");
        }
        System.out.println();

        for (int row = 0; row < adjacencyMatrix.length; row++) {
            System.out.print((char) (row + (int) 'A') + " |");
            for (int col = 0; col < adjacencyMatrix.length; col++)
                if (adjacencyMatrix[row][col] != INFINITY)
                    System.out.print(String.format("% 4d ", adjacencyMatrix[row][col]));
                else
                    System.out.print("---- ");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int testMatrix[][] = { { FloydWarshall.INFINITY, 50, FloydWarshall.INFINITY, 80, FloydWarshall.INFINITY },
                { FloydWarshall.INFINITY, FloydWarshall.INFINITY, 60, 90, FloydWarshall.INFINITY },
                { FloydWarshall.INFINITY, FloydWarshall.INFINITY, FloydWarshall.INFINITY, FloydWarshall.INFINITY, 40 },
                { FloydWarshall.INFINITY, FloydWarshall.INFINITY, 20, FloydWarshall.INFINITY, 70 },
                { FloydWarshall.INFINITY, 50, FloydWarshall.INFINITY, FloydWarshall.INFINITY, FloydWarshall.INFINITY } };
        FloydWarshall testWarshall = new FloydWarshall(testMatrix);

        System.out.println("Adjacency Matrix:");
        testWarshall.printAdjacencyMatrix();

        System.out.println("All Pairs Shortest Paths:");
        testWarshall.processArray();
    }
}
