package com.roya.bookstore.admin;

import com.roya.bookstore.base.dto.BookDto;
import com.roya.bookstore.common.GenericResponse;
import com.roya.bookstore.enums.ResponseStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/books")
@RequiredArgsConstructor
public class AdminBookController {
    private final AdminBookService adminBookService;


    @PostMapping
    public ResponseEntity<GenericResponse> addBook(@RequestBody BookDto bookDto) {
        BookDto responseBookDto = adminBookService.addBook(bookDto);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(GenericResponse.builder()
                        .source(null)
                        .responseStatus(ResponseStatus.SUCCESS)
                        .responseBody(responseBookDto)
                        .build());
    }

    @DeleteMapping("/{bookId}")
    public ResponseEntity<GenericResponse> removeBook(@PathVariable String bookId) {
        String removedBookId = adminBookService.removeBook(bookId);

        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body(GenericResponse.builder()
                        .source(null)
                        .responseStatus(ResponseStatus.SUCCESS)
                        .responseBody(removedBookId)
                        .build());
    }

    @PutMapping("/{bookId}")
    public ResponseEntity<GenericResponse> updateBook(@PathVariable String bookId, @RequestBody BookDto bookDto) {
        BookDto responseBookDto = adminBookService.updateBook(bookId, bookDto);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(GenericResponse.builder()
                        .source(null)
                        .responseStatus(ResponseStatus.SUCCESS)
                        .responseBody(responseBookDto)
                        .build());
    }

}
