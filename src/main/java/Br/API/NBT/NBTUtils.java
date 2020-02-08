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
import org.bukkit.World;
import org.bukkit.inventory.ItemStack;

/**
 *
 * @author Bryan_lzh
 */
public class NBTUtils {
    
    public static Object getNMSWorld(World w){
        Class<?> cw = Utils.getBukkitClass("CraftWorld");
        Object o1 = null;
        try {
            Method m = cw.getMethod("getHandle", (Class<?>[]) null);
            o1 = m.invoke(w, (Object[]) null);
        } catch (NoSuchMethodException ex) {
            Logger.getLogger(NBTUtils.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SecurityException ex) {
            Logger.getLogger(NBTUtils.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(NBTUtils.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(NBTUtils.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(NBTUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
        return o1;
    }

    public static ItemStack getItemStack(BrItemStack bi) {
        try {
            Class<?> cis = Utils.getBukkitClass("inventory.CraftItemStack");
            Method method = cis.getDeclaredMethod("asBukkitCopy", Utils.getNMSClass("ItemStack"));
            method.setAccessible(true);
            return (ItemStack) method.invoke(null, bi.getObject());
        } catch (NoSuchMethodException ex) {
            Logger.getLogger(NBTUtils.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SecurityException ex) {
            Logger.getLogger(NBTUtils.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(NBTUtils.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(NBTUtils.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(NBTUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static BrItemStack getItem(ItemStack is) {
        try {
            Class<?> cis = Utils.getBukkitClass("inventory.CraftItemStack");
            Method method = cis.getDeclaredMethod("asNMSCopy", ItemStack.class);
            method.setAccessible(true);
            return new BrItemStack(method.invoke(null, is));
        } catch (NoSuchMethodException ex) {
            Logger.getLogger(NBTUtils.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SecurityException ex) {
            Logger.getLogger(NBTUtils.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(NBTUtils.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(NBTUtils.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(NBTUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static BrNBTTagCompound setString(BrNBTTagCompound bn, String key, String value) {
        try {
            Method method = bn.TargetClass.getMethod("set", String.class, new BrNBTBase().TargetClass);
            BrNBTTagString bns = new BrNBTTagString(value);
            method.invoke(bn.TargetObject, key, bns.TargetObject);
            return bn;
        } catch (NoSuchMethodException ex) {
            Logger.getLogger(NBTUtils.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SecurityException ex) {
            Logger.getLogger(NBTUtils.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(NBTUtils.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(NBTUtils.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(NBTUtils.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NullPointerException e) {
            Logger.getLogger(NBTUtils.class.getName()).log(Level.SEVERE, null, e);
        }
        return bn;
    }

    public static BrNBTTagCompound getTag(ItemStack is) {
        try {
            Class<?> cis = Utils.getBukkitClass("inventory.CraftItemStack");
            Method method = cis.getMethod("asNMSCopy", ItemStack.class);
            BrItemStack bris = new BrItemStack(method.invoke(null, is));
            Object obj = ((boolean) bris.getCls().getMethod("hasTag", (Class<?>[]) null).invoke(bris.getObject(), (Object[]) null)) ? bris.getCls().getMethod("getTag", (Class<?>[]) null).invoke(bris.getObject(), (Object[]) null) : new BrNBTTagCompound().TargetClass.newInstance();
            return new BrNBTTagCompound(obj);
        } catch (NoSuchMethodException ex) {
            Logger.getLogger(NBTUtils.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SecurityException ex) {
            Logger.getLogger(NBTUtils.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(NBTUtils.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(NBTUtils.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(NBTUtils.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(NBTUtils.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NullPointerException e) {
            Logger.getLogger(NBTUtils.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }
    
    public static boolean hasAttribute(ItemStack is){
        BrItemStack bi = new BrItemStack(is);
        BrNBTTagCompound basetag = bi.hasTag() ? bi.getTag() : new BrNBTTagCompound();
        return basetag.hasValue("AttributeModifiers");
    }
}
