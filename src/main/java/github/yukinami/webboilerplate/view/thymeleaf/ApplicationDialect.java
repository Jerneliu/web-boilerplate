package github.yukinami.webboilerplate.view.thymeleaf;

import github.yukinami.webboilerplate.view.helper.ViewHelper;
import org.thymeleaf.context.IProcessingContext;
import org.thymeleaf.dialect.AbstractDialect;
import org.thymeleaf.dialect.IExpressionEnhancingDialect;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Thymeleaf dialect for extension
 *
 * @author snowblink on 15/11/5.
 */
public class ApplicationDialect extends AbstractDialect implements IExpressionEnhancingDialect {

    private static final Map<String, Object> EXPRESSION_OBJECTS;
    static {
        Map<String, Object> objects = new HashMap<>();
        objects.put("viewHelper", new ViewHelper());
        EXPRESSION_OBJECTS = Collections.unmodifiableMap(objects);
    }

    @Override
    public Map<String, Object> getAdditionalExpressionObjects(IProcessingContext processingContext) {
        return EXPRESSION_OBJECTS;
    }

    @Override
    public String getPrefix() {
        return null;
    }
}
