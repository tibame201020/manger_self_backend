package com.example.self_manager.service;

import com.example.self_manager.domain.Item;
import com.example.self_manager.domain.ItemFormBean;

import java.util.List;

public interface ItemService {
    boolean saveItems(Item[] items, String sub);

    List<Item> getItemsByCategoryAndSubAndDateRange(ItemFormBean itemFormBean);
}
