package net.lycans.narutocraft.item.custom;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import java.util.Properties;

public class Food_Pill extends Item {

    public static final int DEFAULT_COOLDOWN_TICKS = 200;

    public static final FoodProperties FOOD_PILL = new FoodProperties.Builder()
            .nutrition(7)
            .saturationModifier(0.5f)
            .alwaysEdible()
            .fast()
            .effect(() -> new MobEffectInstance(MobEffects.HEAL, 1, 5), 1.0f).build();

    private final int CooldownTicks;

    public Food_Pill(FoodProperties foodProperties, int CooldownTicks) {
        super(new Properties().food(foodProperties));
        this.CooldownTicks = CooldownTicks;

    }

    @Override
    public int getUseDuration(ItemStack stack, LivingEntity entity) {
        return 1;
    }

    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity livingEntity) {
        ItemStack result = super.finishUsingItem(stack, level, livingEntity);

        if (!level.isClientSide()) {
            // Cura exatamente até o máximo de vida atual (funciona com vida baunilha e mods)
            if (livingEntity.getHealth() < livingEntity.getMaxHealth()) {
                livingEntity.setHealth(livingEntity.getMaxHealth());
            }

            if (livingEntity instanceof Player player && CooldownTicks > 0) {
                player.getCooldowns().addCooldown(this, CooldownTicks);
            }
        }

        return result;
    }
}

