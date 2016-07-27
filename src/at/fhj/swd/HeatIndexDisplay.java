package at.fhj.swd;

public class HeatIndexDisplay implements Observer, DisplayElement {

	private float temperature;
	private float humidity;
	private float pressure;
	private Subject weatherData;

	public HeatIndexDisplay(Subject weatherData) {
		this.weatherData = weatherData;
		weatherData.registerObserver(this);
	}

	@Override
	public void update(float temperature, float humidity, float pressure) {
		this.temperature = temperature;
		this.humidity = humidity;
		this.pressure = pressure;
		display();
	}

	@Override
	public void display() {
		System.out.format("Heat index is %.4f\n", calculateHeatIndex());
	}

	private double calculateHeatIndex() {
		// Setting parameters for Function
		final double C1 = -42.379;
		final double C2 = 2.04901523;
		final double C3 = 10.14333127;
		final double C4 = -0.22475541;
		final double C5 = -.00683783;
		final double C6 = -5.481717E-2;
		final double C7 = 1.22874E-3;
		final double C8 = 8.5282E-4;
		final double C9 = -1.99E-6;
		float T = temperature;
		double R = humidity;
		double T2 = temperature * temperature;
		double R2 = humidity * humidity;

		// Function of Calculating Heat Index
		float answer = (float) (C1 + (C2 * T) + (C3 * R) + (C4 * T * R) + (C5 * T2) + (C6 * R2) + (C7 * T2 * R)
				+ (C8 * T * R2) + (C9 * T2 * R2));

		return answer;
	}

}
