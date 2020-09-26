package space.theshock.minecraft.queuesystem.listener;

import java.util.UUID;

import net.md_5.bungee.api.event.LoginEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;
import space.theshock.minecraft.queuesystem.BungeeMain;
import space.theshock.minecraft.queuesystem.player.QueuePlayer;
import space.theshock.minecraft.queuesystem.queue.Queue;

public class PlayerConnectionListener implements Listener {
	//
	@EventHandler
	public void onLogin(LoginEvent event) {
		UUID uuid = event.getConnection().getUniqueId();
		QueuePlayer queuePlayer = BungeeMain.getInstance().getQueuePlayerManager().getQueuePlayer(uuid);
		Queue queue = BungeeMain.getInstance().getQueue();

		
		if (queuePlayer.isEnabledToLogin()) {
			BungeeMain.getInstance().getQueuePlayerManager().removeQueuePlayer(uuid);
			queue.removeFromQueue(uuid);
			return;
		}

		if (!queue.inQueue(uuid)) {
			queue.addToQueue(uuid);
		}

		if (queue.inQueue(uuid)) {

			event.setCancelReason("§cVocê está na fila (N° " + (queue.indexOf(uuid) + 1) + ")");
			event.setCancelled(true);

			if (queue.indexOf(uuid) == 0) {
				queuePlayer.setEnabledToLogin(true);
			}
		}

	}

}
