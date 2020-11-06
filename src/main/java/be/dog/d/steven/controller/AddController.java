package be.dog.d.steven.controller;

import be.dog.d.steven.service.AdditionService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class AddController {

    @RequestMapping("/add")
    public ModelAndView add(HttpServletRequest request, HttpServletResponse response){

        int i = Integer.parseInt(request.getParameter("t1"));
        int j = Integer.parseInt(request.getParameter("t2"));

        AdditionService addition = new AdditionService();

        ModelAndView mv = new ModelAndView();
        mv.setViewName("result");
        mv.addObject("result", addition.sum(i,j));

        return mv;
    }
}
