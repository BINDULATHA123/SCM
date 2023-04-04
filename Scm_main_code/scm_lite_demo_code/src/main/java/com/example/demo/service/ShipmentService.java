package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.demo.model.Shipment;

@Component
public interface ShipmentService {
	
	public void ShipmentData(Shipment shipment);
	
	public boolean Authenticate(String invoiceNumber, String containerNumber);

	public List<Shipment> getshipmentdata();


}
