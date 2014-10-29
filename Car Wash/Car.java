//
//  Car Wash Simulation Project:  Car Class
//
//  The Car Wash Simulation Project is described in 
//  <a href="http://max.cs.kzoo.edu/cs210/Labs/Queues/CarWashProgram.html">Car
//  Wash Project Description</a>.
//
//  Authors:   Autumn C. Spaulding and Alyce Brady,
//             based on a description by
//             <a href="mailto:trollend@nb.net">Todd Ollendyke</a>.
//  Date:      13 July 2000
//  Modified:  29 October 2002
//    Separated class templates into separate files.
//


/**
 *  This class represents a car in the Car Wash program.  The primary
 *  responsibility of a car (at least at this time) is to keep track
 *  of its arrival time so that the simulation can determine how long
 *  the car has to wait before being washed.
 *
 **/
public class Car
{
    int myArrivalTime;

    /** Construct a car.
     *  @param arrivalTime time when car arrived at car wash.
     */
    public Car (int arrivalTime)
    {
        myArrivalTime = arrivalTime;
    }

    /** Report the arrival time for this car at the car wash. */
    public int arrivalTime ()
    {
        return myArrivalTime;
    }

} // end Car class
