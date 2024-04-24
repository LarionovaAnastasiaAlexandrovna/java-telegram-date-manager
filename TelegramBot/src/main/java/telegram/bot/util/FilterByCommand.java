package telegram.bot.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Update;

@Component
public class FilterByCommand {

    @Autowired
    private CommandHandlerMapping commandHandlerMapping;

    public void filterByCommand(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            String messageText = update.getMessage().getText();
            String command = extractCommand(messageText);
            CommandHandler handler = commandHandlerMapping.getHandler(command);
            if (handler != null) {
                handler.handle(update);
            } else {
                // Обработка неизвестной команды
            }
        }
    }

    private String extractCommand(String messageText) {
        //TODO сделать регулярку, которая отлавливает часть по типу /[A-Za-z] + _ Короче до первого пробела
        return "";
    }
}
