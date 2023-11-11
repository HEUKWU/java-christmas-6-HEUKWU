package christmas;

import java.text.DecimalFormat;
import java.util.Map;

public class OutputView {

    private final Order order;
    private static final String GIFT_EVENT_MENU = "샴페인 1개";
    private static final DecimalFormat df = new DecimalFormat("###,###");

    public OutputView(Order order) {
        System.out.println("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.");
        this.order = order;
    }

    public void printMenuInfo(int date) {
        System.out.println("12월 " + date + "일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!");
        System.out.println("<주문 메뉴>");
        Map<String, Integer> orders = order.getOrders();
        for (String s : orders.keySet()) {
            System.out.println(s + " " + orders.get(s) + "개");
        }
        printTotalPrice();
    }

    private void printTotalPrice() {
        System.out.println("<할인 전 총주문 금액>");
        int totalPrice = order.getTotalPrice();

        System.out.println(df.format(totalPrice) + "원");
    }

    public void printEventInfo(int date) {
        int totalPrice = order.getTotalPrice();
        int giftPrice = printGiftMenu(totalPrice);

        printDiscountInfo(date, giftPrice);
    }

    private int printGiftMenu(int totalPrice) {
        System.out.println("<증정 메뉴>");
        int giftPrice = Event.giftEvent(totalPrice);
        if (giftPrice == 0) {
            System.out.println("없음");
            return 0;
        }
        System.out.println(GIFT_EVENT_MENU);
        return giftPrice;
    }

    private void printDiscountInfo(int date, int giftPrice) {
        System.out.println("<혜택 내역>");
        int DDayDiscount = christmasDDayDiscount(Event.christmasDDayDiscount(date));
        int weekdayDiscount = weekdayDiscount(Event.weekdayDiscount(date, order.getDessertCount()));
        int weekendDiscount = weekendDiscount(Event.weekendDiscount(date, order.getMainDishCount()));
        int specialDiscount = specialDiscount(Event.specialDiscount(date));

        int totalDiscount = DDayDiscount + weekdayDiscount + weekendDiscount + specialDiscount;
        if (totalDiscount == 0) {
            System.out.println("없음");
        }

        printTotalDiscount(totalDiscount + giftPrice);
        printPaymentPrice(totalDiscount);
        printBadge(totalDiscount + giftPrice);
    }

    private int christmasDDayDiscount(int discountPrice) {
        if (discountPrice == 0) {
            return 0;
        }
        System.out.println("크리스마스 디데이 할인: -" + df.format(discountPrice) + "원");
        return discountPrice;
    }

    private int weekdayDiscount(int discountPrice) {
        if (discountPrice == 0) {
            return 0;
        }
        System.out.println("평일 할인: -" + df.format(discountPrice) + "원");
        return discountPrice;
    }

    private int weekendDiscount(int discountPrice) {
        if (discountPrice == 0) {
            return 0;
        }
        System.out.println("주말 할인: -" + df.format(discountPrice) + "원");
        return discountPrice;
    }

    private int specialDiscount(int discountPrice) {
        if (discountPrice == 0) {
            return 0;
        }
        System.out.println("특별 할인: -" + df.format(discountPrice) + "원");
        return discountPrice;
    }

    private int giftPrice(int giftPrice) {
        if (giftPrice == 0) {
            return 0;
        }
        System.out.println("증정 이벤트: -" + df.format(giftPrice) + "원");
        return giftPrice;
    }

    private void printTotalDiscount(int totalDiscount) {
        System.out.println("<총혜택 금액>");

        if (totalDiscount == 0) {
            System.out.println("없음");
            return;
        }
        System.out.println("-" + df.format(totalDiscount) + "원");
    }

    private void printPaymentPrice(int totalDiscount) {
        System.out.println("<할인 후 예상 결제 금액>");
        int paymentPrice = order.getTotalPrice() - totalDiscount;

        System.out.println(df.format(paymentPrice) + "원");
    }

    private void printBadge(int totalDiscount) {
        System.out.println("<12월 이벤트 배지>");
        System.out.println(Event.badge(totalDiscount));
    }
}
