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
public class BrTileEntity {

    public Class<?> c;
    public Object obj;


    public BrTileEntity() {
        c = Utils.getNMSClass("TileEntity");
    }

//    public BrTileEntity(BrCraftBlockState bs) {
//        c = Utils.getNMSClass("TileEntity");
//        try {
//            Method m = bs.c.getMethod("getTileEntity", (Class<?>[]) null);
//            obj = m.invoke(bs.obj, (Object[]) null);
//        } catch (NoSuchMethodException ex) {
//            Logger.getLogger(BrTileEntity.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (SecurityException ex) {
//            Logger.getLogger(BrTileEntity.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            Logger.getLogger(BrTileEntity.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (IllegalArgumentException ex) {
//            Logger.getLogger(BrTileEntity.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (InvocationTargetException ex) {
//            Logger.getLogger(BrTileEntity.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
}
