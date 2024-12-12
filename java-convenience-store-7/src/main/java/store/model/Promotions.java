package store.model;

import java.util.Map;

public class Promotions {

    private final Map<String, Promotion> promotions;

    public Promotions(Map<String, Promotion> promotions) {
        this.promotions = promotions;
    }

    public Promotion searchPromotion(String promotionName) {
        return promotions.get(promotionName);
    }
}
