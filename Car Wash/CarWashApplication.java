//
//    Car Wash Simulation Project:  CarWashApplication Class
//
//    The Car Wash Simulation Project is described in 
//    <a href="http://max.cs.kzoo.edu/cs210/Labs/Queues/CarWashProgram.html">Car
//    Wash Project Description</a>.
//
//    Authors:   Autumn C. Spaulding and Alyce Brady,
//               based on a description by
//               <a href="mailto:trollend@nb.net">Todd Ollendyke</a>.
//    Date:      13 July 2000
//    Modified:  12 October 2000
//      Added Bay class and separated simulation behavior from main into
//      the CarWashSimulation class.
//    Modified:  29 October 2002
//    Separated class templates into separate files.
//    Modified: 13 October 2014 by Preston Stosur-Bassett
//      Configured to work with updated simulation.
//

import java.util.ArrayList;

/**
 *  This is the main class for the Car Wash program.
 *
 */
public class CarWashApplication
{
    private String today;
     /**
     *  The main function constructs a car wash simulation and asks it to run.
     *  @param String args[] is not used in this implementation
     *  @return void
     */
    public static void main(String args[])
    {    

        // Construct a simulation object and start the simulation.
        // The car wash is open from 9am to 7pm (10 hours).
        CarWashSimulation sim = new CarWashSimulation(true, 10, 4, 4);

        //Run the simulation for everyday of the week.
        for(int i = 0; i < 6; i++) {
            //Set the value of today to one of the days of the week.
            ArrayList<String> daysOfTheWeek = new ArrayList(6);
            daysOfTheWeek.add("Monday");
            daysOfTheWeek.add("Tuesday");
            daysOfTheWeek.add("Wednesday");
            daysOfTheWeek.add("Thursday");
            daysOfTheWeek.add("Friday");
            daysOfTheWeek.add("Saturday");
            daysOfTheWeek.add("Sunday");

            //Run the simulation
            sim.openForBusiness();

            //Get the reports for todays day of business.
            sim.printReport(daysOfTheWeek.get(i));

            //Reset the simulation
            sim.reset();

            //Add extra line for easier reading
            System.out.println(" ");
        }

        System.out.println("Program done.");

    }    // end main

}  // end class CarWashApplication class
