package store.model;

import java.time.LocalDate;
import store.util.DateComparator;

public class Promotion {
    private final String promotionName;
    private final PromotionPolicy promotionPolicy;
    private final String startDay;
    private final String endDay;

    public Promotion(String promotionName, PromotionPolicy promotionPolicy, String startDay, String endDay) {
        this.promotionName = promotionName;
        this.promotionPolicy = promotionPolicy;
        this.startDay = startDay;
        this.endDay = endDay;
    }

    public boolean isActivate(LocalDate today) {
        return DateComparator.isDateInRange(startDay, endDay, today);
    }
}
