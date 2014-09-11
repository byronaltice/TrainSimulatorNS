package control;
import ui.TrainPrinter;
import domain.Customer;
import domain.Train;

public class TrainSimulator {

	public static void main(String[] args) {
		
		TrainPrinter printer = new TrainPrinter();
		
		printer.printInventory(Train.TrainFactory.getInventory());
		Customer thomasFastFreight = new Customer("Thomas Fast Freight");
		printer.printGreeting(thomasFastFreight);
		thomasFastFreight.CreateTrain(9, 8, 2);
		
		if(thomasFastFreight.GetTrain() == null)
			printer.printFailToMakeTrain(thomasFastFreight);
		else
			printer.printMakeTrainSuccess(thomasFastFreight);
		printer.printInventory(Train.TrainFactory.getInventory());
		thomasFastFreight.GetTrain().adjustNumberOfCars(9,  0, 2);
		
		if(thomasFastFreight.GetTrain() == null)
			printer.printFailToMakeTrain(thomasFastFreight);
		else
			printer.printMakeTrainSuccess(thomasFastFreight);
		printer.printInventory(Train.TrainFactory.getInventory());
		
		Customer henryBlueFreight = new Customer("Henry Blue Freight");
		printer.printGreeting(henryBlueFreight);
		henryBlueFreight.CreateTrain(10, 0, 0);
		

		if(henryBlueFreight.GetTrain() == null)
			printer.printFailToMakeTrain(henryBlueFreight);
		else
			printer.printMakeTrainSuccess(henryBlueFreight);
		printer.printInventory(Train.TrainFactory.getInventory());
		

		
	}

	
}
