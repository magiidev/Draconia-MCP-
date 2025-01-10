package com.aikodev.draconia;

import com.aikodev.draconia.discord.DiscordRP;
import com.aikodev.draconia.init.BlockRegister;
import com.aikodev.draconia.init.ItemRegister;
import com.aikodev.draconia.init.TileEntityRegister;
import com.aikodev.draconia.render.ArifuretaRender;
import com.aikodev.draconia.utils.Constants;
import net.minecraft.client.Minecraft;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.lwjgl.opengl.Display;

public class Draconia
{
    private static Draconia instance;
    private static final Logger logger = LogManager.getLogger();

    public DiscordRP discordRP = new DiscordRP();

    public static void createInstance()
    {
        if(instance == null)
        {
            instance = new Draconia();
        }
    }

    public void init()
    {
        log( "Initialization of " + Constants.NAME);
        log(Constants.NAME + " version is : " + Constants.VERSION);
        log("Java version of the user : " + System.getProperty("java.version"));
        log( "OS of the user : " + System.getProperty("os.name"));
    }

    public void start()
    {
        log( "Starting " + Constants.NAME + " ....");

        Display.setTitle(Constants.NAME + " " + Constants.VERSION + " | " + Minecraft.getMinecraft().getSession().getUsername());

        render();

        discordRP.start();

        log(Constants.NAME + " is successfully launched !");
    }

    public static void render()
    {
        new ArifuretaRender().renderItems();
        new ArifuretaRender().renderTools();
        new ArifuretaRender().renderBlocks();
        new ArifuretaRender().renderArmors();
    }

    public static void boostrap()
    {
        new BlockRegister().registerBlocks();
        new ItemRegister().registerItems();
        new TileEntityRegister().registerTileEntities();
    }

    public void shutdown()
    {
        log("Shutdowning of " + Constants.NAME + " ....");

        discordRP.shutdown();

        log(Constants.NAME + " is successfully shutdown !");
    }

    public static void log(String msg)
    {
        logger.log(Level.INFO, Constants.NAME_LOG + msg);
    }

    public static void log(Level level, String msg)
    {
        logger.log(level, Constants.NAME_LOG + msg);
    }

    public static void logERR(String msg)
    {
        log(Level.ERROR, msg);
    }

    public static Draconia getInstance()
    {
        return instance;
    }

    public DiscordRP getDiscordRP()
    {
        return discordRP;
    }
}
