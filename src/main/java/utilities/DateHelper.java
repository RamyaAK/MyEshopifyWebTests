package utilities;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateHelper {

    public String getDate() {
        DateFormat dateFormat = new SimpleDateFormat("dd");
        Date date = new Date();
        String currentDate = dateFormat.format(date);
        return currentDate;
    }
}
