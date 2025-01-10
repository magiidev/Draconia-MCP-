package com.aikodev.draconia.render;

import com.aikodev.draconia.init.BlockRegister;
import com.aikodev.draconia.init.ItemRegister;
import com.aikodev.draconia.utils.Constants;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;

public class ArifuretaRender
{
    public void registerItem(Item item, String name)
    {
        if (Minecraft.getMinecraft().getRenderItem() != null)
        {
            Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(
                    item,
                    0,
                    new ModelResourceLocation(Constants.NAME.toLowerCase()+ ":" + name, "inventory")
            );
        }
    }

    public void registerBlock(Block block, String name)
    {
        Item itemBlock = Item.getItemFromBlock(block);

        if (Minecraft.getMinecraft().getRenderItem() != null && itemBlock != null)
        {
            Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(
                    itemBlock,
                    0,
                    new ModelResourceLocation(Constants.NAME.toLowerCase()+ ":" + name, "inventory")
            );
        }
    }

    public void renderItems()
    {
        registerItem(ItemRegister.oxyte, "oxyte");
        registerItem(ItemRegister.bauxite, "bauxite");
        registerItem(ItemRegister.kobalte, "kobalte");
        registerItem(ItemRegister.dolomite, "dolomite");

        registerItem(ItemRegister.oxyte_stick, "oxyte_stick");
        registerItem(ItemRegister.bauxite_stick, "bauxite_stick");
        registerItem(ItemRegister.kobalte_stick, "kobalte_stick");
        registerItem(ItemRegister.dolomite_stick, "dolomite_stick");

        registerItem(ItemRegister.oxyte_hammer, "oxyte_hammer");

        registerItem(ItemRegister.heal_stick, "heal_stick");
        registerItem(ItemRegister.tnt_stick, "tnt_stick");
        registerItem(ItemRegister.void_stone, "void_stone");
    }

    public void renderBlocks()
    {
        registerBlock(BlockRegister.oxyte_block, "oxyte_block");
        registerBlock(BlockRegister.oxyte_ore, "oxyte_ore");

        registerBlock(BlockRegister.bauxite_block, "bauxite_block");
        registerBlock(BlockRegister.bauxite_ore, "bauxite_ore");

        registerBlock(BlockRegister.kobalte_block, "kobalte_block");
        registerBlock(BlockRegister.kobalte_ore, "kobalte_ore");

        registerBlock(BlockRegister.dolomite_block, "dolomite_block");
        registerBlock(BlockRegister.dolomite_ore, "dolomite_ore");
    }

    public void renderSpecialBlocks()
    {
        // TNTs
        registerBlock(BlockRegister.oxyte_tnt, "oxyte_tnt");
    }

    public void renderTools()
    {
        registerToolFromItem("dolomite");
        registerToolFromItem("kobalte");
        registerToolFromItem("bauxite");
        registerToolFromItem("oxyte");
    }

    public void renderArmors()
    {
        registerArmorFromItem("dolomite");
        registerArmorFromItem("kobalte");
        registerArmorFromItem("bauxite");
        registerArmorFromItem("oxyte");
    }

    public void registerToolFromItem(String name)
    {
        registerItem(ItemRegister.getItem(name + "_sword"), name + "_sword");
        registerItem(ItemRegister.getItem(name + "_pickaxe"), name + "_pickaxe");
        registerItem(ItemRegister.getItem(name + "_axe"), name + "_axe");
        registerItem(ItemRegister.getItem(name + "_shovel"), name + "_shovel");
        registerItem(ItemRegister.getItem(name + "_hoe"), name + "_hoe");
    }

    public void registerArmorFromItem(String name)
    {
        registerItem(ItemRegister.getItem(name + "_helmet"), name + "_helmet");
        registerItem(ItemRegister.getItem(name + "_chestplate"), name + "_chestplate");
        registerItem(ItemRegister.getItem(name + "_leggings"), name + "_leggings");
        registerItem(ItemRegister.getItem(name + "_boots"), name + "_boots");
    }
}
