package com.adu21.spring.boot.global.param.trace.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import com.adu21.spring.boot.global.param.trace.context.AppContext;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author LukeDu
 * @date 2019/12/21
 */
@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
@Slf4j
public class ContextFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
        throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;

        String traceId = request.getHeader(AppContext.TRACE_ID_HEADER);
        if (StringUtils.isNotBlank(traceId)) {
            AppContext.getContext().setTraceId(traceId);
        }

        String userId = request.getHeader(AppContext.USER_ID_HEADER);
        if (StringUtils.isNotBlank(userId)) {
            AppContext.getContext().setUserId(Long.valueOf(userId));
        }

        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }
}
