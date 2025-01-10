package com.aikodev.draconia.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class TNTStick extends Item
{
    public TNTStick(String name, CreativeTabs tab)
    {
        this.setUnlocalizedName(name);
        this.setCreativeTab(tab);

        this.setMaxStackSize(1);
        this.setMaxDamage(10);
    }

    @Override
    public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player)
    {
        player.setItemInUse(itemStack, getMaxItemUseDuration(itemStack));
        return itemStack;
    }

    @Override
    public ItemStack onItemUseFinish(ItemStack itemStack, World world, EntityPlayer player)
    {
        itemStack.damageItem(1, player);

        if(!world.isRemote)
        {
            world.newExplosion(player, player.posX, player.posY, player.posZ, 5F, false, true);
        }

        return itemStack;
    }

    public int getMaxItemUseDuration(ItemStack itemStack)
    {
        return 32;
    }

    @Override
    public EnumAction getItemUseAction(ItemStack stack)
    {
        return EnumAction.BOW;
    }
}
