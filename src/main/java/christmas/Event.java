package christmas;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class Event {

    private static final int CHRISTMAS_D_DAY_EVENT_END_DATE = 25;
    private static final int D_DAY_DISCOUNT_PRICE = 1_000;
    private static final int D_DAY_DISCOUNT_INCREASE_PRICE = 100;

    private static final int weekdayDessertDiscountPrice = 2_023;
    private static final int weekendMainDishDiscountPrice = 2_023;

    private static final int[] specialDays = {3, 10, 17, 24, 25, 31};
    private static final int specialDiscountPrice = 1_000;

    private static final int giftEventMinimumPrice = 120_000;
    private static final int giftEventPrice = Menu.CHAMPAGNE.getPrice();

    public static int christmasDDayDiscount(int date) {
        if (date > CHRISTMAS_D_DAY_EVENT_END_DATE) {
            return 0;
        }

        return D_DAY_DISCOUNT_PRICE + D_DAY_DISCOUNT_INCREASE_PRICE * (date - 1);
    }

    public static int weekdayDiscount(int date, int dessertCount) {
        if (isWeekday(date)) {
            return dessertCount * weekdayDessertDiscountPrice;
        }

        return 0;
    }

    public static int weekendDiscount(int date, int mainDishCount) {
        if (!isWeekday(date)) {
            return mainDishCount * weekendMainDishDiscountPrice;
        }

        return 0;
    }

    public static int specialDiscount(int date) {
        if (isSpecialDay(date)) {
            return specialDiscountPrice;
        }

        return 0;
    }

    public static int giftEvent(int price) {
        if (price >= giftEventMinimumPrice) {
            return giftEventPrice;
        }

        return 0;
    }

    public static String badge(int price) {
        Badge[] badges = Badge.values();
        for (Badge badge : badges) {
            if (price >= badge.getPrice()) {
                return badge.getBadge();
            }
        }

        return "없음";
    }

    private static boolean isWeekday(int date) {
        DayOfWeek dayOfWeek = LocalDate.of(2023, 12, date).getDayOfWeek();

        return dayOfWeek != DayOfWeek.FRIDAY && dayOfWeek != DayOfWeek.SATURDAY;
    }

    private static boolean isSpecialDay(int date) {
        for (int specialDay : specialDays) {
            if (date == specialDay) {
                return true;
            }
        }

        return false;
    }
}