package com.company.jcc.repository;

import com.company.jcc.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentRepository extends JpaRepository<Book, Integer> {
}
