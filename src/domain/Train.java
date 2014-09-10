package domain;
import java.util.ArrayList;
import trainunit.*;
public class Train {

	private ArrayList <TrainUnit> trainSegments; //first object in ArrayList is the front of the train
	private Train()
	{
		if(!inventory.isCarExists() || !inventory.isLocomotiveExists())
			return; //throw error? TODO
		//Requirements say a train must have one locomotive and one car, so create them here.
		trainSegments.add(inventory.GetLocomotive());
		trainSegments.add(inventory.GetFreeCar());
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
			}
			if(!inventory.getBoxCar(boxCars))
			{
				System.out.println("Could not create train, not enough Box Cars");
			}
			if(!inventory.getTankCar(tankCars))
			{
				System.out.println("Could not create train, not enough Tank Cars");
			}
				
			return new Train();
		}
	}
}
