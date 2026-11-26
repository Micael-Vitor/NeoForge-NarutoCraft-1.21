package net.lycans.narutocraft.item;

import net.lycans.narutocraft.NarutoCraft;
import net.lycans.narutocraft.item.custom.Food_Pill;
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

    public static final DeferredItem<Food_Pill> FOOD_PILL = ITEMS.register("food_pill",
            () -> new Food_Pill(Food_Pill.FOOD_PILL, Food_Pill.DEFAULT_COOLDOWN_TICKS));



    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
