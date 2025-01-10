package com.aikodev.draconia.init;

import com.aikodev.draconia.Draconia;
import com.aikodev.draconia.blocks.base.BlockBase;
import com.aikodev.draconia.blocks.tnt.OxyteTNT;
import com.aikodev.draconia.utils.Constants;
import net.minecraft.block.Block;
import net.minecraft.block.BlockOre;
import net.minecraft.block.BlockTNT;
import net.minecraft.item.Item;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.ResourceLocation;

import java.util.ArrayList;
import java.util.List;

public class BlockRegister
{
    public static List<Block> BLOCKS = new ArrayList<>();

    public static Block oxyte_block = new BlockBase("oxyte_block", CreativeTabs.tabDraconia, Material.iron);
    public static Block oxyte_ore = new BlockOre().setHardness(3.0F).setResistance(5.0F).setStepSound(Block.soundTypePiston).setUnlocalizedName("oxyte_ore").setCreativeTab(CreativeTabs.tabDraconia);

    public static Block bauxite_block = new BlockBase("bauxite_block", CreativeTabs.tabDraconia, Material.iron);
    public static Block bauxite_ore = new BlockOre().setHardness(3.0F).setResistance(5.0F).setStepSound(Block.soundTypePiston).setUnlocalizedName("bauxite_ore").setCreativeTab(CreativeTabs.tabDraconia);

    public static Block kobalte_block = new BlockBase("kobalte_block", CreativeTabs.tabDraconia, Material.iron);
    public static Block kobalte_ore = new BlockOre().setHardness(3.0F).setResistance(5.0F).setStepSound(Block.soundTypePiston).setUnlocalizedName("kobalte_ore").setCreativeTab(CreativeTabs.tabDraconia);

    public static Block dolomite_block = new BlockBase("dolomite_block", CreativeTabs.tabDraconia, Material.iron);
    public static Block dolomite_ore = new BlockOre().setHardness(3.0F).setResistance(5.0F).setStepSound(Block.soundTypePiston).setUnlocalizedName("dolomite_ore").setCreativeTab(CreativeTabs.tabDraconia);

    public static BlockTNT oxyte_tnt = new OxyteTNT(CreativeTabs.tabDraconia, "oxyte_tnt");

    public void registerBlocks()
    {
        int id = 900;

        addBlock(id++, "oxyte_block", oxyte_block);
        addBlock(id++, "oxyte_ore", oxyte_ore);

        addBlock(id++, "bauxite_block", bauxite_block);
        addBlock(id++, "bauxite_ore", bauxite_ore);

        addBlock(id++, "kobalte_block", kobalte_block);
        addBlock(id++, "kobalte_ore", kobalte_ore);

        addBlock(id++, "dolomite_block", dolomite_block);
        addBlock(id++, "dolomite_ore", dolomite_ore);

        addBlock(id++, "oxyte_tnt", oxyte_tnt);
    }

    private void addBlock(int id, String name, Block block)
    {
        BLOCKS.add(block);

        Block.blockRegistry.register(id, new ResourceLocation(Constants.NAME.toLowerCase(), name), block);
        Item.registerItemBlock(block);

        Draconia.log("Enregistrement du block : " + name);
    }
}
