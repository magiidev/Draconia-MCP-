package com.aikodev.draconia.init;

import com.aikodev.draconia.Draconia;
import com.aikodev.draconia.items.HealStick;
import com.aikodev.draconia.items.base.ItemBase;
import com.aikodev.draconia.items.TNTStick;
import com.aikodev.draconia.items.VoidStone;
import com.aikodev.draconia.items.hammers.OxyteHammer;
import com.aikodev.draconia.utils.Constants;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.*;
import net.minecraft.util.ResourceLocation;

import java.util.ArrayList;
import java.util.List;

public class ItemRegister
{
    public static List<Item> ITEMS = new ArrayList<>();

    public static ItemBase oxyte = new ItemBase("oxyte", CreativeTabs.tabDraconia);
    public static ItemBase bauxite = new ItemBase("bauxite", CreativeTabs.tabDraconia);
    public static ItemBase kobalte = new ItemBase("kobalte", CreativeTabs.tabDraconia);
    public static ItemBase dolomite = new ItemBase("dolomite", CreativeTabs.tabDraconia);

    public static Item oxyte_stick = new ItemBase("oxyte_stick", CreativeTabs.tabDraconia);
    public static Item bauxite_stick = new ItemBase("bauxite_stick", CreativeTabs.tabDraconia);
    public static Item kobalte_stick = new ItemBase("kobalte_stick", CreativeTabs.tabDraconia);
    public static Item dolomite_stick = new ItemBase("dolomite_stick", CreativeTabs.tabDraconia);

    public static Item oxyte_hammer = new OxyteHammer(Item.ToolMaterial.OXYTE, "oxyte_hammer", CreativeTabs.tabDraconia);

    public static Item heal_stick = new HealStick("heal_stick", CreativeTabs.tabDraconia);
    public static Item tnt_stick = new TNTStick("tnt_stick", CreativeTabs.tabDraconia);
    public static Item void_stone = new VoidStone("void_stone", CreativeTabs.tabDraconia);

    public void registerItems()
    {
        int id = 500;

        addItem(id++, "oxyte", oxyte);
        addItem(id++, "bauxite", bauxite);
        addItem(id++, "kobalte", kobalte);
        addItem(id++, "dolomite", dolomite);

        addItem(id++, "oxyte_stick", oxyte_stick);
        addItem(id++, "bauxite_stick", bauxite_stick);
        addItem(id++, "kobalte_stick", kobalte_stick);
        addItem(id++, "dolomite_stick", dolomite_stick);

        addItem(id++, "oxyte_hammer", oxyte_hammer);

        addItem(id++, "heal_stick", heal_stick);
        addItem(id++, "tnt_stick", tnt_stick);
        addItem(id++, "void_stone", void_stone);

        id = createToolSetFromItem(id, oxyte);
        id = createToolSetFromItem(id, bauxite);
        id = createToolSetFromItem(id, kobalte);
        id = createToolSetFromItem(id, dolomite);

        id = createArmorSetFromItem(id, dolomite, 5, CreativeTabs.tabDraconia);
        id = createArmorSetFromItem(id, kobalte, 6, CreativeTabs.tabDraconia);
        id = createArmorSetFromItem(id, bauxite, 7, CreativeTabs.tabDraconia);
        id = createArmorSetFromItem(id, oxyte, 8, CreativeTabs.tabDraconia);
    }

    private void addItem(int id, String name, Item item)
    {
        ITEMS.add(item);

        Item.itemRegistry.register(id, new ResourceLocation(Constants.NAME.toLowerCase(), name), item);
        Draconia.log("Enregistrement de l'item : " + name);
    }

    private int createToolSetFromItem(int id, ItemBase item)
    {
        final Item.ToolMaterial material = Item.ToolMaterial.valueOf(item.getName().toUpperCase());

        addItem(id++, item.getName() + "_sword", new ItemSword(material).setUnlocalizedName(item.getName() + "_sword").setCreativeTab(CreativeTabs.tabDraconia));
        addItem(id++, item.getName() + "_pickaxe", new ItemPickaxe(material).setUnlocalizedName(item.getName() + "_pickaxe").setCreativeTab(CreativeTabs.tabDraconia));
        addItem(id++, item.getName() + "_axe", new ItemAxe(material).setUnlocalizedName(item.getName() + "_axe").setCreativeTab(CreativeTabs.tabDraconia));
        addItem(id++, item.getName() + "_shovel", new ItemSpade(material).setUnlocalizedName(item.getName() + "_shovel").setCreativeTab(CreativeTabs.tabDraconia));
        addItem(id++, item.getName() + "_hoe", new ItemHoe(material).setUnlocalizedName(item.getName() + "_hoe").setCreativeTab(CreativeTabs.tabDraconia));

        return id;
    }

    private int createArmorSetFromItem(int id, ItemBase item, int renderIndex, CreativeTabs creativeTabs)
    {
        final ItemArmor.ArmorMaterial material = ItemArmor.ArmorMaterial.valueOf(item.getName().toUpperCase());

        addItem(id++, item.getName() + "_helmet", new ItemArmor(material, renderIndex, 0).setUnlocalizedName(item.getName() + "_helmet").setCreativeTab(creativeTabs));
        addItem(id++, item.getName() + "_chestplate", new ItemArmor(material, renderIndex, 1).setUnlocalizedName(item.getName() + "_chestplate").setCreativeTab(creativeTabs));
        addItem(id++, item.getName() + "_leggings", new ItemArmor(material, renderIndex, 2).setUnlocalizedName(item.getName() + "_leggings").setCreativeTab(creativeTabs));
        addItem(id++, item.getName() + "_boots", new ItemArmor(material, renderIndex, 3).setUnlocalizedName(item.getName() + "_boots").setCreativeTab(creativeTabs));

        return id;
    }

    public static Item getItem(String name)
    {
        return Item.getByNameOrIdCustom(name);
    }

    public static List<Item> getITEMS()
    {
        return ITEMS;
    }
}
