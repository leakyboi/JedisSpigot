package xyz.cookielord.jedistest.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import redis.clients.jedis.Jedis;
import xyz.cookielord.jedistest.JedisTest;

public class ChatEvent implements Listener {

    @EventHandler
    public void onPlayerJoin(AsyncPlayerChatEvent event) {
        JedisTest.getJedis().getResource().publish("chatMessage", event.getMessage());
    }

}
