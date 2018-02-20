package com.flatislove.controller;

import com.flatislove.model.EmailMessage;
import com.flatislove.service.MailService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.net.UnknownServiceException;

@Controller
public class SendController {

    @Autowired
    MailService mailService;

    @RequestMapping("/send/letter")
    public ModelAndView doHome(){
        ModelAndView mv = new ModelAndView("positionindex");
        User user = null;
        try {
            mailService.sendNotification(user);
        }catch (MailException e){
            System.out.println(e);
        }
     //   mv.addObject("lists",positionRepository.findAll());
        return mv;
    }





}
