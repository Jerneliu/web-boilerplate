package github.jerneliu.webboilerplate.validation;

import github.jerneliu.webboilerplate.domain.BaseEntity;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.converter.ConverterFactory;

/**
 * ConvertFactory for BaseEntityConverter.
 *
 * @author snowblink on 15/11/8.
 */
public class BaseEntityConverterFactory implements ConverterFactory<String, BaseEntity> {

    @Override
    public <T extends BaseEntity> Converter<String, T> getConverter(Class<T> targetType) {
        return new BaseEntityConverter<T>(targetType);
    }
}
