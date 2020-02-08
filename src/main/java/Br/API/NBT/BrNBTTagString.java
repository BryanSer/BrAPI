/*
 * 开发者:Bryan_lzh
 * QQ:390807154
 * 保留一切所有权
 * 若为Bukkit插件 请前往plugin.yml查看剩余协议
 */
package Br.API.NBT;

import Br.API.Utils;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Bryan_lzh
 */
public class BrNBTTagString extends BrNBTBase{

    public BrNBTTagString() {
        TargetClass = Utils.getNMSClass("NBTTagString");
        try {
            super.TargetObject = TargetClass.newInstance();
        } catch (InstantiationException ex) {
            Logger.getLogger(BrNBTTagCompound.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(BrNBTTagCompound.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public BrNBTTagString(Object o) {
        TargetClass = Utils.getNMSClass("NBTTagString");
        TargetObject = o;
    }

    public BrNBTTagString(String s) {
        try {
            TargetClass = Utils.getNMSClass("NBTTagString");
            Constructor<?> cs = TargetClass.getConstructor(String.class);
            TargetObject = cs.newInstance(s);
        } catch (NoSuchMethodException ex) {
            Logger.getLogger(BrNBTTagString.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SecurityException ex) {
            Logger.getLogger(BrNBTTagString.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(BrNBTTagString.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(BrNBTTagString.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(BrNBTTagString.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(BrNBTTagString.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String getValue(){
        try {
            Method m = super.TargetClass.getMethod("c_", (Class<?>[]) null);
            return (String) m.invoke(super.TargetObject, (Object[]) null);
        } catch (NoSuchMethodException ex) {
            Logger.getLogger(BrNBTTagString.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SecurityException ex) {
            Logger.getLogger(BrNBTTagString.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(BrNBTTagString.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(BrNBTTagString.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(BrNBTTagString.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
