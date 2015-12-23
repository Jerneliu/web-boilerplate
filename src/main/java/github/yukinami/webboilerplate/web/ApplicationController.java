package github.yukinami.webboilerplate.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Locale;

/**
 * Base Controller for the application
 *
 * @author snowblink on 15/11/6.
 */
public abstract class ApplicationController {

    private static final String TOAST_KEY = "message";

    @Autowired
    private MessageSource messageSource;

    /**
     * add the message to be toasted to model
     *
     * @param model
     * @param message
     */
    protected void toast(Model model, String message) {
        if (model instanceof RedirectAttributes) {
            ((RedirectAttributes) model).addFlashAttribute(TOAST_KEY, message);
        } else {
            model.addAttribute(TOAST_KEY, message);
        }
    }

    /**
     * localize message with the given key
     *
     * @param key
     * @param args
     * @return
     */
    protected String message(String key, Object... args) {
        return messageSource.getMessage(key, args, Locale.getDefault());
    }

}
