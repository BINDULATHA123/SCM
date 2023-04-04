package com.example.demo.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Shipments")

public class Shipment {
	
	private String invoiceNumber;
	
	private String containerNumber;
	
	private String shipmentDescription;
	
	private String routeDetail;
	
	private String goodsType;
	
	private String device;
	
	private String expectedDeliverydate;
	
	private String poNumber;

	private String deliveryNumber;

	private String ndcNumber;

	private String batchId;
	
	private String serialNumber;
	
	

	

	public Shipment(String invoiceNumber, String containerNumber, String shipmentDescription, String routeDetail,
			String goodsType, String device, String expectedDeliverydate, String poNumber, String deliveryNumber,
			String ndcNumber, String batchId, String serialNumber) {
		super();
		this.invoiceNumber = invoiceNumber;
		this.containerNumber = containerNumber;
		this.shipmentDescription = shipmentDescription;
		this.routeDetail = routeDetail;
		this.goodsType = goodsType;
		this.device = device;
		this.expectedDeliverydate = expectedDeliverydate;
		this.poNumber = poNumber;
		this.deliveryNumber = deliveryNumber;
		this.ndcNumber = ndcNumber;
		this.batchId = batchId;
		this.serialNumber = serialNumber;
	}

	public String getInvoiceNumber() {
		return invoiceNumber;
	}

	public void setInvoiceNumber(String invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}

	public String getContainerNumber() {
		return containerNumber;
	}

	public void setContainerNumber(String containerNumber) {
		this.containerNumber = containerNumber;
	}

	public String getShipmentDescription() {
		return shipmentDescription;
	}

	public void setShipmentDescription(String shipmentDescription) {
		this.shipmentDescription = shipmentDescription;
	}

	public String getRouteDetail() {
		return routeDetail;
	}

	public void setRouteDetail(String routeDetail) {
		this.routeDetail = routeDetail;
	}

	public String getGoodsType() {
		return goodsType;
	}

	public void setGoodsType(String goodsType) {
		this.goodsType = goodsType;
	}

	public String getDevice() {
		return device;
	}

	public void setDevice(String device) {
		this.device = device;
	}

	public String getExpectedDeliverydate() {
		return expectedDeliverydate;
	}

	public void setExpectedDeliverydate(String expectedDeliverydate) {
		this.expectedDeliverydate = expectedDeliverydate;
	}

	public String getPoNumber() {
		return poNumber;
	}

	public void setPoNumber(String poNumber) {
		this.poNumber = poNumber;
	}

	public String getDeliveryNumber() {
		return deliveryNumber;
	}

	public void setDeliveryNumber(String deliveryNumber) {
		this.deliveryNumber = deliveryNumber;
	}

	

	public String getNdcNumber() {
		return ndcNumber;
	}

	public void setNdcNumber(String ndcNumber) {
		this.ndcNumber = ndcNumber;
	}

	public String getBatchId() {
		return batchId;
	}

	public void setBatchId(String batchId) {
		this.batchId = batchId;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

}
