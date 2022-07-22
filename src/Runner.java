import java.io.FileNotFoundException;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) throws FileNotFoundException {

        ReadFile readFile = new ReadFile();
        readFile.read();

        InitTask initTask = new InitTask(readFile.getCITY(),readFile.getWEIGHT(),readFile.getWEIGHT_CAR(),readFile.getFUEL());
        initTask.runCarTask();

        Graph graph = new Graph(initTask.matrixSmeg, readFile.getCITY());

        Scanner scan = new Scanner(System.in);
        String input = "O", index1, index2;

        while(!input.equals("exit")){
            System.out.print("\nВыберите алгоритм (dfs, bfs, dijkstra, rozruv, exit): ");
            input = scan.next();
            if (input.equals("dfs")){
                System.out.print("\nВведите вершину:  ");
                index1 = scan.next();
                graph.dfs(index1);
            }else if(input.equals("bfs")){
                System.out.print("\nВведите вершину:  ");
                index1 = scan.next();
                graph.bfs(index1);
            }else if(input.equals("dijkstra")){
                System.out.print("\nВведите начальную вершину:  ");
                index1 = scan.next();
                System.out.print("\nВведите конечную вершину:  ");
                index2 = scan.next();
                graph.Dijkstra(index1,0,index2);
            }else if(input.equals("rozruv")){
                System.out.print("\nВведите вершины между которыми хотите разорвать связь:\n");
                System.out.print("\nV1 = ");
                index1 = scan.next();
                System.out.print("\nV2 = ");
                index2 = scan.next();
                graph.rozruv(index1,index2);
            }
        }
    }
}
