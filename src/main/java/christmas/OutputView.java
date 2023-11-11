package christmas;

import java.text.DecimalFormat;
import java.util.Map;

public class OutputView {

    public void printMenu(Order order) {
        System.out.println("<주문 메뉴>");
        Map<String, Integer> orders = order.getOrders();
        for (String s : orders.keySet()) {
            System.out.println(s + " " + orders.get(s) + "개");
        }
    }

    public void printTotalPrice(Order order) {
        System.out.println("<할인 전 총주문 금액>");
        Map<String, Integer> orders = order.getOrders();
        int price = 0;

        Menu[] menus = Menu.values();
        for (Menu menu : menus) {
            if (orders.containsKey(menu.getName())) {
                price += (menu.getPrice() * orders.get(menu.getName()));
            }
        }

        DecimalFormat df = new DecimalFormat("###,###");
        System.out.println(df.format(price) + "원");
    }
}
