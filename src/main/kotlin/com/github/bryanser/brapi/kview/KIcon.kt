package com.github.bryanser.brapi.kview

import org.bukkit.event.inventory.ClickType
import org.bukkit.inventory.ItemStack
import kotlin.jvm.JvmDefault

interface KIcon<H : KViewHolder> {
    /*
    * 点击后是否继续保持UI开启
    */
    var keepOpen: Boolean
    /*
     * 点击后是否更新整个UI
     */
    var updateAll: Boolean
    /*
     * 更新时是否更新自身显示
     */
    var updateIcon: Boolean

    /*
     * 初次打开UI时显示的物品
     * @param holder UI的上下文
     * @return 显示的物品
     */
    fun initDisplay(holder: H): ItemStack?

    /*
     * 后序更新UI中使用的显示
     * @param holder UI的上下文
     * @return 显示的物品
     */
    fun update(holder: H): ItemStack?

    /*
     * 点击UI时调用的方法
     * @param holder UI的上下文
     */
    fun onClick(type: ClickType, holder: H)

    /*
     * 用数字键点击时调用的方法
     * @param holder UI的上下文
     * @param key 点击的数字范围[0-8] 分别对应字母键盘上放的1,2,3,4,5,6,7,8,9
     */
    fun numberClick(holder: H, key: Int)

    /*
     * 是否取消本次点击事件
     * *默认取消*
     * @param holder UI的上下文
     * @return 返回true时将取消点击事件
     */
    @JvmDefault
    fun cancelClickEvent(holder: H): Boolean {
        return true
    }
}