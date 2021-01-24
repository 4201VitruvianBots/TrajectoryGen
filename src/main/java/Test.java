import edu.wpi.first.wpilibj.geometry.Pose2d;
import edu.wpi.first.wpilibj.geometry.Rotation2d;
import edu.wpi.first.wpilibj.geometry.Transform2d;

import java.util.ArrayList;

public class Test {

    public static void main(String... args) {
        Pose2d endpoint =  new Pose2d(5, 0, new Rotation2d());

        ArrayList<Pose2d> nextPath = new ArrayList<>();
        nextPath.add(new Pose2d(0,0, new Rotation2d()));
        nextPath.add(new Pose2d(10,5, new Rotation2d()));

        ArrayList<Pose2d> adjustedPath = new ArrayList<>();
        for(int i = 0; i < nextPath.size(); i++)
            adjustedPath.add(nextPath.get(i).transformBy(new Transform2d(endpoint, nextPath.get(i))));

        for(Pose2d point:adjustedPath)
            System.out.printf("X: %.2f\tY: %.2f\n", point.getTranslation().getX(),point.getTranslation().getY());
    }
}
