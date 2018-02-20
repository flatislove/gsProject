package com.flatislove.service.impl;

import com.flatislove.model.MatrixSKU;
import com.flatislove.service.MatrixService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MatrixServiceImpl implements MatrixService {

    @Override
    public ArrayList<MatrixSKU> getSkuForSeller(int seller, List<MatrixSKU> list) {
        ArrayList<MatrixSKU> matrixSKUS = new ArrayList<>();
        for (MatrixSKU aList : list) {
            if (aList.getMatrixSeller() == seller) {
                matrixSKUS.add(aList);
            }
        }
        return matrixSKUS;
    }
}
