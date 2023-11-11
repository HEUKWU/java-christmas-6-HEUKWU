package christmas;

public enum Menu {
    MUSHROOM_SOUP("양송이수프", 6_000, "appetizer"),
    TAPAS("타파스", 5_500, "appetizer"),
    CAESAR_SALAD("시저샐러드", 8_000, "appetizer"),

    T_BONE_STEAK("티본스테이크", 55_000, "main"),
    BARBECUE_RIB("바비큐립", 54_000, "main"),
    SEAFOOD_PASTA("해산물파스타", 35_000, "main"),
    CHRISTMAS_PASTA("크리스마스파스타", 25_000, "main"),

    CHOCOLATE_CAKE("초코케이크", 15_000, "dessert"),
    ICE_CREAM("아이스크림", 5_000, "dessert"),

    ZERO_COKE("제로콜라", 3_000, "beverage"),
    RED_WINE("레드와인", 60_000, "beverage"),
    CHAMPAGNE("샴페인", 25_000, "beverage");

    private final String name;
    private final int price;
    private final String type;

    Menu(String name, int price, String type) {
        this.name = name;
        this.price = price;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public String getType() {
        return type;
    }
}
