package com.aikodev.draconia.init;

import com.aikodev.draconia.Draconia;
import net.minecraft.tileentity.TileEntity;

public class TileEntityRegister
{

    public void registerTileEntities()
    {

    }

    private void addTileEntity(Class<? extends TileEntity> tileClass, String name)
    {
        TileEntity.addMapping(tileClass, name);

        Draconia.log("Enregistrement de la TileEntity : " + name);
    }
}
