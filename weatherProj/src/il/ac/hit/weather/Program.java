package il.ac.hit.weather;

import java.io.InputStream;
import java.net.*;
import java.util.*;

import javax.json.JsonObject;

import il.ac.hit.weather.WeatherDataServiceFactory.*;

public class Program
{
	

	public static void main(String[] args)
	{	
		WeatherData weatherdata = new WeatherData();
		System.out.println("Please enter city name");
		Scanner console = new Scanner(System.in); 
		String city = console.next();
		Location location = new Location(city);
		WeatherDataServiceFactory factory = new WeatherDataServiceFactory();
		IWeatherDataService service = factory.getWeatherDataService(status.OPEN_WEATHER_MAP);
		try
		{
			weatherdata = service.getWeatherData(location);
			System.out.println(weatherdata);
		} 
		catch (WeatherDataServiceException e)
		{
			e.printStackTrace();
		}
	}

}
