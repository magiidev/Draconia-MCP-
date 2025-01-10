package com.aikodev.draconia.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class VoidStone extends Item
{

    public VoidStone(String name, CreativeTabs tab)
    {
        this.setUnlocalizedName(name);
        this.setCreativeTab(tab);

        this.setMaxStackSize(1);
        this.setMaxDamage(100);
    }

    @Override
    public ItemStack onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn)
    {
        return super.onItemRightClick(itemStackIn, worldIn, playerIn);
    }
}
