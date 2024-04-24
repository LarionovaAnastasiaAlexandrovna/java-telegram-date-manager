package telegram.bot.command;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Update;
import telegram.bot.util.CommandHandler;

@Component
public class ErrorCommand implements CommandHandler {
    @Override
    public void handle(Update update) {
        //TODO Обработка ситуации, когда клиент написал ерунду
    }
}