package store.util;

import static store.util.StringSplitter.splitByDelimiter;

import java.time.LocalDate;
import java.util.List;

public class DateComparator {
    private static final String DATE_DELIMITER = "-";
    private static final int YEAR_INDEX = 0;
    private static final int MONTH_INDEX = 1;
    private static final int DAY_INDEX = 2;

    public static boolean isDateInRange(String start, String end, LocalDate today) {
        LocalDate startDate = convertToDate(splitByDelimiter(start, DATE_DELIMITER));
        LocalDate endDate = convertToDate(splitByDelimiter(end, DATE_DELIMITER));

        return isDateBetween(startDate, endDate, today) || isSameDate(startDate, endDate, today);
    }

    private static boolean isDateBetween(LocalDate startDate, LocalDate endDate, LocalDate todayDate) {
        return todayDate.isAfter(startDate) && todayDate.isBefore(endDate);
    }

    private static boolean isSameDate(LocalDate startDate, LocalDate endDate, LocalDate todayDate) {
        return startDate.isEqual(todayDate) || endDate.isEqual(todayDate);
    }

    private static LocalDate convertToDate(List<String> rawDate) {
        List<Integer> convertedRawDate = rawDate
                .stream()
                .map(Integer::parseInt)
                .toList();

        int year = convertedRawDate.get(YEAR_INDEX);
        int month = convertedRawDate.get(MONTH_INDEX);
        int day = convertedRawDate.get(DAY_INDEX);

        return LocalDate.of(year, month, day);
    }
}
