/**
*	<code>CarWasSimulation</code> runs a loops that simulates the traffic through the car wash to determine its efficiency
*	@author Preston Stosur-Bassett
* 	@date October 8th, 2014
*	@Couse CS210 (Data Structures)
*	@Assignment Car Wash Simulation
*/

import java.util.Random;

public class CarWashSimulation {
	private final int defaultTotalOpenMinutes = 600;
	private final int defaultTimeToWashCar = 4;
	private int totalOpenMinutes;
	private int totalWaitTime = 0;
	private int totalCarsWashed = 0;
	private int carsWashedBayOne = 0;
	private int carsWashedBayTwo = 0;
	private int waitTimeBayOne = 0;
	private int waitTimeBayTwo = 0; 
	private LLQueue<Car> waitingLine;
	private int timeToWashCar;
	private int timeToWashCarBayOne;
	private int timeToWashCarBayTwo;
	private boolean hasTwoBays;

	/**
	*	<code>CarWashSimulation</code> is one of the <code>CarWashSimulation</code> constructers that will accept no parameters and
	*		create a default simulation that creates a car wash that is open for 10 hours.
	*/
	public CarWashSimulation() {
		totalOpenMinutes = defaultTotalOpenMinutes;
		timeToWashCar = defaultTimeToWashCar;
		waitingLine = new LLQueue<Car>();
		hasTwoBays = false;
	}

	/**
	*	<code>CarWashSimulation(int hoursOpen)</code> is one of the <code>CarWashSimulation</code> constructers that will accept an
	*		int as a parameter and create a car wash with the hours provided as an argument
	*	@param int hoursOpen The total number of hours that the car wash is open.
	*	@param int minutesToWashCar The total number of minutes it takes the washing machine to wash a car
	*/
	public CarWashSimulation(int hoursOpen, int minutesToWashCar) {
		totalOpenMinutes = (hoursOpen * 60);
		timeToWashCar = minutesToWashCar;
		waitingLine = new LLQueue<Car>();
		hasTwoBays = false;
	}

	/**
	*	<code>CarWashSimulation(boolean twoBays)</code> is one of the <code>CarWashSimulation</code> constructers that will accept a
	*		boolean as a parameter and set up a car wash with one or two bays
	*	@param boolean twoBays True if the car wash has two wash bays, false if they only have one
	*/
	public CarWashSimulation(boolean twoBays) {
		if(twoBays == true) {
			//The user selected two bays
			hasTwoBays = true;
			totalOpenMinutes = defaultTotalOpenMinutes;
			timeToWashCarBayOne = defaultTimeToWashCar;
			timeToWashCarBayTwo = defaultTimeToWashCar;
			waitingLine = new LLQueue<Car>();
		}
		else {
			//The user selected one bay
			totalOpenMinutes = defaultTotalOpenMinutes;
			timeToWashCar = defaultTimeToWashCar;
			waitingLine = new LLQueue<Car>();
			hasTwoBays = false;
		}
	}

	/**
	*	<code>CarWashSimulation(boolean twoBays, int hoursOpen, int minutesToWasBayOne, int minutesToWashBayTwo)</code> is one of the 
	*		constructors for CarWashSimulation that takes a boolean to determine how many bays the car wash has, an int to determine
	*		how many hours the car wash is open, and how many minutes it takes to wash using each bay.
	*	@param boolean twoBays True if the car was has two bays, false if they only have one
	*	@param int hoursOpen The total number of hours the car wash should run
	*	@param int minutesToWashBayOne The total number of minutes it takes bay one to wash a car
	*	@param int minutesToWashBayTwo The total number of minutes it takes bay two to wash a car
	*/
	public CarWashSimulation(boolean twoBays, int hoursOpen, int minutesToWashBayOne, int minutesToWashBayTwo) {
		if(twoBays == true) {
			//The user selected two bays
			hasTwoBays = true;
			totalOpenMinutes = (hoursOpen * 60);
			timeToWashCarBayOne = minutesToWashBayOne;
			timeToWashCarBayTwo = minutesToWashBayTwo;
			waitingLine = new LLQueue<Car>();
		}
		else {
			//The user selected one bay
			totalOpenMinutes = (hoursOpen * 60);
			timeToWashCar = minutesToWashBayOne;
			waitingLine = new LLQueue<Car>();
			hasTwoBays = false;
		}
	}

	/**
	*	<code>openForBusiness</code> will check to see how many bays the car wash is using and the run the appropriate simulation
	*/
	public void openForBusiness() {
		if(hasTwoBays == true) {
			runTwoBays();
		}
		else {
			runOneBay();
		}
	}

	/**
	*	<code>runOneBay</code> is the simulation that runs when the car wash only has one bay to wash cars in.
	*/
	private void runOneBay() {
		int currentTime = totalOpenMinutes;		//Set the current time
		Bay washingMachine = new Bay(timeToWashCar);
		boolean queueIsEmpty = false;

		//Run a loop to check for cars while the business is open
		while(currentTime != 0 || currentTime > 0) {
			//Check to see if a car has arrived
			boolean carArrived = new Random().nextInt(4)==0;	//Generate a 1 in 4 chance that in this minute right now a car arrives
			if(carArrived == true) {
				totalCarsWashed = totalCarsWashed + 1;
				Car newCar = new Car(currentTime);	//Create a new car object that arrived right now
				waitingLine.enqueue(newCar);	//Push that car to the queue
			}
			if(waitingLine.isEmpty() != true) {
				if(washingMachine.isEmpty() == true) {
					//Increase the total wait time
					Car thisCar = waitingLine.dequeue();
					int thisCarWaitTime = (thisCar.arrivalTime() - currentTime);
					totalWaitTime = totalWaitTime + thisCarWaitTime;

					//Start Washing the car
					washingMachine.startWash();
				}
				else {
					washingMachine.keepWashing();
				}
			}

			currentTime = currentTime - 1;
		} 
	}

	/**
	*	<code>runTwoBays</code> is the simulation that will run when the car wash has two bays to wash cars in.
	*/
	private void runTwoBays() {
		int currentTime = totalOpenMinutes; 	//Set the current time
		Bay washingMachineOne = new Bay(timeToWashCarBayOne);
		Bay washingMachineTwo = new Bay(timeToWashCarBayTwo);

		//Run a loop to check for cars while the business is open
		while(currentTime != 0 || currentTime > 0) {
			//Check to see if a car has arrived
			boolean carArrived = new Random().nextInt(4)==0; 	//Generate a 1 in 4 chance that this minute right now a car arrives
			if(carArrived == true) {
				totalCarsWashed = totalCarsWashed + 1;
				Car newCar = new Car(currentTime);	//Create a new car object that arrived right now
				waitingLine.enqueue(newCar);
			}
			if(waitingLine.isEmpty() != true) {
				if(washingMachineOne.isEmpty() == true) {
					//System.out.println("Bay one is running");
					//Increase the total wait time
					Car thisCar = waitingLine.dequeue();
					int thisCarWaitTime = (thisCar.arrivalTime() - currentTime);
					totalWaitTime = totalWaitTime + thisCarWaitTime;

					//Increase the bay one wait time
					waitTimeBayOne += thisCarWaitTime;
					carsWashedBayOne++;

					//Start washing the car in bay one
					washingMachineOne.startWash();
				}
				else if(washingMachineTwo.isEmpty() == true) {
					//Keep washing the car in bay one
					washingMachineOne.keepWashing();
					//System.out.println("Bay two is running.");

					//Increase the total wait time
					Car thisCar = waitingLine.dequeue();
					int thisCarWaitTime = (thisCar.arrivalTime() - currentTime);
					totalWaitTime = totalWaitTime + thisCarWaitTime;

					//Increase the bay two wait time
					waitTimeBayTwo += thisCarWaitTime;
					carsWashedBayTwo++;

					//Start washing the car in bay two
					washingMachineTwo.startWash();
				}
				else {
					//System.out.println("Bay one and two are busy.");
					//Both bays are busy right now
					//Keep washing the cars in both bay one and bay two
					washingMachineOne.keepWashing();
					washingMachineTwo.keepWashing();
				}
			}

			currentTime = currentTime - 1;
		}
	}

	/**
	*	<code>printReport</code> will print out to the console a report of the car washes status and efficiency.
	*/
	public void printReport(String daysOfTheWeek) {
		if(hasTwoBays == true) {
			//Get the reports for todays day of business.
            //Get totals
            System.out.print("The total average wait time on "+daysOfTheWeek+" was ");
            System.out.print(getAverageWaitTime());
            System.out.print(" minutes.");
            System.out.println(" ");

            //Get bay one
            System.out.print("The wait time for bay one on "+daysOfTheWeek+" was ");
            System.out.print(getBayOneWaitTime());
            System.out.print(" minutes.");
            System.out.println(" ");

            //Get bay two
            System.out.print("The wait time for bay two on "+daysOfTheWeek+" was ");
            System.out.print(getBayTwoWaitTime());
            System.out.print(" minutes.");
            System.out.println(" ");
		}
		else {
			System.out.print("The total average wait time on "+daysOfTheWeek+" was ");
			System.out.print(getAverageWaitTime());
			System.out.print(" minutes.");
			System.out.println(" ");
		}
	}

	/**
	*	<code>getAverageWaitTime</code> will return the total average wait time
	*	@return int averageWaitTime Returns the total average wait time for all cars washed
	*/
	private int getAverageWaitTime() {
		int averageWaitTime = (totalWaitTime / totalCarsWashed);
		return averageWaitTime;
	}

	/**
	*	<code>getBayOneWaitTime</code> will return the average wait time for cars that were washed in bay one 
	*	@return int averageWaitTime Returns the average wait time for cars washed in bay one
	*/
	private int getBayOneWaitTime() {
		int averageWaitTime;
		if(hasTwoBays == true) {
			//The car wash is using two bays
			if(carsWashedBayOne != 0) {
				averageWaitTime = (waitTimeBayOne / carsWashedBayOne);
			}	
			else {
				averageWaitTime = -1;
			}
		}
		else {
			//There was only one bay being used by the car wash.
			averageWaitTime = this.getAverageWaitTime();
		}

		return averageWaitTime;
	}

	/**
	*	<code>getBayTwoWaitTime</code> will return the average wait time for cars that were washed in bay two 
	*	@return int averageWaitTime Returns -1 if the car wash only has one bay, otherwise returns the average wait time at bay two
	*/
	private int getBayTwoWaitTime() {
		int averageWaitTime;
		if(hasTwoBays == true) {
			//The car wash is using two bays
			if(carsWashedBayTwo != 0) {
				averageWaitTime = (waitTimeBayTwo / carsWashedBayTwo);
			}
			else {
				averageWaitTime = -1;
			}
		}
		else {
			System.out.println("This car wash only has one bay. Please call `getAverageWaitTime` to get the wait time.");
			averageWaitTime = -1;
		}

		return averageWaitTime;
	}

	/**
	*	<code>reset</code> will reset the simulation. This should be called after each time the simulation finishes
	*/
	public void reset() {
		//reset the total values
		totalWaitTime = 0;
		totalCarsWashed = 0;

		//Empty the queue
		while(!waitingLine.isEmpty()) {
			waitingLine.dequeue();
		}
	}
	
}