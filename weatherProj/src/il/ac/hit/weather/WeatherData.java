package il.ac.hit.weather;

public class WeatherData {

	String description;
	double temp;
	int pressure;
	double humidity;
	double tempMin;
	double tempMax;
	double speedWind;
	String country;
	String city;
	String main;
	
	public WeatherData(){}

	
	
	public WeatherData(String description, double temp, int pressure,
			double humidity, double tempMin, double tempMax, double speedWind,
			String country, String city, String main) {

		setDescription(description);
		setTemp(temp);
		setTempMin(tempMin);
		setTempMax(tempMax);
		setDescription(description);
		setPressure(pressure);
		setHumidity(humidity);
		setCountry(country);
		setCity(city);
		setMain(main);
		setSpeedWind(speedWind);

	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getTemp() {
		return temp;
	}


	public void setTemp(double temp) {
		this.temp = temp;
	}
	
	public double getSpeedWind() {
		return speedWind;
	}


	public void setSpeedWind(double speedWind) {
		this.speedWind = speedWind;
	}

	public int getPressure() {
		return pressure;
	}


	public void setPressure(int pressure) {
		this.pressure = pressure;
	}


	public double getHumidity() {
		return humidity;
	}


	public void setHumidity(double humidity) {
		this.humidity = humidity;
	}


	public double getTempMin() {
		return tempMin;
	}


	public void setTempMin(double tempMin) {
		this.tempMin = tempMin;
	}


	public double getTempMax() {
		return tempMax;
	}


	public void setTempMax(double tempMax) {
		this.tempMax = tempMax;
	}

	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	}

	public String getMain() {
		return main;
	}


	public void setMain(String main) {
		this.main = main;
	}
	
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}



	@Override
	public String toString() {
		return "description=" + description +  
				" \n, temp=" + temp + 
				"\n, pressure=" + pressure + 
				"\n, humidity=" + humidity + 
				"\n, tempMin=" + tempMin + 
				"\n, tempMax=" + tempMax	+ 
				"\n, speedWind=" + speedWind + 
				"\n, country=" + country 	+ 
				"\n, city=" + city + 
				"\n, main=" + main ;
	}




	
	
	
}
