package com.example.self_manager.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Item implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(updatable = false)
    private String sub;
    private String date;
    private String category;
    private Integer subCategory;
    private String itemName;
    private String itemValue;

    public Item() {
    }

    public Item(Integer id, String sub, String date, String category, Integer subCategory, String itemName, String itemValue) {
        this.id = id;
        this.sub = sub;
        this.date = date;
        this.category = category;
        this.subCategory = subCategory;
        this.itemName = itemName;
        this.itemValue = itemValue;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSub() {
        return sub;
    }

    public void setSub(String sub) {
        this.sub = sub;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Integer getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(Integer subCategory) {
        this.subCategory = subCategory;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemValue() {
        return itemValue;
    }

    public void setItemValue(String itemValue) {
        this.itemValue = itemValue;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", sub='" + sub + '\'' +
                ", date='" + date + '\'' +
                ", category='" + category + '\'' +
                ", subCategory=" + subCategory +
                ", itemName='" + itemName + '\'' +
                ", itemValue='" + itemValue + '\'' +
                '}';
    }
}
