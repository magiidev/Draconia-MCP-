package com.aikodev.draconia.init;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.FurnaceRecipes;

public class CraftRegister
{
    public void addRecipes(CraftingManager craftingManager)
    {
        craftingManager.addRecipe(new ItemStack(BlockRegister.oxyte_block, 1), new Object[] {"OOO", "OOO", "OOO", 'O', ItemRegister.oxyte});
        FurnaceRecipes.instance().addSmeltingRecipeForBlock(BlockRegister.oxyte_ore, new ItemStack(ItemRegister.oxyte), 1.5F);

        craftingManager.addRecipe(new ItemStack(BlockRegister.bauxite_block, 1), new Object[] {"OOO", "OOO", "OOO", 'O', ItemRegister.bauxite});
        FurnaceRecipes.instance().addSmeltingRecipeForBlock(BlockRegister.bauxite_ore, new ItemStack(ItemRegister.bauxite), 1.5F);

        craftingManager.addRecipe(new ItemStack(BlockRegister.kobalte_block, 1), new Object[] {"OOO", "OOO", "OOO", 'O', ItemRegister.kobalte});
        FurnaceRecipes.instance().addSmeltingRecipeForBlock(BlockRegister.kobalte_ore, new ItemStack(ItemRegister.kobalte), 1.5F);

        craftingManager.addRecipe(new ItemStack(BlockRegister.dolomite_block, 1), new Object[] {"OOO", "OOO", "OOO", 'O', ItemRegister.dolomite});
        FurnaceRecipes.instance().addSmeltingRecipeForBlock(BlockRegister.dolomite_ore, new ItemStack(ItemRegister.dolomite), 1.5F);

        craftingManager.addRecipe(new ItemStack(ItemRegister.oxyte_stick, 1), new Object[] {"#", "#", '#', ItemRegister.oxyte});
        craftingManager.addRecipe(new ItemStack(ItemRegister.heal_stick, 1), new Object[] {"ONO", " # ", " # ", '#', ItemRegister.oxyte_stick, 'O', ItemRegister.oxyte, 'N', Items.nether_star});
        craftingManager.addRecipe(new ItemStack(ItemRegister.tnt_stick, 1), new Object[] {"ONO", "T#T", " # ", '#', ItemRegister.oxyte_stick, 'N', Items.nether_star, 'O', BlockRegister.oxyte_block, 'T', Blocks.tnt});
        craftingManager.addRecipe(new ItemStack(ItemRegister.void_stone, 1), new Object[] {" D ", "DCD", " D ", 'D', ItemRegister.dolomite, 'C', Blocks.chest});
    }
}
