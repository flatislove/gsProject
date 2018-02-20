package com.flatislove.controller;

import com.flatislove.model.EmailMessage;
import com.flatislove.model.Position;
import com.flatislove.model.Request;
import com.flatislove.model.repository.RequestRepository;
import com.flatislove.model.repository.SKURepository;
import com.flatislove.model.repository.SellerRepository;
import com.flatislove.service.ExportService;
import com.flatislove.service.MailService;
import com.flatislove.service.RequestService;
import jxl.write.WriteException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class RequestController {

    private final
    RequestRepository requestRepository;
    private final
    RequestService requestService;
    private final
    SKURepository skuRepository;
    private final
    SellerRepository sellerRepository;
    private final
    ExportService exportService;
    private final
    MailService mailService;

    @Autowired
    public RequestController(RequestRepository requestRepository, SKURepository skuRepository,
                             RequestService requestService, SellerRepository sellerRepository,
                             ExportService exportService, MailService mailService) {
        this.requestRepository = requestRepository;
        this.skuRepository = skuRepository;
        this.requestService = requestService;
        this.sellerRepository = sellerRepository;
        this.exportService = exportService;
        this.mailService=mailService;
    }

    @RequestMapping(value = "/request", method = RequestMethod.GET)
    public ModelAndView doRequestCreator() {
        ModelAndView mv = new ModelAndView("request");
        mv.addObject("uniqueRequestList", requestService.getUniqRequests());
        mv.addObject("requestList", requestRepository.findAll());
        mv.addObject("skuList", skuRepository.findAll());
        mv.addObject("sellerList", sellerRepository.findAll());
        return mv;
    }

    @RequestMapping(value = "/requestmainview/{requestId}", method = RequestMethod.GET)
    public ModelAndView doRequestMainView(@PathVariable("requestId") int requestId) {
        ModelAndView mv = new ModelAndView("requestmainview");
        mv.addObject("requestList", requestRepository.findAll());
        mv.addObject("skuList", skuRepository.findAll());
        mv.addObject("sellerList", sellerRepository.findAll());
        mv.addObject("retId", requestId);
        return mv;
    }


    @RequestMapping("/requestadd")
    public ModelAndView doAddRequest() {
        int i = requestService.createRequest(3) - 1;
//        ModelAndView mv = new ModelAndView("requestadd");
//        mv.addObject("skuList", skuRepository.findAll());
//        mv.addObject("createdRequestList", requestService.getNewRequest(i));
//        return mv;
        return new ModelAndView("redirect:/request");
    }

    @RequestMapping(value = "request/save/{requests}", method = RequestMethod.GET)
    public ModelAndView doSave(@PathVariable("requests") String requests) {
        ModelAndView mv = new ModelAndView("redirect:/request");

        return mv;
    }

    @RequestMapping(value = "request/export/{requestId}", method = RequestMethod.GET)
    public ModelAndView doExport(@PathVariable("requestId") String requestId) {
        List<Request> list = requestRepository.getAllByRequestId(Integer.parseInt(requestId));

        try {
            exportService.ExportToXLSFile(list) ;
        }
        catch (IOException e){
            e.printStackTrace();
        }
        catch (WriteException e){
            e.printStackTrace();
        }
        ModelAndView mv = new ModelAndView("redirect:/requestmainview/{requestId}");
        mv.addObject("list", list);
        mv.addObject("retId", requestId);
        return mv;
    }

    @RequestMapping(value = "request/send}", method = RequestMethod.POST)
    public String sendEmail(@RequestBody EmailMessage message) {

      //  mailService.sendRequestForEmail(message);
       // return new ModelAndView("redirect:/request");
        return "Email successfully";
    }

    @RequestMapping(value = "request/delete/{requestId}", method = RequestMethod.GET)
    public ModelAndView doDelete(@PathVariable("requestId") int employeeId) {
        ModelAndView mv = new ModelAndView("redirect:/request");
        ArrayList<Integer> ids = requestService.getIdsForDelete(employeeId);
        for (int i = 0; i <ids.size() ; i++) {
            requestRepository.delete(ids.get(i));
        }
        return mv;
    }

    @RequestMapping(value = "requestmainview/request/edit/{reqId}", method = RequestMethod.GET)
    public ModelAndView doEdit(@PathVariable("reqId") int reqId){
        ModelAndView mv = new ModelAndView("requestedit");
        mv.addObject("request",requestRepository.findOne(reqId));
        return mv;
    }

    @RequestMapping(value = "requestmainedit/save", method = RequestMethod.POST)
    public ModelAndView doSave(@RequestParam("reqId") String reqId,
                               @RequestParam("requestId") String requestId,
                               @RequestParam("requestCount") String requestCount){

        ModelAndView mv = new ModelAndView("redirect:/requestmainview/"+String.valueOf(requestId)+"");
        Request request;
        request = (Request)requestRepository.findOne(Integer.parseInt(reqId));
        request.setRequestCount(Integer.parseInt(requestCount));
        request.setRequestId(Integer.parseInt(requestId));
        requestRepository.save(request);
        return mv;
    }
}
