package ibf2022.paf.assessment.server.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import ibf2022.paf.assessment.server.exceptions.TodoNotCreatedException;

@ControllerAdvice
public class ErrorController {
    
    @ExceptionHandler(TodoNotCreatedException.class)
    public ModelAndView handleTodoNotCreatedException(TodoNotCreatedException ex){

        final ModelAndView mav = new ModelAndView("error.html");
        mav.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
        return mav;
    }

}
