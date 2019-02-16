package com.tobioyelami.foodapp.foodapp.restaurant.service;

import com.tobioyelami.foodapp.foodapp.restaurant.entities.FoodItem;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by toyelami on 02/02/2019
 */
public class BaseService<T> {

    JpaRepository<T, Long> repository;

    public BaseService(JpaRepository<T, Long> repository){
        this.repository = repository;
    }

    public List<T> all(){
        return repository.findAll(Sort.by(Sort.Direction.DESC, "id"));
    }

    public List<T> paginated(int start, int pages){
        Page<T> paginated = repository.findAll(PageRequest.of(start, pages, Sort.Direction.DESC, "id"));
        return paginated.hasContent() ? paginated.getContent() : new ArrayList<>();
    }

    @Transactional
    public T save(T request){
        return repository.save(request);
    }

    public T findOneById(long id){
        Optional<T> optional = repository.findById(id);
        return optional.orElse(null);
    }

    @Transactional
    public T update(T request) {
        return repository.save(request);
    }

    public boolean delete(long id){
        repository.deleteById(id);
        return findOneById(id) == null;
    }

    public List<T> findByIds(List<Long> foodItemsIds) {
        return repository.findAllById(foodItemsIds);
    }
}
