package christmas;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class OrderTest {

    @Test
    @DisplayName("메뉴판에 없는 메뉴 입력시 예외가 발생한다.")
    public void nonExistMenu() {
        assertThatThrownBy(() -> Order.createOrder("타파스 - 1, 제로사이다 - 1")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("메뉴 형식이 잘못되면 예외가 발생한다.")
    public void MenuInvalidForm() {
        assertThatThrownBy(() -> Order.createOrder("타파스 : 1, 제로콜라 : 1")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("메뉴 개수 1개 미만 입력시 예외가 발생한다.")
    public void menuInvalidCount() {
        assertThatThrownBy(() -> Order.createOrder("타파스 - 0, 제로콜라 - 1")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("메뉴가 중복되는 경우 예외가 발생한다.")
    public void duplicatMenu() {
        assertThatThrownBy(() -> Order.createOrder("시저샐러드 - 1, 티본스테이크 - 1, 티본스테이크 - 1")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("음료만 주문시에 예외가 발생한다.")
    public void onlyBeverageOrder() {
        assertThatThrownBy(() -> Order.createOrder("제로콜라 - 4")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("최대 주문 가능 개수를 넘어서면 예외가 발생한다.")
    public void overMaxOrderCount() {
        assertThatThrownBy(() -> Order.createOrder("시저샐러드 - 7, 티본스테이크 - 7, 제로콜라 - 7")).isInstanceOf(IllegalArgumentException.class);
    }
}