package com.flatislove.service;

import com.flatislove.model.Request;

import java.util.ArrayList;
import java.util.List;

public interface RequestService {
    int createRequest(int daysNumber);

    int getNextNumberRequest();

    List<Request> getUniqueRequests(List<Request> requests);

    List<Request> getNewRequest(int number);

    List<Request> getUniqRequests();

     ArrayList<Integer> getIdsForDelete(int requestId);

}
