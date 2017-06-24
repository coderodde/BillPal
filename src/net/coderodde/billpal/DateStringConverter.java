package net.coderodde.billpal;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.Optional;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.util.StringConverter;
import static net.coderodde.billpal.Config.DATE_FORMAT;

/**
 * This class is responsible for converting between double values and dates.
 * 
 * @author Rodion "rodde" Efremov
 * @version 1.6 (Mar 28, 2016)
 */
public class DateStringConverter extends StringConverter<Date> {

    private boolean formatGotIt;
    
    @Override
    public String toString(Date object) {
        if (object == null) {
            return "";
        }
        
        return DATE_FORMAT.format(object);
    }

    @Override
    public Date fromString(String string) {
        if (string == null || string.trim().isEmpty()) {
            return null;
        }
        
        try {
            return DATE_FORMAT.parse(string);
        } catch (ParseException ex) {
            if (!formatGotIt) {
                ButtonType buttonGotItType =
                        new ButtonType("Got it!", ButtonBar.ButtonData.YES);

                ButtonType buttonDidNotGetItType = 
                        new ButtonType("Did not get it",
                                       ButtonBar.ButtonData.NO);

                Alert alert = 
                        new Alert(AlertType.WARNING, 
                            "The format for dates is year.month.day. " +
                            "For example, today is " + todayToString() + ".",
                             buttonDidNotGetItType,
                             buttonGotItType);
                
                alert.setTitle("Date format warning");
                Optional<ButtonType> result = alert.showAndWait();
                
                if (result.get() == buttonGotItType) {
                    formatGotIt = true;
                }
            }
            
            return null;
        }
    }
    
    private String todayToString() {
        Calendar cal = Calendar.getInstance();
        System.out.println("yeah");
        return new StringBuilder(20)
                .append(cal.get(Calendar.YEAR)).append(".")
                .append(cal.get(Calendar.MONTH) + 1).append(".")
                .append(cal.get(Calendar.DAY_OF_MONTH)).toString();
    }
}
