package telegram.bot.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import telegram.bot.annotation.CommandMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class CommandHandlerMapping {

    private final Map<String, CommandHandler> commandHandlerMap;

    @Autowired
    public CommandHandlerMapping(List<CommandHandler> commandHandlers) {
        this.commandHandlerMap = new HashMap<>();
        for (CommandHandler handler : commandHandlers) {
            CommandMapping annotation = handler.getClass().getAnnotation(CommandMapping.class);
            if (annotation != null) {
                String command = annotation.value();
                commandHandlerMap.put(command, handler);
            }
        }
    }

    public CommandHandler getHandler(String command) {
        return commandHandlerMap.get(command);
    }
}

