package uk.co.hexeption.thx.module.modules;

import net.minecraft.client.Minecraft;
import org.lwjgl.input.Keyboard;
import uk.co.hexeption.thx.event.EventTarget;
import uk.co.hexeption.thx.event.events.EventUpdate;
import uk.co.hexeption.thx.module.Module;

/**
 * Created by Hexeption on 08/01/2017.
 */
@Module.ModInfo(name = "Step", description = "Walk up blocks", category = Module.Catergoy.MOVEMENT, bind = Keyboard.KEY_V)
public class Step extends Module {

    @EventTarget
    public void onUpdate(EventUpdate event) {

        if (getState()) {
            Minecraft.getMinecraft().player.stepHeight = 1;
        }
    }

    @Override
    public void onDisable() {

        Minecraft.getMinecraft().player.stepHeight = 0.5F;
    }
}
