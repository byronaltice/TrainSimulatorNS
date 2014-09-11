package ui;
import domain.Customer;
public class TrainPrinter {

	public void printGreeting()
	{
		System.out.println("Welcome to Norfolk Southern Train Simulator");
	}
	public void printFailToMakeTrain(Customer c)
	{
		System.out.println("Sorry " + c.GetName() + ", we were unable to make your train.");
	}
	public void 
}
