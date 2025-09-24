package core.basesyntax;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SalaryInfo {
    public String getSalaryInfo(String[] names, String[] data, String dateFrom, String dateTo) {
        SimpleDateFormat inputFormat = new SimpleDateFormat("dd.MM.yyyy");
        Date dateFormatFrom;
        Date dateFormatTo;
        try {
            dateFormatFrom = inputFormat.parse(dateFrom);
            dateFormatTo = inputFormat.parse(dateTo);
        } catch (ParseException e) {
            throw new RuntimeException("Помилка розбору дати", e);
        }

        Date currentDate = null;
        int[] salaries = new int[names.length];
        for (String dataSep : data) {
            String[] result = dataSep.split(" ");

            String dateStr = result[0];
            SimpleDateFormat dateStrForm = new SimpleDateFormat("dd.MM.yyyy");
            try {
                currentDate = dateStrForm.parse(dateStr);
            } catch (ParseException e) {
                throw new RuntimeException("Помилка розбору дати: " + dateStr, e);
            }

            String name = result[1];
            int hours = Integer.parseInt(result[2]);
            int rate = Integer.parseInt(result[3]);

            assert currentDate != null;
            if (!currentDate.before(dateFormatFrom) && !currentDate.after(dateFormatTo)) {
                int dailySalary = hours * rate;
                for (int i = 0; i < names.length; i++) {
                    if (names[i].equals(name)) {
                        salaries[i] += dailySalary;
                        break;
                    }
                }
            }
        }

        StringBuilder report = new StringBuilder("Report for period "
                + dateFrom + " - " + dateTo + System.lineSeparator());

        for (int i = 0; i < names.length; i++) {
            report.append(names[i])
                    .append(" - ")
                    .append(salaries[i])
                    .append(System.lineSeparator());
        }
        return report.toString().trim();
    }
}
