package net.nimbonius.learningmod.items;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.nimbonius.learningmod.LearningMod;
import net.nimbonius.learningmod.block.ModBlocks;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab>  CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, LearningMod.MOD_ID);

    public  static final RegistryObject<CreativeModeTab> SQUISHMALLOW_ITEMS_TAB = CREATIVE_MODE_TABS.register("squishmallow_items_tab",
            () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModItems.MUSHROOM_SQUISHMALLOW.get()))
                    .title(Component.translatable("creativetab.learningmod.squishmallow_items"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.BASE_SQUISHMALLOW.get());
                        output.accept(ModItems.MUSHROOM_SQUISHMALLOW.get());
                        output.accept(ModBlocks.COMPRESSED_SQUISHMALLOW.get());
                        output.accept(ModBlocks.SQUISHMALLOW_HEART_ORE.get());
                        output.accept(ModBlocks.SQUISHMALLOW_HEART_DEEPSLATE_ORE.get());

                    }).build());

    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
