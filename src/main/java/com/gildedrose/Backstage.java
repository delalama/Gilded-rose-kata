package com.gildedrose;

public class Backstage implements DegradableItem {
    private final Item item;

    public Backstage(Item item) {
        this.item = item;
    }

    @Override
    public void age() {
        if (this.item.quality < 50) {
            this.item.quality = this.item.quality + 1;

            if (this.item.sellIn < 11) {
                if (this.item.quality < 50) {
                    this.item.quality = this.item.quality + 1;
                }
            }

            if (this.item.sellIn < 6) {
                if (this.item.quality < 50) {
                    this.item.quality = this.item.quality + 1;
                }
            }
        }

        this.item.sellIn = this.item.sellIn - 1;

        if (this.item.sellIn < 0) {
            this.item.quality = this.item.quality - this.item.quality;
        }

    }
}
