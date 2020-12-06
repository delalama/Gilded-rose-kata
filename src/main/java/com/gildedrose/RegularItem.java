package com.gildedrose;

public class RegularItem implements DegradableItem {
    private Item item;

    protected RegularItem(Item item) {
        this.item = item;
    }

    public static DegradableItem createRegularItem(Item item) {
        if(item.name.equals("Sulfuras, Hand of Ragnaros")) return new SulfurasItem(item);
        if(item.name.equals("Aged Brie")) return new AgedBrie(item);
        if(item.name.equals("Backstage passes to a TAFKAL80ETC concert")) return new Backstage(item);
        if(item.name.equals("Conjured Mana Cake")) return new Conjured(item);
        return new RegularItem(item);
    }

    @Override
    public void age() {
        if (this.item.quality > 0) {
            this.item.quality = this.item.quality - 1;
        }

        this.item.sellIn = this.item.sellIn - 1;

        if (this.item.sellIn < 0) {
            if (this.item.quality > 0) {
                this.item.quality = this.item.quality - 1;
            }
        }
    }
}