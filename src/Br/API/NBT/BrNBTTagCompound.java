/*
 * 开发者:Bryan_lzh
 * QQ:390807154
 * 保留一切所有权
 * 若为Bukkit插件 请前往plugin.yml查看剩余协议
 */
package Br.API.NBT;

import Br.API.Utils;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.minecraft.server.v1_10_R1.NBTTagCompound;

/**
 *
 * @author Bryan_lzh
 */
public class BrNBTTagCompound extends BrNBTBase {

    public BrNBTTagCompound() {
        super.c = Utils.getNMSClass("NBTTagCompound");
        try {
            super.obj = c.newInstance();
        } catch (InstantiationException ex) {
            Logger.getLogger(BrNBTTagCompound.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(BrNBTTagCompound.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public BrNBTTagCompound(Object obj) {
        super.c = Utils.getNMSClass("NBTTagCompound");
        super.obj = obj;
    }

    public void set(String key, BrNBTBase nbt) {
        try {
            Method m = super.c.getMethod("set", String.class, Utils.getNMSClass("NBTBase"));
            m.invoke(super.obj, key, nbt.obj);
        } catch (NoSuchMethodException ex) {
            Logger.getLogger(BrNBTTagCompound.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SecurityException ex) {
            Logger.getLogger(BrNBTTagCompound.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(BrNBTTagCompound.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(BrNBTTagCompound.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(BrNBTTagCompound.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
