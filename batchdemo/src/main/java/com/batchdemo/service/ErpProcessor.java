package com.batchdemo.service;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;

import com.batchdemo.data.Order;

public class ErpProcessor implements ItemProcessor<Order,Order> {
	
	
	private ErpService erpService;

	public Order process(Order item) throws Exception {
		erpService.addOrder(item);
		return item;
	}

	public ErpService getErpService() {
		return erpService;
	}

	public void setErpService(ErpService erpService) {
		this.erpService = erpService;
	}

	
	
}
