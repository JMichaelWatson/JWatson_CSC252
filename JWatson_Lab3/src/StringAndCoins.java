/**
 * Created by JMichael on 8/29/2014.
 */
public class StringAndCoins {
    int[][] strings;
    int size;
    int baseSize;


    public StringAndCoins(int rows, int columns) {
        baseSize = columns+1;
        this.size = (rows + 1) * (columns + 1);
        strings = new int[size][size];
        setup();
    }


    private void setup() {
        for (int y = 1; y < baseSize - 1; y++) {
            for (int x = 1; x < baseSize - 1; x++) {
                int fromVertex = (x + (baseSize * y));
                int toVertex = (x + ((y - 1) * baseSize));
                addBiEdge(fromVertex, toVertex, 1);//top
                toVertex = (x + ((y + 1) * baseSize));
                addBiEdge(fromVertex, toVertex, 1);//down
                toVertex = ((x+1) + ((y) * baseSize));
                addBiEdge(fromVertex, toVertex, 1);//right;
                toVertex = ((x-1) + ((y) * baseSize));
                addBiEdge(fromVertex, toVertex, 1);//left

            }
        }
    }

    public void addBiEdge(int fromVertex, int toVertex, int weight) {
        strings[fromVertex][toVertex] = weight;
        strings[toVertex][fromVertex] = weight;
    }

    public void printAdjMatrix(){
        System.out.println("------------------------------------------------");
        System.out.println("Matrix:");
        for(int x = 0; x < size; x ++){
            String result = "";
            for(int y = 0; y < size; y++){
                result += strings[x][y] + " ";
            }
            System.out.println(result);
        }
        System.out.println("------------------------------------------------");
    }

    public boolean isEdge(int fromVertex, int toVertex){

        return strings[fromVertex][toVertex] != 0;
    }

}

