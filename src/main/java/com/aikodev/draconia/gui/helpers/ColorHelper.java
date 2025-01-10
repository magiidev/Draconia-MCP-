package com.aikodev.draconia.gui.helpers;

import net.minecraft.client.renderer.GlStateManager;

public class ColorHelper
{
    public static void color(int color)
    {
        float alpha = (color >> 24 & 255) / 255f;
        float red = (color >> 16 & 255) / 255f;
        float green = (color >> 8 & 255) / 255f;
        float blue = (color & 255) / 255f;
        GlStateManager.color(red, green, blue, alpha);
    }
}
