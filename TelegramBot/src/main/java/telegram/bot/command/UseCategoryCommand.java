package telegram.bot.command;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Update;
import telegram.bot.annotation.CommandMapping;
import telegram.bot.util.CommandHandler;

@Component
@CommandMapping("/use_category")
public class UseCategoryCommand implements CommandHandler {
    @Override
    public void handle(Update update) {
        //TODO Обработка команды /use_category
    }
}