package net.minecraft.item.crafting;

import com.aikodev.draconia.init.ItemRegister;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class RecipesWeapons
{
    private String[][] recipePatterns = new String[][] {{"X", "X", "#"}};
    private Object[][] recipeItems = new Object[][]
            {{Blocks.planks, Blocks.cobblestone, Items.iron_ingot, Items.diamond, Items.gold_ingot, ItemRegister.oxyte, ItemRegister.bauxite, ItemRegister.kobalte, ItemRegister.dolomite},
            {Items.wooden_sword, Items.stone_sword, Items.iron_sword, Items.diamond_sword, Items.golden_sword,
            ItemRegister.getItem("oxyte_sword"),  ItemRegister.getItem("bauxite_sword"),  ItemRegister.getItem("kobalte_sword"),  ItemRegister.getItem("dolomite_sword")}};

    public void addRecipes(CraftingManager craftingManager)
    {
        for (int i = 0; i < this.recipeItems[0].length; ++i)
        {
            Object object = this.recipeItems[0][i];

            for (int j = 0; j < this.recipeItems.length - 1; ++j)
            {
                Item item = (Item)this.recipeItems[j + 1][i];
                craftingManager.addRecipe(new ItemStack(item), new Object[] {this.recipePatterns[j], '#', Items.stick, 'X', object});
            }
        }

        craftingManager.addRecipe(new ItemStack(Items.bow, 1), new Object[] {" #X", "# X", " #X", 'X', Items.string, '#', Items.stick});
        craftingManager.addRecipe(new ItemStack(Items.arrow, 4), new Object[] {"X", "#", "Y", 'Y', Items.feather, 'X', Items.flint, '#', Items.stick});
    }
}
