package com.xians.yaco.web.interceptor;


import cn.hutool.core.util.StrUtil;
import com.xians.yaco.model.enums.BlogPropertiesEnum;
import com.xians.yaco.model.enums.LocaleEnum;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

import static com.xians.yaco.model.dto.HaloConst.OPTIONS;

/**
 *国际化初始化拦截器
 * @author : wangry
 */
@Component
public class LocaleInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        final Object attribute = request.getSession().getAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME);
        if (null != attribute) {
            return true;
        }
        if (StrUtil.equals(LocaleEnum.EN_US.getValue(), OPTIONS.get(BlogPropertiesEnum.BLOG_LOCALE.getProp()))) {
            request.getSession().setAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME, new Locale("en", "US"));
        } else {
            request.getSession().setAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME, new Locale("zh", "CN"));
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
