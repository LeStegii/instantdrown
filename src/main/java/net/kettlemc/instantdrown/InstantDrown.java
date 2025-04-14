package net.kettlemc.instantdrown;

import net.minecraft.util.DamageSource;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod(modid = InstantDrown.MODID, name = InstantDrown.NAME, version = InstantDrown.VERSION, acceptedMinecraftVersions = "[1.12.2]")
public class InstantDrown {
    public static final String MODID = "instantdrown";
    public static final String NAME = "Instant Drown";
    public static final String VERSION = "1.2.0";


    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void onLivingHurt(LivingHurtEvent event) {
        if (event.getSource() == DamageSource.DROWN) {
            if (Configuration.Gameplay.DAMAGE == -1) {
                event.getEntityLiving().setHealth(0);
                return;
            }
            event.setAmount(Math.max(0, Configuration.Gameplay.DAMAGE));
        }

    }
}
