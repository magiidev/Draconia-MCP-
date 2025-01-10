package com.aikodev.draconia.gui;

import com.aikodev.draconia.Draconia;
import com.aikodev.draconia.gui.others.ArifuretaButton;
import com.aikodev.draconia.utils.Constants;
import net.minecraft.client.gui.*;
import net.minecraft.client.multiplayer.GuiConnecting;
import net.minecraft.client.multiplayer.ServerData;
import net.minecraft.util.ResourceLocation;

import java.io.IOException;

import static net.minecraft.client.renderer.GlStateManager.*;

public class ArifuretaMainMenu extends GuiScreen
{
    @Override
    public void initGui()
    {
        // Arifureta - DiscordRPC
        Draconia.getInstance().getDiscordRP().update("Idle", "Main Menu");

        ScaledResolution resolution = new ScaledResolution(mc);

        this.buttonList.add(new ArifuretaButton(0, resolution.getScaledWidth() / 2 - 100, resolution.getScaledHeight() / 2 - 60, "Rejoindre"));
        this.buttonList.add(new ArifuretaButton(1, resolution.getScaledWidth() / 2 - 100, resolution.getScaledHeight() / 2 - 30, "Solo"));
        this.buttonList.add(new ArifuretaButton(2, resolution.getScaledWidth() / 2 - 100, resolution.getScaledHeight() / 2, "Options"));
        this.buttonList.add(new ArifuretaButton(3, resolution.getScaledWidth() / 2 - 100, resolution.getScaledHeight() / 2 + 30, "Quitter"));
        super.initGui();
    }


    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks)
    {
        ScaledResolution resolution = new ScaledResolution(mc);

        mc.getTextureManager().bindTexture(new ResourceLocation(Constants.NAME.toLowerCase(),"/images/background.jpg"));
        drawModalRectWithCustomSizedTexture(0, 0, 0, 0, this.width, this.height, this.width, this.height);

        pushMatrix();
        translate((float) resolution.getScaledWidth() / 2, (float) resolution.getScaledHeight() / 2 - 95, 0);
        scale(2, 2, 2);
        drawCenteredString(mc.fontRendererObj, Constants.NAME, 0, 0, -1);
        popMatrix();

        super.drawScreen(mouseX, mouseY, partialTicks);
    }

    @Override
    protected void actionPerformed(GuiButton button) throws IOException
    {
        switch (button.id)
        {
            case 0:
                this.mc.displayGuiScreen(new GuiConnecting(this, mc, new ServerData("Draconia", "localhost:25565", false)));
                break;

            case 1:
                this.mc.displayGuiScreen(new GuiSelectWorld(this));
                break;

            case 2:
                this.mc.displayGuiScreen(new GuiOptions(this, mc.gameSettings));
                break;

            case 3:
                mc.shutdown();
                break;

            default:
                break;
        }

        super.actionPerformed(button);
    }
}
