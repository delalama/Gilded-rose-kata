package com.gildedrose;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        Stream.of(items).forEach(item -> item = updateItem(item));
    }

    public Item updateItem(Item item) {
        boolean itemIsSulfuras = item.name.equals("Sulfuras, Hand of Ragnaros");
        boolean itemIsAgesBrie = item.name.equals("Aged Brie");
        boolean itemIsConjuredManaCake = item.name.equals("Conjured Mana Cake");
        boolean itemIsBackstagePasses = item.name.equals("Backstage passes to a TAFKAL80ETC concert");

        if (isRegisteredItem(item)) {
            if (itemIsSulfuras) {

            } else if (itemIsAgesBrie) {
                item.sellIn--;
                item.quality++;

            } else if(itemIsBackstagePasses) {
                if( item.sellIn > 5 && item.sellIn <=10 ){
                    item.sellIn--;
                    item.quality = item.quality + 2;
                }else if(item.sellIn >= 0 && item.sellIn <= 5){
                    item.sellIn--;
                    item.quality = item.quality + 3;
                }else{
                    item.sellIn--;
                    item.quality++;
                }
            } else {
                if (itemIsConjuredManaCake) {
                    item.quality--;
                }
                decreaseItem(item);
            }
        } else {
            item.name = "fixme";
            decreaseItem(item);
        }
        item = itemIsSulfuras? item: sellInAndQualityProperties(item);
        return item;
    }


    private void decreaseItem(Item item) {
        item.sellIn--;
        item.quality--;
    }

    private boolean isRegisteredItem(Item item) {
        List<String> registeredItem = Arrays.asList("+5 Dexterity Vest", "Aged Brie", "Elixir of the Mongoose", "Sulfuras, Hand of Ragnaros", "Backstage passes to a TAFKAL80ETC concert", "Conjured Mana Cake");
        return registeredItem.contains(item.name);
    }

    private Item sellInAndQualityProperties(Item item) {
        if (item.quality > 50) {
            item.quality = 50;
        }
        if (item.sellIn < 0) {
            item.sellIn = 0;
        }
        return item;
    }

}