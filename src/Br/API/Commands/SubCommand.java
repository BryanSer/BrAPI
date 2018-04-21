/*
 * 开发者:Bryan_lzh
 * QQ:390807154
 * 保留一切所有权
 * 若为Bukkit插件 请前往plugin.yml查看剩余协议
 */

package Br.API.Commands;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 *
 * @author Bryan_lzh
 * @version 1.0
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface SubCommand {
    public static final String PERMISSION_OP = "*";
    public static final String PERMISSION_NONE= "";
    String command();
    String usage();

    /**
     * 这个参数不包括子命令<br>
     * 也就是 如果玩家使用/<command> <subcommand>  那么参数是0
     * @return
     */
    int minimalArgs() default 0;
    String argsNotEnough() default "§c%subcommand% 命令参数不足 正确用法是: %usage%";
    String permission() default PERMISSION_NONE;
}