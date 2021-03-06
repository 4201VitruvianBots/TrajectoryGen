import edu.wpi.first.wpilibj.geometry.Pose2d;
import edu.wpi.first.wpilibj.geometry.Rotation2d;

import java.util.ArrayList;
import java.util.Arrays;

public class Trajectories {
    //test
    public static ArrayList<Pose2d> driveStraight = new ArrayList<>(
        Arrays.asList(new Pose2d(0, 0, Rotation2d.fromDegrees(0)),
                      new Pose2d(5, 0, Rotation2d.fromDegrees(0)))
    );


    //ally trench path
    public static ArrayList<Pose2d> init1Ally2 = new ArrayList<>(
        Arrays.asList(new Pose2d(0, 0, Rotation2d.fromDegrees(0)),
                      new Pose2d(-13, 0, Rotation2d.fromDegrees(0)))
    );
    public static ArrayList<Pose2d> ally2Ally3 = new ArrayList<>(
            Arrays.asList(new Pose2d(0, 0, Rotation2d.fromDegrees(0)),
                    new Pose2d(5, 2, Rotation2d.fromDegrees(0)))
    );
    public static ArrayList<Pose2d> ally2init2 = new ArrayList<>(
            Arrays.asList(new Pose2d(-13, 0, Rotation2d.fromDegrees(0)),
                    new Pose2d(-3, 0, Rotation2d.fromDegrees(0)))
    );

    //center path
    public static ArrayList<Pose2d> init3Ren45 = new ArrayList<>(
            Arrays.asList(new Pose2d(0, 0, Rotation2d.fromDegrees(0)),
                    new Pose2d(-6.3, 0, Rotation2d.fromDegrees(25)))
    );
    public static ArrayList<Pose2d> ren45Pivot = new ArrayList<>(
            Arrays.asList(new Pose2d(0, 0, Rotation2d.fromDegrees(0)),
                    new Pose2d(5, 0, Rotation2d.fromDegrees(0)))
    );
    public static ArrayList<Pose2d> pivotRen3 = new ArrayList<>(
            Arrays.asList(new Pose2d(0, 0, Rotation2d.fromDegrees(0)),
                    new Pose2d(-5, -1.5, Rotation2d.fromDegrees(0)))
    );


//for the enemy trench path
    public static ArrayList<Pose2d> init4Enemy1 = new ArrayList<>(
            Arrays.asList(new Pose2d(0, 0, Rotation2d.fromDegrees(0)),
                    new Pose2d(-7.5, 0, Rotation2d.fromDegrees(0)))
    );

    public static ArrayList<Pose2d> init5Rendev1 = new ArrayList<>(
            Arrays.asList(new Pose2d(0, -14.5, Rotation2d.fromDegrees(0)),
                    new Pose2d(-7, -14.5, Rotation2d.fromDegrees(0)))
    );
    public static ArrayList<Pose2d> enemy1Shooting1 = new ArrayList<>(
            Arrays.asList(new Pose2d(-7.5, 0, Rotation2d.fromDegrees(0)),
                    //new Pose2d(-5.5, -5.5, Rotation2d.fromDegrees(11.5)),
                    new Pose2d(-3, -11, Rotation2d.fromDegrees(23)))
    );

    public static ArrayList<Pose2d> shooting1Shooting2 = new ArrayList<>(
            Arrays.asList(new Pose2d(0, 0, Rotation2d.fromDegrees(0)),
    //new Pose2d(5, -5, Rotation2d.fromDegrees(0)),
                    new Pose2d(-2.5, 0, Rotation2d.fromDegrees(0)))

    );


}
