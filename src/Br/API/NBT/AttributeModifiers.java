/*
 * 开发者:Bryan_lzh
 * QQ:390807154
 * 保留一切所有权
 * 若为Bukkit插件 请前往plugin.yml查看剩余协议
 */
package Br.API.NBT;

import java.util.EnumMap;
import java.util.EnumSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

/**
 *
 * @author Bryan_lzh
 */
public class AttributeModifiers {

    private static Random RANDOM = new Random();

    private Map<AttributeType, Double> Attrs_opt_0 = new EnumMap<>(AttributeType.class);
    private Map<AttributeType, Double> Attrs_opt_1 = new EnumMap<>(AttributeType.class);
    private Map<AttributeType, Double> Attrs_opt_2 = new EnumMap<>(AttributeType.class);
    private List<String> Solt = new LinkedList<>();

    /**
     * 操作值0: 直接加上value<P>
     * 操作值1: 在其他0操作计算完成后百分比加成<P>
     * 操作值2: 在操作值1全部完成后进行百分比加成.
     *
     * @param at 属性类型
     * @param value 属性值
     * @param opt 属性操作值
     */
    public void setAttribute(AttributeType at, double value, int opt) {
        switch (opt) {
            case 0:
                this.Attrs_opt_0.put(at, value);
                return;
            case 1:
                this.Attrs_opt_1.put(at, value);
                return;
            case 2:
                this.Attrs_opt_2.put(at, value);
                return;
        }
        throw new IllegalArgumentException("操作值必须为0或1或2");
    }

    public double getAttribute(AttributeType at) {
        return this.Attrs_opt_0.containsKey(at) ? this.Attrs_opt_0.get(at) : 0d;
    }

    public List<String> getSolt() {
        return this.Solt;
    }

    public ItemStack setItem(ItemStack is) {
        BrItemStack bi = new BrItemStack(is);
        BrNBTTagCompound basetag = bi.hasTag() ? bi.getTag() : new BrNBTTagCompound();
        BrNBTTagList oldattrs = (BrNBTTagList) basetag.getNBTBase("AttributeModifiers");
        BrNBTTagList attrs = null;
        if (oldattrs != null) {
            attrs = oldattrs;
        } else {
            attrs = new BrNBTTagList();
        }
        if (this.Solt.isEmpty()) {
            for (Map.Entry<AttributeType, Double> E : this.Attrs_opt_0.entrySet()) {
                BrNBTTagCompound tag = new BrNBTTagCompound();
                tag.set("Name", new BrNBTTagString(E.getKey().name()));
                tag.set("Amount", new BrNBTBase(E.getValue()));
                tag.set("UUIDLeast", new BrNBTBase(Math.abs(RANDOM.nextInt())));
                tag.set("UUIDMost", new BrNBTBase(Math.abs(RANDOM.nextInt())));
                tag.set("AttributeName", new BrNBTTagString(E.getKey().getPath()));
                tag.set("Operation", new BrNBTBase(0));
                attrs.add(tag);
            }
            for (Map.Entry<AttributeType, Double> E : this.Attrs_opt_1.entrySet()) {
                BrNBTTagCompound tag = new BrNBTTagCompound();
                tag.set("Name", new BrNBTTagString(E.getKey().name()));
                tag.set("Amount", new BrNBTBase(E.getValue()));
                tag.set("UUIDLeast", new BrNBTBase(Math.abs(RANDOM.nextInt())));
                tag.set("UUIDMost", new BrNBTBase(Math.abs(RANDOM.nextInt())));
                tag.set("AttributeName", new BrNBTTagString(E.getKey().getPath()));
                tag.set("Operation", new BrNBTBase(1));
                attrs.add(tag);
            }
            for (Map.Entry<AttributeType, Double> E : this.Attrs_opt_2.entrySet()) {
                BrNBTTagCompound tag = new BrNBTTagCompound();
                tag.set("Name", new BrNBTTagString(E.getKey().name()));
                tag.set("Amount", new BrNBTBase(E.getValue()));
                tag.set("UUIDLeast", new BrNBTBase(Math.abs(RANDOM.nextInt())));
                tag.set("UUIDMost", new BrNBTBase(Math.abs(RANDOM.nextInt())));
                tag.set("AttributeName", new BrNBTTagString(E.getKey().getPath()));
                tag.set("Operation", new BrNBTBase(2));
                attrs.add(tag);
            }
        } else {
            for (String solt : Solt) {
                for (Map.Entry<AttributeType, Double> E : this.Attrs_opt_0.entrySet()) {
                    BrNBTTagCompound tag = new BrNBTTagCompound();
                    tag.set("Name", new BrNBTTagString(E.getKey().name()));
                    tag.set("Amount", new BrNBTBase(E.getValue().doubleValue()));
                    tag.set("UUIDLeast", new BrNBTBase(Math.abs(RANDOM.nextInt())));
                    tag.set("UUIDMost", new BrNBTBase(Math.abs(RANDOM.nextInt())));
                    tag.set("AttributeName", new BrNBTTagString(E.getKey().getPath()));
                    tag.set("Slot", new BrNBTTagString(solt));
                    tag.set("Operation", new BrNBTBase(0));
                    attrs.add(tag);
                }
                for (Map.Entry<AttributeType, Double> E : this.Attrs_opt_1.entrySet()) {
                    BrNBTTagCompound tag = new BrNBTTagCompound();
                    tag.set("Name", new BrNBTTagString(E.getKey().name()));
                    tag.set("Amount", new BrNBTBase(E.getValue().doubleValue()));
                    tag.set("UUIDLeast", new BrNBTBase(Math.abs(RANDOM.nextInt())));
                    tag.set("UUIDMost", new BrNBTBase(Math.abs(RANDOM.nextInt())));
                    tag.set("AttributeName", new BrNBTTagString(E.getKey().getPath()));
                    tag.set("Slot", new BrNBTTagString(solt));
                    tag.set("Operation", new BrNBTBase(1));
                    attrs.add(tag);
                }
                for (Map.Entry<AttributeType, Double> E : this.Attrs_opt_2.entrySet()) {
                    BrNBTTagCompound tag = new BrNBTTagCompound();
                    tag.set("Name", new BrNBTTagString(E.getKey().name()));
                    tag.set("Amount", new BrNBTBase(E.getValue().doubleValue()));
                    tag.set("UUIDLeast", new BrNBTBase(Math.abs(RANDOM.nextInt())));
                    tag.set("UUIDMost", new BrNBTBase(Math.abs(RANDOM.nextInt())));
                    tag.set("AttributeName", new BrNBTTagString(E.getKey().getPath()));
                    tag.set("Slot", new BrNBTTagString(solt));
                    tag.set("Operation", new BrNBTBase(2));
                    attrs.add(tag);
                }
            }
        }
        basetag.set("AttributeModifiers", attrs);
        bi.setTag(basetag);
        ItemStack item = NBTUtils.getItemStack(bi);
        ItemMeta im = item.getItemMeta();
        im.removeItemFlags(ItemFlag.values());
        item.setItemMeta(im);
        return item;
    }

    public static ItemStack removeAttribute(ItemStack is, AttributeType at) {
        BrItemStack bi = new BrItemStack(is);
        BrNBTTagCompound basetag = bi.hasTag() ? bi.getTag() : new BrNBTTagCompound();
        BrNBTTagList attr = (BrNBTTagList) basetag.getNBTBase("AttributeModifiers");
        if (attr == null) {
            return is;
        }
        BrNBTTagList nattr = new BrNBTTagList();
        for (BrNBTBase b : attr.getList()) {
            if (b instanceof BrNBTTagCompound) {
                BrNBTBase nbt = ((BrNBTTagCompound) b).getNBTBase("Name");
                if (nbt instanceof BrNBTTagString) {
                    if (((BrNBTTagString) nbt).getValue().equals(at.name())) {
                        continue;
                    }
                }
            }
            nattr.add(b);
        }
        basetag.set("AttributeModifiers", nattr);
        bi.setTag(basetag);
        ItemStack item = NBTUtils.getItemStack(bi);
        return item;
    }

    public static ItemStack addAttribute(ItemStack is, AttributeType at, double value, int opt) {
        BrItemStack bi = new BrItemStack(is);
        BrNBTTagCompound basetag = bi.hasTag() ? bi.getTag() : new BrNBTTagCompound();
        BrNBTTagList attr = (BrNBTTagList) basetag.getNBTBase("AttributeModifiers");
        if (attr == null) {
            attr = new BrNBTTagList();
        }
        BrNBTTagCompound tag = new BrNBTTagCompound();
        tag.set("Name", new BrNBTTagString(at.name()));
        tag.set("Amount", new BrNBTBase(value));
        tag.set("UUIDLeast", new BrNBTBase(Math.abs(RANDOM.nextInt())));
        tag.set("UUIDMost", new BrNBTBase(Math.abs(RANDOM.nextInt())));
        tag.set("AttributeName", new BrNBTTagString(at.getPath()));
        tag.set("Operation", new BrNBTBase(2));
        attr.add(tag);
        basetag.set("AttributeModifiers", attr);
        bi.setTag(basetag);
        ItemStack item = NBTUtils.getItemStack(bi);
        ItemMeta im = item.getItemMeta();
        im.removeItemFlags(ItemFlag.values());
        item.setItemMeta(im);
        return item;
    }

    public static ItemStack addAttribute(ItemStack is, AttributeType at, double value, String slot, int opt) {
        BrItemStack bi = new BrItemStack(is);
        BrNBTTagCompound basetag = bi.hasTag() ? bi.getTag() : new BrNBTTagCompound();
        BrNBTTagList attr = (BrNBTTagList) basetag.getNBTBase("AttributeModifiers");
        if (attr == null) {
            attr = new BrNBTTagList();
        }
        BrNBTTagCompound tag = new BrNBTTagCompound();
        tag.set("Name", new BrNBTTagString(at.name()));
        tag.set("Amount", new BrNBTBase(value));
        tag.set("UUIDLeast", new BrNBTBase(Math.abs(RANDOM.nextInt())));
        tag.set("UUIDMost", new BrNBTBase(Math.abs(RANDOM.nextInt())));
        tag.set("AttributeName", new BrNBTTagString(at.getPath()));
        tag.set("Slot", new BrNBTTagString(slot));
        tag.set("Operation", new BrNBTBase(2));
        attr.add(tag);
        basetag.set("AttributeModifiers", attr);
        bi.setTag(basetag);
        ItemStack item = NBTUtils.getItemStack(bi);
        return item;
    }
}
