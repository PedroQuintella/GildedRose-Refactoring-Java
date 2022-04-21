package com.gildedrose;

class GildedRose {
    Item[] items;

    public static final int MIN_QUALITY = 0;
    public static final int MAX_QUALITY = 50;
    public static final String AGED_BRIE_CHEESE = "Aged Brie";
    public static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    public static final String SULFURAS_ITEM = "Sulfuras, Hand of Ragnaros";

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            updateItemQuality(item);
        }
    }

    public void updateItemQuality(Item item) {
        if (!item.name.equals(AGED_BRIE_CHEESE) && !item.name.equals(BACKSTAGE_PASSES)) {
            if (item.quality > MIN_QUALITY) {
                if (!item.name.equals(SULFURAS_ITEM)) {
                    decreaseQuality(item);
                }
            }
        } else {
            if (item.quality < MAX_QUALITY) {
                increaseQuality(item);

                if (item.name.equals(BACKSTAGE_PASSES)) {
                    if (item.sellIn < 11) {
                        if (item.quality < MAX_QUALITY) {
                            increaseQuality(item);
                        }
                    }
                    if (item.sellIn < 6) {
                        if (item.quality < MAX_QUALITY) {
                            increaseQuality(item);
                        }
                    }
                }
            }
        }
        if (!item.name.equals(SULFURAS_ITEM)) {
            item.sellIn = item.sellIn - 1;
        }
        if (item.sellIn < MIN_QUALITY) {
            if (!item.name.equals(AGED_BRIE_CHEESE)) {
                if (!item.name.equals(BACKSTAGE_PASSES)) {
                    if (item.quality > MIN_QUALITY) {
                        if (!item.name.equals(SULFURAS_ITEM)) {
                            decreaseQuality(item);
                        }
                    }
                } else {
                    item.quality = item.quality - item.quality;
                }
            } else {
                if (item.quality < MAX_QUALITY) {
                    increaseQuality(item);
                }
            }
        }
    }

    public void increaseQuality(Item item) {
        item.quality = item.quality + 1;
    }

    public void decreaseQuality(Item item) {
        item.quality = item.quality - 1;
    }
}
