package com.aikodev.draconia.gui.others;

import com.aikodev.draconia.gui.helpers.Helper2D;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;

import java.awt.*;

public class ArifuretaButton extends GuiButton
{
    private String str;
    private int color;

    public ArifuretaButton(int buttonId, int x, int y, int widthIn, int heightIn, String buttonText)
    {
        super(buttonId, x, y, widthIn, heightIn, buttonText);

        this.str = buttonText;
    }

    public ArifuretaButton(int buttonId, int x, int y, String buttonText)
    {
        super(buttonId, x, y, buttonText);

        this.str = buttonText;
    }

    @Override
    public void drawButton(Minecraft mc, int mouseX, int mouseY)
    {
        this.hovered = mouseX >= this.xPosition && mouseY >= this.yPosition && mouseX < this.xPosition + this.width && mouseY < this.yPosition + this.height;
        this.mouseDragged(mc, mouseX, mouseY);

        if(this.hovered)
        {
            this.color = new Color(60, 60, 60).getRGB();
        } else {
            this.color = new Color(50, 50, 50).getRGB();
        }

        Helper2D.drawRoundedRectangle(this.xPosition, this.yPosition, this.width, this.height, 5, this.color, 0);
        this.drawCenteredString(mc.fontRendererObj, str, this.xPosition + this.width / 2, this.yPosition + (this.height - 8) / 2, new Color(255, 255, 255).getRGB());
    }
}
