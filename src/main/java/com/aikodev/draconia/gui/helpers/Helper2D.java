package com.aikodev.draconia.gui.helpers;

import net.minecraft.client.gui.Gui;
import org.lwjgl.opengl.GL11;

import static org.lwjgl.opengl.GL11.*;

public class Helper2D
{
    /**
     * Draws a rounded Rectangle on the HUD using quarter circles and rectangles
     *
     * @param x      Left X coordinate of the rectangle
     * @param y      Top Y coordinate of the rectangle
     * @param w      Width of the rectangle
     * @param h      Height of the rectangle
     * @param radius The radius of the corners
     * @param color  The Color of the rectangle
     * @param index  -1: No Rounded Corners; 0: Rounded Corners on all sides; 1: Rounded Corners on the top; 2: Rounded Corners on the bottom;
     */

    public static void drawRoundedRectangle(int x, int y, int w, int h, int radius, int color, int index)
    {
        if (index == -1)
        {
            drawRectangle(x, y, w, h, color);
        } else if (index == 0) {
            drawRectangle(x + radius, y + radius, w - radius * 2, h - radius * 2, color);
            drawRectangle(x + radius, y, w - radius * 2, radius, color);
            drawRectangle(x + w - radius, y + radius, radius, h - radius * 2, color);
            drawRectangle(x + radius, y + h - radius, w - radius * 2, radius, color);
            drawRectangle(x, y + radius, radius, h - radius * 2, color);
            drawCircle(x + radius, y + radius, radius, 180, 270, color);
            drawCircle(x + w - radius, y + radius, radius, 270, 360, color);
            drawCircle(x + radius, y + h - radius, radius, 90, 180, color);
            drawCircle(x + w - radius, y + h - radius, radius, 0, 90, color);
        } else if (index == 1) {
            drawRectangle(x + radius, y, w - radius * 2, radius, color);
            drawRectangle(x, y + radius, w, h - radius, color);
            drawCircle(x + radius, y + radius, radius, 180, 270, color);
            drawCircle(x + w - radius, y + radius, radius, 270, 360, color);
        } else if (index == 2) {
            drawRectangle(x, y, w, h - radius, color);
            drawRectangle(x + radius, y + h - radius, w - radius * 2, radius, color);
            drawCircle(x + radius, y + h - radius, radius, 90, 180, color);
            drawCircle(x + w - radius, y + h - radius, radius, 0, 90, color);
        }
    }

    /**
     * Draws a rectangle using width and height, instead of 4 coordinate positions
     *
     * @param x     Left X coordinate of the rectangle
     * @param y     Top Y coordinate of the rectangle
     * @param w     Width of the rectangle
     * @param h     Height of the rectangle
     * @param color The Color of the rectangle
     */

    public static void drawRectangle(int x, int y, int w, int h, int color)
    {
        Gui.drawRect(x, y, x + w, y + h, color);
    }

    /**
     * Draws a circle
     *
     * @param x     Left X coordinate of the circle
     * @param y     Top Y coordinate of the circle
     * @param r     The radius of the circle
     * @param h     The beginning of from where the circle should be drawn
     * @param j     The ending of from where the circle should be drawn
     * @param color The color of the circle
     */

    public static void drawCircle(float x, float y, float r, int h, int j, int color)
    {
        GL11.glEnable(GL_BLEND);
        GL11.glDisable(GL11.GL_CULL_FACE);
        GL11.glDisable(GL11.GL_TEXTURE_2D);
        glBegin(GL_TRIANGLE_FAN);

        ColorHelper.color(color);

        float var;
        glVertex2f(x, y);
        for (var = h; var <= j; var++)
        {
            ColorHelper.color(color);
            glVertex2f(
                    (float) (r * Math.cos(Math.PI * var / 180) + x),
                    (float) (r * Math.sin(Math.PI * var / 180) + y)
            );
        }

        glEnd();
        GL11.glEnable(GL11.GL_TEXTURE_2D);
        GL11.glEnable(GL11.GL_CULL_FACE);
        GL11.glDisable(GL_BLEND);
    }
}
