
//Киев Львов Одесса Харьков Мариуполь Днепр Донецк Крым Винница

public class XData {
    /*Класс для счета разных данных (Топливо, вес авто)*/

    public float fuel(float fuel, int loadWeight, int weightCar){
        // Топливо - ((вес авто + весь вес груза) * 0.01) - постоянный минус топлива
        fuel -=((weightCar + loadWeight) * 0.011f);
        return fuel;
    }

    public int loadWeight(int[] weight){
        int loadWeight = 0;

        for (int i = 0; i < weight.length; i++) {
            loadWeight += weight[i];
        }
        return loadWeight;
    }

    public void printMat(int[][] array){
        System.out.println("");
        for (int i = 0; i < array.length; i++) {
            System.out.print("|");
            for (int j = 0; j < array[i].length; j++) {
                System.out.printf("%4d",array[i][j]);
            }
            System.out.println("   |");
        }
    }

    public void printList(String[] list){
        System.out.print("[");
        for (int i = 0; i < list.length; i++) {
            System.out.print(" "+list[i]);
        }
        System.out.print("]");
    }

    public void printIntList(int[] list){
        System.out.print("[");
        for (int i = 0; i < list.length; i++) {
            System.out.print(" "+list[i]);
        }
        System.out.print("]");
    }
}
