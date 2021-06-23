package com.shop.core.core.entity.model;

import com.shop.core.core.entity.Shop;

import java.util.ArrayList;
import java.util.List;

public class ShopModel{
    private Long id;
    private String address;

    public static ShopModel shopToModel(Shop shop){
        ShopModel shopModel = new ShopModel();
        shopModel.setAddress(shop.getAddress());
        shopModel.setId(shop.getId());
        return shopModel;
    }

    public static List<ShopModel> shopListToModel(List<Shop> shops){
        List<ShopModel> shopModels = new ArrayList<>();
        for (Shop shop : shops) {
            ShopModel shopModel = new ShopModel();
            shopModel.setId(shop.getId());
            shopModel.setAddress(shop.getAddress());
            shopModels.add(shopModel);
        }
        return shopModels;
    }

    public ShopModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
