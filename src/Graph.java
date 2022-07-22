public class Graph {
    Stack stack;
    Queue queue;

    private final int maxN;
    public int[][] matrix;
    boolean[] vertexBol;
    public String[] vertexName;

    public int[][] cost;
    public int INF = Integer.MAX_VALUE;
    public int start;
    public int[] visited;
    int realStart = 0;
    int endNum = 0;

    public Graph(int[][] mSmeg, String[] city){
        maxN = city.length;
        matrix = mSmeg;
        vertexName = city;
        vertexBol = new boolean[maxN];
        stack = new Stack(maxN);
        queue = new Queue(maxN);
        cost = new int[2][maxN];
        visited = new int[maxN];
        for (int i = 0; i < maxN; i++) {
            cost[0][i]=INF;
        }
    }



    public int check(int v){
        for (int i = 0; i < maxN; i++) {
            if(matrix[v][i] != 0 && !vertexBol[i]){
                return i;
            }
        }
        return -1;
    }

    public void dfs(String name){
        int index = convertIndex(name);
        System.out.println("\n=============DFS SEARCH=============");
        vertexBol[index] = true;
        stack.push(index);
        System.out.println();
        int iter = 0;

        while(!stack.isEmpty()){
            int neigh = check(stack.peek());
            if(neigh == -1){
                neigh = stack.pop();
                if(iter > 1){
                    System.out.println();
                    iter = 0;
                }else{
                    continue;
                }
            }else{
                System.out.printf("%s ",convertVertex(stack.peek()));
                System.out.printf("=> %s  ",vertexName[neigh]);
                vertexBol[neigh] = true;
                stack.push(neigh);
            }
            iter++;

        }
        for (int i = 0; i < maxN; i++) {
            vertexBol[i] = false;
        }

    }

    public void bfs(String name){
        int index = convertIndex(name);
        System.out.println("\n=============BFS SEARCH=============");
        System.out.printf("Vertex name = %s ",vertexName[index]);
        vertexBol[index] = true;
        queue.insert(index);
        int vertex;

        while (!queue.isEmpty()){
            int temp = queue.remove();

            while ((vertex = check(temp)) != -1){
                System.out.printf("\n%s ",vertexName[vertex]);
                vertexBol[vertex] = true;
                queue.insert(vertex);
            }
        }
        for (int i = 0; i < maxN; i++) {
            vertexBol[i] = false;
        }

    }

    public void Dijkstra(String startName, int count, String endNumName){
        this.endNum = convertIndex(endNumName);
        this.start = convertIndex(startName);

        if (count == 0){
            realStart = start;
            cost[0][start] = 0;
        }
        for (int i = 0; i < cost[0].length; i++) {
            if (matrix[start][i] > 0 && cost[0][i] > (matrix[start][i] + cost[0][start]) ){
                cost[0][i] = matrix[start][i] + cost[0][start];
                cost[1][i] = start;
            }
        }

        int j = minDist();
        if (j  == -1 ){
            result();
            for (int i = 0; i < cost.length; i++) {
                for (int k = 0; k < cost[i].length; k++) {
                    cost[i][k]=INF;
                    visited[k]=0;
                }
            }
            return;
        }else{
            visited[j] = 1;
            Dijkstra(convertVertex(j),1, convertVertex(endNum));
        }
    }

    public int minDist(){
        int minDistance = INF;
        int index = -1;
        for (int i = 0; i < cost[0].length; i++){
            if (minDistance > cost[0][i] && visited[i] == 0){
                minDistance = cost[0][i];
                index = i;
            }
        }
        return index;
    }

    public void result(){
        boolean stop = false;
        int now = endNum;
        int[] result;
        int iter = 0;

        while (now != realStart){
            now = cost[1][now];
            iter++;
            if (iter > maxN){
                stop = true;
                break;
            }
        }
        if (stop){
            System.out.println("Из вершины "+convertVertex(realStart)+" в вершину "+convertVertex(endNum)+" пути нет 0_0");
        }else{

            result = new int[iter];

            now = endNum;
            while (now != realStart){
                now = cost[1][now];
                result[--iter] = now;
            }
            System.out.println();
            for (int i = 0; i < result.length ; i++) {
                System.out.print(convertVertex(result[i])+" ==> ");
            }
            System.out.print(convertVertex(endNum)+"\nСтоимость поездки: \n"+cost[0][endNum]);
        }
    }

    public String convertVertex(int index){
        return vertexName[index];
    }

    public int convertIndex(String vertex){
        for (int i = 0; i < vertexName.length; i++) {
            if (vertexName[i].equals(vertex)){
                return i;
            }
        }
        return -1;
    }

    public void rozruv(String r1, String r2){
        int roz1 = convertIndex(r1), roz2 = convertIndex(r2);
        matrix[roz1][roz2] = 0;
        bfs(convertVertex(0));
        dfs(convertVertex(0));
        Dijkstra(convertVertex(realStart), 0,convertVertex(endNum));
//        Dijkstra("Киев", 0,"Донецк");
    }
}
