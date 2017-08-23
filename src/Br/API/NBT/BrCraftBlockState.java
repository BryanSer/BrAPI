/*
 * 开发者:Bryan_lzh
 * QQ:390807154
 * 保留一切所有权
 * 若为Bukkit插件 请前往plugin.yml查看剩余协议
 */
package Br.API.NBT;

import Br.API.Utils;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Block;

/**
 *
 * @author Bryan_lzh
 */
public class BrCraftBlockState {

    private Class<?> cls;
    private Object obj;

    private int x;
    private int y;
    private int z;
    
    

    public BrCraftBlockState() {
        cls = Utils.getBukkitClass("block.CraftBlockState");
    }

    public BrCraftBlockState(Block b) {
        cls = Utils.getBukkitClass("block.CraftBlockState");
        this.x = b.getLocation().getBlockX();
        this.y = b.getLocation().getBlockY();
        this.z = b.getLocation().getBlockZ();
        try {
            Method m = cls.getMethod("getBlockState", Utils.getNMSClass("World"), int.class, int.class, int.class);
            Location loc = b.getLocation();
            obj = m.invoke(null, NBTUtils.getNMSWorld(loc.getWorld()), loc.getBlockX(), loc.getBlockY(), loc.getBlockZ());
        } catch (NoSuchMethodException ex) {
            Logger.getLogger(BrCraftBlockState.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SecurityException ex) {
            Logger.getLogger(BrCraftBlockState.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(BrCraftBlockState.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(BrCraftBlockState.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(BrCraftBlockState.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Object getTileEntity() {
        Class<?> wl = Utils.getBukkitClass("CraftWorld");
        try {
            Field f = this.cls.getDeclaredField("world");
            f.setAccessible(true);
            Object o = f.get(this.obj);//CraftWorld
            Field f2 = wl.getDeclaredField("world");
            f2.setAccessible(true);
            Object worldserver = f2.get(o);
            Class<?> ws = Utils.getNMSClass("WorldServer");
            Class<?> bpc = Utils.getNMSClass("BlockPosition");
            Method m = ws.getMethod("getTileEntity", bpc);
            Constructor<?> bpcon = bpc.getConstructor(int.class, int.class, int.class);
            Object bp = bpcon.newInstance(x, y, z);
            return m.invoke(worldserver, bp);
        } catch (NoSuchFieldException ex) {
            Logger.getLogger(BrCraftBlockState.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SecurityException ex) {
            Logger.getLogger(BrCraftBlockState.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(BrCraftBlockState.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(BrCraftBlockState.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchMethodException ex) {
            Logger.getLogger(BrCraftBlockState.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(BrCraftBlockState.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(BrCraftBlockState.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Class<?> getCls() {
        return cls;
    }

    public Object getObject() {
        return obj;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getZ() {
        return z;
    }
}
