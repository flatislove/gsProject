package com.flatislove.service.impl;

import com.flatislove.model.MatrixSKU;
import com.flatislove.model.Selling;
import com.flatislove.model.repository.MatrixRepository;
import com.flatislove.model.repository.SellingRepository;
import com.flatislove.converter.DateConverter;
import com.flatislove.service.SellingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class SellingServiceImpl implements SellingService {

   @Autowired
    SellingRepository sellingRepository;
   @Autowired
    MatrixRepository matrixRepository;

    @Override
    public ArrayList<Selling> getPeriodSelling(ArrayList<Selling> list) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, -1);
        calendar.add(Calendar.YEAR, -1);
        Date dateobj = calendar.getTime();
        ArrayList<Selling> periodSellings = new ArrayList<>();
        for (Selling aList : list) {
            if (aList.getSellingDate().after(dateobj)) {
                periodSellings.add(aList);
            }
        }
        return periodSellings;
    }

    @Override
    public ArrayList<Selling> sortByDate(ArrayList<Selling> list) {

        return list;
    }

    @Override
    public ArrayList<Selling> getBySellerAndSku(List<Selling> sellingList, int sku, int seller) {
        ArrayList<Selling> resSelling = new ArrayList<>();
        for (Selling aSellingList : sellingList) {
            if ((aSellingList.getSellingSeller() == seller) && (aSellingList.getSellingSku() == sku)) {
                resSelling.add(aSellingList);
            }
        }
        return resSelling;
    }


    public List<Selling> getNormalSElling() {
        List<Selling> sellingList = sellingRepository.findAll();
        return sellingList;
    }
    @Override
    public List<Selling> getSellingByDate(String date){

//        for (Request request : requests) {
//            if (requestsUni.isEmpty()) {
//                requestsUni.add(request);
//            }
//            for (int j = 0; j < requestsUni.size(); j++) {
//                if (request.getRequestId() != requestsUni.get(j).getRequestId()) {
//                    int g = 0;
//                    for (Request aRequestsUni : requestsUni) {
//                        if (aRequestsUni.getRequestId() == request.getRequestId()) {
//                            g++;
//                        }
//                    }
//                    if (g == 0) {
//                        requestsUni.add(request);
//                    }
//                }
//            }
//        }


//jpa unique records
//        List<Selling> list = sellingRepository.findAll();
//       ArrayList<Selling> uniqList = new ArrayList<>();
//      //  uniqList=sellingRepository.findDistinctBySellingDate();
//        Optional<Selling> sellingForSellerList = sellingRepository.getAllBySellingSeller(102);
//        for (int i = 0; i <list.size() ; i++) {
//            if (uniqList.isEmpty()){
//                uniqList.add(list.get(i));
//            }
//            for (int j = 0; j <uniqList.size() ; j++) {
//                if (!DateConverter.DATE_FORMAT.format(list.get(i).getSellingDate()).
//                        equals(DateConverter.DATE_FORMAT.format(uniqList.get(j).getSellingDate()))){
//                    int g=0;
//                    for (int k = 0; k <uniqList.size() ; k++) {
//                        if (DateConverter.DATE_FORMAT.format(uniqList.get(k).getSellingDate())
//                                .equals(DateConverter.DATE_FORMAT.format(list.get(i).getSellingDate()))){
//                            g++;
//                        }
//                    }
//                    if (g==0){
//                        uniqList.add(list.get(i));
//                        System.out.println(i);
//                    }
//                }
//            }
//        }

        Date date1 = null;
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        try{
            date1 = df.parse(date);
        }
        catch ( Exception ex ){
            System.out.println(ex);
        }

        List<Selling> sellings = sellingRepository.findAll();
        ArrayList<Selling> sellingArrayList = new ArrayList<>();
        for (int i = 0; i <sellings.size() ; i++) {
            if (DateConverter.DATE_FORMAT.format(date1).equals(DateConverter.DATE_FORMAT.format(sellings.get(i).getSellingDate()))){
                sellingArrayList.add(sellings.get(i));
            }
        }

        return sellingArrayList;
    }

    @Override
    public List<Date> getYearSelling() {
        List<Selling> allList = sellingRepository.findAll();
        return null;
    }

    @Override
    public List<LocalDate> getLastWeek() {
        ArrayList<LocalDate> dates = new ArrayList<>();
        LocalDate date = LocalDate.now();
        dates.add(date);
        for (int i = 0; i <6 ; i++) {
            dates.add(date.minusDays(i+1));
        }
        return dates;
    }

    @Override
    public ArrayList<Selling> addSellingNewMatrix(String date) {
        List<MatrixSKU> matrixSKUS = matrixRepository.findAll();
        ArrayList<Selling> matrixSKUArrayList = new ArrayList<>();
        Date date1 = null;
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        try{
            date1 = df.parse(date);
        }
        catch ( Exception ex ){
            System.out.println(ex);
        }
        for (int i = 0; i <matrixSKUS.size() ; i++) {
            if (matrixSKUS.get(i).getMatrixSeller()==102){
                Selling selling=new Selling();
                selling.setSellingSeller(102);
                selling.setSellingCount(0);
                selling.setSellingDate(date1);
                selling.setSellingSku(matrixSKUS.get(i).getMatrixSku());
                sellingRepository.save(selling);
                matrixSKUArrayList.add(selling);
            }
        }
        return matrixSKUArrayList;
    }

    public List<LocalDate> getDatesBetweenUsingJava8(
            LocalDate startDate, LocalDate endDate) {

        long numOfDaysBetween = ChronoUnit.DAYS.between(startDate, endDate);
        return IntStream.iterate(0, i -> i + 1)
                .limit(numOfDaysBetween)
                .mapToObj(i -> startDate.plusDays(i))
                .collect(Collectors.toList());
    }
}
