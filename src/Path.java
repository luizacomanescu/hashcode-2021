import java.util.ArrayList;

public class Path {
    int noStreets;
    ArrayList<String> streetNames;

    public Path(int noStreets, ArrayList<String> streetNames) {
        this.noStreets = noStreets;
        this.streetNames = streetNames;
    }

    public int getNoStreets() {
        return noStreets;
    }

    public void setNoStreets(int noStreets) {
        this.noStreets = noStreets;
    }

    public ArrayList<String> getStreetNames() {
        return streetNames;
    }

    public void setStreetNames(ArrayList<String> streetNames) {
        this.streetNames = streetNames;
    }
}
