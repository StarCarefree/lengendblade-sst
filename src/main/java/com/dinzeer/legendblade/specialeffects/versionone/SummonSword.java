package com.dinzeer.legendblade.specialeffects.versionone;

import com.dinzeer.legendblade.regsitry.slashblade.LBSpecialEffectsRegistry;
import com.dinzeer.legendblade.specialattack.versionone.SommonSwordSommon;
import mods.flammpfeil.slashblade.capability.slashblade.ISlashBladeState;
import mods.flammpfeil.slashblade.event.SlashBladeEvent;
import mods.flammpfeil.slashblade.registry.specialeffects.SpecialEffect;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class SummonSword extends SpecialEffect {
    public SummonSword() {
        super(60,false,false);
    }
    @SubscribeEvent
    public static void onDoingSlash(SlashBladeEvent.DoSlashEvent event) {
        ISlashBladeState state = event.getSlashBladeState();
        if (state.hasSpecialEffect(LBSpecialEffectsRegistry.SummonSword.getId())) {
            if (!(event.getUser() instanceof Player)) {
                return;
            }

            Player player = (Player)event.getUser();
            RandomSource random = player.getRandom();
            int level = player.experienceLevel;
            if (SpecialEffect.isEffective(LBSpecialEffectsRegistry.SummonSword.get(), level)) {

                    SommonSwordSommon.doSlash(player,16777215,false, 1,3F,5,10);

            }
        }

    }
}
