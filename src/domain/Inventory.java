package domain;
public class Inventory{

	// Original keeps track of what we started with
	// Assigned keeps track of what we have assigned to trains
	// the base keeps track of what is in inventory
	
	private int boxCars = 0;
	private int boxCarsAssigned = 0;
	private int boxCarsOriginal = 0;
	
	private int flatCars = 0;
	private int flatCarsAssigned = 0;
	private int flatCarsOriginal = 0;
	
	private int locomotives = 0;
	private int locomotivesAssigned = 0;
	private int locomotivesOriginal = 0;
	
	private int tankCars = 0;
	private int tankCarsAssigned = 0;
	private int tankCarsOriginal = 0;
	
	private static Inventory inventory;
	public static void populateTrainUnits(int numberOfLocomotives, int numberOfBoxCars, int numberOfFlatCars, int numberOfTankCars)
	{
		getInventory().locomotivesOriginal = numberOfLocomotives;
		while(numberOfLocomotives > 0)
		{
			getInventory().locomotives++;
			numberOfLocomotives--;
		}
		getInventory().boxCarsOriginal = numberOfBoxCars;
		while(numberOfBoxCars > 0)
		{
			getInventory().boxCars++;
			numberOfBoxCars--;
		}
		getInventory().flatCarsOriginal = numberOfFlatCars;
		while(numberOfFlatCars > 0)
		{
			getInventory().flatCars++;
			numberOfFlatCars--;
		}
		getInventory().tankCarsOriginal = numberOfTankCars;
		while(numberOfTankCars > 0)
		{
			getInventory().tankCars++;
			numberOfTankCars--;
		}
	}
	public boolean VerifyInventory()
	{
		//The total set of cars and locomotives in your system/application should of course remain the same.
		if(boxCars + boxCarsAssigned == boxCarsOriginal &&
				flatCars + flatCarsAssigned == flatCarsOriginal &&
				locomotives + locomotivesAssigned == locomotivesOriginal &&
				tankCars + tankCarsAssigned == tankCarsOriginal)
			return true;
		
		return false;
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
