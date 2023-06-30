package com.example.basicspringapplication14.controllers;

import com.example.basicspringapplication14.models.Author;
import com.example.basicspringapplication14.models.Book;
import com.example.basicspringapplication14.repositories.AuthorRepository;
import com.example.basicspringapplication14.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/books")
public class BookController {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public BookController(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        List<Author> authors = authorRepository.findAll();
        model.addAttribute("book", new Book());
        model.addAttribute("authors", authors);
        return "book-create";
    }

    @PostMapping("/create")
    public String createBook(@ModelAttribute("book") Book book) {
        bookRepository.save(book);
        return "redirect:/books";
    }

    @GetMapping
    public String showBooks(Model model) {
        List<Book> books = bookRepository.findAll();
        model.addAttribute("books", books);
        return "book-list";
    }
}