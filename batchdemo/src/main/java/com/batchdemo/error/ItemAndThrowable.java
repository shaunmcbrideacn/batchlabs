package com.batchdemo.error;

public class ItemAndThrowable {

	private Object item;
	private Throwable throwable;

	public ItemAndThrowable(Object item, Throwable throwable) {
		this.item = item;
		this.throwable = throwable;
	}

	@Override
	public String toString() {
		return "ItemAndThrowable [item=" + item + ", throwable=" + throwable
				+ "]";
	}

}
