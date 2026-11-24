package net.lycans.narutocraft.item;

import net.lycans.narutocraft.NarutoCraft;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItens {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(NarutoCraft.MODID);

    public static final DeferredItem<Item> KUNAI = ITEMS.register("kunai",
            ()-> new Item(new Item.Properties()));
    public static final DeferredItem<Item> RAW_CHAKRA_METAL = ITEMS.register("raw_chakra_metal",
            ()-> new Item(new Item.Properties()));
    public static final DeferredItem<Item> CHAKRA_METAL = ITEMS.register("chakra_metal",
            ()-> new Item(new Item.Properties()));


    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
