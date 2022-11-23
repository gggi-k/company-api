package kr.kko.kakaoassignapi.core.error.handler;

import kr.kko.kakaoassignapi.core.error.NotFoundException;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

@Component
public class ErrorAttributes extends DefaultErrorAttributes {
    @Override
    public Map<String, Object> getErrorAttributes(WebRequest webRequest, ErrorAttributeOptions options) {
        return super.getErrorAttributes(webRequest, options);
    }
}