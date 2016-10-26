package egovframework.com.cmm.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.ModelAndViewDefiningException;
import org.springframework.web.servlet.mvc.WebContentInterceptor;

import egovframework.com.cmm.util.EgovUserDetailsHelper;

public class SessionCheckInterceptor extends WebContentInterceptor {
	private final static Logger LOG = LoggerFactory.getLogger(SessionCheckInterceptor.class);

	public void isLogined() throws ModelAndViewDefiningException {
		if (!EgovUserDetailsHelper.isAuthenticated()) {
			LOG.info("user is not logined");
			ModelAndView modelAndView = new ModelAndView("redirect:/index.do");
			throw new ModelAndViewDefiningException(modelAndView);
		}
	}

}
