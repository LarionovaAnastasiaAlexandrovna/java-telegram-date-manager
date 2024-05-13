package telegram.bot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.client.okhttp.OkHttpTelegramClient;
import org.telegram.telegrambots.longpolling.util.LongPollingSingleThreadUpdateConsumer;
import org.telegram.telegrambots.meta.api.methods.botapimethods.BotApiMethodMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.generics.TelegramClient;
import telegram.bot.command.*;
import telegram.bot.util.ExtractCommand;

@Component
public class JTDMTelegramBot implements LongPollingSingleThreadUpdateConsumer {
    private final TelegramClient telegramClient;

    @Autowired
    ExtractCommand extractCommand;

    public JTDMTelegramBot(String botToken) {
        telegramClient = new OkHttpTelegramClient(botToken);
        this.extractCommand = new ExtractCommand();
    }

    @Override
    public void consume(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            String message_text = update.getMessage().getText();
            long chat_id = update.getMessage().getChatId();
            switch (extractCommand.extractCommand(message_text)) {
                case ("/add_category") -> {
                    AddCategoryCommand addCategoryCommand = new AddCategoryCommand();
                    BotApiMethodMessage addCategoryMessage = addCategoryCommand.handle(update);
                    try {
                        telegramClient.execute(addCategoryMessage);
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                }
                case ("/add_message") -> {
                    AddMessageCommand addMessageCommand = new AddMessageCommand();
                    BotApiMethodMessage addMessageMessage = addMessageCommand.handle(update);
                    try {
                        telegramClient.execute(addMessageMessage);
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                }
                case ("/change_message") -> {
                    ChangeMessageCommand changeMessageCommand = new ChangeMessageCommand();
                    BotApiMethodMessage changeMessageMessage = changeMessageCommand.handle(update);
                    try {
                        telegramClient.execute(changeMessageMessage);
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                }
                case ("/delete_category") -> {
                    DeleteCategoryCommand deleteCategoryCommand = new DeleteCategoryCommand();
                    BotApiMethodMessage deleteCategoryMessage = deleteCategoryCommand.handle(update);
                    try {
                        telegramClient.execute(deleteCategoryMessage);
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                }
                case ("/delete_message") -> {
                    DeleteMessageCommand deleteMessageCommand = new DeleteMessageCommand();
                    BotApiMethodMessage deleteMessageMessage = deleteMessageCommand.handle(update);
                    try {
                        telegramClient.execute(deleteMessageMessage);
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                }
                case ("/help") -> {
                    HelpCommand helpCommand = new HelpCommand();
                    BotApiMethodMessage helpMessage = helpCommand.handle(update);
                    try {
                        telegramClient.execute(helpMessage);
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                }
                case ("/registration") -> {
                    RegistrationComand registrationComand = new RegistrationComand();
                    BotApiMethodMessage registrationMessage = registrationComand.handle(update);
                    try {
                        telegramClient.execute(registrationMessage);
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                }
                case ("/rename_category") -> {
                    RenameCategoryCommand renameCategoryCommand = new RenameCategoryCommand();
                    BotApiMethodMessage renameCategoryMessage = renameCategoryCommand.handle(update);
                    try {
                        telegramClient.execute(renameCategoryMessage);
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                }
                case ("/start") -> {
                    StartCommand startCommand = new StartCommand();
                    BotApiMethodMessage startMessage = startCommand.handle(update);
                    try {
                        telegramClient.execute(startMessage);
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                }
                case ("/use_category") -> {
                    UseCategoryCommand useCategoryCommand = new UseCategoryCommand();
                    BotApiMethodMessage useCategoryMessage = useCategoryCommand.handle(update);
                    try {
                        telegramClient.execute(useCategoryMessage);
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                }
                default -> {
                    SendMessage message = SendMessage // Create a message object
                            .builder()
                            .chatId(chat_id)
                            .text("Unknown command")
                            .build();
                    try {
                        telegramClient.execute(message);
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}