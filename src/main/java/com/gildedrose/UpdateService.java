package com.gildedrose;

public class UpdateService {

    public UpdateService() {

    }

    public void updateAgedBrie(Item item) {
        item.sellIn--;
        item.quality++;
        postProcess(item);

    }

    public void updateBackstage(Item item) {
        item.sellIn--;
        if (item.sellIn <= 10 && item.sellIn > 5) {
            item.quality += 2;
        } else if (item.sellIn <= 5 && item.sellIn >= 0) {
            item.quality += 3;
        } else if (item.sellIn < 0) {
            item.quality = 0 ;
        }

        postProcess(item);
    }

    public void updateConjured(Item item) {
        item.sellIn --;
        item.quality -= 2;
        postProcess(item);
    }

    public void standardUpdate(Item item) {
        item.sellIn --;
        item.quality --;
        postProcess(item);
    }

    private void postProcess(Item item) {
        if(item.sellIn < 0){
            item.quality--;
        }
        if(item.quality<0){
            item.quality = 0 ;
        }
        if(item.quality > 50){
            item.quality = 50;
        }
    }
}
