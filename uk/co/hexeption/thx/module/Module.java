package uk.co.hexeption.thx.module;

import org.lwjgl.input.Keyboard;
import uk.co.hexeption.thx.event.EventManager;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by Hexeption on 08/01/2017.
 */
public class Module {

    private String name = getClass().getAnnotation(ModInfo.class).name();

    private String discrption = getClass().getAnnotation(ModInfo.class).description();

    private Catergoy catergoy = getClass().getAnnotation(ModInfo.class).category();

    private int bind = getClass().getAnnotation(ModInfo.class).bind();

    private boolean state;

    /**
     * Category
     */
    public enum Catergoy {
        COMTBAT(0x3ABDFF), MOVEMENT(0xF8FF1F), RENDER(0x48FF1F), WORLD(0xCF1FFF), MISC(0xFFC100), PLAYER(0x00FFEC), GUI(0xE800D5);

        public int color;

        Catergoy(int color) {

            this.color = color;
        }
    }

    /**
     * Module information @ModInfo
     */
    @Retention(RetentionPolicy.RUNTIME)
    public @interface ModInfo {

        String name();

        String description();

        Catergoy category();

        int bind();

    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public String getDiscrption() {

        return discrption;
    }

    public void setDiscrption(String discrption) {

        this.discrption = discrption;
    }

    public Catergoy getCatergoy() {

        return catergoy;
    }

    public void setCatergoy(Catergoy catergoy) {

        this.catergoy = catergoy;
    }

    public int getBind() {

        return bind;
    }

    public void setBind(int bind) {

        this.bind = bind;
    }

    public boolean getState() {

        return state;
    }

    public void setState(boolean state) {

        onToggle();

        if (state) {
            onEnable();
            this.state = true;
            EventManager.register(this);
        } else {
            onDisable();
            this.state = false;
            EventManager.unregister(this);
        }

        //Save the module

    }

    public void onDisable() {

    }

    public void onEnable() {

    }

    public void onToggle() {

    }

    public void toggle() {

        setState(!this.getState());
    }

    public final boolean isCategory(Catergoy catergoy) {

        if (catergoy == this.catergoy)
            return true;
        return false;
    }

    public String getKeyName() {

        return getBind() == -1 ? "-1" : Keyboard.getKeyName(getBind());
    }

}
