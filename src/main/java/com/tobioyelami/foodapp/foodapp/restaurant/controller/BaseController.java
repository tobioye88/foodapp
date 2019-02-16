package com.tobioyelami.foodapp.foodapp.restaurant.controller;

import com.tobioyelami.foodapp.foodapp.restaurant.service.BaseService;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by toyelami on 02/02/2019
 */
public abstract class BaseController<T> {

    private BaseService service;

    BaseController(BaseService service){
        this.service = service;
    }

    @GetMapping("/all")
    @ResponseBody
    public ResponseEntity<List<T>> all(){
        List<T> all = service.all();
        return new ResponseEntity<>(all, HttpStatus.OK);
    }

    @GetMapping("/paged")
    public ResponseEntity<List<T>> paginated(@Param("start") int start, @Param("pages") int pages){
        List<T> paginated = service.paginated(start, pages);
        return new ResponseEntity<>(paginated, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<T> get(@PathVariable("id") long id){
        T one = (T) service.findOneById(id);
        return new ResponseEntity<>(one, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<T> add(@RequestBody T request){
        T added = (T) service.save(request);
        return new ResponseEntity<>(added, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<T> put(@RequestBody T request){
        T updated = (T) service.update(request);
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Boolean> delete(@PathVariable long id){
        boolean isDeleted = service.delete(id);
        return new ResponseEntity<>(isDeleted, HttpStatus.OK);
    }
}
