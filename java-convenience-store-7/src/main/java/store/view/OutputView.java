package store.view;

import java.util.List;
import store.model.dto.ItemDto;

public class OutputView {
    private static final String ITEM_FORMAT = "- %s %,d원 %s개 %s";

    public void printItems(List<ItemDto> itemDtos) {
        for (ItemDto itemDto : itemDtos) {
            printItem(itemDto);
        }
    }

    private void printItem(ItemDto itemDto) {
        String message = String.format(ITEM_FORMAT, itemDto.name(), itemDto.price(), itemDto.quantity(),
                itemDto.promotionName());

        System.out.println(message);
    }
}
