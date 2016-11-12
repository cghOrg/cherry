package com.bytebeats.example.host;

import com.bytebeats.switcher.core.PluginManager;
import com.bytebeats.switcher.example.api.IHelloService;
import com.bytebeats.switcher.example.api.IUserService;
import com.bytebeats.switcher.example.domain.User;

import java.util.List;

/**
 * Hello world!
 *
 */
public class App {

    public static void main( String[] args ) {

        PluginManager pluginManager = PluginManager.getMgr();
        pluginManager.addExternalJar("D:\\osgi");

        IHelloService helloService = pluginManager.getPlugin("com.bytebeats.example.plugin.HelloServiceImpl", IHelloService.class);
        helloService.hello("ricky");

        IUserService userService = pluginManager.getPlugin("com.bytebeats.example.plugin.UserServiceImpl", IUserService.class);
        List<User> list = userService.getUsers();
        System.out.println("list = [" + list + "]");

        userService.update(new User("test", "test"));
    }
}
