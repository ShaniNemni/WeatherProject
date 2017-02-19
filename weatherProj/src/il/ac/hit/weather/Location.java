package il.ac.hit.weather;
/*
 * 
 */
public class Location
{	
	private String city;
	private int id;
	
	public Location(String city)
	{
		this.setCity(city);
	}
	
	public Location(int id)
	{
		this.setId(id);
	}

	public String getCity()
	{
		return city;
	}

	public void setCity(String city)
	{
		this.city = city;
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	@Override
	public String toString()
	{
		return "Location [city=" + city + "]";
	}
	
	
	
	
}
