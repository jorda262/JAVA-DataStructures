package century.edu.pa1;

public class LunarLander 
{
	public final double MAX_FUEL_CONSUMPTION = 50.0;
	public final double MAX_THRUST = 2150.0;
	public final double MASS_OF_LANDER = 2150.0;
	
	private double fuelFlowRate;
	private double verticalSpeed;
	private double altitude;
	private double amountFuel;
	private double mass;
	private double maxFuelConsumption;
	private double maxThrust;
	private double time;

	//No-Argument Constructor
	public LunarLander()
	{
		fuelFlowRate = 0.0;
		verticalSpeed = 0.0;
		altitude = 150.0;
		amountFuel = 10.0;
		mass = MASS_OF_LANDER;
		maxFuelConsumption = MAX_FUEL_CONSUMPTION;
		maxThrust = MAX_THRUST;	
		time = 0;
	}
	public LunarLander(double altitude, double amountFuel, double mass,
		double maxFuelConsumption, double maxThrust)
	{
		fuelFlowRate = 0.0;
		verticalSpeed = 0.0;
		this.altitude = altitude;
		this.amountFuel = amountFuel;
		this.mass = mass;
		this.maxFuelConsumption = maxFuelConsumption;
		this.maxThrust = maxThrust;	
		time = 0;
	}

//getters
public double getFuelFlowRate()
{
	return fuelFlowRate;
}
public double getVerticalSpeed()
{
	return verticalSpeed;
}
public double getAltitude()
{
	return altitude;
}
public double getAmountFuel()
{
	return amountFuel;
}
public double getMass()
{
	return mass;
}
public double getMaxFuelConsumption()
{
	return maxFuelConsumption;
}
public double getMaxThrust()
{
	return maxThrust;
}
//setters
public void setFuelFlowRate(double fuelFlowRate)
{
	this.fuelFlowRate = fuelFlowRate;
}
public void setVerticalSpeed(double verticalSpeed)
{
	this.verticalSpeed = verticalSpeed;
}
public void setAltitude(double altitude)
{
	this.altitude = altitude;
}
public void setAmountFuel(double amountFuel)
{
	this.amountFuel = amountFuel;
}
public void setMass(double mass)
{
	this.mass = mass;
}
public void setMaxFuelConsumption(double maxFuelConsumption)
{
	this.maxFuelConsumption = maxFuelConsumption;
}
public void setMaxThrust(double maxThrust)
{
	this.maxThrust = maxThrust;
}
//method using time to update equations
public void testing(double time)
{
	
	double deltaT = (time - this.time);
	double f = (getFuelFlowRate()* maxThrust);
	double totalMass = (getAmountFuel() + getMass());
	double deltaV = ( deltaT* ((f/totalMass)-1.62));
	double deltaY = (deltaT * verticalSpeed);
	double deltaF = (deltaT * getFuelFlowRate() * getMaxFuelConsumption());
	this.time = time;
	velocity(f,deltaV);	
	altitude(deltaY);
	fuel(deltaF);
	
	if (amountFuel <= 0)
	{
		setFuelFlowRate(0);
		setVerticalSpeed(0);
		setAmountFuel(0);
	}	
	
	if (altitude <= 0)
	{
		setVerticalSpeed(0);
		setFuelFlowRate(0);
		setAltitude(0);
	}
	
	System.out.printf("%n%-25.3f%-25.2f%-25.1f%-25.3f", getVerticalSpeed(), getFuelFlowRate(),getAmountFuel(), (getAltitude()));
}
	public void velocity(double f, double deltaV)
	{
		double initialVelocity = getVerticalSpeed();
		setVerticalSpeed((initialVelocity - deltaV));	
	}

	public void altitude(double deltaY)
	{
		double initialAltitude = getAltitude();
		setAltitude(initialAltitude - deltaY);
	}
	
	public void fuel(double deltaF)
	{
		double initialFuel = getAmountFuel();
		setAmountFuel(initialFuel - deltaF);
	}

}