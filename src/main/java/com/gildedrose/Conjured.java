package com.gildedrose;

public class Conjured implements DegradableItem {
    private final Item item;

    public Conjured(Item item) {
        this.item = item;
    }

    @Override
    public void age() {
            this.item.quality = this.item.quality - 2;
            if (this.item.quality < 0) {
                this.item.quality = 0;
            }
    }
}
