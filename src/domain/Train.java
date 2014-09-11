package domain;
import java.util.ArrayList;
import trainunit.*;
public class Train {

	private ArrayList <TrainUnit> trainSegments; //first object in ArrayList is the front of the train
	private int maxCarsPerLocomotive = 15;
	
	private void AddSegment(TrainUnit segment)
	{
		trainSegments.add(segment);
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
			correctNumberOfLocomotives(newTrain);
			
			return newTrain;
		}
		private static void correctNumberOfLocomotives(Train train) // Correct the number of locomotives that should be with this train
		{
			int numberOfLocomotivesNeeded = (train.trainSegments.size() + train.maxCarsPerLocomotive)/train.maxCarsPerLocomotive;
			int numberOfLocomotivesPresent = 0;
			for(TrainUnit t : train.trainSegments)
			{
				if(t.GetDescription() == "Locomotive")
					numberOfLocomotivesPresent++;
			}
			if(numberOfLocomotivesNeeded > numberOfLocomotivesPresent)
			{
				if(!inventory.getLocomotive(numberOfLocomotivesNeeded - numberOfLocomotivesPresent))
				{
					System.out.println("Could not create train, not enough Locomotives");
				}
			}
			else
			{
				inventory.putLocomotive(numberOfLocomotivesPresent - numberOfLocomotivesNeeded);
			}
		}
	}

	public void adjustNumberOfCars(int flatCars, int boxCars, int tankCars)
	{
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
