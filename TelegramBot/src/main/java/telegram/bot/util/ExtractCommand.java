package telegram.bot.util;

import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class ExtractCommand {
    public String extractCommand(String messageText) {
        String regex = "^/[A-Za-z_]+";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(messageText);
        if (matcher.find()) {
            return matcher.group();
        } else {
            //TODO обработка если команда не найдена
            return "";
        }
    }
}
