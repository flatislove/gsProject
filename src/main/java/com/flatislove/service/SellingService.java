package com.flatislove.service;

import com.flatislove.model.Selling;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public interface SellingService {
    ArrayList<Selling> getPeriodSelling(ArrayList<Selling> list);

    ArrayList<Selling> sortByDate(ArrayList<Selling> list);

    ArrayList<Selling> getBySellerAndSku(List<Selling> sellingList, int sku, int seller);

    List<Selling> getSellingByDate(String date);

    public List<LocalDate> getDatesBetweenUsingJava8(
            LocalDate startDate, LocalDate endDate);

    List<Date> getYearSelling();

    List<LocalDate> getLastWeek();

    ArrayList<Selling> addSellingNewMatrix(String date);
}
