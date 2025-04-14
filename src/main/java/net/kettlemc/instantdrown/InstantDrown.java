package net.kettlemc.instantdrown;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.util.DamageSource;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.event.entity.living.LivingHurtEvent;


@Mod(modid = InstantDrown.MODID, version = InstantDrown.VERSION, acceptedMinecraftVersions = "[1.7.10]")
public class InstantDrown {
    public static final String MODID = "instantdrown";
    public static final String VERSION = "1.2";


    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        Config.setup(new Configuration(event.getSuggestedConfigurationFile()));
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void onLivingHurt(LivingHurtEvent event) {
        if (event.source == DamageSource.drown) {
            if (Config.DAMAGE.getInt() == -1) {
                event.entityLiving.setHealth(0);
                return;
            }
            event.ammount = Math.max(0, Config.DAMAGE.getInt());
        }

    }
}
