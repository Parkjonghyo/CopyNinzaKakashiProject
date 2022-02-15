package com.example.clonecoovapp.explain;

public class ExplainDTO {
    private int img_id;
    private String title, desc;

    public ExplainDTO() {
    }

    public ExplainDTO(int img_id, String title, String desc) {
        this.img_id = img_id;
        this.title = title;
        this.desc = desc;
    }

    public int getImg_id() {
        return img_id;
    }

    public void setImg_id(int img_id) {
        this.img_id = img_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
