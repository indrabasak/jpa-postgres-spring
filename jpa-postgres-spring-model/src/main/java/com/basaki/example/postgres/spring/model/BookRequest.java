package com.basaki.example.postgres.spring.model;

import lombok.Data;

/**
 * {@code BookRequest} represents a request to create or update a book entity.
 * <p/>
 *
 * @author Indra Basak
 * @since 3/8/17
 */
@Data
public class BookRequest {
    private String title;
    private String author;
    private Genre genre;
}
