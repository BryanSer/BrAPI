/*
 * 开发者:Bryan_lzh
 * QQ:390807154
 * 保留一切所有权
 * 若为Bukkit插件 请前往plugin.yml查看剩余协议
 */
package Br.API.Data;

import java.util.Arrays;
import java.util.Map;
import org.bukkit.Location;

/**
 *
 * @author Bryan_lzh
 * @version 1.0
 * @since 2019-2-17
 */
public class Zone implements BrConfigurationSerializable {

    @Config
    private Location top;
    @Config
    private Location bottom;

    public Zone(Location top, Location bottom) {
        setLocation(top, bottom);
    }

    public Zone(Map<String, Object> args) {
        BrConfigurationSerializable.deserialize(args, this);
    }

    public final void setLocation(Location l1, Location l2) {
        if (l1.getWorld() != l2.getWorld()) {
            throw new IllegalArgumentException("提供的两个坐标不位于一个世界");
        }
        int[] x = {l1.getBlockX(), l2.getBlockX()},
                y = {l1.getBlockY(), l2.getBlockY()},
                z = {l1.getBlockZ(), l2.getBlockZ()};
        Arrays.sort(x);
        Arrays.sort(y);
        Arrays.sort(z);
        this.bottom = new Location(l1.getWorld(), x[0], y[0], z[0]);
        this.top = new Location(l2.getWorld(), x[1], y[1], z[1]);
    }

    public boolean inZone(Location loc) {
        int[] arr = {loc.getBlockX(), loc.getBlockY(), loc.getBlockZ()};
        return loc.getWorld() == this.top.getWorld()
                ? arr[0] <= this.top.getBlockX()
                && arr[0] >= this.bottom.getBlockX()
                && arr[1] <= this.top.getBlockY()
                && arr[1] >= this.bottom.getBlockY()
                && arr[2] <= this.top.getBlockZ()
                && arr[2] >= this.bottom.getBlockZ()
                : false;
    }

    public Location getTop() {
        return top.clone();
    }

    public Location getBottom() {
        return bottom.clone();
    }

}
