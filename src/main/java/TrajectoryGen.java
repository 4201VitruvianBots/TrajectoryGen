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
                csvWriter.writeNext(line);
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
    }
}
