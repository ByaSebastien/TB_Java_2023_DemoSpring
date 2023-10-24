package be.bstorm.controllers;

import be.bstorm.models.dtos.book.BookDTO;
import be.bstorm.models.dtos.book.BookShortDTO;
import be.bstorm.models.entities.Book;
import be.bstorm.models.forms.BookForm;
import be.bstorm.services.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/book")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/create")
    public String getCreate(Model model){
        model.addAttribute("book",new BookForm());
        return "book/create";
    }

    @PostMapping("/create")
    public String postCreate(@ModelAttribute BookForm form){
        bookService.create(form.toEntity());
        return "redirect:/book";
    }

    @GetMapping
    public String findAll(Model model){
        List<Book> books = bookService.getAll();
        List<BookShortDTO> dtos = books.stream()
                .map(BookShortDTO::fromEntity)
                .toList();
        model.addAttribute("books",dtos);
        return "book/index";
    }

    @GetMapping("/{id}")
    public String findOne(@PathVariable Long id,Model model){
        Book book = bookService.getOne(id);
        BookDTO dto = BookDTO.fromEntity(book);
        model.addAttribute("book",dto);
        return "book/detail";
    }

    @GetMapping("/update/{id}")
    public String getUpdate(@PathVariable Long id, Model model){
        Book book = bookService.getOne(id);
        BookForm form = BookForm.fromEntity(book);
        model.addAttribute("id",id);
        model.addAttribute("book",form);
        return "book/update";
    }
    @PostMapping("update/{id}")
    public String postUpdate(@PathVariable Long id, @ModelAttribute BookForm form){
        bookService.update(id,form.toEntity());
        return "redirect:/book";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable Long id){
        bookService.delete(id);
        return "redirect:/book";
    }
}