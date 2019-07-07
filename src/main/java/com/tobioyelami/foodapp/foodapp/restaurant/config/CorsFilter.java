package com.tobioyelami.foodapp.foodapp.restaurant.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by toyelami on 06/07/2019
 */
@Component
public class CorsFilter extends OncePerRequestFilter{
    Logger logger = Logger.getLogger(CorsFilter.class.getName());

    @Value("${headers.access.allowed-origins:*}")
    private String accessControlAllowedDomain;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        String originHeader = request.getHeader("Origin");

        if (originHeader != null && !originHeader.isEmpty() && accessControlAllowedDomain.contains(originHeader)) {
            response.setHeader("Access-Control-Allow-Origin", originHeader);
            response.setHeader("Access-Control-Allow-Credentials", "true");
            response.setHeader("Access-Control-Allow-Methods", "POST, PUT, GET, OPTIONS, DELETE");
            response.setHeader("Access-Control-Max-Age", "3600");
            response.setHeader("Access-Control-Allow-Headers", "x-requested-with,origin,accept,content-type,access-control-request-method,access-control-request-headers,authorization,documentConfigName");
        }

        String method = request.getMethod();
        if (!method.equals("OPTIONS")) {
            try {
                filterChain.doFilter( request, response);
            } catch (ServletException | IOException e) {
                logger.log(Level.SEVERE, e.getMessage());
            }
        }
    }
}
