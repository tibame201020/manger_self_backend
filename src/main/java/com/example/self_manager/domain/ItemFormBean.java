package com.example.self_manager.domain;

public class ItemFormBean {
    private String category;
    private String sub;
    private String startDate;
    private String endDate;

    public ItemFormBean() {
    }

    public ItemFormBean(String category, String sub, String startDate, String endDate) {
        this.category = category;
        this.sub = sub;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSub() {
        return sub;
    }

    public void setSub(String sub) {
        this.sub = sub;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "ItemFormBean{" +
                "category='" + category + '\'' +
                ", sub='" + sub + '\'' +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                '}';
    }
}
