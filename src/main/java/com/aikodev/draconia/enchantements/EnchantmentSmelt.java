package com.aikodev.draconia.enchantements;

import com.aikodev.draconia.init.BlockRegister;
import com.aikodev.draconia.init.ItemRegister;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class EnchantmentSmelt extends Enchantment
{

    public EnchantmentSmelt(int enchID, ResourceLocation enchName, int enchWeight, EnumEnchantmentType enchType)
    {
        super(enchID, enchName, enchWeight, enchType);

        this.setName("smelt");
    }

    @Override
    public boolean canApply(ItemStack stack)
    {
        return super.canApply(stack);
    }

    public void onBlockDestroyedWithEnchant(ItemStack stack, World world, BlockPos pos, IBlockState state, EntityPlayer player)
    {
        if (this.canApply(stack))
        {
            Block block = state.getBlock();

            if (block == BlockRegister.oxyte_ore)
            {
                world.setBlockState(pos, Blocks.air.getDefaultState());
                player.inventory.addItemStackToInventory(new ItemStack(ItemRegister.oxyte));
            }

            if (block == BlockRegister.bauxite_ore)
            {
                world.setBlockState(pos, Blocks.air.getDefaultState());
                player.inventory.addItemStackToInventory(new ItemStack(ItemRegister.bauxite));
            }

            if (block == BlockRegister.kobalte_ore)
            {
                world.setBlockState(pos, Blocks.air.getDefaultState());
                player.inventory.addItemStackToInventory(new ItemStack(ItemRegister.kobalte));
            }

            if (block == BlockRegister.dolomite_ore)
            {
                world.setBlockState(pos, Blocks.air.getDefaultState());
                player.inventory.addItemStackToInventory(new ItemStack(ItemRegister.dolomite));
            }
        }
    }
}
