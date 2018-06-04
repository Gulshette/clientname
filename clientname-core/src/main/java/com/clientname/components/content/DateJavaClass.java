package com.clientname.components.content;

import java.time.LocalDate;

public class DateJavaClass {

    private String timezone;


    public static void main(String[] args)
    {
        LocalDate d=LocalDate.now();
        System.out.println(d);

        String startDate= "10/10/2017";
        String  endDate = "10/10/2017";
        if(startDate.equals(endDate))
        {
            System.out.println(true);
        }
        else
        {
            System.out.println(false);
        }
    }

    public String getTimezone() {
        return timezone;
    }
}
