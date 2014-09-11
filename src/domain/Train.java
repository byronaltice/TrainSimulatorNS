package domain;
import java.util.ArrayList;

import domain.trainunit.*;;

public class Train {

	private ArrayList <TrainUnit> trainSegments; //first object in ArrayList is the front of the train
	private int maxCarsPerLocomotive = 15;
	
	private void AddSegment(TrainUnit segment)
	{
		trainSegments.add(segment);
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
		public static Train create(int flatCars, int boxCars, int tankCars) //FACTORY to create trains
		{
			if(flatCars < 1 && boxCars < 1 && tankCars < 1)
			{
				System.out.println("All trains require at least one car. Try to create train again.");
				return null;
			}
			if(!inventory.getFlatCar(flatCars))
			{
				System.out.println("Could not create train, not enough Flat Cars");
				return null;
			}
			if(!inventory.getBoxCar(boxCars))
			{
				System.out.println("Could not create train, not enough Box Cars");
				return null;
			}
			if(!inventory.getTankCar(tankCars))
			{
				System.out.println("Could not create train, not enough Tank Cars");
				return null;
			}
				
			Train newTrain = new Train();
			for(int i = 0; i < flatCars; i++)
			{
				newTrain.AddSegment(new FlatCar());
			}
			for(int i = 0; i < boxCars; i++)
			{
				newTrain.AddSegment(new BoxCar());
			}
			for(int i = 0; i < tankCars; i++)
			{
				newTrain.AddSegment(new TankCar());
			}
			if(!correctNumberOfLocomotives(newTrain))
				return null;
			
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

	public void adjustNumberOfCars(int flatCars, int boxCars, int tankCars)
	{
		// Add locomotives currently being used back to inventory
		int numberOfLocomotivesPresent = 0;
		for(TrainUnit t : trainSegments)
		{
			if(t.GetDescription() == "Locomotive")
				numberOfLocomotivesPresent++;
		}
		TrainFactory.inventory.putLocomotive(numberOfLocomotivesPresent);
		
		// Add cars currently being used back to inventory
		TrainFactory.inventory.putFlatCar(flatCars);
		TrainFactory.inventory.putBoxCar(boxCars);
		TrainFactory.inventory.putTankCar(tankCars);
		
		// Recreate the train
		trainSegments.clear();
		
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
		TrainFactory.correctNumberOfLocomotives(this);
		
	}
}
