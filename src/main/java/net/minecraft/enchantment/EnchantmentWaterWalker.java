package net.minecraft.enchantment;

import net.minecraft.util.ResourceLocation;

public class EnchantmentWaterWalker extends Enchantment
{
    public EnchantmentWaterWalker(int id, ResourceLocation resourceLocation, int rarity)
    {
        super(id, resourceLocation, rarity, EnumEnchantmentType.ARMOR_FEET);
        this.setName("waterWalker");
    }

    public int getMinEnchantability(int enchantmentLevel)
    {
        return enchantmentLevel * 10;
    }

    public int getMaxEnchantability(int enchantmentLevel)
    {
        return this.getMinEnchantability(enchantmentLevel) + 15;
    }

    public int getMaxLevel()
    {
        return 3;
    }
}
