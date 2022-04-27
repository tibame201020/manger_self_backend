package com.example.self_manager.controller;

import com.example.self_manager.domain.Item;
import com.example.self_manager.domain.ItemFormBean;
import com.example.self_manager.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @RequestMapping("/saveItems")
    public boolean saveItems(@RequestBody Item[] items, HttpServletRequest request) {
        String sub = Objects.toString(request.getAttribute("sub"));
        boolean result = itemService.saveItems(items, sub);
        return result;
    }

    @RequestMapping("/getItems")
    public List<Item> getItemByCategoryAndSubAndDateRange(@RequestBody ItemFormBean itemFormBean, HttpServletRequest request) {
        String sub = Objects.toString(request.getAttribute("sub"));
        itemFormBean.setSub(sub);
        List<Item> itemList = itemService.getItemsByCategoryAndSubAndDateRange(itemFormBean);
        return itemList;
    }

    @RequestMapping("/delItem")
    public boolean delItems(@RequestBody String id) {
        try {
            itemService.deleteItemById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @RequestMapping("/saveChangeItem")
    public boolean saveChangeItem(@RequestBody Item item) {
        try {
            itemService.saveChangeItem(item);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
