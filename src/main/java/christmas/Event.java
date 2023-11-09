package christmas;

public class Event {

    private static final int EVENT_START_DATE = 1;
    private static final int EVENT_END_DATE = 31;
    private static final int CHRISTMAS_D_DAY_EVENT_END_DATE = 25;
    private static final int D_DAY_DISCOUNT_PRICE = 1_000;
    private static final int D_DAY_DISCOUNT_INCREASE_PRICE = 100;

    public static int christmasDDayDiscount(int price, int date) {
        if (date < EVENT_START_DATE || date > EVENT_END_DATE) {
            throw new IllegalArgumentException("[error] 유효하지 않은 날짜입니다. 다시 입력해주세요.");
        }
        if (date > CHRISTMAS_D_DAY_EVENT_END_DATE) {
            return 0;
        }

        return D_DAY_DISCOUNT_PRICE + D_DAY_DISCOUNT_INCREASE_PRICE * (date - 1);
    }
}