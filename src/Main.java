import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static int simulationDuration;
    static int noIntersections;
    static int noStreets;
    static int noCars;
    static int bonusPoints;

    /**
     * FUCLK OFF
     * @param args
     */

    public static void main(String args[]) {
        String data;
        String[] values;
        ArrayList<Street> streets = new ArrayList<>();
        ArrayList<Path> paths = new ArrayList<>();
        try {
            File myObj = new File("/Users/luizacomanescu/git/hashcode_2021/a.txt");
            Scanner myReader = new Scanner(myObj);

            data = myReader.nextLine();
            values = data.split(" ");

            simulationDuration = Integer.valueOf(values[0]);
            noIntersections = Integer.valueOf(values[1]);
            noStreets = Integer.valueOf(values[2]);
            noCars = Integer.valueOf(values[3]);
            bonusPoints = Integer.valueOf(values[4]);

            int copyNoStreets = noStreets;

            while (copyNoStreets > 0 && myReader.hasNextLine()) {
                data = myReader.nextLine();
                values = data.split(" ");

                Street street = new Street(Integer.valueOf(values[0]), Integer.valueOf(values[1]),
                        values[2], Integer.valueOf(values[3]));
                streets.add(street);
                copyNoStreets --;
            }

            int copyNoCars = noCars;

            while(copyNoCars > 0 && myReader.hasNextLine()) {
                data = myReader.nextLine();
                values = data.split(" ");

                int noStreets = Integer.valueOf(values[0]);
                ArrayList<String> streetNames = new ArrayList<>();

                for(int i = 1; i < values.length; i ++) {
                    streetNames.add(values[i]);
                }

                paths.add(new Path(noStreets, streetNames));
            }

            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
