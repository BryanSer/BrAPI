/*
 * 开发者:Bryan_lzh
 * QQ:390807154
 * 保留一切所有权
 * 若为Bukkit插件 请前往plugin.yml查看剩余协议
 */

package Br.API.GUI.Ex;

/**
 *
 * @author Bryan_lzh
 * @version 1.0
 */
public abstract class BaseUI {
    
    public static final String UICODE = "§c§b§p§r";
    protected String Name;
    protected String DisplayName;
    protected int Rows = 6;
    
    

    public String getName() {
        return Name;
    }

    public String getDisplayName() {
        return DisplayName;
    }

    public int getRows() {
        return Rows;
    }
    
    public int getSize(){
        return this.Rows * 9;
    }
    
    public String getPrefix(){
        return UIManager.encode(this.Name) + BaseUI.UICODE;
    }
}
