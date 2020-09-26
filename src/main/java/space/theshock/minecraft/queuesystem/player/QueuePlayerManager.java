package space.theshock.minecraft.queuesystem.player;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class QueuePlayerManager {

	private Map<UUID, QueuePlayer> queuePlayerMap;

	public QueuePlayerManager() {
		queuePlayerMap = new HashMap<>();
	}

	public QueuePlayer getQueuePlayer(UUID uuid) {
		if (!queuePlayerMap.containsKey(uuid))
			queuePlayerMap.put(uuid, new QueuePlayer(uuid));
		return queuePlayerMap.get(uuid);
	}

}
