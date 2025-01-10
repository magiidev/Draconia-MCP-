package net.minecraft.item.crafting;

import com.aikodev.draconia.init.ItemRegister;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class RecipesArmor
{
    private String[][] recipePatterns = new String[][] {{"XXX", "X X"}, {"X X", "XXX", "XXX"}, {"XXX", "X X", "X X"}, {"X X", "X X"}};
    private Item[][] recipeItems = new Item[][] {
            {Items.leather, Items.iron_ingot, Items.diamond, Items.gold_ingot, ItemRegister.oxyte, ItemRegister.bauxite, ItemRegister.kobalte, ItemRegister.dolomite},
            {Items.leather_helmet, Items.iron_helmet, Items.diamond_helmet, Items.golden_helmet, ItemRegister.getItem("oxyte_helmet"), ItemRegister.getItem("bauxite_helmet"), ItemRegister.getItem("kobalte_helmet"), ItemRegister.getItem("dolomite_helmet")},
            {Items.leather_chestplate, Items.iron_chestplate, Items.diamond_chestplate, Items.golden_chestplate, ItemRegister.getItem("oxyte_chestplate"), ItemRegister.getItem("bauxite_chestplate"), ItemRegister.getItem("kobalte_chestplate"), ItemRegister.getItem("dolomite_chestplate")},
            {Items.leather_leggings, Items.iron_leggings, Items.diamond_leggings, Items.golden_leggings, ItemRegister.getItem("oxyte_leggings"), ItemRegister.getItem("bauxite_leggings"), ItemRegister.getItem("kobalte_leggings"), ItemRegister.getItem("dolomite_leggings")},
            {Items.leather_boots, Items.iron_boots, Items.diamond_boots, Items.golden_boots, ItemRegister.getItem("oxyte_boots"), ItemRegister.getItem("bauxite_boots"), ItemRegister.getItem("kobalte_boots"), ItemRegister.getItem("dolomite_boots")}};

    public void addRecipes(CraftingManager craftManager)
    {
        for (int i = 0; i < this.recipeItems[0].length; ++i)
        {
            Item item = this.recipeItems[0][i];

            for (int j = 0; j < this.recipeItems.length - 1; ++j)
            {
                Item item1 = this.recipeItems[j + 1][i];
                craftManager.addRecipe(new ItemStack(item1), new Object[] {this.recipePatterns[j], 'X', item});
            }
        }
    }
}
