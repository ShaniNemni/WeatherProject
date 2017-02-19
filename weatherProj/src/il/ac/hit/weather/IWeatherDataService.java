package il.ac.hit.weather;

public interface IWeatherDataService
{
	public WeatherData getWeatherData(Location location) throws WeatherDataServiceException;
}
