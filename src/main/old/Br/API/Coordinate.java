/*
 * 开发者:Bryan_lzh
 * QQ:390807154
 * 保留一切所有权
 * 若为Bukkit插件 请前往plugin.yml查看剩余协议
 */
package Br.API;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Egg;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.util.Vector;

/**
 * 与坐标系有关的辅助方法
 *
 * @author Bryan_lzh
 * @version 1.0
 * @since 2018-9-14
 */
public class Coordinate {

    /**
     * 将向量转换为Location里使用的yaw与pitch
     * @param v 向量
     * @return [0]为yaw [1]为pitch
     */
    @Deprecated
    public static float[] toYawAndPitch(Vector v) {
        return Utils.Coordinate.toYawAndPitch(v);
    }

    @Deprecated
    public static LivingEntity getLookAtEntity(LivingEntity e, double maxlength, int ρ) {
        return Utils.Coordinate.getLookAtEntity(e, maxlength, ρ);
    }

    private Coordinate() {
    }
}
