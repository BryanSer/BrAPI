/*
 * 开发者:Bryan_lzh
 * QQ:390807154
 * 保留一切所有权
 * 若为Bukkit插件 请前往plugin.yml查看剩余协议
 */
package Br.API.NBT;

/**
 *
 * @author Bryan_lzh
 */
public enum AttributeType {
    MaxHealth("generic.maxHealth"),
    FollowRange("generic.followRange"),
    KnockbackResistance("generic.knockbackResistance"),
    MovementSpeed("generic.movementSpeed"),
    AttackDamage("generic.attackDamage"),
    Armor("generic.armor"),
    AttackSpeed("generic.attackSpeed"),
    ArmorToughness("generic.armorToughness");

    private String path;

    private AttributeType(String s) {
        this.path = s;
    }

    public String getPath() {
        return this.path;
    }

    public AttributeType getAttributeType(String path) {
        for (AttributeType at : AttributeType.values()) {
            if (at.getPath().equalsIgnoreCase(path)) {
                return at;
            }
        }
        return null;
    }
}
