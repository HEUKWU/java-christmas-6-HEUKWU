package christmas;

public enum Badge {

    SANTA("산타", 20_000),
    TREE("트리", 10_000),
    STAR("별", 5_000),
    ;

    private final String badge;
    private final int price;

    Badge(String badge, int price) {
        this.badge = badge;
        this.price = price;
    }

    public String getBadge() {
        return badge;
    }

    public int getPrice() {
        return price;
    }
}
