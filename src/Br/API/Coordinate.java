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
    public static float[] toYawAndPitch(Vector v) {
        double pitch = Math.acos(-v.getY());
        return new float[]{(float) Math.toDegrees(Math.asin(-v.getX() / Math.acos(pitch))), (float) Math.toDegrees(pitch)};
    }

    public static LivingEntity getLookAtEntity(LivingEntity e, double maxlength, int ρ) {
        Egg d = e.getWorld().spawn(e.getLocation().add(0, -5, 0), Egg.class);
        d.setSilent(true);
        Location loc = e.getEyeLocation();
        d.setGravity(false);
        Vector v = e.getLocation().getDirection();
        for (double l = maxlength / ρ; l < maxlength; l += maxlength / ρ) {
            Vector vd = v.clone().multiply(l);
            d.teleport(loc.clone().add(vd));
            if (d.getLocation().getBlock().getType() != Material.AIR) {
                d.remove();
                return null;
            }
            for (Entity eeee : d.getNearbyEntities(0.25, 0.25, 0.25)) {
                if (eeee == e) {
                    continue;
                }
                if (eeee instanceof LivingEntity) {
                    d.remove();
                    return (LivingEntity) eeee;
                }
            }
        }
        d.remove();
        return null;
    }

    private Coordinate() {
    }
}
