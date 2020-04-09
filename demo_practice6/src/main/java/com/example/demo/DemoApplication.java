package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(DemoApplication.class, args);
		BookService service = applicationContext.getBean(BookService.class);
		BookEntity bookDefault = service.createBook("last wish", "andjey sapkowskiy", "777");

		System.out.println("Saved new book : " + bookDefault );

		List<BookEntity> users = service.findAllBooks();
		for(BookEntity user : users)
			System.out.println(user);
		System.out.printf("find default book");
		users = service.findByAuthor("andjey sapkowskiy");
		for(BookEntity user : users)
			System.out.println(user);
		System.out.printf("find books with \'a\' in entity");
		users = service.findBookWhereNameOrAuthorContains("a");
		for(BookEntity user : users)
			System.out.println(user);
	}

}
