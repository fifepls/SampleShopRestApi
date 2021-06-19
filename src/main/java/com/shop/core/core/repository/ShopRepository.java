package com.shop.core.core.repository;

import com.shop.core.core.entity.Shop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShopRepository extends JpaRepository<Shop,Long> {
}
