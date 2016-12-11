package Random;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Kunal on 12/10/2016.
 */
public class ShoppingCart {

    private static Map<String, Integer> shoppingBag;
    private static Integer bagTotal;

    class Item {
        String itemLabel;
        Double priceEach;
        Integer itemsPerBundle;
        Double bundlePrice;

        public Item(String itemLabel, Double priceEach) {
            this.itemLabel = itemLabel;
            this.priceEach = priceEach;
        }

        public Item(String itemLabel, Double priceEach, Integer itemsPerBundle, Double bundlePrice) {
            this.itemLabel = itemLabel;
            this.priceEach = priceEach;
            this.itemsPerBundle = itemsPerBundle;
            this.bundlePrice = bundlePrice;
        }

        public String getItemLabel() {
            return itemLabel;
        }

        public void setItemLabel(String itemLabel) {
            this.itemLabel = itemLabel;
        }

        public Double getPriceEach() {
            return priceEach;
        }

        public void setPriceEach(Double priceEach) {
            this.priceEach = priceEach;
        }

        public Integer getItemsPerBundle() {
            return itemsPerBundle;
        }

        public void setItemsPerBundle(Integer itemsPerBundle) {
            this.itemsPerBundle = itemsPerBundle;
        }

        public Double getBundlePrice() {
            return bundlePrice;
        }

        public void setBundlePrice(Double bundlePrice) {
            this.bundlePrice = bundlePrice;
        }
    }

    private Map<String, Item> itemInventory = new HashMap<>();

    public void setPricing(Item item) {
        itemInventory.put(item.getItemLabel(), item);
    }

    public void scan(String itemLabel) {
        Item currentItem = itemInventory.get(itemLabel);
        Integer currentItemCount = shoppingBag`
    }
}
