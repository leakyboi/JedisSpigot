package xyz.cookielord.jedistest;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPubSub;

public class RedisPubSub {

    public void setupChatSync(){
        Thread thread = new Thread(() -> {
            try { JedisTest.getJedis().getResource().subscribe(new JedisPubSub() {
                @Override
                public void onMessage(String channel, String message) {
                    for(Player p: Bukkit.getServer().getOnlinePlayers()){
                        p.sendMessage(message);
                    }
                }

            }, "chatMessage"); } catch (Error e){
                System.out.println(e);
            }
        });
        thread.setDaemon(true);
        thread.start();
    }
}
