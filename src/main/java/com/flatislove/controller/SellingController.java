package com.flatislove.controller;

import com.flatislove.converter.DateConverter;
import com.flatislove.model.Employee;
import com.flatislove.model.Selling;
import com.flatislove.model.repository.MatrixRepository;
import com.flatislove.model.repository.SKURepository;
import com.flatislove.model.repository.SellingRepository;
import com.flatislove.service.SellingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Date;


@Controller
public class SellingController {

    @Autowired
    SellingRepository sellingRepository;
    @Autowired
    SellingService sellingService;
    @Autowired
    SKURepository skuRepository;

    @RequestMapping(value = "/selling", method = RequestMethod.GET)
    public ModelAndView doAddSelling() {
        ModelAndView mv = new ModelAndView("sellingindex");
        mv.addObject("lists",sellingService.getLastWeek());
        return mv;
    }

    @RequestMapping(value = "/selling/view/{sellingDate}", method = RequestMethod.GET)
    public ModelAndView doViewSelling(@PathVariable("sellingDate") String sellingDate) {
        ModelAndView mv = new ModelAndView("sellingview");
        mv.addObject("listByDate",sellingService.getSellingByDate(sellingDate));
        mv.addObject("date",sellingDate);
        //  mv.addObject("lists", sellingRepository.findAll());
        // mv.addObject("lists",sellingService.getSellingByDate());
        mv.addObject("skuList",skuRepository.findAll());
        mv.addObject("lists",sellingRepository.getSellingBySellingSeller(102));
        return mv;
    }

    @RequestMapping(value = "/selling/save", method = RequestMethod.POST)
    public ModelAndView doSave(@RequestParam("sellingId") String sellingId, /*@RequestParam("sellingDate") String sellingDate,*/
                               @RequestParam("sellingSku") String sellingSku, @RequestParam("sellingCount") String sellingCount) {
        ModelAndView mv = new ModelAndView("redirect:/selling");
        Selling selling;
        if (!sellingId.isEmpty()) {
            selling = sellingRepository.findOne(Integer.parseInt(sellingId));
        } else {
            selling = new Selling();
        }
        selling.setSellingSku(Integer.parseInt(sellingSku));
        //selling.setSellingDate(DateConverter.DATE_FORMAT.format(new Timestamp(Long.parseLong(sellingDate))));
        selling.setSellingCount(Double.parseDouble(sellingCount));
        sellingRepository.save(selling);
        return mv;
    }

    @RequestMapping("/selling/add/{sellingDate}")
    public ModelAndView doAddPosition(@PathVariable("sellingDate") String sellingDate){
//        ModelAndView mv = new ModelAndView("sellingadd");
        sellingService.addSellingNewMatrix(sellingDate);
        ModelAndView mv = new ModelAndView("redirect:/selling");
        return mv;
    }

    @RequestMapping("/selling/view/seller/edit/{sellingId}")
    public ModelAndView doEditPosition(@PathVariable("sellingId") String sellingId){
//        ModelAndView mv = new ModelAndView("sellingadd");

        //sellingService.addSellingNewMatrix(sellingDate);
        ModelAndView mv = new ModelAndView("sellingeditdesc");
        Selling selling = sellingRepository.findOne(Integer.parseInt(sellingId));
        mv.addObject("selling",sellingRepository.findOne(Integer.parseInt(sellingId)));
        mv.addObject("sku",skuRepository.findOne(selling.getSellingSku()));
        return mv;
    }

    @RequestMapping(value = "/selling/view/seller/view/{sellingId}", method = RequestMethod.GET)
    public ModelAndView doViewDescSelling(@PathVariable("sellingId") String sellingId) {
        ModelAndView mv = new ModelAndView("sellingviewdesc");
        Selling selling = sellingRepository.findOne(Integer.parseInt(sellingId));
        mv.addObject("list",sellingRepository.findOne(Integer.parseInt(sellingId)));
        mv.addObject("sku",skuRepository.getOne(selling.getSellingSku()));
        //mv.addObject("lists",sellingService.getLastWeek());
        return mv;
    }
}
