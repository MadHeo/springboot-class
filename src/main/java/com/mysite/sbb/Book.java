package com.mysite.sbb;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class Book {
    private final String title;
    private final String author;

    public static void main(String[] args) {
        Book book = new Book("오늘, 또 일을 미루고 말았다", "나카미타 사토시");

        System.out.println(
                book.getTitle() + "-"  + book.getAuthor()
        );
    }

}
