package pl.sdacademy.utils;

import java.time.LocalDate;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        DateUtils date = new DateUtils();
        System.out.println(date.dateDifference(LocalDate.of(2000,10,25)
                ,LocalDate.of(2000,10,20)));

        List<LocalDate> dateList = new ArrayList<>();
        dateList.add(LocalDate.of(2020, 5, 10));
        dateList.add(LocalDate.of(2020, 5, 9));
        dateList.add(LocalDate.of(2020, 5, 19));
        System.out.println(date.maxMinDiff(dateList));

        Set<LocalDate> dateSet = new TreeSet<>();
        dateSet.add(LocalDate.of(2020,5,10));
        dateSet.add(LocalDate.of(2020,5,9));
        dateSet.add(LocalDate.of(2020,5,11));
        System.out.println(date.datesGap(dateSet));

    }
}
