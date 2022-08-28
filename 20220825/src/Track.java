import java.util.ArrayList;
import java.util.Arrays;

public class Track {
    private ArrayList<Stage> stages;

    public ArrayList<Stage> getStages() {
        return stages;
    }

    public Track(Stage... stages) {
        this.stages = new ArrayList<>(Arrays.asList(stages));
    }
}