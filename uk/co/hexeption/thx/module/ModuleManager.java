package uk.co.hexeption.thx.module;

import com.sun.org.apache.xpath.internal.operations.Mod;
import uk.co.hexeption.thx.module.modules.Step;

import java.lang.reflect.Field;
import java.util.Collection;
import java.util.TreeMap;

/**
 * Created by Hexeption on 08/01/2017.
 */
public class ModuleManager {

    private final TreeMap<String, Module> modules = new TreeMap<>();

    /**
     * Modules
     */

    public final Step step = new Step();


    public ModuleManager() {

        try {
            for (Field field : ModuleManager.class.getFields()) {
                Module module = (Module) field.get(this);
                modules.put(module.getName(), module);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public Collection<Module> getAllModules() {

        return modules.values();
    }

    public Module getModuleByName(String name) {

        return modules.get(name);
    }

    public Module getModuleByClass(Class<? extends Module> clazz) {

        for (Module module : getAllModules()) {
            if (module.getClass() == clazz) {
                return module;
            }
        }
        return null;
    }

}
