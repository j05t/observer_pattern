package at.fhj.swd;

public class WeatherStation {

	public static void main(String[] args) {
		WeatherData weatherData = new WeatherData();
		CurrentConditionsDisplay currentDisplay = new CurrentConditionsDisplay(weatherData);

		// not implemented right now
		// StatisticsDisplay statisticsDisplay = new StatisticsDisplay(weatherData);
		// ForeCastDisplay forecastDisplay = new ForecastDisplay(weatherData);

		
		// simulate new weather measurements
		weatherData.setMeasurements(80, 65, 30.4f);
		weatherData.setMeasurements(82, 70, 29.2f);
		weatherData.setMeasurements(78, 90, 29.2f);
	}

}
