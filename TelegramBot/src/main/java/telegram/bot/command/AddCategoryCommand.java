package telegram.bot.command;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Update;
import telegram.bot.annotation.CommandMapping;
import telegram.bot.util.CommandHandler;

@Component
@CommandMapping("/add_category")
public class AddCategoryCommand implements CommandHandler {
    @Override
    public void handle(Update update) {
        //TODO Обработка команды /add_category
    }
}
