package com.flatislove.service;

import com.flatislove.model.EmailMessage;
import jxl.read.biff.File;
import org.apache.catalina.User;

import javax.mail.internet.AddressException;

/**
 * Created by flatislove.
 */
public interface MailService {
//    void sendRequestForEmail(EmailMessage emailMessage) throws AddressException;
public void sendNotification(User user);
}
