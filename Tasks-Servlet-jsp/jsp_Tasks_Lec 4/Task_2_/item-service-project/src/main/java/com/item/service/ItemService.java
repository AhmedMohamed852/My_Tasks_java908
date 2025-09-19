package com.item.service;

import java.util.List;

import com.item.model.Item;

public interface ItemService {

	
	 boolean addItem(Item item);

	    boolean removeItem(long id);

	    boolean editItem(Item item);
	    boolean addItemDetails(Item item);
	    boolean updateItemDetails(Item item);

	    Item loadItem(long id);
	    Item showItemDetails(long id);

	    List<Item> loadItems();
}
