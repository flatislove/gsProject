package com.flatislove.model.repository;

import com.flatislove.model.Seller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface SellerRepository extends CrudRepository<Seller, Integer>, JpaRepository<Seller, Integer> {
}
