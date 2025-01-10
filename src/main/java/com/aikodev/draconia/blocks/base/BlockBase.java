package com.aikodev.draconia.blocks.base;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BlockBase extends Block
{
    public BlockBase(String name, CreativeTabs tab)
    {
        super(Material.rock);

        this.setUnlocalizedName(name);
        this.setCreativeTab(tab);
        this.setResistance(5.0F);
        this.setHardness(3.0F);
        this.setStepSound(Block.soundTypePiston);
    }

    public BlockBase(String name, CreativeTabs tab, Material material)
    {
        super(material);

        this.setUnlocalizedName(name);
        this.setCreativeTab(tab);
        this.setResistance(5.0F);
        this.setHardness(3.0F);
    }
}
