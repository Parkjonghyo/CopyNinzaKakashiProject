package com.example.clonecoovapp.setup;

public class OptionVO {
    private int category;
    private String name;
    private Boolean select, support;

    public OptionVO() {
    }

    public OptionVO(String name, Boolean select, Boolean support, int category) {
        this.name = name;
        this.select = select;
        this.support = support;
        this.category = category;
    }

    public int getCategory() { return category; }

    public void setCategory(int category) { this.category = category; }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getSelect() {
        return select;
    }

    public void setSelect(Boolean select) {
        this.select = select;
    }

    public Boolean getSupport() {
        return support;
    }

    public void setSupport(Boolean support) {
        this.support = support;
    }
}
