package com.example.demo.validation;

import com.example.demo.model.Shipment;

public class ShipmentValidation {
	public static boolean validation1(Shipment shipment) throws Exception {
		
		if ((shipment.getInvoiceNumber()).length() == 0) {
			throw new Exception("Enter Shipment Number!");
		} else if ((shipment.getContainerNumber()).length() == 0) {
			throw new Exception("Enter Container Number!");

		} else if ((shipment.getShipmentDescription()).length() == 0) {
			throw new Exception("Provide a description!");

		} else if ((shipment.getRouteDetail()).length() == 0) {
			throw new Exception("Select a Route!");

		} else if ((shipment.getGoodsType()).length() == 0) {
			throw new Exception("Select Goods!");

		} else if ((shipment.getDevice()).length() == 0) {
			throw new Exception("Select Device!");

		} else if ((shipment.getExpectedDeliverydate()).length() == 0) {
			throw new Exception("Enter Date!");

		} else if ((shipment.getPoNumber()).length() == 0) {
			throw new Exception("Enter PO Number!");

		} else if ((shipment.getDeliveryNumber()).length() == 0) {
			throw new Exception("Enter Delivery Number!");

		}
		else if ((shipment.getNdcNumber()).length()==0) {
			throw new Exception("Enter NDC Number!");

			
		}
		else if ((shipment.getBatchId()).length() == 0) {
			throw new Exception("Enter Batch ID!");

		} else if ((shipment.getSerialNumber()).length() == 0) {
			throw new Exception("Enter Serial Number!");

		}

		return true;
		
	}

}
