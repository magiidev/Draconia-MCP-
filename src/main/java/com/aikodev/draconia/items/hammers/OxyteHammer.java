package com.aikodev.draconia.items.hammers;

import com.aikodev.draconia.enchantements.EnchantmentSmelt;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class OxyteHammer extends ItemPickaxe
{

    public OxyteHammer(ToolMaterial material, String name, CreativeTabs creativeTab)
    {
        super(material);

        this.setUnlocalizedName(name);
        this.setCreativeTab(creativeTab);
        this.setMaxDamage(1600);
        this.setMaxStackSize(1);
    }

    @Override
    public boolean onBlockDestroyed(ItemStack stack, World world, Block block, BlockPos pos, EntityLivingBase living)
    {
        // Vérifie si l'entité est un joueur et que l'appel n'est pas sur le client
        if (living instanceof EntityPlayer && !world.isRemote)
        {
            EntityPlayer player = (EntityPlayer) living;

            // Vérifie si l'outil a l'enchantement Smelt
            if (stack.isItemEnchanted() && this.hasSmeltEnchantment(stack)) {
                // Applique l'enchantement Smelt lorsque le bloc est détruit
                EnchantmentSmelt smeltEnchant = (EnchantmentSmelt) EnchantmentSmelt.smelt; // Utiliser l'enchantement existant
                smeltEnchant.onBlockDestroyedWithEnchant(stack, world, pos, world.getBlockState(pos), player);
            }

            // Détruire les blocs autour du bloc cible (zone 3x3)
            switch (determineOrientation(world, pos, living))
            {
                case 0: // Orientation horizontale
                    for (int x1 = -1; x1 <= 1; x1++)
                    {
                        for (int z1 = -1; z1 <= 1; z1++)
                        {
                            BlockPos targetPos = pos.add(x1, 0, z1);
                            IBlockState targetState = world.getBlockState(targetPos);
                            Block targetBlock = targetState.getBlock();
                            TileEntity targetTE = world.getTileEntity(targetPos); // Récupérer le TileEntity

                            if (targetBlock.getBlockHardness(world, targetPos) >= 0.0F)
                            {
                                // Appel à harvestBlock avec 5 arguments
                                targetBlock.harvestBlock(world, player, targetPos, targetState, targetTE); // Utilisation correcte
                                world.setBlockToAir(targetPos);
                            }
                        }
                    }
                    break;
                case 1: // Orientation verticale
                    for (int y1 = -1; y1 <= 1; y1++)
                    {
                        for (int z1 = -1; z1 <= 1; z1++)
                        {
                            BlockPos targetPos = pos.add(0, y1, z1);
                            IBlockState targetState = world.getBlockState(targetPos);
                            Block targetBlock = targetState.getBlock();
                            TileEntity targetTE = world.getTileEntity(targetPos); // Récupérer le TileEntity

                            if (targetBlock.getBlockHardness(world, targetPos) >= 0.0F)
                            {
                                // Appel à harvestBlock avec 5 arguments
                                targetBlock.harvestBlock(world, player, targetPos, targetState, targetTE); // Utilisation correcte
                                world.setBlockToAir(targetPos);
                            }
                        }
                    }
                    break;
                case 2: // Orientation en profondeur
                    for (int x1 = -1; x1 <= 1; x1++)
                    {
                        for (int y1 = -1; y1 <= 1; y1++)
                        {
                            BlockPos targetPos = pos.add(x1, y1, 0);
                            IBlockState targetState = world.getBlockState(targetPos);
                            Block targetBlock = targetState.getBlock();
                            TileEntity targetTE = world.getTileEntity(targetPos); // Récupérer le TileEntity

                            if (targetBlock.getBlockHardness(world, targetPos) >= 0.0F)
                            {
                                // Appel à harvestBlock avec 5 arguments
                                targetBlock.harvestBlock(world, player, targetPos, targetState, targetTE); // Utilisation correcte
                                world.setBlockToAir(targetPos);
                            }
                        }
                    }
                    break;
            }
        }
        return super.onBlockDestroyed(stack, world, block, pos, living);
    }

    // Méthode pour vérifier si l'enchantement Smelt est appliqué
    private boolean hasSmeltEnchantment(ItemStack stack) {
        // Vérifie si l'enchantement Smelt est présent sur l'outil
        return stack.getEnchantmentTagList().toString().contains("smelt");
    }

    public int determineOrientation(World world, BlockPos pos, EntityLivingBase living)
    {
        // Vérifie la distance entre le joueur et le bloc
        if (MathHelper.abs((float) living.posX - pos.getX()) < 2.0F && MathHelper.abs((float) living.posZ - pos.getZ()) < 2.0F)
        {
            double d0 = living.posY + 1.82D - (double) living.getYOffset();
            if (d0 - pos.getY() > 2.0D || pos.getY() - d0 > 0.0D)
            {
                return 0; // Orientation horizontale
            }
        }
        // Calcule la rotation
        float rotation = MathHelper.abs(living.rotationYaw);
        return (rotation > 45F && rotation < 135F) || (rotation > 225F && rotation < 315F) ? 1 : 2; // 1 pour vertical, 2 pour profondeur
    }
}
