import edu.wpi.first.wpilibj.geometry.Pose2d;
import edu.wpi.first.wpilibj.geometry.Rotation2d;

import java.util.ArrayList;
import java.util.Arrays;

public class Trajectory {
    public String name;
    public ArrayList<Pose2d> waypoints;

    public Trajectory(String name, ArrayList<Pose2d> waypoints) {
        this.name = name;
        this.waypoints = waypoints;
    }
}
