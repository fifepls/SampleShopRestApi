package com.shop.core.core.service.impl;

import com.shop.core.core.entity.Shop;
import com.shop.core.core.repository.ShopRepository;
import com.shop.core.core.service.exception.shop.ShopNotAddedException;
import com.shop.core.core.service.exception.shop.ShopNotRemovedException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
class ShopServiceImplTest {

    @Autowired
    private ShopServiceImpl shopService;

    @MockBean
    private ShopRepository shopRepository;

    @Test
    void addNewShop() throws ShopNotAddedException {
        Shop shop = new Shop();
        shop.setAddress("some test adr");
        shop.setId(1L);

        Mockito.doReturn(shop).when(shopRepository).save(shop);

        //invoking service method that should be tested
        shopService.addNewShop(shop);

        Mockito.verify(shopRepository,Mockito.times(1)).save(shop);
        Assertions.assertEquals("some test adr", shop.getAddress());
        Assertions.assertEquals(1L, shop.getId());

    }

    @Test
    void removeShop() throws ShopNotRemovedException {
        Shop shop1 = new Shop();
        shop1.setAddress("adr1");
        shop1.setId(1L);

        //invoking service method that should be tested
        Assertions.assertTrue(shopService.removeShop(1L));
        Mockito.verify(shopRepository).deleteById(1L);
    }

    @Test
    void getAllShops() {
        List<Shop> shops = new ArrayList<>();
        Shop shop1 = new Shop();
        shop1.setAddress("adr1");
        shop1.setId(1L);
        Shop shop2 = new Shop() ;
        shop1.setAddress("adr2");
        shop1.setId(2L);
        shops.add(shop1);
        shops.add(shop2);

        Mockito.doReturn(shops).when(shopRepository).findAll();

        //invoking service method that should be tested
        Assertions.assertEquals(shops, shopService.getAllShops());
        Mockito.verify(shopRepository,Mockito.times(1)).findAll();

    }
}