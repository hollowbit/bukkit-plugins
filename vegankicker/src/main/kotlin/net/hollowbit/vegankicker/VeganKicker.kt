package net.hollowbit.vegankicker

import org.bukkit.Bukkit
import org.bukkit.Material
import org.bukkit.command.Command
import org.bukkit.command.CommandSender
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.Action
import org.bukkit.event.player.PlayerInteractEvent
import org.bukkit.plugin.java.JavaPlugin

@SuppressWarnings("unused")
class VeganKicker: JavaPlugin(), Listener {

    private val bannedItems = listOf(
        Material.PORKCHOP,
            Material.COOKED_PORKCHOP,
            Material.MUTTON,
            Material.COOKED_MUTTON,
            Material.COOKED_BEEF,
            Material.BEEF,
            Material.COOKED_CHICKEN,
            Material.CHICKEN,
            Material.COOKED_RABBIT,
            Material.RABBIT,
            Material.RABBIT_STEW,
            Material.SPIDER_EYE
    )

    override fun onCommand(sender: CommandSender?, command: Command?, label: String?, args: Array<out String>?): Boolean {
        if (label == "heyo") {
            sender?.sendMessage("Hi mang!")
            return true
        }
        return super.onCommand(sender, command, label, args)
    }

    @EventHandler
    fun onPlayerClick(event: PlayerInteractEvent) {
        Bukkit.broadcastMessage("reched1")
        if (event.action == Action.RIGHT_CLICK_BLOCK || event.action == Action.RIGHT_CLICK_AIR) {
            val p = event.player
            Bukkit.broadcastMessage("reached 2  ${p.inventory.itemInMainHand.data.itemType.name}   ${p.inventory.itemInOffHand.data.itemType.name}")
            if (p.inventory.itemInMainHand.data.itemType in bannedItems || p.inventory.itemInOffHand.data.itemType in bannedItems) {
                Bukkit.broadcastMessage("reached 3")
                p.kickPlayer("This is a vegan server!")
            }
        }
    }

}