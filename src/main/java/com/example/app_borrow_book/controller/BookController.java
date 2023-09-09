package com.example.app_borrow_book.controller;

import com.example.app_borrow_book.entity.Book;
import com.example.app_borrow_book.entity.Oder;
import com.example.app_borrow_book.service.IBookService;
import com.example.app_borrow_book.service.IOderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.sql.Date;
import java.util.List;

@Controller
public class BookController {

    @Autowired
    private IBookService iBookService;

    @Autowired
    private IOderService iOderService;

    @GetMapping("/home")
    public ModelAndView home() {
        ModelAndView modelAndView = new ModelAndView("home");
        modelAndView.addObject("list", iBookService.findAll());
        return modelAndView;
    }

    @GetMapping("/oder/{idBook}")
    public String oder(@PathVariable int idBook, RedirectAttributes redirectAttributes) throws Exception {
        Book book = iBookService.findById(idBook);

        if (book.getCount() == 0) {
            throw new Exception();
        }
        book.setCount(book.getCount() - 1);


        Oder oder = new Oder();
        long code = (long) (Math.random() * (90000 - 10000) + 10000);
        oder.setCode(code);

        long millis = System.currentTimeMillis();
        oder.setDate(new Date(millis));

        // Lấy ra tất cả oders của book đang mượn sách
        List<Oder> oders = book.getList();
        oders.add(oder);
        book.setList(oders);

        iOderService.saveOder(oder);
        iBookService.save(book);
        redirectAttributes.addFlashAttribute("bookCode", "mã code của bạn là :" + code);
        return "redirect:/home";
    }

    @GetMapping("/returnBook/{idBook}")
    public String goReturnBook(@PathVariable int idBook, Model model) {
        Book book = iBookService.findById(idBook);
        model.addAttribute("idBook", idBook);
        return "returnBook";
    }

    @PostMapping("/returnBook")
    public String returnBook(@RequestParam long codeOder, @RequestParam int idBook ,RedirectAttributes redirectAttributes) throws Exception {
        Oder oder1 = iOderService.findByCode(codeOder);
        Book book = iBookService.findById(idBook);
        if (oder1 == null) {
            throw new Exception();
        } else {
            book.setCount(book.getCount() + 1);
        }

        List<Oder> oders = book.getList();
        oders.remove(oder1);
        book.setList(oders);


        redirectAttributes.addFlashAttribute("returnBook", "Bạn đã trả sách thành công !");
        iOderService.saveOder(oder1);
        iBookService.save(book);

        return "redirect:/home";
    }

    @GetMapping("/delete/{id}")
    public String doDelete(@PathVariable int id, Model model) {
        iBookService.delete(id);
        model.addAttribute("book", iBookService.findAll());
        return "redirect:/home";
    }


}
