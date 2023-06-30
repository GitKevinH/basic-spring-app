package com.example.basicspringapplication14.repositories;


import com.example.basicspringapplication14.models.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}