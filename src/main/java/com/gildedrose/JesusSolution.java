package com.gildedrose;

public class JesusSolution {

    private Item item;

    UpdateService updateService = new UpdateService();

    public JesusSolution(Item item) {
        this.item = item;
    }

    public void update() {
        if (itemIsAgedBrie()){
            updateService.updateAgedBrie(item);
        }else if (itemIsBackstage()){
            updateService.updateBackstage(item);
        }else if (itemIsConjured()){
            updateService.updateConjured(item);
        }else if (itemIsNotSulfuras()){
            updateService.standardUpdate(item);
        }
    }

    boolean itemIsNotSulfuras() {
        return !this.item.name.equals("Sulfuras, Hand of Ragnaros");
    }

    boolean itemIsAgedBrie() {
        return this.item.name.equals("Aged Brie");
    }

    boolean itemIsBackstage() {
        return this.item.name.equals("Backstage passes to a TAFKAL80ETC concert");
    }

    boolean itemIsConjured() {
        return this.item.name.equals("Conjured Mana Cake");
    }


}
