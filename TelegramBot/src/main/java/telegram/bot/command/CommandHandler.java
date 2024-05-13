package telegram.bot.command;

import org.telegram.telegrambots.meta.api.methods.botapimethods.BotApiMethodMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

public interface CommandHandler {
    BotApiMethodMessage handle(Update update);
}

