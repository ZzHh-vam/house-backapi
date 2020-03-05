package com.team.house.housebackapi.util;

/**
 * @Author ZzHh
 * @Classname Condition
 * @Description TODO
 * @Date: Created in 2020/3/1 15:48
 * @Create By IntelliJ IDEA
 **/

public class Condition extends PageParameter {
    private String title;  //标题
    private Integer districtId;  //区域编号
    private Integer streetId;  //街道编号
    private Integer typeId;  //房型编号
    private Integer startPrice;  //开始价格
    private Integer endPrice;  //结束价格
    //private Integer startFloorage;
    //private Integer endFloorage;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getDistrictId() {
        return districtId;
    }

    public void setDistrictId(Integer districtId) {
        this.districtId = districtId;
    }

    public Integer getStreetId() {
        return streetId;
    }

    public void setStreetId(Integer streetId) {
        this.streetId = streetId;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public Integer getStartPrice() {
        return startPrice;
    }

    public void setStartPrice(Integer startPrice) {
        this.startPrice = startPrice;
    }

    public Integer getEndPrice() {
        return endPrice;
    }

    public void setEndPrice(Integer endPrice) {
        this.endPrice = endPrice;
    }



    /*public Integer getStartFloorage() {
        return startFloorage;
    }

    public void setStartFloorage(Integer startFloorage) {
        this.startFloorage = startFloorage;
    }

    public Integer getEndFloorage() {
        return endFloorage;
    }

    public void setEndFloorage(Integer endFloorage) {
        this.endFloorage = endFloorage;
    }*/
}
