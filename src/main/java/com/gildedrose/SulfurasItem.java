package com.gildedrose;

public class SulfurasItem implements DegradableItem{
    private final Item item;

    public SulfurasItem(Item item) {
        this.item = item;
    }

    @Override
    public void age() {
        if (this.item.quality > 0) {
        }

        if (this.item.sellIn < 0) {
            if (this.item.quality > 0) {
            }
        }

    }
}
