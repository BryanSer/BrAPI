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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Bryan_lzh
 */
public class BrNBTBase {

    protected Class<?> TargetClass;
    protected Object TargetObject;

    public BrNBTBase() {
        TargetClass = Utils.getNMSClass("NBTBase");
    }
    
     public BrNBTBase(Object obj) {
        TargetClass = Utils.getNMSClass("NBTBase");
        TargetObject = obj;
    }
    
    public static BrNBTBase getNumber(Object num){
        BrNBTBase tag = new BrNBTBase();
        tag.TargetClass = Utils.getNMSClass("NBTNumber");
        tag.TargetObject = num;
        return tag;
    }

    public BrNBTBase(int i) {
        try {
            TargetClass = Utils.getNMSClass("NBTTagInt");
            Class<?> num = Utils.getNMSClass("NBTTagInt");
            Constructor<?> con = num.getConstructor(int.class);
            Object obj = con.newInstance(i);
            this.TargetObject = obj;
        } catch (NoSuchMethodException ex) {
            Logger.getLogger(BrNBTBase.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SecurityException ex) {
            Logger.getLogger(BrNBTBase.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(BrNBTBase.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(BrNBTBase.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(BrNBTBase.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(BrNBTBase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public BrNBTBase(float i) {
        try {
            TargetClass = Utils.getNMSClass("NBTTagFloat");
            Class<?> num = Utils.getNMSClass("NBTTagFloat");
            Constructor<?> con = num.getConstructor(float.class);
            Object obj = con.newInstance(i);
            this.TargetObject = obj;
        } catch (NoSuchMethodException ex) {
            Logger.getLogger(BrNBTBase.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SecurityException ex) {
            Logger.getLogger(BrNBTBase.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(BrNBTBase.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(BrNBTBase.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(BrNBTBase.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(BrNBTBase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public BrNBTBase(double i) {
        try {
            TargetClass = Utils.getNMSClass("NBTTagDouble");
            Class<?> num = Utils.getNMSClass("NBTTagDouble");
            Constructor<?> con = num.getConstructor(double.class);
            Object obj = con.newInstance(i);
            this.TargetObject = obj;
        } catch (NoSuchMethodException ex) {
            Logger.getLogger(BrNBTBase.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SecurityException ex) {
            Logger.getLogger(BrNBTBase.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(BrNBTBase.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(BrNBTBase.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(BrNBTBase.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(BrNBTBase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public BrNBTBase(byte i) {
        try {
            TargetClass = Utils.getNMSClass("NBTTagByte");
            Class<?> num = Utils.getNMSClass("NBTTagByte");
            Constructor<?> con = num.getConstructor(byte.class);
            Object obj = con.newInstance(i);
            this.TargetObject = obj;
        } catch (NoSuchMethodException ex) {
            Logger.getLogger(BrNBTBase.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SecurityException ex) {
            Logger.getLogger(BrNBTBase.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(BrNBTBase.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(BrNBTBase.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(BrNBTBase.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(BrNBTBase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public BrNBTBase(short i) {
        try {
            TargetClass = Utils.getNMSClass("NBTTagShort");
            Class<?> num = Utils.getNMSClass("NBTTagShort");
            Constructor<?> con = num.getConstructor(short.class);
            Object obj = con.newInstance(i);
            this.TargetObject = obj;
        } catch (NoSuchMethodException ex) {
            Logger.getLogger(BrNBTBase.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SecurityException ex) {
            Logger.getLogger(BrNBTBase.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(BrNBTBase.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(BrNBTBase.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(BrNBTBase.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(BrNBTBase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public BrNBTBase(long i) {
        try {
            TargetClass = Utils.getNMSClass("NBTTagLong");
            Class<?> num = Utils.getNMSClass("NBTTagLong");
            Constructor<?> con = num.getConstructor(long.class);
            Object obj = con.newInstance(i);
            this.TargetObject = obj;
        } catch (NoSuchMethodException ex) {
            Logger.getLogger(BrNBTBase.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SecurityException ex) {
            Logger.getLogger(BrNBTBase.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(BrNBTBase.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(BrNBTBase.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(BrNBTBase.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(BrNBTBase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Class<?> getTargetClass() {
        return TargetClass;
    }

    public Object getTargetObject() {
        return TargetObject;
    }
    
    
}
