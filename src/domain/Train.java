package domain;
import java.util.ArrayList;
import trainunit.*;
public class Train {

	private ArrayList <TrainUnit> trainSegments; //first object in ArrayList is the front of the train
	InventoryConnection inventoryConn;
	Train()
	{
		if(!inventoryConn.IsCarExists() || !inventoryConn.IsLocomotiveExists())
			return; //throw error? TODO
		//Requirements say a train must have one locomotive and one car, so create them here.
		trainSegments.add(inventoryConn.GetLocomotive());
		trainSegments.add(inventoryConn.GetFreeCar());
	}
}
