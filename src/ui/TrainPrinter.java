package ui;
import domain.Customer;
import domain.trainunit.TrainUnit;
import domain.Inventory;
public class TrainPrinter {

	String trainSegmentBuffer;
	public void printGreeting(Customer c)
	{
		System.out.println("Welcome to Norfolk Southern Train Simulator, " + c.GetName());
		System.out.println("\n\n");
	}
	public void printFailToMakeTrain(Customer c)
	{
		System.out.println("Sorry " + c.GetName() + ", we were unable to make your train.");
		System.out.println("\n\n");
	}
	public void printMakeTrainSuccess(Customer c)
	{
		System.out.println(c.GetName() + ", we created a train for you.");
		System.out.println("Your Train:");
		printTrain(c);
		System.out.println("\n\n");
	}
	private void printTrain(Customer c)
	{
		String buffer1 = "/";
		String buffer2 = "";
		String buffer3 = "\\";
		System.out.println("Front--->");
		
		for(TrainUnit t : c.GetTrain().getSegments())
		{
			if(buffer1.length() > 70)
			{
				System.out.println(buffer1);
				System.out.println(buffer2);
				System.out.println(buffer3);
				buffer1 = "";
				buffer2 = "";
				buffer3 = "";
			}
			buffer1 += "--------------  ";
			buffer2 += createTrainSegment(t);
			buffer3 += "--------------  ";
			
		}
		System.out.println(buffer1);
		System.out.println(buffer2);
		System.out.println(buffer3);
		System.out.println("--->Back");
		
		System.out.println("\n\n");
	}
	private String createTrainSegment(TrainUnit t)
	{
		String buffer = "";
		buffer += "| " + t.GetDescription();
		while(buffer.length() < 14)
		{
			buffer += " ";
		}
		buffer += "| ";
		return buffer;
	}
	public void printInventory(Inventory inv)
	{
		System.out.println("Current Inventory:");
		System.out.println("Locomotives: " + inv.getLocomotives());
		System.out.println("Flat Cars: " + inv.getFlatCars());
		System.out.println("Box Cars: " + inv.getBoxCars());
		System.out.println("Tank Cars: " + inv.getTankCars());
		System.out.println("\n\n");
	}
	
}
