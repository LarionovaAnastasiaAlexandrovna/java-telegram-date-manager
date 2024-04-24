package telegram.bot.command;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Update;
import telegram.bot.annotation.CommandMapping;
import telegram.bot.util.CommandHandler;

@Component
@CommandMapping("/start")
public class StartCommand implements CommandHandler {
    @Override
    public void handle(Update update) {
        //TODO Обработка команды /start
    }
}