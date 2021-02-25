import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
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
            File myObj = new File("files/f.txt");
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

        try {
            HashMap<String, Integer> streetTime;
            ArrayList<HashMap<String,Integer>> listIntersections = new ArrayList<>();
            FileWriter myWriter = new FileWriter("output/out_f.txt");
            for (int i=0;i<simulationDuration;i++){
                streetTime = new HashMap<>();
                for (Path path:paths) {
                    if (!path.getStreetNames().isEmpty()) {
                        streetTime.put(path.streetNames.remove(0), 1);
                    }
                }
                if(!streetTime.isEmpty()){
                    listIntersections.add(streetTime);
                }
            }

            myWriter.write(String.valueOf(listIntersections.size()));
            myWriter.write(" \n");
            int i = 1;
            for (HashMap<String, Integer> map:listIntersections) {
                myWriter.write(String.valueOf(i ++));
                myWriter.write(" \n");
                myWriter.write(String.valueOf(map.size()));
                myWriter.write(" \n");
                for (Map.Entry<String,Integer> entry : map.entrySet()) {
                    myWriter.write(entry.getKey() + " " + entry.getValue());
                    myWriter.write(" \n");
                }
            }

            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }
}
