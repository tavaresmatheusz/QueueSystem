package space.theshock.minecraft.queuesystem;

import java.util.concurrent.TimeUnit;

import lombok.Getter;
import lombok.Setter;
import net.md_5.bungee.api.plugin.Plugin;
import space.theshock.minecraft.queuesystem.listener.PlayerConnectionListener;
import space.theshock.minecraft.queuesystem.player.QueuePlayerManager;
import space.theshock.minecraft.queuesystem.queue.Queue;

public class BungeeMain extends Plugin {
// 
	@Getter
	@Setter
	private static BungeeMain instance;
	@Getter
	private QueuePlayerManager queuePlayerManager;
	@Getter
	private Queue queue;

	@Override
	public void onLoad() {
		setInstance(this);
	}

	@Override
	public void onEnable() {

		queuePlayerManager = new QueuePlayerManager();
		queue = new Queue();

		getProxy().getPluginManager().registerListener(getInstance(), new PlayerConnectionListener());
		
		getProxy().getScheduler().schedule(this, new Runnable() {

			@Override
			public void run() {
				
				for (int i = 0; i < 2; i++)
					queue.removeFromQueue(i);

			}
		}, 0, 6, TimeUnit.SECONDS);

	}

}
