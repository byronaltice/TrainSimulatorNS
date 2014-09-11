package domain;
import java.util.ArrayList;

import trainunit.*;
public class Inventory {

	private int boxCars = 0;
	private int flatCars = 0;
	private int locomotives = 0;
	private int tankCars = 0;
	private static Inventory inventory;
	public static Inventory getInventory()
	{
		return inventory;
	}
	Inventory(int numberOfLocomotives, int numberOfBoxCars, int numberOfFlatCars, int NumberOfTankCars)
	{
		while(numberOfLocomotives > 0)
		{
			inventory.locomotives++;
			numberOfLocomotives--;
		}
		while(numberOfBoxCars > 0)
		{
			inventory.boxCars++;
			numberOfBoxCars--;
		}
		while(numberOfFlatCars > 0)
		{
			inventory.flatCars++;
			numberOfFlatCars--;
		}
		while(NumberOfTankCars > 0)
		{
			inventory.tankCars++;
			NumberOfTankCars--;
		}
	}
	
	public boolean isLocomotiveExists()
	{
		return inventory.locomotives > 0; 
	}
	public boolean getLocomotive(int number)
	{
		if(inventory.locomotives >= number)
		{
			while(number > 0)
			{
				inventory.locomotives--;
				number--;
			}
			return true;
		}
		else
			return false;
	}
	public void putLocomotive(int number)
	{
		while(number > 0)
		{
			inventory.locomotives++;
			number--;
		}
	}
	public boolean getBoxCar(int number)
	{
		if(inventory.boxCars >= number)
		{
			while(number > 0)
			{
				inventory.boxCars--;
				number--;
			}
			return true;
		}
		else
			return false;
	}
	public boolean getFlatCar(int number)
	{
		if(inventory.flatCars >= number)
		{
			while(number > 0)
			{
				inventory.flatCars--;
				number--;
			}
			return true;
		}
		else
			return false;
	}
	public boolean getTankCar(int number)
	{
		if(inventory.tankCars >= number)
		{
			while(number > 0)
			{
				inventory.tankCars--;
				number--;
			}
			return true;
		}
		else
			return false;
	}
}
