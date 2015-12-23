package github.jerneliu.webboilerplate.view.helper;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;

/**
 * Helper class for view
 *
 * @author snowblink on 15/11/5.
 */
public final class ViewHelper {

    /**
     * test if target mapping name is match current requested url
     *
     * @param mappingName
     * @param uriVariables
     * @return
     */
    public final boolean isCurrentController(String mappingName, String... uriVariables) {
        String targetUrl = MvcUriComponentsBuilder.fromMappingName(mappingName).buildAndExpand((Object[])uriVariables);

        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        return request.getRequestURL().toString().equals(targetUrl);
    }
}
