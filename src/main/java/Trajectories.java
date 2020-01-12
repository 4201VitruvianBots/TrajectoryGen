import edu.wpi.first.wpilibj.geometry.Pose2d;
import edu.wpi.first.wpilibj.geometry.Rotation2d;
import edu.wpi.first.wpilibj.trajectory.Trajectory;

import java.util.ArrayList;
import java.util.Arrays;

public class Trajectories {
    public static ArrayList<Pose2d> driveStraight = new ArrayList<>(
        Arrays.asList(new Pose2d(0, 0, Rotation2d.fromDegrees(0)),
                      new Pose2d(5, 0, Rotation2d.fromDegrees(0)))
    );
}
