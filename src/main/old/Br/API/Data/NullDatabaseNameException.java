/*
 * 开发者:Bryan_lzh
 * QQ:390807154
 * 保留一切所有权
 * 若为Bukkit插件 请前往plugin.yml查看剩余协议
 */
package Br.API.Data;

/**
 *
 * @author Bryan_lzh
 */
public class NullDatabaseNameException extends Exception {
    
    public NullDatabaseNameException(Class<? extends DatabaseSerializable> cls) {
        super("缺少表名 这将在匿名内部类时出现致命错误 请使用@Database来指定表名 " + cls.toGenericString());
    }
    
}
