package com.example.demo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.DeviceData;
import com.example.demo.repository.DeviceDataRepository;
import com.example.demo.service.DeviceDataService;
@Service
public class DeviceDataServiceImpl implements DeviceDataService {
	
	@Autowired
	private DeviceDataRepository devicedatarepository;

	@Override
	public List<DeviceData> getdevicedata() {
		return devicedatarepository.findAll();
	}

}
