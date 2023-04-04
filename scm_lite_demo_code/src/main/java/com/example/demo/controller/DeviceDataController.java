package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.DeviceData;
import com.example.demo.service.DeviceDataService;
@RestController
public class DeviceDataController {
	
	@Autowired
	private DeviceDataService devicedataservice;

	public DeviceDataController(DeviceDataService devicedataservice) {
		super();
		this.devicedataservice=devicedataservice;
	}
	
	public DeviceDataService getService() {
		return devicedataservice;
	}

	public void setService(DeviceDataService devicedataservice) {
		this.devicedataservice = devicedataservice;
	}

	@GetMapping("/getData")
	public List<DeviceData> getAllDeviceData() {
		

		return devicedataservice.getdevicedata();

	}

}
