package io.forecast;

import com.fasterxml.jackson.annotation.*;
import io.tools.Direction;

public class CurrentWeather {
	private double temperature;
	private double windspeed;
	private long winddirection;
	private long weathercode;
	private long isDay;
	private String time;

	@JsonProperty("temperature")
	public String getTemperature() { return (int)temperature + " C"; }
	@JsonProperty("temperature")
	public void setTemperature(double value) { this.temperature = value; }

	@JsonProperty("windspeed")
	public Double getWindspeed() { return windspeed; }
	@JsonProperty("windspeed")
	public void setWindspeed(double value) { this.windspeed = value; }

	/**
	 * Returns the direction of the wind information
	 * @return Wind Direction Orientation + degrees
	 */
	@JsonProperty("winddirection")
	public String getWinddirection() 
	{ 
		Direction dir = new Direction((int)winddirection);
		return dir.getDir() + " | " + winddirection; 
	}
	@JsonProperty("winddirection")
	public void setWinddirection(long value) { this.winddirection = value; }

	/**
	 * Returns the type of current weather state (weather code)
	 * @return Type of Weather + Weather Code
	 */
	@JsonProperty("weathercode")
	public String getWeathercode() 
	{ 
		String weatherstate = null;
		switch((int)weathercode)
		{
		case 1:
		case 2:
		case 3:
			weatherstate = "Partly cloudy";
			break;
		case 45:
		case 48:
			weatherstate = "Fog";
			break;
		case 51:
		case 53:
		case 55:
			weatherstate = "Drizzle";
			break;
		case 56:
		case 57:
			weatherstate = "Freezing drizzle";
			break;
		case 61:
		case 63:
		case 65:
			weatherstate = "Rain";
			break;
		case 66:
		case 67:
			weatherstate = "Freezing rain";
			break;
		case 71:
		case 73:
		case 75:
			weatherstate = "Snow fall";
			break;
		case 77:
			weatherstate = "Snow grains";
			break;
		case 80:
		case 81:
		case 82: 
			weatherstate = "Rain showers";
			break;
		case 85:
		case 86:
			weatherstate = "Snow showers";
			break;
		case 95:
			weatherstate = "Thunderstorm";
			break;
		case 96:
		case 99:
			weatherstate = "Thunderstorm with hail";
			break;
		}
		return weatherstate + " | " + weathercode; 
	}
	@JsonProperty("weathercode")
	public void setWeathercode(long value) { this.weathercode = value; }

	@JsonProperty("is_day")
	public String getIsDay() 
	{ 
		return (isDay == 1) ? "Day" : "Night"; 
	}
	@JsonProperty("is_day")
	public void setIsDay(long value) { this.isDay = value; }

	@JsonProperty("time")
	public String getTime() { return time; }
	@JsonProperty("time")
	public void setTime(String value) { this.time = value; }

	public String toString()
	{
		return "\tTemperature: " + getTemperature() + System.lineSeparator() +
				"\tWeather state: " + getWeathercode() + System.lineSeparator() +
				"\tWind Speed: " + getWindspeed() + " km/h " + System.lineSeparator() +
				"\tWind Direction: " + getWinddirection() + System.lineSeparator() +
				"\tAt " + getTime() + " | On " + getIsDay() + System.lineSeparator();
	}
}
