package il.ac.hit.weather;

import java.io.IOException;
import java.io.InputStream;
import java.net.*;

import javax.json.*;
/**
 * 
 * @author Shani Nemni,Shir Dagan,Sapir Levy
 * 
 */
public class OpenWeatherMap implements IWeatherDataService
{
	private URL url;
	private InputStream in;
	private static OpenWeatherMap openweathermap;
	private OpenWeatherMap(){}
	
	public static OpenWeatherMap creatOpenWeatherMap()
	{
		if(openweathermap == null)
		{
			openweathermap = new OpenWeatherMap();
		}
		return openweathermap;
	}
	
	@Override
	public WeatherData getWeatherData(Location location) throws WeatherDataServiceException
	{
		WeatherData weatherdata = new WeatherData();	
		try
		{ 
			if(location.getCity() == null)
			{
				url = new URL("http://api.openweathermap.org/data/2.5/weather?id="+location.getId()+"&appid=a1aedf2bc31386a8a91429246bc93ff6");
			}
			else
			{
			url = new URL("http://api.openweathermap.org/data/2.5/weather?q="+location.getCity()+"&appid=a1aedf2bc31386a8a91429246bc93ff6");
			}
			
			in = url.openStream();
			JsonReader rdr = Json.createReader(in);
			JsonObject object = rdr.readObject();
			JsonObject main = object.getJsonObject("main");//take from main
			weatherdata.setCity(object.getString("name"));
			weatherdata.setHumidity(Double.parseDouble("" + main.getJsonNumber("humidity")));
			weatherdata.setTemp(Double.parseDouble("" +main.getJsonNumber("temp")));
			weatherdata.setPressure(main.getInt("pressure"));
			weatherdata.setTempMin(Double.parseDouble("" + main.getJsonNumber("temp_min")));
			weatherdata.setTempMax(Double.parseDouble("" + main.getJsonNumber("temp_max")));
			JsonObject weather = object.getJsonArray("weather").getJsonObject(0); //take from arrayWeather
			weatherdata.setMain(weather.getString("main"));
			weatherdata.setDescription(weather.getString("description"));
			JsonObject system = object.getJsonObject("sys"); //take from system
			weatherdata.setCountry(system.getString("country"));
			JsonObject wind =object.getJsonObject("wind");
			weatherdata.setSpeedWind(Double.parseDouble("" + wind.getJsonNumber("speed")));
		}
		catch (IOException e) 
		{
			throw new WeatherDataServiceException("There is a problem",e);
		} 
		finally
		{
			return weatherdata;
		}
	}

}
