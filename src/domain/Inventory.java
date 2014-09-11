package domain;
public class Inventory{

	private int boxCars = 0;
	private int flatCars = 0;
	private int locomotives = 0;
	private int tankCars = 0;
	private static Inventory inventory;
	public static void populateTrainUnits(int numberOfLocomotives, int numberOfBoxCars, int numberOfFlatCars, int NumberOfTankCars)
	{
		while(numberOfLocomotives > 0)
		{
			getInventory().locomotives++;
			numberOfLocomotives--;
		}
		while(numberOfBoxCars > 0)
		{
			getInventory().boxCars++;
			numberOfBoxCars--;
		}
		while(numberOfFlatCars > 0)
		{
			getInventory().flatCars++;
			numberOfFlatCars--;
		}
		while(NumberOfTankCars > 0)
		{
			getInventory().tankCars++;
			NumberOfTankCars--;
		}
	}

	public static Inventory getInventory()
	{
		if(inventory == null) 
		{
			inventory = new Inventory();
			inventory.InitializeInventory();
		}
		return inventory;
	}
	public void InitializeInventory()
	{
		//Would normally pull info from db or external source... but since we don't have one, just initialize manually
		populateTrainUnits(3, 10, 15, 5);
	}
	
	public boolean getLocomotive(int number)
	{
		if(getInventory().locomotives >= number)
		{
			while(number > 0)
			{
				getInventory().locomotives--;
				number--;
			}
			return true;
		}
		else
			return false;
	}
	public int getLocomotives()
	{
		return getInventory().locomotives;
	}
	public int getFlatCars()
	{
		return getInventory().flatCars;
	}
	public int getBoxCars()
	{
		return getInventory().boxCars;
	}
	public int getTankCars()
	{
		return getInventory().tankCars;
	}
	public void putLocomotive(int number)
	{
		while(number > 0)
		{
			getInventory().locomotives++;
			number--;
		}
	}
	public void putFlatCar(int number)
	{
		while(number > 0)
		{
			getInventory().flatCars++;
			number--;
		}
	}
	public void putBoxCar(int number)
	{
		while(number > 0)
		{
			getInventory().boxCars++;
			number--;
		}
	}
	public void putTankCar(int number)
	{
		while(number > 0)
		{
			getInventory().tankCars++;
			number--;
		}
	}
	public boolean getBoxCar(int number)
	{
		if(getInventory().boxCars >= number)
		{
			while(number > 0)
			{
				getInventory().boxCars--;
				number--;
			}
			return true;
		}
		else
			return false;
	}
	public boolean getFlatCar(int number)
	{
		if(getInventory().flatCars >= number)
		{
			while(number > 0)
			{
				getInventory().flatCars--;
				number--;
			}
			return true;
		}
		else
			return false;
	}
	public boolean getTankCar(int number)
	{
		if(getInventory().tankCars >= number)
		{
			while(number > 0)
			{
				getInventory().tankCars--;
				number--;
			}
			return true;
		}
		else
			return false;
	}
}
