package com.example.self_manager.service.impl;

import com.example.self_manager.domain.Item;
import com.example.self_manager.domain.ItemFormBean;
import com.example.self_manager.repo.ItemRepo;
import com.example.self_manager.service.ItemService;
import com.example.self_manager.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    private ItemRepo itemRepo;

    @Override
    public boolean saveItems(Item[] items, final String sub) {
        try {
            List<Item> itemList = new ArrayList<>();
            Arrays.stream(items).forEach(
                    item -> {
                        item.setSub(sub);
                        item.setDate(DateUtil.parse(item.getDate()));
                        itemList.add(item);
                    });
            itemRepo.saveAll(itemList);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public List<Item> getItemsByCategoryAndSubAndDateRange(ItemFormBean itemFormBean) {
        if ("home".equalsIgnoreCase(itemFormBean.getCategory())) {
            String sub = itemFormBean.getSub();
            String start = itemFormBean.getStartDate().replace("/", "");
            String end = itemFormBean.getEndDate().replace("/", "");
            List<Item> itemList = new ArrayList<>();
            itemList.addAll(itemRepo.findByCategoryAndSubAndDateBetweenOrderByDateDesc("account", sub, start, end));
            itemList.addAll(itemRepo.findByCategoryAndSubAndDateBetweenOrderByDateDesc("eat", sub, start, end));
            itemList.addAll(itemRepo.findByCategoryAndSubAndDateBetweenOrderByDateDesc("fit", sub, start, end));
            itemList.addAll(itemRepo.findByCategoryAndSubAndDateBetweenOrderByDateDesc("note", sub, start, end));
            return itemList;
        } else {
            return itemRepo.findByCategoryAndSubAndDateBetweenOrderByDateDesc(
                    itemFormBean.getCategory(), itemFormBean.getSub(),
                    itemFormBean.getStartDate().replace("/", ""),
                    itemFormBean.getEndDate().replace("/", "")
            );
        }
    }

    @Override
    public void deleteItemById(String id) {
        itemRepo.deleteById(new Integer(id));
    }

    @Override
    public void saveChangeItem(Item item) {
        if ("note".equalsIgnoreCase(item.getCategory())) {
            item.setItemValue(null);
        }
        itemRepo.save(item);
    }
}
