package telegram.bot;
import org.telegram.telegrambots.longpolling.TelegramBotsLongPollingApplication;
import telegram.bot.service.JTDMTelegramBot;


public class TelegramBotApplication {
    public static void main(String[] args) {
        String botToken = "12345:your_token";
        try (TelegramBotsLongPollingApplication botsApplication = new TelegramBotsLongPollingApplication()) {
            botsApplication.registerBot(botToken, new JTDMTelegramBot(botToken));
            System.out.println("JTDMTelegramBot successfully started!");
            Thread.currentThread().join();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}