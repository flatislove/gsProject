package com.flatislove.controller;

import com.flatislove.model.MatrixSKU;
import com.flatislove.model.repository.MatrixRepository;
import com.flatislove.model.repository.SKURepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MatrixController {
    private final
    MatrixRepository matrixRepository;
    private final
    SKURepository skuRepository;

    @Autowired
    public MatrixController(MatrixRepository matrixRepository, SKURepository skuRepository) {
        this.matrixRepository = matrixRepository;
        this.skuRepository = skuRepository;
    }

    @RequestMapping(value = "/matrix", method = RequestMethod.GET)
    public ModelAndView doRequestCreator() {
        ModelAndView mv = new ModelAndView("matrix");
        mv.addObject("matrixList", matrixRepository.findAll());
        mv.addObject("skuList", skuRepository.findAll());
        return mv;
    }

    @RequestMapping("/matrixadd")
    public ModelAndView doAddMatrix() {
        ModelAndView mv = new ModelAndView("matrixadd");
        mv.addObject("matrixList", matrixRepository.findAll());
        mv.addObject("skuList", skuRepository.findAll());
        return mv;
    }

    @RequestMapping(value = "/matrixsave", method = RequestMethod.POST)
    public ModelAndView doSaveMatrix(@RequestParam("matrixId") String matrixId, @RequestParam("matrixSeller") int matrixSeller,
                                     @RequestParam("matrixSku") int matrixSku) {
        ModelAndView mv = new ModelAndView("redirect:/matrix");
        MatrixSKU matrixSKU;
        if (!matrixId.isEmpty()) {
            matrixSKU = matrixRepository.findOne(Integer.parseInt(matrixId));
        } else {
            matrixSKU = new MatrixSKU();
        }
        matrixSKU.setMatrixSeller(matrixSeller);
        matrixSKU.setMatrixSku(matrixSku);
        matrixRepository.save(matrixSKU);
        return mv;
    }

    @RequestMapping(value = "/matrixdelete/{matrixId}", method = RequestMethod.GET)
    public ModelAndView doDeleteMatrix(@PathVariable("matrixId") int matrixId) {
        ModelAndView mv = new ModelAndView("redirect:/matrix");
        matrixRepository.delete(matrixId);
        return mv;
    }
}
