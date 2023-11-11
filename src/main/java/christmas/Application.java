package christmas;

public class Application {
    public static void main(String[] args) {
        int date = repeatableReadDate();
        Order order = createOrder();

        OutputView output = new OutputView(order);
        output.printMenuInfo(date);
        output.printEventInfo(date);
    }

    private static int repeatableReadDate() {
        int date = 0;
        boolean errorFlag = true;

        while (true) {
            try {
                date = InputView.readDate();
                errorFlag = false;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
            if (!errorFlag) {
                return date;
            }
        }
    }

    private static Order createOrder() {
        Order order = null;
        boolean errorFlag = true;

        while (true) {
            String input = InputView.readOrder();
            try {
                order = Order.createOrder(input);
                errorFlag = false;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }

            if (!errorFlag) {
                return order;
            }
        }
    }
}
