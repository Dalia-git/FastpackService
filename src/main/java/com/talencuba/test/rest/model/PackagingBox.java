package com.talencuba.test.rest.model;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * Represents a packaging box which contains items. The total capacity of items must be lower or equal 10.
 * 
 * @author Dalia Maria Berbes
 *
 */
public class PackagingBox implements Serializable{
	
	private static final long serialVersionUID = 1L;

	/**
	 * Total amount of items
	 */
	@JsonInclude(Include.NON_NULL)
	private int itemsCount;
	
	/**
	 * Real items capacity. It must be lower than or equal  10
	 */
	@JsonInclude(Include.NON_NULL)
	private int itemsCapacity;
	
	/**
	 * Sequence of items
	 */
	@JsonInclude(Include.NON_NULL)
	private List<Integer> items;

	public int getItemsCount() {
		return itemsCount;
	}

	public void setItemsCount(int itemsCount) {
		this.itemsCount = itemsCount;
	}

	public List<Integer> getItems() {
		return items;
	}

	public void setItems(List<Integer> items) {
		this.items = items;
	}

	public int getItemsCapacity() {
		return itemsCapacity;
	}

	public void setItemsCapacity(int itemsCapacity) {
		this.itemsCapacity = itemsCapacity;
	}

	
}
