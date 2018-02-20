package com.flatislove.service;

import com.flatislove.model.Request;
import jxl.write.WriteException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public interface ExportService {
    void ExportToXLSFile(List<Request> requests) throws IOException,WriteException;
}
