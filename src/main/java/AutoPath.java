import edu.wpi.first.wpilibj.geometry.Pose2d;

import java.util.ArrayList;

public class AutoPath {
    public String name;
    public ArrayList<Pose2d> waypoints;

    public AutoPath(String name, ArrayList<Pose2d> waypoints) {
        this.name = name;
        this.waypoints = waypoints;
    }
}
