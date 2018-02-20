package com.flatislove.model.repository;

import com.flatislove.model.MatrixSKU;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface MatrixRepository extends CrudRepository<MatrixSKU, Integer>,
        JpaRepository<MatrixSKU, Integer> {
}
