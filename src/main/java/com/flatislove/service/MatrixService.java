package com.flatislove.service;

import com.flatislove.model.MatrixSKU;

import java.util.ArrayList;
import java.util.List;

public interface MatrixService {
    ArrayList<MatrixSKU> getSkuForSeller(int seller, List<MatrixSKU> list);
}
