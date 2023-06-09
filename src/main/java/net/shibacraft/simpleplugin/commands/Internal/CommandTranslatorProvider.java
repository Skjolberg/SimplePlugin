package net.shibacraft.simpleplugin.commands.Internal;

import lombok.Getter;
import me.fixeddev.commandflow.Namespace;
import me.fixeddev.commandflow.translator.DefaultMapTranslationProvider;

import java.util.HashMap;
import java.util.Map;

@Getter
public class CommandTranslatorProvider extends DefaultMapTranslationProvider {

    public static CommandTranslatorProvider commandTranslatorProvider;
    protected Map<String, String> translations = new HashMap<>();

    public CommandTranslatorProvider() {
        commandTranslatorProvider = this;

        translations.put("command.subcommand.invalid", "Messages.INVALID_ARGUMENT.get()");
        translations.put("command.no-permission", "Messages.NO_PERMISSION.get()");
        translations.put("argument.no-more", "No more arguments were found, size: %s position: %s");
        translations.put("number.out-range", "The number %s is not within the range min: %s max: %s");
        translations.put("invalid.byte", "The number %s is not a valid byte!");
        translations.put("invalid.integer", "The number %s is not a valid integer!");
        translations.put("invalid.float", "The number %s is not a valid float!");
        translations.put("invalid.double", "The number %s is not a valid double!");
        translations.put("invalid.boolean", "The string %s is not a valid boolean!");
        translations.put("invalid.enum-value", "The value %s is not valid, the valid values are: %s");
        translations.put("invalid.long", "The number %s is not a valid long!");
    }

    public void reload() {
        translations.put("command.subcommand.invalid", "Messages.INVALID_ARGUMENT.get()");
        translations.put("command.no-permission", "Messages.NO_PERMISSION.get()");
    }

    public String getTranslation(String key) {
        return translations.get(key);
    }

    @Override
    public String getTranslation(Namespace namespace, String key) {
        return getTranslation(key);
    }


}
