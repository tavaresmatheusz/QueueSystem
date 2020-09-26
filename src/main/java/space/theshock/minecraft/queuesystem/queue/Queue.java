package space.theshock.minecraft.queuesystem.queue;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Queue {

	private List<UUID> queue;

	public Queue() {
		queue = new ArrayList<>();
	}

	public void addToQueue(UUID uuid) {
		if (!queue.contains(uuid))
			queue.add(uuid);
	}

	public void removeFromQueue(UUID uuid) {
		System.out.println("removido da fila");
		if (queue.contains(uuid))
			queue.remove(uuid);
	}

	public void removeFromQueue(int i) {
		if (queue.size() > i)
			queue.remove(i);
	}

	public boolean inQueue(UUID uuid) {
		return queue.contains(uuid);
	}
	
	public int indexOf(UUID uuid) {
		return queue.indexOf(uuid);
	}

}
