package domain;


public class Customer {

	private Train customerTrain; //Each customer has 1 train
	private String customerName;
	private Customer() //Force to create with a name.
	{
		
	}
	public Customer(String name)
	{
		customerName = name;
	}
	public String GetName()
	{
		return customerName;
	}
	public void SetName(String customerName)
	{
		this.customerName = customerName;
	}
	public Train GetTrain()
	{
		if(customerTrain == null)
		{
			System.out.println("You need to create a train for this customer first");
		}
		return customerTrain;
	}
	public void CreateTrain(int flatCars, int boxCars, int tankCars)
	{
		customerTrain = Train.TrainFactory.create(flatCars, boxCars, tankCars);
	}
	
}
