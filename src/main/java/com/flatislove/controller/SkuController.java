package com.flatislove.controller;

import com.flatislove.model.SKU;
import com.flatislove.model.repository.SKURepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SkuController {

    private final
    SKURepository skuRepository;

    @Autowired
    public SkuController(SKURepository skuRepository) {
        this.skuRepository = skuRepository;
    }

    @RequestMapping("/skuadd")
    public ModelAndView doAddSku() {
        ModelAndView mv = new ModelAndView("skuadd");
        mv.addObject("list", skuRepository.findAll());
        return mv;
    }

    @RequestMapping(value = "/sku/save", method = RequestMethod.POST)
    public ModelAndView doSave(@RequestParam("skuId") String skuId, @RequestParam("skuName") String skuName,
                               @RequestParam("skuCode") String skuCode) {
        ModelAndView mv = new ModelAndView("redirect:/skuindex");
        SKU sku;
        if (!skuId.isEmpty()) {
            sku = skuRepository.findOne(Integer.parseInt(skuId));
        } else {
            sku = new SKU();
        }
        sku.setSkuName(skuName);
        sku.setSkuCode(skuCode);
        skuRepository.save(sku);
        return mv;
    }

    @RequestMapping(value = "/skuindex", method = RequestMethod.GET)
    public ModelAndView doSkuIndex() {
        ModelAndView mv = new ModelAndView("skuindex");
        mv.addObject("list", skuRepository.findAll());
        return mv;
    }

    @RequestMapping(value = "/sku/view/{skuId}", method = RequestMethod.GET)
    public ModelAndView doView(@PathVariable("skuId") int skuId) {
        ModelAndView mv = new ModelAndView("skuview");
        mv.addObject("list", skuRepository.findOne(skuId));
        return mv;
    }

    @RequestMapping(value = "/sku/delete/{skuId}", method = RequestMethod.GET)
    public ModelAndView doDelete(@PathVariable("skuId") int skuId) {
        ModelAndView mv = new ModelAndView("redirect:/skuindex");
        skuRepository.delete(skuId);
        return mv;
    }

    @RequestMapping(value = "/sku/edit/{skuId}", method = RequestMethod.GET)
    public ModelAndView doEdit(@PathVariable("skuId") int skuId) {
        ModelAndView mv = new ModelAndView("skuedit");
        mv.addObject("list", skuRepository.findOne(skuId));
        return mv;
    }
}
