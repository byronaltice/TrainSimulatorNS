package domain;


public class Customer {

	private Train train; //Each customer has 1 train
	private String customerName; //
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
		return train;
	}
}
