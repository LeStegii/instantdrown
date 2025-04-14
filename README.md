# 🫧 Instant Drown

Instant Drown allows to configure the damage a player takes when running out of air, even allowing for instantly killing them.
It is meant to be used in hardcore modpacks or modpacks, that try to make Minecraft more realistic.

There are some mods that do similar things (e.g. [Drowning Overhaul for 1.6.4-1.7.10](https://www.minecraftforum.net/forums/mapping-and-modding-java-edition/minecraft-mods/2174575-drowning-overhaul-water-got-a-whole-lot-more)), but none of them are available for 1.12 and above.
They also cannot be simply used in CurseForge modpacks, since they're uploaded elsewhere.

## Configuration

The mod has a config file that allows you to configure the following options:

```toml
gameplay {
    # The amount of damage to apply per drowning tick.
    # Minecraft's default is 2 damage (= 1 heart).
    # -1 = instant death
    # 0 = no damage
    I:damage=-1
}
```

## Notes and Credit
- Inspired by [Drowning Overhaul for 1.6.4-1.7.10](https://www.minecraftforum.net/forums/mapping-and-modding-java-edition/minecraft-mods/2174575-drowning-overhaul-water-got-a-whole-lot-more)
- The workspace for this version is based on [anatawa12's FG fork](https://github.com/anatawa12/ForgeGradle-1.2).