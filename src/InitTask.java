import java.util.Scanner;
public class InitTask {
    Scanner scan = new Scanner(System.in);
    XData xData = new XData();
    private final int maxN;
    public int[][] matrixSmeg;
    public String[] nameCity;
    public int[] weight;
    public int weightCar;
    public float fuel;

    public InitTask(String[] nameCity, int[] weight, int weightCar, float fuel){
        maxN = nameCity.length;
        this.nameCity = nameCity;
        this.weight = weight;
        this.weightCar = weightCar;
        this.fuel = fuel;
        matrixSmeg = new int[maxN][maxN];
    }

    public void addEdge (int start, int end, int weight){
        matrixSmeg[start][end] = weight;
    }

    public void runCarTask(){
        String start, end;
        int startNum = 0, endNum = 0, weightMat;
        boolean stop = false;
        System.out.print("\nНапишите, от куда и куда будет ехать грузовик\n");
        for (int i = 0; !stop ; i++) {
            start = scan.next();
            if (start.equals("over")){
                System.out.print("Это был последний пункт назначения");
                stop = true;
                break;
            }
            end = scan.next();
//            weightMat = scan.nextInt();
            for (int j = 0; j < maxN; j++) {

                if(start.equals(nameCity[j])){
                    startNum = j;
                }
                if(end.equals(nameCity[j])){
                    endNum = j;
                    System.out.printf("Общий вес груза: %d",xData.loadWeight(weight));
                    System.out.printf("\nВыгрузил: %d: ", weight[j]);
                    System.out.printf("\nОсталось груза: %d ",xData.loadWeight(weight) - weight[j]);
                    weight[j] = 0;
                    fuel = xData.fuel(fuel, xData.loadWeight(weight), weightCar);
                    System.out.printf("\nОсталось топлива: %.1f\n", fuel);
                }
            }
            addEdge(startNum, endNum, 1);
        }
    }
}
