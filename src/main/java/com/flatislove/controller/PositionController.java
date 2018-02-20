package com.flatislove.controller;

import com.flatislove.model.Employee;
import com.flatislove.model.Position;
import com.flatislove.model.repository.EmployeeRepository;
import com.flatislove.model.repository.PositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PositionController {

        @Autowired
        PositionRepository positionRepository;

        @RequestMapping("/positionadd")
        public ModelAndView doAddPosition(){
            ModelAndView mv = new ModelAndView("positionadd");
            mv.addObject("lists",positionRepository.findAll());
            return mv;
        }

        @RequestMapping("/position")
        public ModelAndView doHome(){
            ModelAndView mv = new ModelAndView("positionindex");
            mv.addObject("lists",positionRepository.findAll());
            return mv;
        }

        @RequestMapping(value = "/position/save", method = RequestMethod.POST)
        public ModelAndView doSave(@RequestParam("positionId") String positionId, @RequestParam("positionName") String positionNme){
            ModelAndView mv = new ModelAndView("redirect:/position");
            Position position;
            if(!positionId.isEmpty()){
                position = (Position) positionRepository.findOne(Integer.parseInt(positionId));
            }
            else {
                position = new Position();
            }
            position.setPositionName(positionNme);
            positionRepository.save(position);
            return mv;
        }

        @RequestMapping(value = "/position/view/{positionId}", method = RequestMethod.GET)
        public ModelAndView doView(@PathVariable("positionId") int positionId){
            ModelAndView mv = new ModelAndView("positionview");
            mv.addObject("lists",positionRepository.findOne(positionId));
            return mv;
        }

        @RequestMapping(value = "/position/delete/{positionId}", method = RequestMethod.GET)
        public ModelAndView doDelete(@PathVariable("positionId") int positionId){
            ModelAndView mv = new ModelAndView("redirect:/position");
            positionRepository.delete(positionId);
            return mv;
        }

        @RequestMapping(value = "/position/edit/{positionId}", method = RequestMethod.GET)
        public ModelAndView doEdit(@PathVariable("positionId") int positionId){
            ModelAndView mv = new ModelAndView("positionedit");
            mv.addObject("lists",positionRepository.findOne(positionId));
            return mv;
        }
    }
