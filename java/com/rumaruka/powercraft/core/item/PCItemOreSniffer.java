package com.rumaruka.powercraft.core.item;

import com.rumaruka.powercraft.api.PCField.Flag;
import com.rumaruka.powercraft.api.PCLangHelper;
import com.rumaruka.powercraft.api.PCVec4I;
import com.rumaruka.powercraft.api.gres.IGresGui;
import com.rumaruka.powercraft.api.gres.IGresGuiOpenHandler;
import com.rumaruka.powercraft.api.gres.PCGres;
import com.rumaruka.powercraft.api.gres.PCGresBaseWithInventory;
import com.rumaruka.powercraft.api.item.PCItem;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class PCItemOreSniffer extends PCItem implements IGresGuiOpenHandler {


    public PCItemOreSniffer(){
        setMaxStackSize(1);
        setMaxDamage(500);
        setCreativeTab(CreativeTabs.TOOLS);
    }

    @Override
    public void initRecipes() {
            //WIP
      }

    @Override
    public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        ItemStack itemStack = player.getHeldItem(hand);
        if(!worldIn.isRemote){
            PCGres.openGui(player,this,new PCVec4I(pos.getX(),pos.getY(),pos.getZ(),facing.getIndex()));
        }
        itemStack.damageItem(1,player);
        return EnumActionResult.SUCCESS;

    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer entityPlayer, EnumHand handIn) {
        return super.onItemRightClick(world, entityPlayer, handIn);
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add(PCLangHelper.tr("item.PCco_ItemOreSniffer.desc"));
    }


    @Override
    public IGresGui openClientGui(EntityPlayer player, NBTTagCompound serverData) {
        return null;
    }

    @Override
    public PCGresBaseWithInventory openServerGui(EntityPlayer player, Object[] params) {
        return null;
    }

    @Override
    public NBTTagCompound sendOnGuiOpenToClient(EntityPlayer player, Object[] params) {
        NBTTagCompound nbtTagCompound = new NBTTagCompound();
        ((PCVec4I)params[0]).saveToNBT(nbtTagCompound, Flag.SYNC);
        return nbtTagCompound;
    }
}
