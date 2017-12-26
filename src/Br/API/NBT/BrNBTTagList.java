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
public class BrNBTTagList extends BrNBTBase{
    
    public BrNBTTagList() {
        TargetClass = Utils.getNMSClass("NBTTagList");
        try {
            super.TargetObject = TargetClass.newInstance();
        } catch (InstantiationException ex) {
            Logger.getLogger(BrNBTTagCompound.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(BrNBTTagCompound.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public BrNBTTagList(Object o) {
        TargetClass = Utils.getNMSClass("NBTTagList");
        TargetObject = o;
    }
    
    public void add(BrNBTBase bn){
        try {
            Method method = TargetClass.getMethod("add", Utils.getNMSClass("NBTBase"));
            method.invoke(this.TargetObject, bn.TargetObject);
        } catch (NoSuchMethodException ex) {
            Logger.getLogger(BrNBTTagList.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SecurityException ex) {
            Logger.getLogger(BrNBTTagList.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(BrNBTTagList.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(BrNBTTagList.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(BrNBTTagList.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
