package net.hollowbit.vegankicker

import org.bukkit.Bukkit
import org.bukkit.Material
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.Action
import org.bukkit.event.player.PlayerInteractEvent
import org.bukkit.plugin.java.JavaPlugin

class VeganKicker: JavaPlugin(), Listener {

    override fun onEnable() {
        super.onEnable()
        Bukkit.getServer().pluginManager.registerEvents(this, this)
    }

    private val bannedItems = listOf(
        Material.LEGACY_PORK,
            Material.LEGACY_GRILLED_PORK,
            Material.LEGACY_MUTTON,
            Material.LEGACY_COOKED_MUTTON,
            Material.LEGACY_COOKED_BEEF,
            Material.LEGACY_COOKED_CHICKEN,
            Material.LEGACY_COOKED_RABBIT,
            Material.LEGACY_RABBIT,
            Material.LEGACY_RABBIT_STEW,
            Material.LEGACY_SPIDER_EYE
    )

    @EventHandler
    fun onPlayerClick(event: PlayerInteractEvent) {
        if (event.action == Action.RIGHT_CLICK_BLOCK || event.action == Action.RIGHT_CLICK_AIR) {
            val p = event.player
            if (p.inventory.itemInMainHand.data.itemType in bannedItems || p.inventory.itemInOffHand.data.itemType in bannedItems) {
                p.kickPlayer("This is a vegan server!")
            }
        }
    }

}