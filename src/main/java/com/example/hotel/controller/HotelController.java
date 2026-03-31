package com.example.hotel.controller;

import java.util.List;

import com.example.hotel.entity.Hotel;
import com.example.hotel.service.HotelService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/hotels")
public class HotelController {

    private final HotelService service;

    public HotelController(HotelService service) {
        this.service = service;
    }

    @GetMapping
    public List<Hotel> findAll() { return service.findAll(); }

    @GetMapping("/{id}")
    public Hotel findById(@PathVariable Long id) { return service.findById(id); }

    @PostMapping
    public Hotel create(@RequestBody Hotel hotel) { return service.create(hotel); }

    @PutMapping("/{id}")
    public Hotel update(@PathVariable Long id, @RequestBody Hotel hotel) { return service.update(id, hotel); }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) { service.delete(id); }
}
