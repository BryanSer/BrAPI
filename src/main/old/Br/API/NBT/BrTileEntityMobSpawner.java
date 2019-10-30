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

/**
 *
 * @author Bryan_lzh
 */
public class BrTileEntityMobSpawner extends BrTileEntity {

    public BrTileEntityMobSpawner() {
        super();
        c = Utils.getNMSClass("TileEntityMobSpawner");
    }

    public BrTileEntityMobSpawner(BrCraftBlockState bs) {
        super();
        c = Utils.getNMSClass("TileEntityMobSpawner");
        this.obj = bs.getTileEntity();
    }

    public BrNBTTagCompound getNBTTagCompound() {
        c = Utils.getNMSClass("TileEntityMobSpawner");
        try {
            Method m = c.getMethod("c", (Class<?>[]) null);
            Object o = m.invoke(obj, (Object[]) null);
            return new BrNBTTagCompound(o);
        } catch (NoSuchMethodException ex) {
            Logger.getLogger(BrTileEntity.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SecurityException ex) {
            Logger.getLogger(BrTileEntity.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(BrTileEntity.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(BrTileEntity.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(BrTileEntity.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void save(BrNBTTagCompound br) {
        c = Utils.getNMSClass("TileEntityMobSpawner");
        try {
            Method m = c.getMethod("a", br.TargetClass);
            m.invoke(obj, br.TargetObject);
        } catch (NoSuchMethodException ex) {
            Logger.getLogger(BrTileEntity.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SecurityException ex) {
            Logger.getLogger(BrTileEntity.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(BrTileEntity.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(BrTileEntity.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(BrTileEntity.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
