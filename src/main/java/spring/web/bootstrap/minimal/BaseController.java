package spring.web.bootstrap.minimal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping(value="/")
public class BaseController {
	@RequestMapping("/")
    protected ModelAndView init() throws Exception {
		ModelAndView model = new ModelAndView("scrolling-nav");
		//model.addObject("expListSize", expDao.count());
		return model;
    }
	
	@RequestMapping("/OAuth2v1")
    protected ModelAndView getOauth2(@RequestParam(value="code", required=false) String code, @RequestParam(value="state", required=false) String state) throws Exception {
		ModelAndView model = new ModelAndView("index");
		System.out.println("code: " + code);
		System.out.println("state: " + state);
		if (code==null || state==null) {
			model.setView(new RedirectView(new GoogleAuthHelper().buildLoginUrl()));
		} else if (code!=null) {
			System.out.println(new GoogleAuthHelper().getUserInfoJson(code));
		}
		return model;
    }
}
