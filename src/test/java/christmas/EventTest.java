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

    @Test
    @DisplayName("입력받은 날짜가 평일이면 디저트 개수만큼 할인을 받는다.")
    public void weekdayDiscount() {
        assertThat(Event.weekdayDiscount(5, 1)).isEqualTo(2_023);
    }

    @Test
    @DisplayName("입력받은 날짜가 평일이 아니면 할인을 받지 못한다.")
    public void notWeekdayDiscount() {
        assertThat(Event.weekdayDiscount(1, 1)).isEqualTo(0);
    }

    @Test
    @DisplayName("유요한 날짜를 입력하지 않았을 때 예외가 발생한다.")
    public void invalidDateWeekday() {
        assertThatThrownBy(() -> {
            int discountPrice = Event.weekdayDiscount(50, 1);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("입력받은 날짜가 주말이면 매인 메뉴 개수만큼 할인을 받는다.")
    public void weekendDiscount() {
        assertThat(Event.weekendDiscount(1, 1)).isEqualTo(2_023);
    }

    @Test
    @DisplayName("입력받은 날짜가 주말이 아니면 할인을 받지 못한다.")
    public void notWeekendDiscount() {
        assertThat(Event.weekendDiscount(5, 1)).isEqualTo(0);
    }

    @Test
    @DisplayName("유요한 날짜를 입력하지 않았을 때 예외가 발생한다.")
    public void invalidDateWeekend() {
        assertThatThrownBy(() -> {
            int discountPrice = Event.weekendDiscount(50, 1);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("입력받은 날짜가 스페셜 날짜면 할인을 받는다.")
    public void specialDayDiscount() {
        assertThat(Event.specialDiscount(25, 10_000)).isEqualTo(1_000);
    }

    @Test
    @DisplayName("입력받은 날짜가 스페셜 날짜가 아니면 할인을 받지 못한다.")
    public void notSpecialDayDiscount() {
        assertThat(Event.specialDiscount(1, 10_000)).isEqualTo(0);
    }

    @Test
    @DisplayName("유요한 날짜를 입력하지 않았을 때 예외가 발생한다.")
    public void invalidDateDiscount() {
        assertThatThrownBy(() -> {
            int discountPrice = Event.specialDiscount(50, 10_000);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}