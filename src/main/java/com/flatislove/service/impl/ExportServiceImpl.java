package com.flatislove.service.impl;

import com.flatislove.model.Request;
import com.flatislove.model.repository.SKURepository;
import com.flatislove.service.ExportService;
import jxl.Workbook;
import jxl.write.*;
import jxl.write.Number;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ExportServiceImpl implements ExportService{

    @Autowired
    SKURepository skuRepository;

    public void ExportToXLSFile(List<Request> requests) throws IOException,WriteException{

        Date date = new Date();
        WritableWorkbook workbook = Workbook.createWorkbook(new File("D://report"+date.hashCode()+".xls"));
        WritableSheet sheet = workbook.createSheet("FirstSheet", 0);
        sheet.mergeCells(0,0,1,0);
        Label label1 = new Label(1,6,"Наименование");
        Label label2 = new Label(2,6,"Код товара");
        Label label3 = new Label(3,6,"Количество");

        sheet.addCell(label1);
        sheet.addCell(label2);
        sheet.addCell(label3);

        for (int i = 0; i <requests.size() ; i++) {
            Label labeldesc = new Label(1,i+7,skuRepository.findBySkuId(requests.get(i).getRequestSku()).getSkuName());
            Label number2 = new Label(2,i+7,skuRepository.findBySkuId(requests.get(i).getRequestSku()).getSkuCode());
            Number number3 = new Number(3,i+7,requests.get(i).getRequestCount());
            sheet.addCell(labeldesc);
            sheet.addCell(number2);
            sheet.addCell(number3);
        }


        //Formula f = new Formula(7,5,"SUM(A2,B2)");
        //sheet.addCell(f);
        WritableFont cellFont = new WritableFont(WritableFont.TIMES, 12);
        cellFont.setColour(Colour.BLUE);

        WritableCellFormat cellFormat = new WritableCellFormat(cellFont);
        cellFormat.setBackground(Colour.ORANGE);
        cellFormat.setBorder(Border.ALL, BorderLineStyle.THIN);

        int col = 0;
        int widthInChars = 7;
        sheet.setColumnView(col, widthInChars);

        col = 1;
        widthInChars = 40;
        sheet.setColumnView(col, widthInChars);
        sheet.addCell(new Label(col, 6, "Наименование", cellFormat));

        col = 2;
        widthInChars = 20;
        sheet.setColumnView(col, widthInChars);
        sheet.addCell(new Label(col, 6, "Код товара", cellFormat));

        col = 3;
        widthInChars = 20;
        sheet.setColumnView(col, widthInChars);
        sheet.addCell(new Label(col, 6, "Количество", cellFormat));


        workbook.write();
        workbook.close();
    }
}
