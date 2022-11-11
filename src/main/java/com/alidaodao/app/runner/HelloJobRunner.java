package com.alidaodao.app.runner;

import com.alidaodao.app.utils.DateTimeUtils;
import com.alidaodao.app.utils.IdGenUtils;
import com.alidaodao.app.utils.MathUtils;
import java.io.Serializable;
import java.time.LocalDate;

/**
 * @author jack
 * @since 2022-11-11
 */
public class HelloJobRunner implements Serializable {
    private static final long serialVersionUID = -7876450706485261323L;


    public static int getRomdom(){
        return MathUtils.randDom(1,100);
    }

    public static String getGlobalId(){
        return IdGenUtils.UUID();
    }


    public static String getLocalDateNow(){
        return DateTimeUtils.dateFormat(LocalDate.now(),DateTimeUtils.DATE_DEFAULT_FORMAT);
    }




    public static void main(String[] args) {
        System.out.println(getRomdom());
    }
}
