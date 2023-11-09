package christmas;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class EventTest {

    @Test
    @DisplayName("금액과 날짜를 입력하면 할인 금액을 알 수 있다.")
    public void getDiscountPrice() {
        assertThat(Event.christmasDDayDiscount(10_000, 25)).isEqualTo(3_400);
    }

    @Test
    @DisplayName("이벤트 종료일자를 넘어서는 날짜 입력시에는 할인이 불가하다.")
    public void overEndDateDiscountX() {
        assertThat(Event.christmasDDayDiscount(1_000, 31)).isEqualTo(0);
    }

    @Test
    @DisplayName("유요한 날짜를 입력하지 않았을 때 예외가 발생한다.")
    public void invalidDateInput() {
        assertThatThrownBy(() -> {
            int discountPrice = Event.christmasDDayDiscount(50_000, 33);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}