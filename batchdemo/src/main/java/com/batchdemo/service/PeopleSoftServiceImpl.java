package com.batchdemo.service;

import com.batchdemo.data.Order;

public class PeopleSoftServiceImpl implements ErpService {

	private static int quantityProcessed = 0;
	
	public void addOrder(Order order) {
		quantityProcessed++;
		System.out.println("Order #" + order.getId() + " added");
	}

	public static int getQuantityprocessed() {
		return quantityProcessed;
	}
	
	

}
