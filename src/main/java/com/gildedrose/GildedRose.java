package com.gildedrose;

import java.util.Arrays;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
//        the_iñaki_you_owe_me_a_ramen_method();
        the_I_do_not_like_to_repair_things_method();
    }

    public void the_I_do_not_like_to_repair_things_method() {
        /*probably the most extended method, it consists on finding a way to increment the code entropy
        and finish asap.
        Pros ? -> if you have the ability to do it fast this is the most time efficient option, on the other hand if you
        don't fix it, this is the worst option because you haven't done nothing.
        */
        for (int i = 0; i < items.length; i++) {
            if (!items[i].name.equals("Aged Brie")
                    && !items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                if (items[i].quality > 0) {
                    if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                        items[i].quality = items[i].quality - 1;
                    }
                }
            } else {
                if (items[i].quality < 50) {
                    items[i].quality = items[i].quality + 1;

                    if (items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (items[i].sellIn < 11) {
                            if (items[i].quality < 50) {
                                items[i].quality = items[i].quality + 1;
                            }
                        }

                        if (items[i].sellIn < 6) {
                            if (items[i].quality < 50) {
                                items[i].quality = items[i].quality + 1;
                            }
                        }
                    }
                }
            }
            //With the help of bunch of tests you can find the place to find this code.
            if (items[i].name.equals("Conjured Mana Cake")) {
                items[i].quality = items[i].quality - 1;
                if (items[i].quality < 0) {
                    items[i].quality = 0;
                }
            }

            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                items[i].sellIn = items[i].sellIn - 1;
            }

            if (items[i].sellIn < 0) {
                if (!items[i].name.equals("Aged Brie")) {
                    if (!items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (items[i].quality > 0) {
                            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                                items[i].quality = items[i].quality - 1;
                            }
                        }
                    } else {
                        items[i].quality = items[i].quality - items[i].quality;
                    }
                } else {
                    if (items[i].quality < 50) {
                        items[i].quality = items[i].quality + 1;
                    }
                }
            }
        }
    }

    public void the_iñaki_you_owe_me_a_ramen_method() {

        Arrays.stream(items).forEach(item -> new JesusSolution(item).update());
    }

    public void the_i_am_the_best_work_colleague_of_the_world() {
        /*This method consists on fixing the legacy code and also fix the actual problem.
        Extracted from:
        https://www.youtube.com/watch?v=CIfBC56tPEI&feature=youtu.be&ab_channel=CodesaiDev
        Simply brilliant
         */

        //for better debug readability use this:
/*        for (Item item : items) {
            RegularItem.createRegularItem(item).age();
        }
*/
        Arrays.stream(items).forEach(item -> RegularItem.createRegularItem(item).age());
    }

}