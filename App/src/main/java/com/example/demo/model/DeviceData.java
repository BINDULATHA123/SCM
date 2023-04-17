package com.example.demo.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Stream")
public class DeviceData {
	//private long _id;
	private String battery_Level;
	private int device_ID;
	private int first_Sensor_temperature;
	private String route_From;
	private String route_To;
	public String getBattery_Level() {
		return battery_Level;
	}
	public void setBattery_Level(String battery_Level) {
		this.battery_Level = battery_Level;
	}
	public int getDevice_ID() {
		return device_ID;
	}
	public void setDevice_ID(int device_ID) {
		this.device_ID = device_ID;
	}
	public int getFirst_Sensor_temperature() {
		return first_Sensor_temperature;
	}
	public void setFirst_Sensor_temperature(int first_Sensor_temperature) {
		this.first_Sensor_temperature = first_Sensor_temperature;
	}
	public String getRoute_From() {
		return route_From;
	}
	public void setRoute_From(String route_From) {
		this.route_From = route_From;
	}
	public String getRoute_To() {
		return route_To;
	}
	public void setRoute_To(String route_To) {
		this.route_To = route_To;
	}
	public DeviceData() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "DeviceData [battery_Level=" + battery_Level + ", device_ID=" + device_ID + ", first_Sensor_temperature="
				+ first_Sensor_temperature + ", route_From=" + route_From + ", route_To=" + route_To + "]";
	}
	
	
	
	
}