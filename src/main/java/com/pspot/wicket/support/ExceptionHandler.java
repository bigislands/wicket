package com.pspot.wicket.support;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * Created by Administrator on 2019/5/9.
 */
public class ExceptionHandler {

    public static  String getErrorInfoFromException(Exception e) {

        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        String result = "";
        try {
            e.printStackTrace(pw);
            result = sw.toString();

        } catch (Exception ex) {
            ex.getStackTrace();
        }finally {
            try {
                sw.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            pw.close();
        }
        return result;
    }
}
