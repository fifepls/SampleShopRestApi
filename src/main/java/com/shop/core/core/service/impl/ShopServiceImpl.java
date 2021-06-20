package com.shop.core.core.service.impl;

import com.shop.core.core.entity.Shop;
import com.shop.core.core.repository.ShopRepository;
import com.shop.core.core.service.ShopService;
import com.shop.core.core.service.exception.shop.ShopNotAddedException;
import com.shop.core.core.service.exception.shop.ShopNotRemovedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class ShopServiceImpl implements ShopService {
    private final ShopRepository shopRepository;
    private final Logger logger = LoggerFactory.getLogger(ShopServiceImpl.class);

    public ShopServiceImpl(ShopRepository shopRepository) {
        this.shopRepository = shopRepository;
    }

    @Override
    @Transactional
    public Shop addNewShop(Shop shop) throws ShopNotAddedException {
        try{
            if(shop == null){
                throw new ShopNotAddedException("shop is null");
            }
            return shopRepository.save(shop);
        }catch (ShopNotAddedException e){
            logger.error("shop is null catch",e);
            throw new ShopNotAddedException("shop not added",e);
        }
    }

    @Override
    @Transactional
    public Boolean removeShop(Long shopId) throws ShopNotRemovedException {
        try{
            if(shopId == null){
                throw new ShopNotRemovedException("id is null");
            }
            shopRepository.deleteById(shopId);
            return true;
        }catch (ShopNotRemovedException e){
            logger.error("shop id is null", e);
            throw new ShopNotRemovedException("shop not removed", e);
        }
    }

    @Override
    public List<Shop> getAllShops() {
        return shopRepository.findAll();
    }
}
