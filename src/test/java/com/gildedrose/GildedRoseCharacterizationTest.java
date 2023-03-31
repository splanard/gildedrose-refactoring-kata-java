package com.gildedrose;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class GildedRoseCharacterizationTest {

    private final List<Item> items = new ArrayList<>();

    @Test
    void shouldUpdateItemsQuality() {
        Item dexterityVest = givenAnItem("+5 Dexterity Vest").toSellIn(10).withQuality(20);
        Item agedBrie = givenAnItem("Aged Brie").toSellIn(2).withQuality(0);
        Item mongooseElixir = givenAnItem("Elixir of the Mongoose").toSellIn(5).withQuality(7);
        Item sulfuras = givenAnItem("Sulfuras, Hand of Ragnaros").toSellIn(0).withQuality(80);
        Item sulfurasNegativeSellIn = givenAnItem("Sulfuras, Hand of Ragnaros").toSellIn(-1).withQuality(80);
        Item backstagePass15Days = givenAnItem("Backstage passes to a TAFKAL80ETC concert").toSellIn(15).withQuality(20);
        Item backstagePass10Days = givenAnItem("Backstage passes to a TAFKAL80ETC concert").toSellIn(10).withQuality(49);
        Item backstagePass5Days = givenAnItem("Backstage passes to a TAFKAL80ETC concert").toSellIn(5).withQuality(49);
        Item conjuredManaCake = givenAnItem("Conjured Mana Cake").toSellIn(3).withQuality(6);

        whenUpdatingQuality();

        assertThat(dexterityVest.sellIn).isEqualTo(9);
        assertThat(dexterityVest.quality).isEqualTo(19);

        assertThat(agedBrie.sellIn).isEqualTo(1);
        assertThat(agedBrie.quality).isEqualTo(1);

        assertThat(mongooseElixir.sellIn).isEqualTo(4);
        assertThat(mongooseElixir.quality).isEqualTo(6);

        assertThat(sulfuras.sellIn).isEqualTo(0);
        assertThat(sulfuras.quality).isEqualTo(80);

        assertThat(sulfurasNegativeSellIn.sellIn).isEqualTo(-1);
        assertThat(sulfurasNegativeSellIn.quality).isEqualTo(80);

        assertThat(backstagePass15Days.sellIn).isEqualTo(14);
        assertThat(backstagePass15Days.quality).isEqualTo(21);

        assertThat(backstagePass10Days.sellIn).isEqualTo(9);
        assertThat(backstagePass10Days.quality).isEqualTo(50);

        assertThat(backstagePass5Days.sellIn).isEqualTo(4);
        assertThat(backstagePass5Days.quality).isEqualTo(50);

        assertThat(conjuredManaCake.sellIn).isEqualTo(2);
        assertThat(conjuredManaCake.quality).isEqualTo(5);
    }

    private ItemWrapper givenAnItem(String itemName){
        ItemWrapper itemWrapper = new ItemWrapper(itemName);
        this.items.add(itemWrapper.getItem());
        return itemWrapper;
    }

    private void whenUpdatingQuality(){
        new GildedRose(items.toArray(new Item[0])).updateQuality();
    }

}
