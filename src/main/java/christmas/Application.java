package christmas;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Order order = Order.createOrder("티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1");
        OutputView output = new OutputView(order);
        output.printMenuInfo();
        output.printEventInfo(3);
    }
}
