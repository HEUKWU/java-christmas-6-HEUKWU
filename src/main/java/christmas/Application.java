package christmas;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }

    public static boolean isWeekend(int date) {
        DayOfWeek dayOfWeek = LocalDate.of(2023, 12, date).getDayOfWeek();

        return dayOfWeek == DayOfWeek.FRIDAY || dayOfWeek == DayOfWeek.SATURDAY;
    }
}
