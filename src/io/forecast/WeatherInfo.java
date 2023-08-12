package io.forecast;

import com.fasterxml.jackson.annotation.*;

public class WeatherInfo {
    private double latitude;
    private double longitude;
    private double generationtimeMS;
    private long utcOffsetSeconds;
    private String timezone;
    private String timezoneAbbreviation;
    private long elevation;
    private CurrentWeather currentWeather;

    @JsonProperty("latitude")
    public Double getLatitude() { return latitude; }
    @JsonProperty("latitude")
    public void setLatitude(double value) { this.latitude = value; }

    @JsonProperty("longitude")
    public Double getLongitude() { return longitude; }
    @JsonProperty("longitude")
    public void setLongitude(double value) { this.longitude = value; }

    @JsonProperty("generationtime_ms")
    public Double getGenerationtimeMS() { return generationtimeMS; }
    @JsonProperty("generationtime_ms")
    public void setGenerationtimeMS(double value) { this.generationtimeMS = value; }

    @JsonProperty("utc_offset_seconds")
    public long getUTCOffsetSeconds() { return utcOffsetSeconds; }
    @JsonProperty("utc_offset_seconds")
    public void setUTCOffsetSeconds(long value) { this.utcOffsetSeconds = value; }

    @JsonProperty("timezone")
    public String getTimezone() { return timezone; }
    @JsonProperty("timezone")
    public void setTimezone(String value) { this.timezone = value; }

    @JsonProperty("timezone_abbreviation")
    public String getTimezoneAbbreviation() { return timezoneAbbreviation; }
    @JsonProperty("timezone_abbreviation")
    public void setTimezoneAbbreviation(String value) { this.timezoneAbbreviation = value; }

    @JsonProperty("elevation")
    public Long getElevation() { return elevation; }
    @JsonProperty("elevation")
    public void setElevation(long value) { this.elevation = value; }

    @JsonProperty("current_weather")
    public CurrentWeather getCurrentWeather() { return currentWeather; }
    @JsonProperty("current_weather")
    public void setCurrentWeather(CurrentWeather value) { this.currentWeather = value; }
    
    public String toString()
    {
    	return "latitude: " + getLatitude() + System.lineSeparator() +
    			"longitude: " + getLongitude() + System.lineSeparator() +
    			"timezone: " + getTimezone() + " | " + getTimezoneAbbreviation() + System.lineSeparator() +
    			"elevation: " + getElevation() + " m." + System.lineSeparator() +
    			System.lineSeparator() +
    			"Current weather: { " + System.lineSeparator() +
    			getCurrentWeather().toString() + System.lineSeparator() +
    			"} Generated in: " + getGenerationtimeMS().toString() +
    			System.lineSeparator();
    }
}
