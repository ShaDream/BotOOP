package games.anonymous.commands;

import core.CommandBase;
import core.MessageHandlable;
import core.User;
import games.anonymous.Anonymous;

public class AbandonChatAnonymousCommand extends CommandBase
{
    public AbandonChatAnonymousCommand()
    {
        super("Abbaadon from chat");
    }

    @Override
    public void execute(MessageHandlable anonymous, User user)
    {
        ((Anonymous) anonymous).abandonChat(user);
    }
}