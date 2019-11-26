package service;

import model.Author;
import model.Book;

import java.util.List;


public abstract class AuthorService implements MainService<Author>
{
	public abstract List<Book> getBooksById(int id);
}
