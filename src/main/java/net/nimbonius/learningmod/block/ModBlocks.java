package net.nimbonius.learningmod.block;

import com.mojang.blaze3d.shaders.Uniform;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.nimbonius.learningmod.LearningMod;
import net.nimbonius.learningmod.items.ModItems;

import java.util.function.Supplier;

public class ModBlocks {

    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, LearningMod.MOD_ID);


    // Compressed

    public static final RegistryObject<Block> COMPRESSED_SQUISHMALLOW = registerBlock("compressed_squishmallow",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(0.8f).sound(SoundType.WOOL)));


    // Ores

    public static final RegistryObject<Block> SQUISHMALLOW_HEART_ORE = registerBlock("squishmallow_heart_ore",
            () -> new DropExperienceBlock(UniformInt.of(2,4), BlockBehaviour.Properties.of()
                    .strength(4f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final RegistryObject<Block> SQUISHMALLOW_HEART_DEEPSLATE_ORE = registerBlock("squishmallow_heart_deepslate_ore",
            () -> new DropExperienceBlock(UniformInt.of(2,4), BlockBehaviour.Properties.of()
                    .strength(5f).requiresCorrectToolForDrops().sound(SoundType.DEEPSLATE)));





    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);

        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
