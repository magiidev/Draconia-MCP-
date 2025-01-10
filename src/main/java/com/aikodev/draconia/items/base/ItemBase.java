package com.aikodev.draconia.items.base;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemBase extends Item
{
    private String name;

    public ItemBase(String name, CreativeTabs creativeTabs)
    {
        this.name = name;

        this.setUnlocalizedName(name);
        this.setCreativeTab(creativeTabs);
    }

    public String getName()
    {
        return name;
    }
}
