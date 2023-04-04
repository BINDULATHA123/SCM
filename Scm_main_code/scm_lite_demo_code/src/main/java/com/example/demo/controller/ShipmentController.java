package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Shipment;
import com.example.demo.service.ShipmentService;
import static com.example.demo.validation.ShipmentValidation.validation1;

@RestController
public class ShipmentController {
	
	@Autowired
	ShipmentService service;
	
	public ShipmentController(ShipmentService service) {
		super();
		this.service = service;
	}
	public ShipmentService getService() {
		return service;
	}

	public void setService(ShipmentService service) {
		this.service = service;
	}
	
	@GetMapping("/getShipment")
	public List<Shipment> getshipmentdata() {

		return service.getshipmentdata();
	}
	
	@PostMapping("/createshipment")
	public ResponseEntity<Object> saveUsers(@RequestBody Shipment shipment) throws Exception {

		if (!service.Authenticate(shipment.getInvoiceNumber(), shipment.getContainerNumber())) {
			validation1(shipment);
			
			service.ShipmentData(shipment);
			return ResponseEntity.ok().header("Custom-Header", "success").body("successfully created");

		} else {

			return ResponseEntity.internalServerError().header("Custom-Header", "failure").body("Failure please try again");

		}

	}
	
	
	
}
