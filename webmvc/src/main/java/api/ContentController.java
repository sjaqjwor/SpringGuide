package api;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ContentController extends MultiActionController {

   public ModelAndView list(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse){
       ModelAndView modelAndView = new ModelAndView();
       modelAndView.setViewName("get");
        return modelAndView;
   }

}
