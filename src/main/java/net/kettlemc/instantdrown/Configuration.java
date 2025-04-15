package net.kettlemc.instantdrown;

import net.minecraftforge.common.ForgeConfigSpec;

public class Configuration {

    public static final ForgeConfigSpec CONFIG;

    public static final ForgeConfigSpec.IntValue DAMAGE;

    static {
        ForgeConfigSpec.Builder builder = new ForgeConfigSpec.Builder();

        builder.push("gameplay");

        DAMAGE = builder
                .comment("The amount of damage to apply per drowning tick.",
                        "Minecraft's default is 2 damage (= 1 heart).",
                        "-1 = instant death",
                        "0 = no damage")
                .defineInRange("damage", -1, -1, Integer.MAX_VALUE);

        builder.pop();

        CONFIG = builder.build();
    }
}
