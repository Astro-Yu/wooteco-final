package store.model;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Warehouse {
    private final List<Item> items;

    public Warehouse(List<Item> items) {
        this.items = items;
    }

    public boolean isNotExist(String itemName) {
        Set<String> itemNames = items.stream()
                .map(Item::getName)
                .collect(Collectors.toSet());

        return !itemNames.contains(itemName);
    }

    public boolean exceedQuantity(String itemName, int quantity) {
        int totalQuantity = items.stream().
                filter(item -> item.getName().equals(itemName))
                .mapToInt(Item::getQuantity)
                .sum();

        return totalQuantity < quantity;
    }

    public void removePromotionItemQuantity(Promotions promotions, LocalDate today, int quantity) {
        Item promotionItem = items.stream()
                .filter(item -> item.isPromotionActivated(promotions, today))
                .findFirst()
                .get();

        promotionItem.removeQuantity(quantity);
    }

    public void removeNotPromotionItemQuantity(Promotions promotions, LocalDate today, int quantity) {
        Item promotionItem = items.stream()
                .filter(item -> !item.isPromotionActivated(promotions, today))
                .findFirst()
                .get();

        promotionItem.removeQuantity(quantity);
    }
}
