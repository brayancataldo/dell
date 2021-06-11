package com.residencia.dell.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.residencia.dell.entities.Orderlines;
import com.residencia.dell.entities.OrderlinesId;
import com.residencia.dell.services.OrderlinesService;

@RestController
@RequestMapping("/orderlines")
public class OrderlinesController {

    @Autowired
    private OrderlinesService orderlinesService;

    @GetMapping("/{id}")
    public ResponseEntity<Orderlines> findById(@PathVariable OrderlinesId id) {
        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<>(orderlinesService.findById(id), headers, HttpStatus.OK);
    }

    @GetMapping("/orderlines_list")
    public ResponseEntity<List<Orderlines>> listByOrderlines(@RequestParam(required = true) Integer orderlines) {
        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<>(orderlinesService.findAll(), headers, HttpStatus.OK);
    }

    @GetMapping("/count")
    public Long count() {
        return orderlinesService.count();
    }

    //POST
    @PostMapping
    public ResponseEntity<Orderlines> save(Orderlines orderlines) {
        //return alunoService.save(aluno);
        HttpHeaders headers = new HttpHeaders();

        if (null != orderlinesService.save(orderlines)) {
            return new ResponseEntity<>(orderlinesService.save(orderlines), headers, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(orderlinesService.save(orderlines), headers, HttpStatus.BAD_REQUEST);
        }
    }

    // PUT 
    @PutMapping
    public Orderlines update(Orderlines orderlines, OrderlinesId id) {
        return orderlinesService.update(orderlines, id);
    }

    // DELETE
    @DeleteMapping
    public ResponseEntity<Orderlines> deletePost(@RequestParam OrderlinesId id) {
        HttpHeaders headers = new HttpHeaders();
        boolean isRemoved = orderlinesService.delete(id);
        if (isRemoved) {
            return new ResponseEntity<>(headers, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(headers, HttpStatus.BAD_REQUEST);
        }
    }
}
