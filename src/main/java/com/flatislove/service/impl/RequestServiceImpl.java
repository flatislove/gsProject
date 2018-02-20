package com.flatislove.service.impl;

import com.flatislove.model.MatrixSKU;
import com.flatislove.model.Request;
import com.flatislove.model.Selling;
import com.flatislove.model.repository.MatrixRepository;
import com.flatislove.model.repository.RequestRepository;
import com.flatislove.model.repository.SellingRepository;
import com.flatislove.service.MatrixService;
import com.flatislove.service.RequestService;
import com.flatislove.service.SellingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class RequestServiceImpl implements RequestService {

    private final
    SellingRepository sellingRepository;
    private final
    SellingService sellingService;
    private final
    MatrixRepository matrixRepository;
    private final
    MatrixService matrixService;
    private final
    RequestRepository requestRepository;


    @Autowired
    public RequestServiceImpl(SellingRepository sellingRepository, SellingService sellingService, MatrixRepository matrixRepository, MatrixService matrixService, RequestRepository requestRepository) {
        this.sellingRepository = sellingRepository;
        this.sellingService = sellingService;
        this.matrixRepository = matrixRepository;
        this.matrixService = matrixService;
        this.requestRepository = requestRepository;
    }

    @Override
    public int createRequest(int daysNumber) {
        List<Selling> sellingList = sellingRepository.findAll();
        ArrayList<Request> resultRequest = new ArrayList<>();
        List<MatrixSKU> matrix = matrixRepository.findAll();
        int seller = 102;
        ArrayList<MatrixSKU> matrixSKUS = matrixService.getSkuForSeller(seller, matrix);
        ArrayList<Selling> sellingSellerSku = new ArrayList<>();
        for (Selling aSellingList : sellingList) {
            for (MatrixSKU matrixSKU : matrixSKUS) {
                if (aSellingList.getSellingSku() == matrixSKU.getMatrixSku()) {
                    sellingSellerSku.add(aSellingList);
                }
            }
        }
        int next = getNextNumberRequest();
        //список продаж для всех скю магаза
        ArrayList<Selling> sellings = sellingService.getPeriodSelling(sellingSellerSku);
        //список по скю за период
        double sellingSum;
        for (MatrixSKU matrixSKU : matrixSKUS) {
            sellingSum = 0;
            for (Selling selling : sellings) {

                if (matrixSKU.getMatrixSku() == selling.getSellingSku()) {
                    sellingSum += selling.getSellingCount();
                }
            }
            double averCount = sellingSum / sellings.size();
            double ostatki = 4;
            double result = daysNumber * averCount * 1.5 - ostatki;
            if (result < 0) {
                result = 0;
            }
            Request resReq = new Request(matrixSKU.getMatrixSku(), result, new Date(), seller);
            resultRequest.add(resReq);

            resReq.setRequestId(next);
            requestRepository.save(resReq);
        }
        return getNextNumberRequest();
    }

    @Override
    public int getNextNumberRequest() {
        List<Request> requests = requestRepository.findAll();
        Request request = requests.get(0);
        for (Request request1 : requests) {
            if (request.getRequestId() < request1.getRequestId()) {
                request = request1;
            }
        }
        return request.getRequestId() + 1;
    }

    @Override
    public List<Request> getUniqueRequests(List<Request> requests) {
        List<Request> list = requestRepository.findAll();
        List<Request> uniqueList = new ArrayList<>();
        unique:
        for (Request aList : list) {
            int id = aList.getRequestId();
            for (Request anUniqueList : uniqueList) {
                if (id == anUniqueList.getRequestId()) {
                    break unique;
                }
            }
            uniqueList.add(aList);
        }
        return uniqueList;
    }

    public List<Request> getUniqRequests() {
        List<Request> requests = requestRepository.findAll();
        ArrayList<Request> requestsUni = new ArrayList<>();
        for (Request request : requests) {
            if (requestsUni.isEmpty()) {
                requestsUni.add(request);
            }
            for (int j = 0; j < requestsUni.size(); j++) {
                if (request.getRequestId() != requestsUni.get(j).getRequestId()) {
                    int g = 0;
                    for (Request aRequestsUni : requestsUni) {
                        if (aRequestsUni.getRequestId() == request.getRequestId()) {
                            g++;
                        }
                    }
                    if (g == 0) {
                        requestsUni.add(request);
                    }
                }
            }
        }
        return requestsUni;
    }

    @Override
    public ArrayList<Integer> getIdsForDelete(int requestId) {
        List<Request> requests = requestRepository.findAll();
        ArrayList<Integer> ids = new ArrayList<>();
        for (Request request : requests) {
            if (request.getRequestId() == requestId) {
                ids.add(request.getReqId());
            }
        }
        return ids;
    }

    @Override
    public List<Request> getNewRequest(int number) {
        List<Request> requests = requestRepository.findAll();
        List<Request> resultList = new ArrayList<>();
        for (Request request : requests) {
            if (request.getRequestId() == number) {
                resultList.add(request);
            }
        }
        return resultList;
    }
}
