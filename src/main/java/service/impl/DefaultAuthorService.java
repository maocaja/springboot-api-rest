package service.impl;

import exception.ResourceNotFoundException;
import model.Author;
import model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import repository.AuthorRepository;
import service.AuthorService;

import java.util.List;


public class DefaultAuthorService extends AuthorService
{
	@Autowired
	private AuthorRepository authorRepository;

	@Override
	public Page<Author> getAll(final Pageable pageable)
	{
		return authorRepository.findAll(pageable);
	}

	@Override
	public Author add(final Author author)
	{
		return authorRepository.save(author);
	}

	@Override
	public Author update(final Author author, final int id)
	{
		Author newAuthor = getAuthorById(id);

		return null;
	}

	@Override
	public Author getById(final int id)
	{
		return null;
	}

	@Override
	public Author deleteById(final int id)
	{
		return null;
	}

	@Override
	public List<Book> getBooksById(final int id)
	{
		return null;
	}

	private Author getAuthorById(int id)
	{
		if (!authorRepository.findById(id).isPresent())
			throw new ResourceNotFoundException(" Author id = " + id + " not found");
		else
			return authorRepository.findById(id).get();
	}
}
