package com.flatislove.controller;

import com.flatislove.model.Seller;
import com.flatislove.model.repository.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SellerController {

    private final
    SellerRepository sellerRepository;

    @Autowired
    public SellerController(SellerRepository sellerRepository) {
        this.sellerRepository = sellerRepository;
    }

    @RequestMapping("/seller")
    public ModelAndView doHome() {
        ModelAndView mv = new ModelAndView("sellerindex");
        mv.addObject("lists", sellerRepository.findAll());
        return mv;
    }

    @RequestMapping("/selleradd")
    public ModelAndView doAddSeller() {
        ModelAndView mv = new ModelAndView("selleradd");
        mv.addObject("lists", sellerRepository.findAll());
        return mv;
    }

    @RequestMapping(value = "/seller/save", method = RequestMethod.POST)
    public ModelAndView doSave(@RequestParam("sellerId") String sellerId, @RequestParam("sellerName") String sellerName,
                               @RequestParam("sellerAddress") String sellerAddress) {
        ModelAndView mv = new ModelAndView("redirect:/seller");
        Seller seller;
        if (!sellerId.isEmpty()) {
            seller = sellerRepository.findOne(Integer.parseInt(sellerId));
        } else {
            seller = new Seller();
        }
        seller.setSellerName(sellerName);
        seller.setSellerAddress(sellerAddress);
        sellerRepository.save(seller);
        return mv;
    }

    @RequestMapping(value = "/seller/view/{sellerId}", method = RequestMethod.GET)
    public ModelAndView doView(@PathVariable("sellerId") int sellerId) {
        ModelAndView mv = new ModelAndView("sellerview");
        mv.addObject("lists", sellerRepository.findOne(sellerId));
        return mv;
    }

    @RequestMapping(value = "/seller/delete/{sellerId}", method = RequestMethod.GET)
    public ModelAndView doDelete(@PathVariable("sellerId") int sellerId) {
        ModelAndView mv = new ModelAndView("redirect:/seller");
        sellerRepository.delete(sellerId);
        return mv;
    }

    @RequestMapping(value = "/seller/edit/{sellerId}", method = RequestMethod.GET)
    public ModelAndView doEdit(@PathVariable("sellerId") int sellerId) {
        ModelAndView mv = new ModelAndView("selleredit");
        mv.addObject("lists", sellerRepository.findOne(sellerId));
        return mv;
    }

}
