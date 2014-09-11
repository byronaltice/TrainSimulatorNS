package control;
import ui.TrainPrinter;
import domain.Customer;

public class TrainSimulator {

	public static void main(String[] args) {
		
		TrainPrinter printer = new TrainPrinter();
		printer.printGreeting();
		
		Customer thomasFastFreight = new Customer("Thomas Fast Freight");
		thomasFastFreight.CreateTrain(9, 8, 2);
		
		if(thomasFastFreight.GetTrain() == null)
			printer.printFailToMakeTrain(thomasFastFreight);

	}

	
}
