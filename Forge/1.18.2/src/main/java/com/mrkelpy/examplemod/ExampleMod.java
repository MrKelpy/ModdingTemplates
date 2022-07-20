package com.mrkelpy.examplemod;

import com.mojang.logging.LogUtils;
import com.mrkelpy.examplemod.setup.Registration;
import com.mrkelpy.examplemod.setup.SetupClient;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;


/**
 * This class handles core interactions with Forge in order to make the mod work.
 */
@Mod(ExampleMod.MODID)
public class ExampleMod {

    public static final String MODID = "examplemod";
    public static final Logger LOGGER = LogUtils.getLogger();

    public ExampleMod() {
        IEventBus modbus = FMLJavaModLoadingContext.get().getModEventBus();

        // Register the deferred registers
        Registration.ITEMS.register(modbus);
        Registration.RECIPE_SERIALIZERS.register(modbus);
        Registration.RECIPE_TYPES.register(modbus);
        Registration.BLOCKS.register(modbus);

        // Register the setup methods
        modbus.register(new SetupClient());

    }

}
