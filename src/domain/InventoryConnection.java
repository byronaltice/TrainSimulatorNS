package domain;
import trainunit.*;

public class InventoryConnection { //TODO should this be an interface instead?

	private Inventory inventory; //Inventory storage for Train Units, cars, locomotives etc
	public boolean isLocomotiveExists()
	{
		return true; //TODO add method to Inventory
	}
	public boolean isCarExists()
	{
		return inventory.isCarExists(); //TODO add method to Inventory
	}
	public boolean getLocomotive(int number)
	{
		boolean success = inventory.GetLocomotive(number);
		printUnitsRemoved(success, new Locomotive().GetDescription(), number);
		return success;
	}
	/*public TrainUnit GetFreeCar() //Get a free car of any type from the inventory if it exists TODO make user initialize a specific type?
	{
		return new TrainUnit();
	}*/
	public boolean getBoxCar(int number)
	{
		boolean success = inventory.GetBoxCar(number);
		printUnitsRemoved(success, new BoxCar().GetDescription(), number);
		return success;
	}
	public boolean getFlatCar(int number)
	{
		boolean success = inventory.GetFlatCar(number);
		printUnitsRemoved(success, new FlatCar().GetDescription(), number);
		return success;
	}
	public boolean getTankCar(int number)
	{

		boolean success = inventory.GetTankCar(number);
		printUnitsRemoved(success, new TankCar().GetDescription(), number);
		return success;
	}
	private void printUnitsRemoved(boolean success, String type, int number)
	{
		if(success)
		{
			System.out.println("Removed " + number + " " + type + "s from the inventory"); //possible make an output class to handle this
		}
		else
		{
			System.out.println(number + " " + type + "s aren't available.");
		}
	}
}
