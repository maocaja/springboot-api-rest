package controller;

import Constants.ApiConstants;
import model.Author;
import model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import results.ResponseWrapper;
import service.AuthorService;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;
import java.util.List;

import static Constants.ApiConstants.MESSAGE_FOR_REGEX_NUMBER_MISMATCH;
import static Constants.ApiConstants.REGEX_FOR_NUMBERS;


@Validated
@RestController
@RequestMapping("/api/v1/author")
public class AuthorController
{
	@Autowired
	AuthorService authorService;

	@GetMapping(value = "/{id}")
	public ResponseWrapper<Author> getAuthorById(
			@Valid @Pattern(regexp = ApiConstants.REGEX_FOR_NUMBERS, message = MESSAGE_FOR_REGEX_NUMBER_MISMATCH) @PathVariable(value = "id") String id)
	{
		return new ResponseWrapper<>(authorService.getById(Integer.parseInt(id)), HttpStatus.OK);
	}

	@GetMapping()
	public ResponseWrapper<Page<Author>> getAuthorAll(Pageable pageable)
	{
		return new ResponseWrapper<>(authorService.getAll(pageable), HttpStatus.OK);
	}

	@PostMapping
	public ResponseWrapper<Author> createAuthor(@Valid @RequestBody Author author)
	{
		return new ResponseWrapper<>(authorService.add(author), HttpStatus.OK);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseWrapper<Author> deleteAuthor(
			@Valid @Pattern(regexp = ApiConstants.MESSAGE_FOR_REGEX_NUMBER_MISMATCH) @PathVariable(value = "id") String id)
	{
		return new ResponseWrapper<>(authorService.deleteById(Integer.parseInt(id)), HttpStatus.OK);
	}

	@PatchMapping(value = "/{id}")
	public ResponseWrapper<Author> updateAuthor(@Valid @RequestBody Author author,
			@Valid @Pattern(regexp = REGEX_FOR_NUMBERS, message = MESSAGE_FOR_REGEX_NUMBER_MISMATCH) @PathVariable(value = "id") String id)
	{
		return new ResponseWrapper<>(authorService.update(author, Integer.parseInt(id)), HttpStatus.OK);
	}

	@GetMapping(value = "/{id}/books")
	public ResponseWrapper<List<Book>> getAuthorBooksById(
			@Valid @Pattern(regexp = REGEX_FOR_NUMBERS, message = MESSAGE_FOR_REGEX_NUMBER_MISMATCH) @PathVariable(value = "id") String id)
	{
		return new ResponseWrapper<>(authorService.getBooksById(Integer.parseInt(id)), HttpStatus.OK);
	}

}
