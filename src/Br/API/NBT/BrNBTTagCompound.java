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
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Bryan_lzh
 */
public class BrNBTTagCompound extends BrNBTBase {

    public BrNBTTagCompound() {
        super.TargetClass = Utils.getNMSClass("NBTTagCompound");
        try {
            super.TargetObject = TargetClass.newInstance();
        } catch (InstantiationException ex) {
            Logger.getLogger(BrNBTTagCompound.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(BrNBTTagCompound.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public BrNBTTagCompound(Object obj) {
        super.TargetClass = Utils.getNMSClass("NBTTagCompound");
        super.TargetObject = obj;
    }

    public void set(String key, BrNBTBase nbt) {
        try {
            Method m = super.TargetClass.getMethod("set", String.class, Utils.getNMSClass("NBTBase"));
            m.invoke(super.TargetObject, key, nbt.TargetObject);
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

    public boolean hasValue(String key) {
        try {
            Method m = super.TargetClass.getMethod("hasKey", String.class);
            return (boolean) m.invoke(super.TargetObject, key);
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
        return false;
    }
    
    public Set<String> getKeySet(){
        try {
            Method m = super.TargetClass.getMethod("c", (Class<?>[]) null);
            return (Set<String>) m.invoke(super.TargetObject, (Object[]) null);
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
        return new HashSet<>();
    }
    
    public BrNBTTagCompound getCompound(String key){
        try {
            Method m = super.TargetClass.getMethod("getCompound", String.class);
            Object obj = m.invoke(super.TargetObject, key);
            return new BrNBTTagCompound(obj);
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
        return null;
    }
    
    public BrNBTBase getNBTBase(String key){
        try {
            Method m = super.TargetClass.getMethod("get", String.class);
            Object obj = m.invoke(super.TargetObject, key);
            if(obj == null){
                return null;
            }
            if(Utils.getNMSClass("NBTTagString").isInstance(obj)){
                return new BrNBTTagString(obj);
            }
            if(Utils.getNMSClass("NBTTagList").isInstance(obj)){
                return new BrNBTTagList(obj);
            }
            if(Utils.getNMSClass("NBTNumber").isInstance(obj)){
                return BrNBTBase.getNumber(obj);
            }
            return new BrNBTBase(obj);
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
        return null;
    }
}
