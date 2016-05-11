package net.coderodde.billpal;

import java.text.SimpleDateFormat;

/**
 * This class contains all magic date for the BillPal.
 * 
 * @author Rodion "rodde" Efremov
 * @version 1.6 (May 10, 2016)
 */
public class Config {

    /**
     * The date format.
     */
    public static final String DATE_FORMAT_STRING = "yyyy.MM.dd";    
    
    /**
     * The format for all the {@link Date}s in the BillPal.
     */
    public static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat();
}
