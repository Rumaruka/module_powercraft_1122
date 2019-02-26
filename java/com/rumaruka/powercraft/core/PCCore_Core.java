package com.rumaruka.powercraft.core;

public class PCCore_Core   {


    public static final String NAME = POWERCRAFT + "-Core";
    public static final String VERSION = PCBuild.BUILD_VERSION;
    public static final String DEPENDENCIES = "required-after:" + PCApi.NAME + "@" + PCApi.VERSION;

    public static final PCCore_Core INSTANCE = new PCCore_Core();

}
