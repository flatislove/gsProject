package com.flatislove.model;

import jxl.read.biff.File;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by flatislove.
 */
@Setter
@Getter
public class EmailMessage {
    private String to_address;
    private String subject;
    private String body;
    private File file;
}
