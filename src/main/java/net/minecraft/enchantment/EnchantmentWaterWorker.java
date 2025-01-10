package net.minecraft.enchantment;

import net.minecraft.util.ResourceLocation;

public class EnchantmentWaterWorker extends Enchantment
{
    public EnchantmentWaterWorker(int id, ResourceLocation resourceLocation, int rarity)
    {
        super(id, resourceLocation, rarity, EnumEnchantmentType.ARMOR_HEAD);
        this.setName("waterWorker");
    }

    public int getMinEnchantability(int enchantmentLevel)
    {
        return 1;
    }

    public int getMaxEnchantability(int enchantmentLevel)
    {
        return this.getMinEnchantability(enchantmentLevel) + 40;
    }

    public int getMaxLevel()
    {
        return 1;
    }
}
