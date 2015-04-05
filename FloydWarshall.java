public class FloydWarshall {
    public int adjacencyMatrix[][];

    public FloydWarshall(int adjacencyMatrix[][]) {
        this.adjacencyMatrix = adjacencyMatrix;
    }

    public void processArray(int iteration) {
        if (iteration <= adjacencyMatrix[0].length) // processing left
        {
            for (int i = 0; i < adjacencyMatrix[0].length; i++)
                for (int j = 0; j < adjacencyMatrix[0].length; j++)
                    if (adjacencyMatrix[iteration][j] + adjacencyMatrix[i][iteration] < adjacencyMatrix[i][j])
                        adjacencyMatrix[i][j] = adjacencyMatrix[iteration][j] + adjacencyMatrix[i][iteration];
        } else
            return;
    }

    public static void main(String[] args) {

    }
}
