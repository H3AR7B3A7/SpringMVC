package be.dog.d.steven.controller;

import be.dog.d.steven.service.AdditionService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.Pattern;

@Controller
@Validated
public class AddController {

    @RequestMapping("/add")
    public ModelAndView add(
            @RequestParam("t1") @Pattern(message = "That is not a whole number.", regexp = "-?[1-9]\\d*|0") String i,
            @RequestParam("t2") @Pattern(message = "That is not a whole number.", regexp = "-?[1-9]\\d*|0") String j,
            HttpServletRequest request, HttpServletResponse response){

//        int i = Integer.parseInt(request.getParameter("t1"));
//        int j = Integer.parseInt(request.getParameter("t2"));

        AdditionService addition = new AdditionService();

        ModelAndView mv = new ModelAndView();
        mv.setViewName("result");
        mv.addObject("result", addition.sum(Integer.parseInt(i),Integer.parseInt(j)));

        return mv;
    }
}
