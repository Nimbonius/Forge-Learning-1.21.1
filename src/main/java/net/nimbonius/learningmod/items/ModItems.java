package net.nimbonius.learningmod.items;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.nimbonius.learningmod.LearningMod;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, LearningMod.MOD_ID);

    public static final RegistryObject<Item> BASE_SQUISHMALLOW =
            ITEMS.register("base_squishmallow", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> MUSHROOM_SQUISHMALLOW =
            ITEMS.register("mushroom_squishmallow", () -> new Item(new Item.Properties()));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
