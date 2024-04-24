package telegram.bot.command;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Update;
import telegram.bot.annotation.CommandMapping;
import telegram.bot.util.CommandHandler;

@Component
@CommandMapping("/delete_category")
public class DeleteCategoryCommand implements CommandHandler {
    @Override
    public void handle(Update update) {
        //TODO Обработка команды /delete_category
    }
}