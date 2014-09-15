package spring.web.bootstrap.minimal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class BaseController {
	@RequestMapping("/")
    protected ModelAndView init() throws Exception {
		ModelAndView model = new ModelAndView("scrolling-nav");
		//model.addObject("expListSize", expDao.count());
		return model;
    }
}
