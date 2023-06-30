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
import java.util.Optional;

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

    @GetMapping("/update/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if (optionalBook.isPresent()) {
            Book book = optionalBook.get();
            List<Author> authors = authorRepository.findAll();
            model.addAttribute("book", book);
            model.addAttribute("authors", authors);
            return "book-update";
        } else {
            return "redirect:/books";
        }
    }

    @PostMapping("/update")
    public String updateBook(@ModelAttribute("book") Book book) {
        bookRepository.save(book);
        return "redirect:/books";
    }

    @PostMapping("/update/{id}")
    public String updateBook(@PathVariable("id") Long id, @ModelAttribute("book") Book book) {
        // Retrieve the existing book from the repository
        Book existingBook = bookRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid book id: " + id));

        // Update the properties of the existing book with the new values
        existingBook.setTitle(book.getTitle());
        existingBook.setAuthor(book.getAuthor());

        // Save the updated book
        bookRepository.save(existingBook);

        return "redirect:/books";
    }


    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable("id") Long id) {
        bookRepository.deleteById(id);
        return "redirect:/books";
    }
}