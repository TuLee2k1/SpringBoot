package poly.edu.shop.service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;

import poly.edu.shop.domain.Category;

public interface CategoryService {

	void deleteAll();

	<S extends Category> List<S> findAll(Example<S> example, Sort sort);

	<S extends Category> List<S> findAll(Example<S> example);

	void deleteAll(Iterable<? extends Category> entities);

	Category getReferenceById(Integer id);

	void deleteAllById(Iterable<? extends Integer> ids);

	void delete(Category entity);

	Category getById(Integer id);

	void deleteById(Integer id);

	long count();

	<S extends Category, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction);

	Category getOne(Integer id);

	void deleteAllInBatch();

	<S extends Category> boolean exists(Example<S> example);

	void deleteAllByIdInBatch(Iterable<Integer> ids);

	<S extends Category> long count(Example<S> example);

	boolean existsById(Integer id);

	void deleteAllInBatch(Iterable<Category> entities);

	Optional<Category> findById(Integer id);

	<S extends Category> Page<S> findAll(Example<S> example, Pageable pageable);

	void deleteInBatch(Iterable<Category> entities);

	List<Category> findAllById(Iterable<Integer> ids);

	List<Category> findAll();

	<S extends Category> List<S> saveAllAndFlush(Iterable<S> entities);

	<S extends Category> S saveAndFlush(S entity);

	Page<Category> findAll(Pageable pageable);

	void flush();

	List<Category> findAll(Sort sort);

	<S extends Category> Optional<S> findOne(Example<S> example);

	<S extends Category> List<S> saveAll(Iterable<S> entities);

	<S extends Category> S save(S entity);

	List<Category> findByNameContaining(String name);

	Page<Category> findByNameContaining(String name, Pageable pageable);

	

	
}
