package com.gildedrose;

import org.approvaltests.combinations.CombinationApprovals;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;


public class GoldenMasterOwnApprovalTest {

    @Test
    public void
    gildedRoseApprovalTest() {
        CombinationApprovals.verifyAllCombinations(
                this::updateItem,
                new String[]{"anyItem", "+5 Dexterity Vest", "Aged Brie", "Elixir of the Mongoose", "Sulfuras, Hand of Ragnaros", "Backstage passes to a TAFKAL80ETC concert", "Iñaki me debes un ramen"},
                range(-1, 51),
                range(-1, 12)
        );
    }

    private Item updateItem(String name, int sellIn, int quality) {
        Item it = new ItemBuilder()
                .setName(name)
                .setSellIn(sellIn)
                .setQuality(quality)
                .createItem();

        new GildedRose(new Item[]{it}).updateQuality();

        return it;
    }

    private Integer[] range(int initial, int end) {
        return IntStream.range(initial, end).boxed().toArray(Integer[]::new);
    }
}
