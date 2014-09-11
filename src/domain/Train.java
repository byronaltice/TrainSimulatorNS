package domain;
import java.util.ArrayList;

import domain.trainunit.*;;

public class Train {

	private ArrayList <TrainUnit> trainSegments; //first object in ArrayList is the front of the train
	private int maxCarsPerLocomotive = 15;
	Train()
	{
		trainSegments = new ArrayList<TrainUnit>();
	}
	private void AddSegment(TrainUnit segment)
	{
		trainSegments.add(segment);
	}
	public ArrayList<TrainUnit> getSegments()
	{
		return new ArrayList<TrainUnit>(trainSegments); //make a copy so no one outside can modify the member variable
	}
	private void AddLocomotive(TrainUnit segment) // Add to front of train.
	{
		trainSegments.add(0, segment);
	}
	public static class TrainFactory
	{	
		//Factory class for Train, and Inventory manipulation logic encapsulated here. 
		//Considered using an intermediate class between inventory and Train like InventoryConnection in case the interface to the Inventory changes, 
		//such as via a db, but since this is just a simple program, just have Train hold a static inventory 
		private static Inventory inventory = Inventory.getInventory();
		private static ArrayList<Train> allTrains = new ArrayList<Train>();
		
		public static Inventory getInventory()
		{
			return inventory;
		}
		public static Train create(int flatCars, int boxCars, int tankCars) //FACTORY to create trains
		{
			if(!validateCars(flatCars, boxCars, tankCars))
			{
				return null;
			}
			if(!reserveCars(flatCars, boxCars, tankCars))
			{
				return null;
			}

			Train newTrain = new Train();
			newTrain.createCars(flatCars, boxCars, tankCars);
			if(!correctNumberOfLocomotives(newTrain))
				return null;
			
			allTrains.add(newTrain);
			return newTrain;
		}
		private static boolean correctNumberOfLocomotives(Train train) // Get the correct the number of locomotives that should be with this train
		{
			int numberOfLocomotivesPresent = 0;
			for(TrainUnit t : train.trainSegments)
			{
				if(t.GetDescription() == "Locomotive")
					numberOfLocomotivesPresent++;
			}
			int numberOfLocomotivesNeeded = (train.trainSegments.size() + train.maxCarsPerLocomotive - numberOfLocomotivesPresent)/train.maxCarsPerLocomotive;
			
			
			if(!inventory.getLocomotive(numberOfLocomotivesNeeded))
			{
				System.out.println("Could not create train, not enough Locomotives");
				return false;
			}
			for(int i = 0; i < numberOfLocomotivesNeeded; i++)
			{
				train.AddLocomotive(new Locomotive());
			}
			return true;
		}
	}

	private void createCars(int flatCars, int boxCars, int tankCars)
	{

		for(int i = 0; i < flatCars; i++)
		{
			AddSegment(new FlatCar());
		}
		for(int i = 0; i < boxCars; i++)
		{
			AddSegment(new BoxCar());
		}
		for(int i = 0; i < tankCars; i++)
		{
			AddSegment(new TankCar());
		}
	}
	private static boolean validateCars(int flatCars, int boxCars, int tankCars)
	{
		if(flatCars < 1 && boxCars < 1 && tankCars < 1)
		{
			System.out.println("All trains require at least one car. Try to create train again.");
			return false;
		}
		if(flatCars + boxCars + tankCars > 50)
		{
			System.out.println("Trains can't have more than 50 cars. Try to create train again.");
			return false;
		}
		return true;
	}
	private static boolean reserveCars(int flatCars, int boxCars, int tankCars)
	{

		if(!TrainFactory.getInventory().getFlatCar(flatCars))
		{
			System.out.println("Could not create train, not enough Flat Cars");
			return false;
		}
		if(!TrainFactory.getInventory().getBoxCar(boxCars))
		{
			System.out.println("Could not create train, not enough Box Cars");
			return false;
		}
		if(!TrainFactory.getInventory().getTankCar(tankCars))
		{
			System.out.println("Could not create train, not enough Tank Cars");
			return false;
		}
		return true;
	}
	public void adjustNumberOfCars(int flatCars, int boxCars, int tankCars)
	{
		// Add locomotives currently being used back to inventory
		int numberOfLocomotivesPresent = 0;
		int numberOfFlatCarsPresent = 0;
		int numberOfBoxCarsPresent = 0;
		int numberOfTankCarsPresent = 0;
		for(TrainUnit t : trainSegments)
		{
			if(t.GetDescription() == "Locomotive")
				numberOfLocomotivesPresent++;
			if(t.GetDescription() == "Flat Car")
				numberOfFlatCarsPresent++;
			if(t.GetDescription() == "Box Car")
				numberOfBoxCarsPresent++;
			if(t.GetDescription() == "Tank Car")
				numberOfTankCarsPresent++;
		}
		TrainFactory.getInventory().putLocomotive(numberOfLocomotivesPresent);
		
		
		// Add cars currently being used back to inventory
		TrainFactory.getInventory().putFlatCar(numberOfFlatCarsPresent);
		TrainFactory.getInventory().putBoxCar(numberOfBoxCarsPresent);
		TrainFactory.getInventory().putTankCar(numberOfTankCarsPresent);
		
		// Recreate the train
		trainSegments.clear();
		validateCars(flatCars, boxCars, tankCars);
		reserveCars(flatCars, boxCars, tankCars);
		createCars(flatCars, boxCars, tankCars);
		
		TrainFactory.correctNumberOfLocomotives(this);
		
	}
}
