package space.theshock.minecraft.queuesystem.player;

import java.util.UUID;

import lombok.Getter;
import lombok.Setter;

@Getter
public class QueuePlayer {

	private UUID uuid;
	@Setter
	private boolean enabledToLogin = false;

	public QueuePlayer(UUID uuid) {
		this.uuid = uuid;
	}

}
