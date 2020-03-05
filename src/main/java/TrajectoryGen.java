import com.opencsv.CSVWriter;
import edu.wpi.first.wpilibj.geometry.Pose2d;

import java.io.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class TrajectoryGen {
    static Map<String, Trajectory> trajectories = new HashMap<>();
    static long startTime;
    static int index = 0;

    public static void main(String[] args) {
        startTime = System.nanoTime();
        // Generate all path settings
        initializeTrajectories();

        Set<String> keySet = trajectories.keySet();
        Iterator<String> iterator = keySet.iterator();

        File trajectoryDir = new File("Trajectories/");
        if(!trajectoryDir.exists()) {
            System.out.println("Trajectories/ directory doesn't exist. Making directory...");
            trajectoryDir.mkdir();
        }

        while(iterator.hasNext()) {
            String key = iterator.next();

            File trajectoryFile = new File(trajectoryDir, trajectories.get(key).name + ".csv");
            FileWriter fileWriter = null;
            try {
                fileWriter = new FileWriter(trajectoryFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
            CSVWriter csvWriter = new CSVWriter(fileWriter);

            for(Pose2d waypoint : trajectories.get(key).waypoints) {
                String[] line = {String.format("%.2f", waypoint.getTranslation().getX()),
                                 String.format("%.2f", waypoint.getTranslation().getY()),
                                 String.format("%.2f", waypoint.getRotation().getDegrees())};
                csvWriter.writeNext(line, false);
            }
            try {
                csvWriter.close();
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            index++;
        }

        System.out.println("Number of Paths Generated: " + index);
        long runTime = System.nanoTime() - startTime;
        if(runTime < 1e12)
            System.out.printf("\nRuntime: %.3f nanoseconds", runTime / 1e3);
        else if(runTime < 1e9)
            System.out.printf("\nRuntime: %.3f milliseconds", runTime / 1e6);
        else
            System.out.printf("\nRuntime: %.3f seconds", runTime / 1e9);
    }

    public static void initializeTrajectories() {
        trajectories.put("driveStraight", new Trajectory("driveStraight", Trajectories.driveStraight));
        trajectories.put("init1Ally2", new Trajectory("init1Ally2", Trajectories.init1Ally2));
        trajectories.put("ally2Ally3", new Trajectory("ally2Ally3", Trajectories.ally2Ally3));
        trajectories.put("ally2init2", new Trajectory("ally2init2", Trajectories.ally2init2));
        trajectories.put("init4Enemy1", new Trajectory("init4Enemy1", Trajectories.init4Enemy1));
        trajectories.put("init5Rendev1", new Trajectory("init5Rendev1", Trajectories.init5Rendev1));
        trajectories.put("enemy1Shooting1", new Trajectory("enemy1Shooting1", Trajectories.enemy1Shooting1));
        trajectories.put("shooting1Shooting2", new Trajectory("shooting1Shooting2", Trajectories.shooting1Shooting2));
        trajectories.put("init3Ren45", new Trajectory("init3Ren45", Trajectories.init3Ren45));
        trajectories.put("ren45Pivot", new Trajectory("ren45Pivot", Trajectories.ren45Pivot));
        trajectories.put("pivotRen3", new Trajectory("pivotRen3", Trajectories.pivotRen3));




    }
}
