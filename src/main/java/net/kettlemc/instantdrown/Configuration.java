package net.kettlemc.instantdrown;

import net.minecraftforge.common.config.Config;

public class Configuration {

    @Config(modid = InstantDrown.MODID, type = Config.Type.INSTANCE, category = "gameplay")
    public static class Gameplay {

        @Config.Comment({
                "The amount of damage to apply per drowning tick." +
                        "\nMinecraft's default is 2 damage (= 1 heart)." +
                        "\n-1 = instant death" +
                        "\n0 = no damage",
        })
        @Config.Name("damage")
        @Config.RangeInt(min = -1)
        public static Integer DAMAGE = -1;

    }

}
