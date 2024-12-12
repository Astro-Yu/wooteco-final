package store.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import store.model.Item;
import store.model.Promotion;
import store.model.PromotionPolicy;
import store.model.Promotions;
import store.model.Warehouse;
import store.util.FileReader;
import store.util.StringSplitter;

public class StoreConfig {
    private static final String ITEM_PATH = "java-convenience-store-7/src/main/resources/products.md";
    private static final String PROMOTION_PATH = "java-convenience-store-7/src/main/resources/promotions.md";

    public Warehouse loadWarehouse() {
        String rawItems = FileReader.readFile(ITEM_PATH);
        List<String> splittedRawItems = StringSplitter.splitByDelimiter(rawItems, "\n");

        List<Item> items = new ArrayList<>();
        for (String rawItem : splittedRawItems) {
            List<String> splittedRawItem = StringSplitter.splitByDelimiter(rawItem, ",");
            String name = splittedRawItem.get(0);
            int price = Integer.getInteger(splittedRawItem.get(1));
            int quantity = Integer.getInteger(splittedRawItem.get(2));
            String promotionName = splittedRawItem.get(3);

            Item item = new Item(name, price, promotionName, quantity);
            items.add(item);
        }
        return new Warehouse(items);
    }

    public Promotions loadPromotions() {
        String rawItems = FileReader.readFile(ITEM_PATH);
        List<String> splittedRawPromotions = StringSplitter.splitByDelimiter(rawItems, "\n");

        Map<String, Promotion> promotions = new HashMap<>();
        for (String rawPromotion : splittedRawPromotions) {
            List<String> splittedRawPromotion = StringSplitter.splitByDelimiter(rawPromotion, ",");
            String name = splittedRawPromotion.get(0);
            int buy = Integer.getInteger(splittedRawPromotion.get(1));
            int get = Integer.getInteger(splittedRawPromotion.get(2));
            String startDate = splittedRawPromotion.get(3);
            String endDate = splittedRawPromotion.get(4);

            PromotionPolicy promotionPolicy = new PromotionPolicy(buy, get);
            Promotion promotion = new Promotion(name, promotionPolicy, startDate, endDate);
            promotions.put(name, promotion);
        }
        return new Promotions(promotions);
    }
}
