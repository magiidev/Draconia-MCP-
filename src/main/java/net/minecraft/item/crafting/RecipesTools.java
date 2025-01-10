package net.minecraft.item.crafting;

import com.aikodev.draconia.init.ItemRegister;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class RecipesTools
{
    private String[][] recipePatterns = new String[][] {{"XXX", " # ", " # "}, {"X", "#", "#"}, {"XX", "X#", " #"}, {"XX", " #", " #"}};
    private Object[][] recipeItems = new Object[][]
            {{Blocks.planks, Blocks.cobblestone, Items.iron_ingot, Items.diamond, Items.gold_ingot, ItemRegister.oxyte, ItemRegister.bauxite, ItemRegister.kobalte, ItemRegister.dolomite},
            {Items.wooden_pickaxe, Items.stone_pickaxe, Items.iron_pickaxe, Items.diamond_pickaxe, Items.golden_pickaxe, ItemRegister.getItem("oxyte_pickaxe"), ItemRegister.getItem("bauxite_pickaxe"), ItemRegister.getItem("kobalte_pickaxe"), ItemRegister.getItem("dolomite_pickaxe")},
            {Items.wooden_shovel, Items.stone_shovel, Items.iron_shovel, Items.diamond_shovel, Items.golden_shovel, ItemRegister.getItem("oxyte_shovel"), ItemRegister.getItem("bauxite_shovel"), ItemRegister.getItem("kobalte_shovel"), ItemRegister.getItem("dolomite_shovel")},
            {Items.wooden_axe, Items.stone_axe, Items.iron_axe, Items.diamond_axe, Items.golden_axe, ItemRegister.getItem("oxyte_axe"), ItemRegister.getItem("bauxite_axe"), ItemRegister.getItem("kobalte_axe"), ItemRegister.getItem("dolomite_axe")},
            {Items.wooden_hoe, Items.stone_hoe, Items.iron_hoe, Items.diamond_hoe, Items.golden_hoe, ItemRegister.getItem("oxyte_hoe"), ItemRegister.getItem("bauxite_hoe"), ItemRegister.getItem("kobalte_hoe"), ItemRegister.getItem("dolomite_hoe")}};

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

        craftingManager.addRecipe(new ItemStack(Items.shears), new Object[] {" #", "# ", '#', Items.iron_ingot});
    }
}
