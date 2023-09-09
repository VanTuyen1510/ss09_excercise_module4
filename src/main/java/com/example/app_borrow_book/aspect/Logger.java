package com.example.app_borrow_book.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@Aspect
@Component
public class Logger {

    @AfterThrowing(value = "execution(* com.example.app_borrow_book.controller.BookController.oder(..))")
    public void checkEx() {
        System.out.println("--------------");
        System.out.println("Gặp lỗi");
    }

    @After(value = "execution(* com.example.app_borrow_book.controller.BookController.oder(..))")
    public void logOderDone() {
        System.out.println("---------------");
        System.out.println("Done");
    }

    @ExceptionHandler(Exception.class)
    public ModelAndView handlerError(Exception e){
        ModelAndView modelAndView = new ModelAndView("error");
        return modelAndView;
    }
}
