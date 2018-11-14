package com.arsoft.projects.artutorial.learning.designpattern.observer;

public class WeatherStation {
	public static void main(String[] args) {
		WeatherData weatherData = new WeatherData();
		CurrentConditionDisplay current = new CurrentConditionDisplay(weatherData);
		StatisticsDisplay statistics = new StatisticsDisplay(weatherData);
		ForecastDisplay forecast = new ForecastDisplay(weatherData);
		
		weatherData.setMeasurement(10, 20, 30);
		weatherData.setMeasurement(30, 40, 50);
		weatherData.setMeasurement(40, 50, 60);
	}
}
