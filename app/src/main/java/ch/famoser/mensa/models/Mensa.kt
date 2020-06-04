package ch.famoser.mensa.models

import com.squareup.moshi.JsonClass
import java.net.URI
import java.util.*
import kotlin.collections.ArrayList

@JsonClass(generateAdapter = true)
class Mensa(
    val id: UUID,
    val title: String,
    val mealTime: String,
    val url: URI,
    val imagePath: String? = null
) {
    var location: Location? = null

    private val _menus: MutableList<Menu> = ArrayList()

    val menus: List<Menu>
        get() = _menus

    fun replaceMenus(menus: List<Menu>) {
        this._menus.clear()

        for (menu in menus) {
            menu.mensa = this
            this._menus.add(menu)
        }
    }

    override fun toString(): String = title
}