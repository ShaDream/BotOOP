package data.commands;

import core.Bot;
import core.MessageHandlable;
import core.User;

public class QuizCommand extends CommandBase
{
    public QuizCommand()
    {
        super("Start playing quiz");
    }

    @Override
    public void execute(MessageHandlable bot, User user)
    {
        ((Bot)bot).games.find("quiz").start(user);
    }
}