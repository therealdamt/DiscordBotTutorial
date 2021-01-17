package xyz.damt.discordbot.commands;

import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import xyz.damt.discordbot.DiscordBot;

public class SayCommand extends ListenerAdapter {

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        Member member = event.getMember();
        String[] args = event.getMessage().getContentRaw().split("\\s+");


        if (!args[0].startsWith(DiscordBot.prefix)) {
            return;
        }

        if (args[0].equalsIgnoreCase(DiscordBot.prefix + "say")) {
            if (args.length > 1) {

                String text = "";
                for (int i = 1; i < args.length; i++) {
                    text += " " + args[i];
                }

                event.getMessage().delete().queue();
                event.getChannel().sendMessage(text).queue();


            } else {
                event.getChannel().sendMessage("/say <message>").queue();
            }
        }

    }
}
