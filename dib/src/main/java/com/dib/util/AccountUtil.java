package com.dib.util;

import jakarta.persistence.PreUpdate;

import java.time.Year;

public  class AccountUtil {

    public static final String ACCOUNT_EXISTS_CODE="001";

    public static final String ACCOUNT_EXISTS_MESS="This user already has account";

    public static final String ACCOUNT_EXISTS_CODE2 ="002";

    public static final String ACCOUNT_EXISTS_MESS2="This customer has successfully created a account";

    public static String generateAccountNumber(){

        Year current_year = Year.now();

        int min = 100000;

        int max = 999999;

        //generate random number between min and max

        int random_number = (int) Math.floor(Math.random() * (max - min + 1) + min);

        //convert year and random_no to string and concatenate

        String year = String.valueOf(current_year);

        String random_no = String.valueOf(random_number);

        StringBuilder account_number = new StringBuilder();

       return account_number.append(year).append(random_no).toString();

    }

    public static String generateCustomerId(){

        Year current_month=Year.now();

        int min=1000;

        int max=9999;

        int random_id= (int) Math.floor(Math.random() * (max-min+1)+min);

        String year = String.valueOf(current_month);

        String random_no = String.valueOf(random_id);

        StringBuilder customer_id = new StringBuilder();

        return customer_id.append(year).append(random_no).toString();



    }

}



