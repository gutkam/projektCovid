package pl.sdacademy.utils;

import java.time.LocalDate;
import java.util.*;

public class DateUtils {
    public long dateDifference(LocalDate date1, LocalDate date2) {
        if (date2.isAfter(date1)) throw new IllegalArgumentException("First date must be greater then the second one");
        long result = 0;
        while (!date1.equals(date2)) {
            date2 = date2.plusDays(1);
            result++;
        }
        return result;
    }

    public long maxMinDiff(List<LocalDate> list) {
        return dateDifference(Collections.max(list), Collections.min(list));
    }

    public boolean datesGap(Set<LocalDate> set) {
        List<LocalDate> list = new ArrayList<>();
        for (LocalDate element : set) {
            list.add(element);
        }

        //for (LocalDate element : list) {
            for (int i = 0; i < list.size() - 1; i++)
                if (list.get(i).plusDays(1) == list.get(i+1)) {
                    return true;
                }
        return false;
    }


//    public static LocalDate minDate(List<LocalDate> list){
//        LocalDate min = list.get(0);
//        for (int i = 0; i < list.size(); i++) {
//            if (list.get(i).isBefore(min)) {
//                min = list.get(i);
//            }
//        }
//        return min;
//    }
}
