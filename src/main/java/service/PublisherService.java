package service;

import model.Book;
import model.Publisher;

import java.util.List;


public abstract class PublisherService implements MainService<Publisher>
{
	public abstract List<Book> getBooksById(int id);
}
