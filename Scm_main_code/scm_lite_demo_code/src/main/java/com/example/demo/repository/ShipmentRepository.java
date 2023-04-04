package com.example.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Shipment;
@Repository
public interface ShipmentRepository extends MongoRepository<Shipment, String>{

	Shipment findByInvoiceNumber(String invoiceNumber, String containerNumber);
	

}
