package games.anonymous;

import core.Message;
import core.MessageHandler;
import core.User;
import games.BaseGame;
import games.GameType;
import games.anonymous.commands.AnonymousCommandSet;

import java.util.ArrayList;

public class Anonymous extends BaseGame
{
    private ArrayList<User> users = new ArrayList<User>();
    private AnonymousCommandSet commands = new AnonymousCommandSet();
    private MessageHandler bot;
    public Searcher searcher;


    public Anonymous(MessageHandler bot)
    {
        type = GameType.Anonymous;
        this.bot = bot;
        this.searcher = new Searcher(bot);
    }

    @Override
    public void start(User user)
    {
        if (!users.contains(user)) users.add(user);
        searcher.addUser(user);
        sendMessage(new Message("Hello, you start anonymous. say /search to find chatmate users in db:" + users.size(), user));
        user.state = GameType.Anonymous;
    }

    @Override
    public void stop(User user)
    {
        sendMessage(new Message("You are living anonymous chat", user));
        //  if (searchers.contains(user)) searchers.remove(user);
        searcher.stop(user);
        user.state = GameType.None;
    }

    @Override
    public void sendMessage(Message message)
    {
        bot.sendMessage(message);
    }

    @Override
    public void handleMessage(Message message)
    {
        var user = message.user;
        if (commands.hasCommand(message.text))
            commands.find(message.text).execute(this, user);
        else searcher.handleMessage(message);
    }
}
