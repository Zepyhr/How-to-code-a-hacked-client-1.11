package uk.co.hexeption.thx;

import org.lwjgl.input.Keyboard;
import uk.co.hexeption.thx.event.EventManager;
import uk.co.hexeption.thx.event.EventTarget;
import uk.co.hexeption.thx.event.events.EventKeyboard;
import uk.co.hexeption.thx.module.Module;
import uk.co.hexeption.thx.module.ModuleManager;

/**
 * Created by Hexeption on 07/01/2017.
 */
public class Thx {

    public static final Thx INSTANCE = new Thx();

    public final String NAME = "Thx";

    public final String VERSION = "Thx Dev 1";

    public final ModuleManager MODULE_MANAGER = new ModuleManager();


    public void startClient() {

        EventManager.register(this);


        //Ends Client
        Runtime.getRuntime().addShutdownHook(new Thread(() -> endClient()));
    }

    public void endClient() {

    }

    @EventTarget
    private void eventKeyboard(EventKeyboard eventKeyboard) {

        for (Module module : Thx.INSTANCE.MODULE_MANAGER.getAllModules()) {
            if (Keyboard.getEventKey() == module.getBind()) {
                module.toggle();
            }
        }
    }

}
