package poly.com.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import poly.com.domain.Category;
import poly.com.repository.CategoryRespository;
import poly.com.service.CategoryService;
@Service
public class CategoryServiceImpl implements CategoryService {
	CategoryRespository categoryRespository;

	public CategoryServiceImpl(CategoryRespository categoryRespository) {
		this.categoryRespository = categoryRespository;
	}

	@Override
	public <S extends Category> S save(S entity) {
		
		return categoryRespository.save(entity);
	}


	@Override
	public List<Category> findAll(Sort sort) {
		return categoryRespository.findAll(sort);
	}

	@Override
	public void flush() {
		categoryRespository.flush();
	}

	@Override
	public Page<Category> findAll(Pageable pageable) {
		return categoryRespository.findAll(pageable);
	}

	@Override
	public <S extends Category> S saveAndFlush(S entity) {
		return categoryRespository.saveAndFlush(entity);
	}

	@Override
	public <S extends Category> List<S> saveAllAndFlush(Iterable<S> entities) {
		return categoryRespository.saveAllAndFlush(entities);
	}

	@Override
	public List<Category> findAll() {
		return categoryRespository.findAll();
	}

	@Override
	public List<Category> findAllById(Iterable<Long> ids) {
		return categoryRespository.findAllById(ids);
	}

	@Override
	public Optional<Category> findById(Long id) {
		return categoryRespository.findById(id);
	}

	@Override
	public void deleteAllInBatch(Iterable<Category> entities) {
		categoryRespository.deleteAllInBatch(entities);
	}

	@Override
	public boolean existsById(Long id) {
		return categoryRespository.existsById(id);
	}

	@Override
	public void deleteAllByIdInBatch(Iterable<Long> ids) {
		categoryRespository.deleteAllByIdInBatch(ids);
	}

	@Override
	public <S extends Category> boolean exists(Example<S> example) {
		return categoryRespository.exists(example);
	}

	@Override
	public void deleteAllInBatch() {
		categoryRespository.deleteAllInBatch();
	}

	@Override
	public long count() {
		return categoryRespository.count();
	}

	@Override
	public void deleteById(Long id) {
		categoryRespository.deleteById(id);
	}

	@Override
	public Category getById(Long id) {
		return categoryRespository.getById(id);
	}

	@Override
	public void delete(Category entity) {
		categoryRespository.delete(entity);
	}

	@Override
	public void deleteAllById(Iterable<? extends Long> ids) {
		categoryRespository.deleteAllById(ids);
	}

	@Override
	public void deleteAll(Iterable<? extends Category> entities) {
		categoryRespository.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		categoryRespository.deleteAll();
	}
	
	
}
