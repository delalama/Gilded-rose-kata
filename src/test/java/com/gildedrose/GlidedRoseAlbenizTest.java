package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GlidedRoseAlbenizTest {

    private static final String AGED_BRIE = "Aged Brie";
    private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    private static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    private static final String CONJURED = "Conjured Mana Cake";

    @Test
    void sell_in_days_should_degrade_by_one() {

        Item item = new ItemBuilder().setName("foo").setSellIn(10).setQuality(20).createItem();
        GildedRose gildedRose = new GildedRose(new Item[]{item});

        gildedRose.updateQuality();

        assertEquals(9, gildedRose.items[0].sellIn);
    }

    @Test
    void quality_should_degrade_by_one_when_the_sell_in_days_has_not_passed() {

        Item item = new ItemBuilder().setName("foo").setSellIn(10).setQuality(20).createItem();
        GildedRose gildedRose = new GildedRose(new Item[]{item});

        gildedRose.updateQuality();

        assertEquals(19, gildedRose.items[0].quality);
    }

    @Test
    void quality_should_degrade_twice_as_fast_when_the_sell_in_days_has_passed() {

        Item item = new ItemBuilder().setName("foo").setSellIn(0).setQuality(20).createItem();
        GildedRose gildedRose = new GildedRose(new Item[]{item});

        gildedRose.updateQuality();

        assertEquals(18, gildedRose.items[0].quality);
    }

    @Test
    void quality_should_not_be_negative() {
            Item item = new Item("foo", 0 , 0);
            GildedRose gildedRose = new GildedRose(new Item[]{item});

            gildedRose.updateQuality();

            assertEquals( 0,item.quality);
    }

    @Test
    public void quality_is_never_more_than_50() {
        Item item = new Item("foo" , 50, 50);
        GildedRose gildedRose = new GildedRose(new Item[]{item});

        gildedRose.updateQuality();

        assertEquals( 49, gildedRose.items[0].quality);
    }

    //Specific item tests
    @Test
    void quality_should_increase_when_aged_brie_item() {

        Item item = new ItemBuilder().setName(AGED_BRIE).setSellIn(10).setQuality(0).createItem();
        GildedRose gildedRose = new GildedRose(new Item[]{item});

        gildedRose.updateQuality();

        assertEquals(1, gildedRose.items[0].quality);
    }
    @Test
    void quality_should_and_sellin_should_not_decrease_when_sulfuras_item() {

        Item item = new ItemBuilder().setName(SULFURAS).setSellIn(10).setQuality(10).createItem();
        GildedRose gildedRose = new GildedRose(new Item[]{item});

        gildedRose.updateQuality();

        assertEquals(10, gildedRose.items[0].quality);
        assertEquals(10, gildedRose.items[0].sellIn);
    }

    @Test
    public void quality_increase_by_2_when_sellin_between_10_and_6_on_backstagePasses() {

        Item anyItem = new ItemBuilder()
                .setName(BACKSTAGE_PASSES)
                .setSellIn(7)
                .setQuality(7)
                .createItem();

        new GildedRose(new Item[]{anyItem}).updateQuality();

        assertEquals(9,anyItem.quality);

    }

    @Test
    public void quality_increase_by_3_when_sellin_between_5_and_0_on_backstagePasses() {

        Item anyItem = new ItemBuilder()
                .setName(BACKSTAGE_PASSES)
                .setSellIn(5)
                .setQuality(7)
                .createItem();

        new GildedRose(new Item[]{anyItem}).updateQuality();

        assertEquals(10,anyItem.quality);

    }

    @Test
    public void quality_should_decrease_twice_when_conjurer_item() {

        Item anyItem = new ItemBuilder()
                .setName(CONJURED)
                .setSellIn(5)
                .setQuality(7)
                .createItem();

        new GildedRose(new Item[]{anyItem}).updateQuality();

        assertEquals(5,anyItem.quality);

    }

    @Test
    public void quality_should_not_be_over_50_except_sulfuras_item() {

        Item sulfuras = new ItemBuilder()
                .setName(SULFURAS)
                .setSellIn(5)
                .setQuality(140)
                .createItem();
        Item aged = new ItemBuilder()
                .setName(AGED_BRIE)
                .setSellIn(5)
                .setQuality(50)
                .createItem();
        Item backstage = new ItemBuilder()
                .setName(BACKSTAGE_PASSES)
                .setSellIn(5)
                .setQuality(55)
                .createItem();
        Item conjured = new ItemBuilder()
                .setName(CONJURED)
                .setSellIn(5)
                .setQuality(60)
                .createItem();

        new GildedRose(new Item[]{aged,backstage, conjured, sulfuras}).updateQuality();

        boolean over_50 = true;
        assertArrayEquals(new int[]{50,50,50,140}, new int[]{aged.quality, backstage.quality, conjured.quality, sulfuras.quality});

    }

    @Test
    public void quality_should_not_be_negative_when_foo_item() {
        Item anyItem = new ItemBuilder()
                .setName("foo")
                .setSellIn(5)
                .setQuality(0)
                .createItem();

        new GildedRose(new Item[]{anyItem}).updateQuality();

        assertEquals(0,anyItem.quality);
    }

    @Test
    public void quality_should_not_be_negative_when_special_item() {
        Item aged = new ItemBuilder()
                .setName(AGED_BRIE)
                .setSellIn(5)
                .setQuality(0)
                .createItem();
        Item backstage = new ItemBuilder()
                .setName(BACKSTAGE_PASSES)
                .setSellIn(0)
                .setQuality(0)
                .createItem();
        Item conjured = new ItemBuilder()
                .setName(CONJURED)
                .setSellIn(5)
                .setQuality(0)
                .createItem();
        Item sulfuras = new ItemBuilder()
                .setName(SULFURAS)
                .setSellIn(5)
                .setQuality(0)
                .createItem();

        new GildedRose(new Item[]{aged, backstage, conjured, sulfuras}).updateQuality();

        assertEquals(1,aged.quality);
        assertEquals(0,backstage.quality);
        assertEquals(0,conjured.quality);
        assertEquals(0,sulfuras.quality);
    }

}
