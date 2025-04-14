package net.kettlemc.instantdrown;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;

public class Config {

    private static Config instance;
    private static Configuration configuration;

    public static Property DAMAGE;

    private Config(Configuration config) {
        configuration = config;
        configuration.load();

        DAMAGE = config.get("gameplay", "damage", -1,
                "The amount of damage to apply per drowning tick." +
                        "\nMinecraft's default is 2 damage (= 1 heart)." +
                        "\n-1 = instant death" +
                        "\n0 = no damage",
                -1, Integer.MAX_VALUE
        );

        configuration.setCategoryComment("gameplay", "All settings related to gameplay.");
        configuration.save();

    }

    public static void setup(Configuration configuration) {
        if (instance == null)
            instance = new Config(configuration);
    }

    public static Configuration getConfig() {
        return configuration;
    }

}