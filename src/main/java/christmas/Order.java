package christmas;

import java.util.HashMap;
import java.util.Map;

public class Order {
    private static final int MAX_ORDER_COUNT = 20;

    private final Map<String, Integer> orders;

    public Order(Map<String, Integer> orders) {
        this.orders = orders;
    }

    public static Order createOrder(String input) {
        String[] inputSplit = inputValidate(input);
        Map<String, Integer> orders = new HashMap<>();

        for (String menu : inputSplit) {
            String[] menus = menuFormValidate(menu);
            orders.put(menus[0], Integer.parseInt(menus[1]));
        }

        duplicateMenuValidate(inputSplit, orders);
        orderValidate(orders);
        orderCountValidate(orders);

        return new Order(orders);
    }

    private static String[] inputValidate(String input) {
        if (input == null || "".equals(input)) {
            throw new IllegalArgumentException("[ERROR] 주문 정보를 입력해주세요.");
        }

        return input.replaceAll(" ", "").split(",");
    }

    private static String[] menuFormValidate(String menu) {
        if (!menu.contains("-")) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }

        String[] split = menu.split("-");
        menuExistValidate(split[0]);
        menuCountValidate(split[1]);

        return split;
    }

    private static void menuExistValidate(String menu) {
        int count = 0;

        Menu[] values = Menu.values();
        for (Menu value : values) {
            if (value.getName().equals(menu)) {
                count++;
            }
        }

        if (count == 0) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }

    private static void menuCountValidate(String s) {
        final int count;

        try {
            count = Integer.parseInt(s);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }

        if (count < 1) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }

    private static void duplicateMenuValidate(String[] menus, Map<String, Integer> orders) {
        if (menus.length != orders.size()) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }

    private static void orderValidate(Map<String, Integer> orders) {
        int count = 0;

        Menu[] menus = Menu.values();
        for (Menu menu : menus) {
            if (orders.containsKey(menu.getName())) {
                if (!menu.getType().equals("beverage")) {
                    count++;
                }
            }
        }

        if (count == 0) {
            throw new IllegalArgumentException("[ERROR] 음료만 주문은 불가합니다.");
        }
    }

    private static void orderCountValidate(Map<String, Integer> orders) {
        int count = 0;

        for (Integer value : orders.values()) {
            count += value;
        }

        if (count > MAX_ORDER_COUNT) {
            throw new IllegalArgumentException("[ERROR] 메뉴는 한 번에 최대 20개까지만 주문할 수 있습니다.");
        }
    }
}
