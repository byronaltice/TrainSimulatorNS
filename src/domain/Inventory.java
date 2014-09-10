package domain;
import java.util.ArrayList;

import trainunit.*;
public class Inventory {

	private ArrayList<BoxCar> boxCars;
	private ArrayList<FlatCar> flatCars;
	private ArrayList<Locomotive> locomotives;
	private ArrayList<TankCar> tankCars;
	private static Inventory inventory;
	public static Inventory getInventory()
	{
		return inventory;
	}
	Inventory(int numberOfLocomotives, int numberOfBoxCars, int numberOfFlatCars, int NumberOfTankCars)
	{
		while(numberOfLocomotives > 0)
		{
			inventory.locomotives.add(new Locomotive());
			numberOfLocomotives--;
		}
		while(numberOfBoxCars > 0)
		{
			inventory.boxCars.add(new BoxCar());
			numberOfBoxCars--;
		}
		while(numberOfFlatCars > 0)
		{
			inventory.flatCars.add(new FlatCar());
			numberOfFlatCars--;
		}
		while(NumberOfTankCars > 0)
		{
			inventory.tankCars.add(new TankCar());
			NumberOfTankCars--;
		}
	}
	
	public boolean isLocomotiveExists()
	{
		return inventory.locomotives.size() > 0; //TODO add method to Inventory
	}
	public boolean isCarExists()
	{
		return inventory.boxCars.contains(new BoxCar()) || flatCars.contains(new FlatCar()) || tankCars.contains(new TankCar());
	}
	public boolean getLocomotive(int number)
	{
		if(inventory.locomotives.size() >= number)
		{
			while(number > 0)
			{
				inventory.locomotives.remove(0);
				number--;
			}
			return true;
		}
		else
			return false;
	}
	/*public TrainUnit GetFreeCar() //Get a free car of any type from the inventory if it exists TODO make user initialize a specific type?
	{
		return new TrainUnit();
	}*/
	public boolean getBoxCar(int number)
	{
		if(inventory.boxCars.size() >= number)
		{
			while(number > 0)
			{
				inventory.boxCars.remove(0);
				number--;
			}
			return true;
		}
		else
			return false;
	}
	public boolean getFlatCar(int number)
	{
		if(inventory.flatCars.size() >= number)
		{
			while(number > 0)
			{
				inventory.flatCars.remove(0);
				number--;
			}
			return true;
		}
		else
			return false;
	}
	public boolean getTankCar(int number)
	{
		if(inventory.tankCars.size() >= number)
		{
			while(number > 0)
			{
				inventory.tankCars.remove(0);
				number--;
			}
			return true;
		}
		else
			return false;
	}
}
