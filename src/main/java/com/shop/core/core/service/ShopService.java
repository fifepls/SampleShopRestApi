package com.shop.core.core.service;

import com.shop.core.core.entity.Shop;

import java.util.List;

public interface ShopService {
    public Shop addNewShop(Shop shop);
    public Boolean removeShop(Long shopId);
    public List<Shop> getAllShops();
}
