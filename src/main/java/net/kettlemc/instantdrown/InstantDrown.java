package net.kettlemc.instantdrown;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;

@Mod(InstantDrown.MODID)
public class InstantDrown {
    public static final String MODID = "instantdrown";
    public static final String NAME = "Instant Drown";
    public static final String VERSION = "1.2.0";

    public InstantDrown() {
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Configuration.CONFIG);
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void onLivingHurt(LivingHurtEvent event) {
        if (event.getSource() == DamageSource.DROWN) {
            if (Configuration.DAMAGE.get() == -1) {
                event.getEntityLiving().setHealth(0);
                return;
            }
            event.setAmount(Math.max(0, Configuration.DAMAGE.get()));
        }

    }
}
