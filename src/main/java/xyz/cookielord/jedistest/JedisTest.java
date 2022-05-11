package xyz.cookielord.jedistest;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPubSub;
import xyz.cookielord.jedistest.events.ChatEvent;

public final class JedisTest extends JavaPlugin {

    private static JedisTest instance;
    private static JedisPool redis;
    @Override
    public void onEnable() {
        // Plugin startup logic
        redis = new JedisPool("localhost", 6379);

        getServer().getPluginManager().registerEvents(new ChatEvent(), this);

        RedisPubSub te = new RedisPubSub();
        te.setupChatSync();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static JedisPool getJedis(){
        return redis;
    }

}
