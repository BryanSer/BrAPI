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
public class TooMuchKeyException extends Exception {

    public TooMuchKeyException(Class<? extends DatabaseSerializable> cls) {
        super("过多的主键" + cls.toGenericString());
    }

}
