package com.example.metricsdemo;

import java.io.IOException;
import java.util.Enumeration;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
public class AuditLogFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal( HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain chain) throws ServletException, IOException {
        System.out.println(request.getRemoteAddr());
        chain.doFilter(request, response);
//        System.out.println(request.getHeader());
//        System.out.println(request.getHeaderNames());
        Enumeration<String> e = request.getHeaderNames();

        while (e.hasMoreElements()) {
            String param = e.nextElement();
            System.out.println(request.getHeader(param));
        }

//        Enumeration<String> headers = headers1);
        
    }
}