package github.jerneliu.webboilerplate.validation;

import github.jerneliu.webboilerplate.domain.BaseEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.convert.converter.Converter;

/**
 * Convert id string to id based entity.
 *
 * @author snowblink on 15/11/8.
 */
public class BaseEntityConverter<T extends BaseEntity> implements Converter<String, T> {

    private final Logger logger = LoggerFactory.getLogger(BaseEntityConverter.class);

    public Class<T> targetType;

    public BaseEntityConverter(Class<T> targetType) {
        this.targetType = targetType;
    }

    @Override
    public T convert(String source) {
        T target = null;
        try {
            target = targetType.newInstance();
        } catch (Exception e) {
            logger.error("Error occurred converting target", e);
        }

        if (target != null) {
            target.setId(Integer.parseInt(source));
        }
        return target;
    }
}
