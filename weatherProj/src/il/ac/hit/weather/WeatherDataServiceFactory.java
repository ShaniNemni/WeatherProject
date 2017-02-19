package il.ac.hit.weather;

public class WeatherDataServiceFactory
{
	//private static final WeatherDataServiceFactory OPEN_WEATHER_MAP = null;
	public static enum status {OPEN_WEATHER_MAP;}
	//private IWeatherDataService service = WeatherDataServiceFactory.getWeatherDataService(e.OPEN_WEATHER_MAP);
			
	public static IWeatherDataService getWeatherDataService(status ekaki)
	{
		switch(ekaki)
		{
		case OPEN_WEATHER_MAP:
		return OpenWeatherMap.creatOpenWeatherMap();

		default:
		return null;
		}
	}
}
