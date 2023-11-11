package christmas;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final int EVENT_START_DATE = 1;
    private static final int EVENT_END_DATE = 31;

    public static int readDate() {
        System.out.println("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)");
        String input = Console.readLine();

        int date = numberFormatValidate(input);
        validateDate(date);

        return date;
    }

    public static String readOrder() {
        System.out.println("주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)");
        return Console.readLine();
    }

    private static int numberFormatValidate(String input) {
        int date;
        try {
            date = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
        }

        return date;
    }

    private static void validateDate(int date) {
        if (date < EVENT_START_DATE || date > EVENT_END_DATE) {
            throw new IllegalArgumentException("[error] 유효하지 않은 날짜입니다. 다시 입력해주세요.");
        }
    }
}
