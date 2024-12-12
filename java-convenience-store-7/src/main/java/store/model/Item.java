package store.model;

import java.time.LocalDate;

public class Item {
    private final String name;
    private final int price;
    private final String promotionName;
    private int quantity;

    public Item(String name, int price, String promotionName, int quantity) {
        this.name = name;
        this.price = price;
        this.promotionName = promotionName;
        this.quantity = quantity;
    }

    public boolean isPromotionActivated(Promotions promotions, LocalDate today) {
        Promotion currentPromotion = promotions.searchPromotion(promotionName);

        return currentPromotion.isActivate(today);
    }

    public void removeQuantity(int removingQuantity) {
        quantity -= removingQuantity;
    }

    public void addQuantity(int addedQuantity) {
        quantity += addedQuantity;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public String getPromotionName() {
        return promotionName;
    }

    public int getQuantity() {
        return quantity;
    }
}
