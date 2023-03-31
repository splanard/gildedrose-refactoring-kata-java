package com.gildedrose;

public class ItemWrapper {

    private final Item item;

    public ItemWrapper(String name) {
        this.item = new Item(name, 0, 0);
    }

    public Item getItem(){
        return this.item;
    }

    public ItemWrapper toSellIn(int sellIn){
        this.item.sellIn = sellIn;
        return this;
    }

    public Item withQuality(int quality){
        this.item.quality = quality;
        return this.item;
    }
}
