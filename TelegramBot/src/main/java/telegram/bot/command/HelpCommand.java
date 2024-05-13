package telegram.bot.command;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.botapimethods.BotApiMethodMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

@Component
public class HelpCommand implements CommandHandler {

    @Override
    public BotApiMethodMessage handle(Update update) {
        //TODO Обработка команды /help
        long chat_id = update.getMessage().getChatId();
        String start_message = """
                Welcome! This is assistance from JTDMTelegramBot.
                                
                Here is a list of available commands:
                                
                /add_category: Add a new category for organizing messages.
                /add_message: Add a new message to the specified category.
                /change_message: Modify an existing message.
                /delete_category: Delete an existing category and all associated messages.
                /delete_message: Delete a specific message from the selected category.
                /registration: Undergo registration procedure to access additional features.
                /rename_category: Rename an existing category.
                /use_category: Choose a category for further interaction with messages within it.""";

        SendMessage message = SendMessage // Create a message object
                .builder()
                .chatId(chat_id)
                .text(start_message)
                .build();
        return message;
    }
}
