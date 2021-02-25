public class Street {
    int startIntersection;
    int endIntersection;
    String description;
    int timeToCross;

    public Street(int startIntersection, int endIntersection, String description, int timeToCross) {
        this.startIntersection = startIntersection;
        this.endIntersection = endIntersection;
        this.description = description;
        this.timeToCross = timeToCross;
    }

    public int getStartIntersection() {
        return startIntersection;
    }

    public void setStartIntersection(int startIntersection) {
        this.startIntersection = startIntersection;
    }

    public int getEndIntersection() {
        return endIntersection;
    }

    public void setEndIntersection(int endIntersection) {
        this.endIntersection = endIntersection;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getTimeToCross() {
        return timeToCross;
    }

    public void setTimeToCross(int timeToCross) {
        this.timeToCross = timeToCross;
    }
}
