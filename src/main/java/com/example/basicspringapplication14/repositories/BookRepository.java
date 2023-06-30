package com.example.basicspringapplication14.repositories;


import com.example.basicspringapplication14.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
