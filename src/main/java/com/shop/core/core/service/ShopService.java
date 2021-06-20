package com.shop.core.core.service;

import com.shop.core.core.entity.Shop;
import com.shop.core.core.service.exception.shop.ShopNotAddedException;
import com.shop.core.core.service.exception.shop.ShopNotRemovedException;

import java.util.List;

public interface ShopService {
    public Shop addNewShop(Shop shop) throws ShopNotAddedException;
    public Boolean removeShop(Long shopId) throws ShopNotRemovedException;
    public List<Shop> getAllShops();
}
