package domain;
import java.util.ArrayList;

import trainunit.*;
public class Inventory {

	private ArrayList<BoxCar> boxCars;
	private ArrayList<FlatCar> flatCars;
	private ArrayList<Locomotive> locomotives;
	private ArrayList<TankCar> tankCars;
	
	Inventory(int numberOfLocomotives, int numberOfBoxCars, int numberOfFlatCars, int NumberOfTankCars)
	{
		while(numberOfLocomotives > 0)
		{
			locomotives.add(new Locomotive());
			numberOfLocomotives--;
		}
		while(numberOfBoxCars > 0)
		{
			boxCars.add(new BoxCar());
			numberOfBoxCars--;
		}
		while(numberOfFlatCars > 0)
		{
			flatCars.add(new FlatCar());
			numberOfFlatCars--;
		}
		while(NumberOfTankCars > 0)
		{
			tankCars.add(new TankCar());
			NumberOfTankCars--;
		}
	}
	
	public boolean isLocomotiveExists()
	{
		return locomotives.size() > 0; //TODO add method to Inventory
	}
	public boolean isCarExists()
	{
		return boxCars.contains(new BoxCar()) || flatCars.contains(new FlatCar()) || tankCars.contains(new TankCar());
	}
	public boolean GetLocomotive(int number)
	{
		if(locomotives.size() >= number)
		{
			while(number > 0)
			{
				locomotives.remove(0);
				number--;
			}
			return true;
		}
		else
			return false;
	}
	public TrainUnit GetFreeCar() //Get a free car of any type from the inventory if it exists TODO make user initialize a specific type?
	{
		return new TrainUnit();
	}
	public boolean GetBoxCar(int number)
	{
		if(boxCars.size() >= number)
		{
			while(number > 0)
			{
				boxCars.remove(0);
				number--;
			}
			return true;
		}
		else
			return false;
	}
	public boolean GetFlatCar(int number)
	{
		if(flatCars.size() >= number)
		{
			while(number > 0)
			{
				flatCars.remove(0);
				number--;
			}
			return true;
		}
		else
			return false;
	}
	public boolean GetTankCar(int number)
	{
		if(tankCars.size() >= number)
		{
			while(number > 0)
			{
				tankCars.remove(0);
				number--;
			}
			return true;
		}
		else
			return false;
	}
}
