package com.flatislove.model.repository;

import com.flatislove.model.Request;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface RequestRepository extends CrudRepository<Request, Integer>, JpaRepository<Request, Integer> {

    List<Request> getAllByRequestId(int requestId);

}
