package github.yukinami.webboilerplate.config;

import github.yukinami.webboilerplate.validation.BaseEntityConverterFactory;
import github.yukinami.webboilerplate.view.thymeleaf.ApplicationDialect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.thymeleaf.dialect.IDialect;

/**
 * @author snowblink on 15/11/4.
 */
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {

    @Bean
    public IDialect applicationDialect() {
        return new ApplicationDialect();
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addRedirectViewController("/", "/todos");
    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
        super.addFormatters(registry);
        registry.addConverterFactory(new BaseEntityConverterFactory());
    }
}
