import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadFile {
    private String[] CITY;
    private int[] WEIGHT;
    private int WEIGHT_CAR;
    private float FUEL;

    public ReadFile(){
        WEIGHT_CAR = 0;
        FUEL = 0;
    }


    public String[] getCITY(){
        return CITY;
    }
    public int[] getWEIGHT(){
        return WEIGHT;
    }
    public int getWEIGHT_CAR(){
        return WEIGHT_CAR;
    }
    public float getFUEL(){
        return FUEL;
    }

    public void read() throws FileNotFoundException {

        File file = new File("src/File/File.txt");
        Scanner scan = new Scanner(file);

        int i = -1, indexW = 0;
        while(scan.hasNextLine()){
            i++;
            String line = scan.nextLine();

            if(i == 0 ){
                CITY = line.split(" ");
            }
            else if(i == 1){
                String[] numberString = line.split(" ");
                WEIGHT = new int[numberString.length];
                for(int j = 0; j < WEIGHT.length; j++){
                    String number = numberString[j];
                    WEIGHT[indexW++] = Integer.parseInt(number);
                }
            }
            else if(i == 2){
                FUEL = Integer.parseInt(line);
            }
            else if (i == 3) {
                WEIGHT_CAR = Integer.parseInt(line);
            }
        }
        scan.close();

        System.out.print("\nСписок пунктов остановки\n");
        for (int j = 0; j < CITY.length; j++) {
            System.out.printf("%s, ", CITY[j]);
        }
        System.out.print("\nВыгруз груза на каждой точке выгрузки\n");
        for (int j = 0; j < WEIGHT.length; j++) {
            System.out.printf("%d кг ", WEIGHT[j]);
        }
        System.out.printf("\nНачальное кол-во топлива: %.1f л",FUEL);
        System.out.printf("\nВес грузовика без груза: %d кг",WEIGHT_CAR);
    }
}
