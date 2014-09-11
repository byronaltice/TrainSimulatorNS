package control;
import ui.TrainPrinter;
import domain.Customer;
import domain.Train;

public class TrainSimulator {

	public static void main(String[] args) {
		
		TrainPrinter printer = new TrainPrinter();
		
		printer.printInventoryErrorIfInvalid(Train.TrainFactory.getInventory());
		printer.printInventory(Train.TrainFactory.getInventory());
		
		Customer thomasFastFreight = new Customer("Thomas Fast Freight");
		printer.printGreeting(thomasFastFreight);
		
		//Asign the first customer's cars
		thomasFastFreight.CreateTrain(9, 8, 2);
		
		if(thomasFastFreight.GetTrain() == null)
			printer.printFailToMakeTrain(thomasFastFreight);
		else
			printer.printMakeTrainSuccess(thomasFastFreight);

		printer.printInventoryErrorIfInvalid(Train.TrainFactory.getInventory());
		printer.printInventory(Train.TrainFactory.getInventory());
		
		//Adjust the first customer's cars
		thomasFastFreight.GetTrain().adjustNumberOfCars(9,  0, 2);
		
		if(thomasFastFreight.GetTrain() == null)
			printer.printFailToMakeTrain(thomasFastFreight);
		else
			printer.printMakeTrainSuccess(thomasFastFreight);
		
		printer.printInventoryErrorIfInvalid(Train.TrainFactory.getInventory());
		printer.printInventory(Train.TrainFactory.getInventory());
		
		Customer henryBlueFreight = new Customer("Henry Blue Freight");
		printer.printGreeting(henryBlueFreight);
		
		//Assign the second customer's cars
		henryBlueFreight.CreateTrain(10, 0, 0);
		
		if(henryBlueFreight.GetTrain() == null) //NOTE: This will currently throw an error since there aren't enough cars for second customer.
			printer.printFailToMakeTrain(henryBlueFreight);
		else
			printer.printMakeTrainSuccess(henryBlueFreight);
		
		printer.printInventoryErrorIfInvalid(Train.TrainFactory.getInventory());
		printer.printInventory(Train.TrainFactory.getInventory());
		
	}
}
