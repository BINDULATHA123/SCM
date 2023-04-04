package com.example.demo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Shipment;
import com.example.demo.repository.ShipmentRepository;
import com.example.demo.service.ShipmentService;
@Service
public class ShipmentServiceImpl implements ShipmentService {
	
	@Autowired
	ShipmentRepository shipmentrepository;

	@Override
	public void ShipmentData(Shipment shipment) {
		shipmentrepository.save(shipment);
	}

	@Override
	public boolean Authenticate(String invoiceNumber, String containerNumber) {
		Shipment shipment = shipmentrepository.findByInvoiceNumber(invoiceNumber, containerNumber);
		if (shipment == null
				|| (!shipment.getInvoiceNumber().equals(invoiceNumber) || (!shipment.getContainerNumber().equals(containerNumber)))) {
			return false;
		}
		return true;
	}

	@Override
	public List<Shipment> getshipmentdata() {
		return shipmentrepository.findAll();
	}

}
