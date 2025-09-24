package core.basesyntax;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.text.ParseException;
import java.util.Date;

public class SalaryInfo {
    public String getSalaryInfo(String[] names, String[] data, String dateFrom, String dateTo) {
        SimpleDateFormat inputFormat = new SimpleDateFormat("dd.MM.yyyy");

        try {
            Date dateFormatFrom = inputFormat.parse(dateFrom);
            Date dateFormatTo = inputFormat.parse(dateTo);
        } catch (ParseException e) {
            System.err.println("Помилка розбору дати: " + e.getMessage());
        }

        for (String dataSep : data) {
            String[] result = dataSep.split(" ");

            String dateStr = result[0];
            SimpleDateFormat dateStrForm = new SimpleDateFormat("dd.MM.yyyy");

            String name = result[1];
            int hours = Integer.parseInt(result[2]);
            int rate = Integer.parseInt(result[3]);
        }
    }
}
