package telegram.bot.command;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.botapimethods.BotApiMethodMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

@Component
public class AddMessageCommand implements CommandHandler {
    @Override
    public BotApiMethodMessage handle(Update update) {
        // TODO Обработка команды /add_message
        long chat_id = update.getMessage().getChatId();
        String start_message = """
                Hello in JTDMTelegramBot!
                Command /add_message isn't ready""";

        SendMessage message = SendMessage // Create a message object
                .builder()
                .chatId(chat_id)
                .text(start_message)
                .build();
        return message;
    }
}