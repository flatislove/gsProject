package com.flatislove.model.repository;

import com.flatislove.model.SKU;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface SKURepository extends CrudRepository<SKU, Integer>, JpaRepository<SKU, Integer> {
    SKU findBySkuId(int skuId);
}
