package com.gildedrose;

import java.util.Arrays;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        Arrays.stream(items).forEach(this::age);
    }

    private void age(Item item) {
        boolean aged_brie = item.name.equals("Aged Brie");
        if (!aged_brie
                && !item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
            if (item.quality > 0) {
                if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                    item.quality = item.quality - 1;
                }
            }
        } else {
            if (item.quality < 50) {
                item.quality = item.quality + 1;

                if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                    if (item.sellIn < 11) {
                        if (item.quality < 50) {
                            item.quality = item.quality + 1;
                        }
                    }

                    if (item.sellIn < 6) {
                        if (item.quality < 50) {
                            item.quality = item.quality + 1;
                        }
                    }
                }
            }
        }

        if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
            item.sellIn = item.sellIn - 1;
        }

        if (item.sellIn < 0) {
            if (!aged_brie) {
                if (!item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                    if (item.quality > 0) {
                        if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                            item.quality = item.quality - 1;
                        }
                    }
                } else {
                    item.quality = item.quality - item.quality;
                }
            } else {
                if (item.quality < 50) {
                    item.quality = item.quality + 1;
                }
            }
        }
    }

//    //New code
//    public Item updateItem2(Item item) {
//        boolean itemIsSulfuras = item.name.equals("Sulfuras, Hand of Ragnaros");
//        boolean itemIsAgesBrie = item.name.equals("Aged Brie");
//        boolean itemIsConjuredManaCake = item.name.equals("Conjured Mana Cake");
//        boolean itemIsBackstagePasses = item.name.equals("Backstage passes to a TAFKAL80ETC concert");
//
//        if (isRegisteredItem(item)) {
//            if (itemIsSulfuras) {
//
//            } else if (itemIsAgesBrie) {
//                item.sellIn--;
//                item.quality++;
//
//            } else if(itemIsBackstagePasses) {
//                if( item.sellIn > 5 && item.sellIn <=10 ){
//                    item.sellIn--;
//                    item.quality = item.quality + 2;
//                }else if(item.sellIn >= 0 && item.sellIn <= 5){
//                    item.sellIn--;
//                    item.quality = item.quality + 3;
//                }else{
//                    item.sellIn--;
//                    item.quality++;
//                }
//            } else {
//                if (itemIsConjuredManaCake) {
//                    item.quality--;
//                }
//                standardItemDecrease(item);
//            }
//        } else {
//            item.name = "fixme";
//            standardItemDecrease(item);
//        }
//        item = itemIsSulfuras? item: sellInAndQualityProperties(item);
//        return item;
//    }
//
//
//    private void standardItemDecrease(Item item) {
//        item.sellIn--;
//        item.quality--;
//    }
//
//    private boolean isRegisteredItem(Item item) {
//        List<String> registeredItem = Arrays.asList("+5 Dexterity Vest", "Aged Brie", "Elixir of the Mongoose", "Sulfuras, Hand of Ragnaros", "Backstage passes to a TAFKAL80ETC concert", "Conjured Mana Cake");
//        return registeredItem.contains(item.name);
//    }
//
//    private Item sellInAndQualityProperties(Item item) {
//        if (item.sellIn < 0) {
//            item.sellIn = 0;
//        }
//        if (item.quality > 50) {
//            item.quality = 50;
//        return item;
//    }
//*/

}