import edu.wpi.first.wpilibj.geometry.Pose2d;
import edu.wpi.first.wpilibj.geometry.Rotation2d;
import edu.wpi.first.wpilibj.trajectory.Trajectory;
import edu.wpi.first.wpilibj.util.Units;

import java.util.ArrayList;
import java.util.Arrays;

public class Trajectories {
    public static ArrayList<Pose2d> driveStraight = new ArrayList<>(
        Arrays.asList(new Pose2d(0, 0, Rotation2d.fromDegrees(0)),
                      new Pose2d(5, 0, Rotation2d.fromDegrees(0)))
    );

    public static ArrayList<Pose2d> spline = new ArrayList<>(
        Arrays.asList(new Pose2d(0, 0, Rotation2d.fromDegrees(45)),
                      new Pose2d(5, 5, Rotation2d.fromDegrees(45)))
    );


    public static ArrayList<Pose2d> initiationToRendezvous3 = new ArrayList<>(
            Arrays.asList(new Pose2d(0, 0, Rotation2d.fromDegrees(0)),
                    new Pose2d(0, 0, Rotation2d.fromDegrees(0)))
    );
    public static ArrayList<Pose2d> initiationToAllyTrench = new ArrayList<>(
            Arrays.asList(new Pose2d(0, 0, Rotation2d.fromDegrees(0)),
                    new Pose2d(8.25, 0, Rotation2d.fromDegrees(0)))
    );
    public static ArrayList<Pose2d> allyTrenchPickup = new ArrayList<>(
            Arrays.asList(new Pose2d(0, 0, Rotation2d.fromDegrees(0)),
                    new Pose2d(4.5, 0, Rotation2d.fromDegrees(15)))
    );
    public static ArrayList<Pose2d> initiationToRendezvous2 = new ArrayList<>(
            Arrays.asList(new Pose2d(0, 0, Rotation2d.fromDegrees(0)),
                    new Pose2d(5.5, 1, Rotation2d.fromDegrees(0)),
                    new Pose2d(8.64, -0.44, Rotation2d.fromDegrees(-63)))
    );
    public static ArrayList<Pose2d> rendezvous2Trench = new ArrayList<>(
            Arrays.asList(new Pose2d(0, 0, Rotation2d.fromDegrees(0)),
                    new Pose2d(5.47, 6.08, Rotation2d.fromDegrees(0)))
    );
    public static ArrayList<Pose2d> trench2Initiation = new ArrayList<>(
            Arrays.asList(new Pose2d(0, 0, Rotation2d.fromDegrees(0)),
                    new Pose2d(-14.75, 0, Rotation2d.fromDegrees(720)))
    );
    public static ArrayList<Pose2d> enemyTrench = new ArrayList<>(
            Arrays.asList(new Pose2d(0, 0, Rotation2d.fromDegrees(0)),
                    new Pose2d(-9.5, 0, Rotation2d.fromDegrees(0)))
    );
    public static ArrayList<Pose2d> backUp = new ArrayList<>(
            Arrays.asList(new Pose2d(0, 0, Rotation2d.fromDegrees(0)),
                    new Pose2d(9.5, 0, Rotation2d.fromDegrees(0)))
    );
    public static ArrayList<Pose2d> turnShoot = new ArrayList<>(
            Arrays.asList(new Pose2d(0, 0, Rotation2d.fromDegrees(0)),
                    new Pose2d(3, -2.5, Rotation2d.fromDegrees(-100))
                 //   new Pose2d(2.75, -10, Rotation2d.fromDegrees(45))
            )

    );

    public static ArrayList<Pose2d> driveShoot = new ArrayList<>(
            Arrays.asList(new Pose2d(0, 0, Rotation2d.fromDegrees(0)),
                    new Pose2d(5, 5, Rotation2d.fromDegrees(0)))
    );


}
