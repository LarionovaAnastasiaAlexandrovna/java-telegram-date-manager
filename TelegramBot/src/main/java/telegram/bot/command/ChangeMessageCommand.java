package telegram.bot.command;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Update;
import telegram.bot.annotation.CommandMapping;
import telegram.bot.util.CommandHandler;

@Component
@CommandMapping("/change_message")
public class ChangeMessageCommand implements CommandHandler {
    @Override
    public void handle(Update update) {
        //TODO Обработка команды /change_message
    }
}