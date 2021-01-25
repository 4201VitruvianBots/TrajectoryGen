import edu.wpi.first.wpilibj.geometry.Pose2d;
import edu.wpi.first.wpilibj.geometry.Rotation2d;
import edu.wpi.first.wpilibj.geometry.Transform2d;
import edu.wpi.first.wpilibj.trajectory.Trajectory;
import edu.wpi.first.wpilibj.trajectory.TrajectoryConfig;
import edu.wpi.first.wpilibj.trajectory.TrajectoryGenerator;
import edu.wpi.first.wpilibj.util.Units;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XYChart;
import org.knowm.xchart.XYChartBuilder;
import org.knowm.xchart.XYSeries;
import org.knowm.xchart.style.Styler;
import org.knowm.xchart.style.markers.Marker;
import org.knowm.xchart.style.markers.SeriesMarkers;

import java.awt.*;
import java.util.List;

public class PlotTrajectory {
    public static void main(String... args) {
        plotTrajectory();
    }

    public static void plotTrajectory() {
        Pose2d startPosition = new Pose2d();
        Pose2d[] waypoints = {
                new Pose2d(Units.inchesToMeters(30), Units.inchesToMeters(30), new Rotation2d(Units.degreesToRadians(0))),
                new Pose2d(Units.inchesToMeters(90), Units.inchesToMeters(60), new Rotation2d(Units.degreesToRadians(60))),
                new Pose2d(Units.inchesToMeters(120), Units.inchesToMeters(90), new Rotation2d(Units.degreesToRadians(0))),
                new Pose2d(Units.inchesToMeters(240), Units.inchesToMeters(90), new Rotation2d(Units.degreesToRadians(0))),
                new Pose2d(Units.inchesToMeters(270), Units.inchesToMeters(60), new Rotation2d(Units.degreesToRadians(-45))),
                new Pose2d(Units.inchesToMeters(315), Units.inchesToMeters(34), new Rotation2d(Units.degreesToRadians(30))),
                new Pose2d(Units.inchesToMeters(315), Units.inchesToMeters(86), new Rotation2d(Units.degreesToRadians(150))),
                new Pose2d(Units.inchesToMeters(270), Units.inchesToMeters(60), new Rotation2d(Units.degreesToRadians(225))),
                new Pose2d(Units.inchesToMeters(240), Units.inchesToMeters(30), new Rotation2d(Units.degreesToRadians(180))),
                new Pose2d(Units.inchesToMeters(120), Units.inchesToMeters(30), new Rotation2d(Units.degreesToRadians(180))),
                new Pose2d(Units.inchesToMeters(90), Units.inchesToMeters(60), new Rotation2d(Units.degreesToRadians(135))),
                new Pose2d(Units.inchesToMeters(30), Units.inchesToMeters(90), new Rotation2d(Units.degreesToRadians(180)))
        };

        Trajectory[] trajectories = new Trajectory[waypoints.length - 1];
        Trajectory[] transformedTrajectories = new Trajectory[waypoints.length - 1];

        TrajectoryConfig configA = new TrajectoryConfig(Units.feetToMeters(6), Units.feetToMeters(10));
        configA.setReversed(false);
        configA.setEndVelocity(configA.getMaxVelocity());
//        configA.addConstraint(new DifferentialDriveKinematicsConstraint(driveTrain.getDriveTrainKinematics(), configA.getMaxVelocity()));
//        configA.addConstraint(new DifferentialDriveVoltageConstraint(driveTrain.getFeedforward(), driveTrain.getDriveTrainKinematics(),10));
//        configA.addConstraint(new CentripetalAccelerationConstraint(0.75));

        Trajectory tempTrajectory;
        Pose2d finalPose = waypoints[0];

        for(int i = 0; i < waypoints.length - 1; i++) {
            trajectories[i] = TrajectoryGenerator.generateTrajectory(waypoints[i],
                    List.of(),
                    waypoints[i + 1],
                    configA);
            Transform2d transform = finalPose.minus(trajectories[i].getInitialPose());
            transformedTrajectories[i] = trajectories[i].transformBy(transform);

            tempTrajectory = transformedTrajectories[i];
            finalPose = tempTrajectory.getStates().get(tempTrajectory.getStates().size() - 1).poseMeters;
        }

        /*Trajectory startTo2Path = TrajectoryGenerator.generateTrajectory(startPosition,
                List.of(),
                point2,
                configA);
        Transform2d startTransform = origin.minus(startTo2Path.getInitialPose());
        Trajectory transformedPathstartTo2 = startTo2Path.transformBy(startTransform);

        //configA.setStartVelocity(configA.getMaxVelocity());
        Trajectory point2To3Path = TrajectoryGenerator.generateTrajectory(point2,
                List.of(),
                point3,
                configA);

        tempTrajectory = transformedPathstartTo2;
        finalPose = tempTrajectory.getStates().get(tempTrajectory.getStates().size() - 1).poseMeters;

        Transform2d point2To3Transform = finalPose.minus(point2To3Path.getInitialPose());
        Trajectory transformedPath2To3 = point2To3Path.transformBy(point2To3Transform);

        Trajectory point3To4Path = TrajectoryGenerator.generateTrajectory(point3,
                List.of(),
                point4,
                configA);

        tempTrajectory = transformedPath2To3;
        finalPose = tempTrajectory.getStates().get(tempTrajectory.getStates().size() - 1).poseMeters;

        Transform2d point3To4Transform = finalPose.minus(point3To4Path.getInitialPose());
        Trajectory transformedPath3To4 = point3To4Path.transformBy(point3To4Transform);

        Trajectory point4To5Path = TrajectoryGenerator.generateTrajectory(point4,
                List.of(),
                point5,
                configA);

        tempTrajectory = transformedPath3To4;
        finalPose = tempTrajectory.getStates().get(tempTrajectory.getStates().size() - 1).poseMeters;

        Transform2d point4To5Transform = finalPose.minus(point4To5Path.getInitialPose());
        Trajectory transformedPath4To5 = point4To5Path.transformBy(point4To5Transform);*/
//        Trajectory point4To5Path = TrajectoryGenerator.generateTrajectory(point4,
//                List.of(),
//                point5,
//                configA);
//
//        tempTrajectory = transformedPath3To4;
//        finalPose = tempTrajectory.getStates().get(tempTrajectory.getStates().size() - 1).poseMeters;
//
//        Transform2d point4To5Transform = finalPose.minus(point4To5Path.getInitialPose());
//        Trajectory transformedPath4To5 = point4To5Path.transformBy(point4To5Transform);
//
//        Transform2d point5To6Transform = point4To5Path.getInitialPose().minus(point5);
//        Trajectory transformedPath5To6 = transformedPath4To5.transformBy(point5To6Transform);
//
//        Transform2d point6To7Transform = point4To5Path.getInitialPose().minus(point6);
//        Trajectory transformedPath6To7 = transformedPath4To5.transformBy(point6To7Transform);


        plotTrajectories(transformedTrajectories);
    }

    public static void plotTrajectories(Trajectory... trajectories){
        double[][] xValues = new double[trajectories.length][];
        double[][] yValues = new double[trajectories.length][];
        double[][] time = new double[trajectories.length][];

        double lastTime = 0;
        double sampleSize = 0.02;
        for(int i = 0; i < trajectories.length; i++){
            double timestamp = 0;
            int idx = 0;

            int length = (int) Math.floor(trajectories[i].getTotalTimeSeconds() / sampleSize);
            xValues[i] = new double[length];
            yValues[i] = new double[length];
            time[i] = new double[length];

            while(idx < length) {
                timestamp = idx * sampleSize;
                Trajectory.State state = trajectories[i].sample(timestamp);

                xValues[i][idx] = state.poseMeters.getX();
                yValues[i][idx] = state.poseMeters.getY();
                time[i][idx] = lastTime + timestamp;

                timestamp += sampleSize * idx;
                idx++;
            }
            lastTime += timestamp;
        }


        // Create Chart
        XYChart chart = new XYChartBuilder().width(600).height(500).title("Trajectory").xAxisTitle("X").yAxisTitle("Y").build();

        // Customize Chart
        chart.getStyler().setDefaultSeriesRenderStyle(XYSeries.XYSeriesRenderStyle.Scatter);
        chart.getStyler().setChartTitleVisible(false);
        chart.getStyler().setLegendPosition(Styler.LegendPosition.InsideSW);
        chart.getStyler().setMarkerSize(8);


        Marker[] markers = {
                SeriesMarkers.DIAMOND,
                SeriesMarkers.CIRCLE,
                SeriesMarkers.OVAL,
                SeriesMarkers.SQUARE,
                SeriesMarkers.TRAPEZOID,
                SeriesMarkers.TRIANGLE_DOWN,
                SeriesMarkers.TRIANGLE_UP,
                SeriesMarkers.DIAMOND,
                SeriesMarkers.CIRCLE,
                SeriesMarkers.OVAL,
                SeriesMarkers.SQUARE
        };
        Color[] colors = {
                Color.BLACK,
                Color.BLUE,
                Color.CYAN,
                Color.DARK_GRAY,
                Color.GRAY,
                Color.GREEN,
                Color.LIGHT_GRAY,
                Color.BLACK,
                Color.BLUE,
                Color.CYAN,
                Color.DARK_GRAY
        };
//        Color[] colors = {
//            Color.getHSBColor(30, (float) 100.0, (float)   0.0),
//            Color.getHSBColor(30, (float) 100.0, (float)  12.5),
//            Color.getHSBColor(30, (float) 100.0, (float)  25.0),
//            Color.getHSBColor(30, (float) 100.0, (float)  37.5),
//            Color.getHSBColor(30, (float) 100.0, (float)  50.0),
//            Color.getHSBColor(30, (float) 100.0, (float)  75.0),
//            Color.getHSBColor(30, (float) 100.0, (float)  87.5),
//            Color.getHSBColor(30, (float) 100.0, (float) 100.0)
//        };

        for(int i = 0; i < trajectories.length; i++) {
            String name = "Path: " + i;
            XYSeries series = chart.addSeries(name, xValues[i], yValues[i]);
            series.setMarker(markers[i]);
            series.setMarkerColor(colors[i]);
        }

        new SwingWrapper(chart).displayChart();
    }
}
