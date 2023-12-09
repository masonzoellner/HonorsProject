package dataqueue;

import cs2.*;

import cs2.Button;
import cs2.Shape;
import cs2.Window;

import java.awt.*;
import student.TestableRandom;
import java.awt.Color;

// -------------------------------------------------------------------------
/**
 * This class creates the graphical window for the project.
 * 
 * @author mason
 * @version Nov 21, 2023
 */
public class GUI
{
    private TimeMeasurement timeMeasurement;
    private Window window;

    // ----------------------------------------------------------
    /**
     * Create a new GUI object.
     */
    public GUI()
    {
        this.timeMeasurement = new TimeMeasurement(); 
        this.window = new Window();
    }


    // ----------------------------------------------------------
    /**
     * This is the main method that runs to set up the GUI.
     * @param args
     */
    public static void main(String[] args)
    {
        //
    }


    // ----------------------------------------------------------
    /**
     * This class measures and displays the time for the different 
     * PlayerDataSets
     * @param methodName
     * @param pds 
     */
    public void measureAndDisplayTime(String methodName, PlayerDataSet pds)
    {
        double enqueueTime = timeMeasurement.measureEnqueueTime(pds);
        double dequeueTime = timeMeasurement.measureDequeueTime(pds);
        double frontTime = timeMeasurement.measureFrontTime(pds);
        double emptyTime = timeMeasurement.measureEmptyTime(pds);
        int startX = 150;
        if ( pds.getPlayerQueue().getSize() == 250 )
        {
            startX = 200;
        }
        if ( pds.getPlayerQueue().getSize() == 2500)
        {
            startX = 250;
        }

        drawBarGraph(window, methodName, startX, enqueueTime, dequeueTime, frontTime, emptyTime);
    }
    private void drawBarGraph(
        Window window, 
        String label, 
        int startingX, 
        double value1, double value2, double value3, 
        double value4) {
        
        int barWidth = 50;
        int maxValue = 1;
        int barHeight = 40000;

        int x1 = startingX;
        int x2 = startingX + 150;
        int x3 = startingX + 300;
        int x4 = startingX + 450;
        
        int xAxisLabelX = 300;
        int xAxisLabelY = 350;
        int yAxisLabelX = 30;
        int yAxisLabelY = 200;

        TextShape xAxisLabel = new TextShape(xAxisLabelX, xAxisLabelY, "PlayerDataSet Size + method name");
        window.addShape(xAxisLabel);

        TextShape yAxisLabel = new TextShape(yAxisLabelX, yAxisLabelY, "Time (ms)");
        window.addShape(yAxisLabel);
        
        
        for (int i = 0; i <= 5; i++) {
            double tickValue =  i * (value1/5);
            TextShape tickLabel = new TextShape(100, (int)(300 - ( tickValue * barHeight)), String.format("%.4f", tickValue) + "-");
            window.addShape(tickLabel);
        }
        
        TextShape titleLabel = new TextShape(300, 20, "Algorithm Time Results");
        window.addShape(titleLabel);

        drawBarAndLabel(window, label + "eqt", x1, 300, barWidth, (int) (value1 / maxValue * barHeight), Color.BLUE);
        drawBarAndLabel(window, label + "dt", x2, 300, barWidth, (int) (value2 / maxValue * barHeight), Color.RED);
        drawBarAndLabel(window, label + "ft", x3, 300, barWidth, (int) (value3 / maxValue * barHeight), Color.GREEN);
        drawBarAndLabel(window, label + "emt", x4, 300, barWidth, (int) (value3 / maxValue * barHeight), Color.ORANGE);
    }

    private void drawBarAndLabel(Window window, String label, int x, int yBottom,
        int width, int height, Color color)
    {
        int yTop = yBottom - height;
        Shape bar = new Shape(x, yTop, width, height, color);
        window.addShape(bar);
        int labelY = yBottom + 5;
        TextShape labelText = new TextShape(x + width / 2, labelY, label);
        labelText.setX(labelText.getX() - labelText.getWidth() / 2);          
        window.addShape(labelText);
    }
}
