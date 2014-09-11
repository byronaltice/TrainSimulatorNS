package domain.trainunit;
//Unit/Segment of a train, like a car or locomotive
public class TrainUnit {

	private String description;
	
	TrainUnit()
	{
		
	}
	public String GetDescription()
	{
		return description; //Initialize during the appropriate object's constructor
	}
	protected void SetDescription(String description)
	{
		this.description = description;
	}
	
}
