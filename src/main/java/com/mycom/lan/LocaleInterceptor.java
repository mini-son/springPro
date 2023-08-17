package com.mycom.lan;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LocaleInterceptor extends HandlerInterceptorAdapter {
	
	//컨트롤러 실행 전에 호출
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session=request.getSession();
        String locale=request.getParameter("locale");
        System.out.println("인터셉터 preHandle()의 locale="+locale);
        if(locale==null)
           locale="ko";
        session.setAttribute("org.springframework.web.servlet.i18n.SessionLocaleResolver.LOCALE",new Locale(locale));
		System.out.println("세션후="+session.getAttribute("org.springframework.web.servlet.i18n.SessionLocaleResolver.LOCALE"));
        return true;
	}
	
	//컨트롤러 실행 후 DispatcherServlet이 뷰로 보내기 전에 호출
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
	}
	
	//뷰까지 수행이되고 난 이후에 호출
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
	}

}
