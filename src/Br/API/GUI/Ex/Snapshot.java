/*
 * 开发者:Bryan_lzh
 * QQ:390807154
 * 保留一切所有权
 * 若为Bukkit插件 请前往plugin.yml查看剩余协议
 */

package Br.API.GUI.Ex;

import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

/**
 *
 * @author Bryan_lzh
 * @version 1.0
 */
public interface Snapshot<T extends BaseUI> {
    
    String getPlayerName();
    
    void Delete();

    ExItem[] getContains();
    
    T getUI();

    ExItem getItem(int solt);
    
    void setData(String key,Object value);
    
    Object getData(String key);
    
    void removeData(String key);
    
    Inventory getInventory();
    
    void setInventory(Inventory inv);
}
