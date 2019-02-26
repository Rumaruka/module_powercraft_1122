package com.rumaruka.powercraft.core;

import com.rumaruka.powercraft.api.PCApi;
import com.rumaruka.powercraft.api.PCBuild;
import com.rumaruka.powercraft.api.PCModule;
import com.rumaruka.powercraft.api.network.PCPacketHandler;
import com.rumaruka.powercraft.core.item.PCItemOreSniffer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Mod;


@Mod(modid = PCCore_Core.NAME,name = PCCore_Core.NAME,version = PCCore_Core.VERSION,dependencies = PCCore_Core.DEPENDENCIES)
public class PCCore_Core extends PCModule {

    public static final String NAME = POWERCRAFT + "-core";
    public static final String VERSION = PCBuild.BUILD_VERSION;
    public static final String DEPENDENCIES = "required-after:" + PCApi.NAME + "@" + PCApi.VERSION;

    public static PCCore_Core instance;

    static   {
        try {
            instance = new PCCore_Core();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
    public static final PCItemOreSniffer ORE_SNIFFER = new PCItemOreSniffer();
    @Mod.InstanceFactory
    public static PCCore_Core factory(){
        return instance;
    }

    public PCCore_Core() throws IllegalAccessException {


    }



    @Override
    public ItemStack getCreativeTabItemStack() {
        return null;
    }
}
