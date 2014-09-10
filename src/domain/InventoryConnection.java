package domain;
import trainunit.TrainUnit;

public class InventoryConnection {

	private Inventory inventory; //Inventory storage for Train Units, cars, locomotives etc
	public boolean isLocomotiveExists()
	{
		return true; //TODO add method to Inventory
	}
	public boolean isCarExists()
	{
		return true; //TODO add method to Inventory
	}
	public TrainUnit GetLocomotive()
	{
		return new TrainUnit(); //TODO get it from Inventory;
	}
	public TrainUnit GetFreeCar() //Get a free car of any type from the inventory if it exists
	{
		return new TrainUnit();
	}
}
