package com.zb.entity;

public class Order {
    private Integer id;
    private String name;
    private Double price;
    private Integer uid;

    public Order() {
    }

    public Order(Integer id, String name, Double price, Integer uid) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.uid = uid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", uid=" + uid +
                '}';
    }
}
