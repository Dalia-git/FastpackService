package com.talencuba.test.rest.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.talencuba.test.rest.model.LinePackedItems;
import com.talencuba.test.rest.model.PackagingBox;

/**
 * Optimize the baggage process to maximize the number of items per box
 * 
 * @author Dalia Maria Berbes
 *
 */

@Service
public class FastpackService{
	
	/**
	 * Return the sequence of boxes with an optimized capacity amount of items.
	 * 
	 * @param items Incoming sequence of items
	 * @return List of packaged boxes. Each box contains a mount of items with a capacity lower than or equal to 10 
	 */
	public LinePackedItems maximizeNumberItemsPerBox(String items) {
		char[] incomingItems = items.toCharArray();//Original sequence of items
		
		Integer[] incomingCapacityItems = convertToIntSequence(incomingItems);
		
		/*
		 * Initialize the list of pending items 
		 */
		List<Integer> pendingItems = new LinkedList<Integer>(Arrays.asList(incomingCapacityItems));
		int totalItems = pendingItems.size();
		
		List<PackagingBox> optimizedPackagedBoxes = new ArrayList<PackagingBox>();
		while(totalItems > 0) {
			Integer item = pendingItems.get(0);
			int currentCapacityAmount = item;
			
			List<Integer> boxedItems = new ArrayList<Integer>();
			boxedItems.add(item);
			int visitedItems = 1;
			
			/*
			 * Find items to be packaged into a box with the first item in the list
			 */
			List<Integer> remainingItems = new ArrayList<Integer>();
			
			while (visitedItems < pendingItems.size()) {
				Integer nextItem = pendingItems.get(visitedItems);
				
				if (currentCapacityAmount < 10) {
					int calculatedCapacity = currentCapacityAmount + nextItem;
					
					if (calculatedCapacity <= 10) {
						currentCapacityAmount = currentCapacityAmount + nextItem;
						
						boxedItems.add(nextItem);
					} else {
						remainingItems.add(nextItem);
					}
				} else {
					remainingItems.add(nextItem);
				}
				
				visitedItems++;
			}
			
			PackagingBox packagedItems = new PackagingBox();
			packagedItems.setItems(boxedItems);
			packagedItems.setItemsCount(boxedItems.size());
			packagedItems.setItemsCapacity(currentCapacityAmount);
			
			optimizedPackagedBoxes.add(packagedItems);
			
			pendingItems.clear();
			pendingItems.addAll(remainingItems);
			totalItems = pendingItems.size();
			currentCapacityAmount = 0;
		}
		
		LinePackedItems lineBoxes = new LinePackedItems(); 
		lineBoxes.setPackages(optimizedPackagedBoxes);
		lineBoxes.setPackagesCount(optimizedPackagedBoxes.size());
		
		return lineBoxes;
	}

	/**
	 * To obtain the sequence of each item's capacity
	 *
	 * @param incomingItems Incoming sequence of items
	 * @return
	 */
	private Integer[] convertToIntSequence(char[] incomingItems) {
		
		Integer[] convertedToIntItems = new Integer[incomingItems.length];
		for (int i = 0; i < incomingItems.length; i++) {
			String item = String.valueOf(incomingItems[i]);
			
			convertedToIntItems[i] = Integer.parseInt(item);
		}
		return convertedToIntItems;
	}
	
}
