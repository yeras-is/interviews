package defult;

// how to check current day is n

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class isCurrentDate {
    public static void main(String[] args) {
        Integer n = 11;
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd");
        System.out.println(n == Integer.valueOf(formatter.format(date)));
    }
}
