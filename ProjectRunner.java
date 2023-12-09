package dataqueue;
import bsh.ParseException;

import java.io.*;
import java.util.Scanner;

// -------------------------------------------------------------------------
/**
 *  This ProjectRunner class includes the code needed to run the project.
 * 
 *  @author mason
 *  @version Nov 21, 2023
 */
public class ProjectRunner {
    // ----------------------------------------------------------
    /**
     * This is the main method that runs before the project runs
     * @param args
     */
    //~ Fields ................................................................

    //~ Constructors ..........................................................

    //~Public  Methods ........................................................
    public static void main(String[] args) {
        String csvFileName = "top5_leagues_player.csv";
        GUI benchmark = new GUI();
        readCSV(csvFileName, 2500, benchmark);
        readCSV(csvFileName, 250, benchmark);
        readCSV(csvFileName, 25, benchmark);
    }

    // ----------------------------------------------------------
    /**
     * This is the method that reads in the csv file.
     * @param filePath
     * @param x
     * @param benchmark
     * @return 
     */
    public static void readCSV(String filePath, int x, GUI benchmark) {
        PlayerDataSet dataset = new PlayerDataSet(x);
        try (Scanner scanner = new Scanner(new FileReader(filePath))) {
            if (scanner.hasNextLine()) {
                scanner.nextLine();
            }
            int count = 0;
            while (scanner.hasNextLine() && count < x) 
            {
                String[] nextRecord = scanner.nextLine().split(",");
                if (nextRecord.length >= 5 && !nextRecord[4].isEmpty()) 
                { 
                    String name = nextRecord[1];
                    double value;
                    try  
                    {
                        value = Double.parseDouble(nextRecord[4]);
                    } 
                    catch (NumberFormatException e) 
                    {
                        value = 0.00;
                    }
                    Data player = new Data(name, value);
                    dataset.addPlayer(player);
                    count++;
                }
            } 
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        benchmark.measureAndDisplayTime("" + x, dataset);
    }
}

