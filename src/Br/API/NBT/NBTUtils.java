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
public class NBTUtils {

    public static ItemStack getItemStack(BrItemStack bi) {
        try {
            Class<?> cis = Utils.getBukkitClass("inventory.CraftItemStack");
            Method method = cis.getDeclaredMethod("asBukkitCopy", Utils.getNMSClass("ItemStack"));
            method.setAccessible(true);
            return (ItemStack) method.invoke(null, bi.obj);
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
            Method method = bn.c.getMethod("set", String.class, new BrNBTBase().c);
            BrNBTTagString bns = new BrNBTTagString(value);
            method.invoke(bn.obj, key, bns.obj);
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
            Object obj = ((boolean) bris.c.getMethod("hasTag", (Class<?>[]) null).invoke(bris.obj, (Object[]) null)) ? bris.c.getMethod("getTag", (Class<?>[]) null).invoke(bris.obj, (Object[]) null) : new BrNBTTagCompound().c.newInstance();
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
}
