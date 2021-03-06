package functions.quiz.commands;

import core.CommandBase;
import core.Message;
import core.User;
import functions.quiz.Quiz;

public class NextQuizCommand extends CommandBase<Quiz>
{

    NextQuizCommand()
    {
        super("Change question on Quiz");
    }

    @Override
    public void execute(Quiz bot, Message message)
    {
        bot.next(message.getUser());
    }
}
