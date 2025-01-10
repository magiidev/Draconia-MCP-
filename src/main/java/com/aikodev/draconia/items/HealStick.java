package com.aikodev.draconia.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import java.util.List;

public class HealStick extends Item
{
    public HealStick(String name, CreativeTabs tab)
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
        if(!player.capabilities.isCreativeMode)
        {
            if(player.getHealth() == player.getMaxHealth())
            {
                itemStack.damageItem(0, player);
            }
            else
            {
                itemStack.damageItem(1, player);
                player.setHealth(player.getMaxHealth());
                player.getFoodStats().addStats(20, 1F);
            }
        }

        return itemStack;
    }

    public int getMaxItemUseDuration(ItemStack itemStack)
    {
        return 16;
    }

    @Override
    public EnumAction getItemUseAction(ItemStack stack)
    {
        return EnumAction.BOW;
    }

    @Override
    public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced)
    {
        super.addInformation(stack, playerIn, tooltip, advanced);

        tooltip.add("Heal toute la vie");
    }
}
