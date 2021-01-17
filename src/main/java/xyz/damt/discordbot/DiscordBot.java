package xyz.damt.discordbot;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import xyz.damt.discordbot.commands.SayCommand;

import javax.security.auth.login.LoginException;

public class DiscordBot {

    private static JDA jda;
    public static String prefix;

    public static void main(String[] args) {

        prefix = "-";

        try {
            jda = JDABuilder.createDefault("your token").build();
        } catch (LoginException e) {
            e.printStackTrace();
            System.out.println("There was an error logging in your token!");
        }

        jda.getPresence().setActivity(Activity.streaming("damt", "https://twitch.tv/damtistheboi"));
        jda.addEventListener(new SayCommand());

    }


}
