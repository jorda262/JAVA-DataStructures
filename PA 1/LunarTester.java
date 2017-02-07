package century.edu.pa1;

public class LunarTester 
{
	public static void printSpecs(LunarLander test)
	{
		System.out.println("Lunar Lander Specs:");
		System.out.println("\tCurrent Fuel Flow Rate: " + test.getFuelFlowRate() + " (kg/s)");
		System.out.println("\tVertical Speed: " + test.getVerticalSpeed() + " (m/s)");
		System.out.println("\tAltitude: " + test.getAltitude() + " (m)");
		System.out.println("\tAmount of Fuel: " + test.getAmountFuel() + " (kg)");
		System.out.println("\tMass of Lander without fuel: " + test.getMass() + " (kg)");
		System.out.println("\tMaximum Fuel Consumption Rate: " + test.getMaxFuelConsumption() + " (kg/s)");
		System.out.println("\tMaximum Thrust of Lander's engine: " + test.getMaxThrust() + " (N)");
		System.out.println("***********************************************************************\n");
		System.out.printf("%-25s%-25s%-25s%-25s", "Speed (m/s)", "CurrentffRate", "AmountFuel (kg)","Altitude (m)");
	}
	
	public static void main(String[]args)
	{
		double time = 0.0;
		LunarLander apollo13 = new LunarLander();
		
		printSpecs(apollo13);
		
		while(apollo13.getAltitude()>0 && apollo13.getAmountFuel()>0)
		{
			if (time > 0)
			{
				apollo13.setFuelFlowRate(.02);
			}
			
			apollo13.testing(time);
			time += .1;
		}
	}
}
