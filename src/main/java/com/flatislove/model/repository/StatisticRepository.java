package com.flatislove.model.repository;

import com.flatislove.model.Statistic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface StatisticRepository extends CrudRepository<Statistic, Integer>, JpaRepository<Statistic, Integer> {
}
