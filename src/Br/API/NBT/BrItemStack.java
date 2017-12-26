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
import org.bukkit.inventory.ItemStack;

/**
 *
 * @author Bryan_lzh
 */
public class BrItemStack {
    private Class<?> cls;
    private Object obj;
    
    public BrItemStack(){
        cls = Utils.getNMSClass("ItemStack");
    }
    
    public BrItemStack(Object o){
        cls = Utils.getNMSClass("ItemStack");
        obj = o;
    }
    
    public BrItemStack(ItemStack is){
        try {
            cls = Utils.getNMSClass("ItemStack");
            Class<?> cis = Utils.getBukkitClass("inventory.CraftItemStack");
            Method method = cis.getMethod("asNMSCopy", ItemStack.class);
            this.obj = method.invoke(null, is);
        } catch (NoSuchMethodException ex) {
            Logger.getLogger(BrItemStack.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SecurityException ex) {
            Logger.getLogger(BrItemStack.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(BrItemStack.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(BrItemStack.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(BrItemStack.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public BrNBTTagCompound getTag(){
        try {
            Method method = cls.getMethod("getTag");
            return new BrNBTTagCompound(method.invoke(obj));
        } catch (NoSuchMethodException ex) {
            Logger.getLogger(BrItemStack.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SecurityException ex) {
            Logger.getLogger(BrItemStack.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(BrItemStack.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(BrItemStack.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(BrItemStack.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public boolean hasTag(){
        try {
            Method method = cls.getMethod("hasTag");
            return (boolean) method.invoke(this.obj);
        } catch (NoSuchMethodException ex) {
            Logger.getLogger(BrItemStack.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SecurityException ex) {
            Logger.getLogger(BrItemStack.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(BrItemStack.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(BrItemStack.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(BrItemStack.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public void setTag(BrNBTTagCompound nbt){
        try {
            Method method = cls.getMethod("setTag", Utils.getNMSClass("NBTTagCompound"));
            method.invoke(this.obj, nbt.TargetObject);
        } catch (NoSuchMethodException ex) {
            Logger.getLogger(BrItemStack.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SecurityException ex) {
            Logger.getLogger(BrItemStack.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(BrItemStack.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(BrItemStack.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(BrItemStack.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Class<?> getCls() {
        return cls;
    }

    public Object getObject() {
        return obj;
    }
    
    
}
