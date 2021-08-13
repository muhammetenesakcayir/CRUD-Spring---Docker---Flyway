package com.enoca.message;

import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
public class MessageService {

    private final MessageSource messageSource;

    public MessageService(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    public String getText(String key, String... params) {
        try {
            return messageSource.getMessage(key, params, getLocale());
        } catch (NoSuchMessageException e) {
            return "";
        }
    }

    public String getMessageOrEmpty(String messageKey, String... params) {
        return messageSource.getMessage(messageKey, params, "", getLocale());
    }

    private Locale getLocale() {
        return LocaleContextHolder.getLocale();
    }
}
