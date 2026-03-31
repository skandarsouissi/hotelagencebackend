package com.example.hotel.service.impl;

import java.util.List;

import com.example.hotel.entity.Hotel;
import com.example.hotel.exception.ResourceNotFoundException;
import com.example.hotel.repository.HotelRepository;
import com.example.hotel.service.HotelService;
import org.springframework.stereotype.Service;

@Service
public class HotelServiceImpl implements HotelService {

    private final HotelRepository repository;

    public HotelServiceImpl(HotelRepository repository) {
        this.repository = repository;
    }

    public List<Hotel> findAll() { return repository.findAll(); }

    public Hotel findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Hotel not found: " + id));
    }

    public Hotel create(Hotel hotel) { return repository.save(hotel); }

    public Hotel update(Long id, Hotel hotel) {
        Hotel existing = findById(id);
        existing.setName(hotel.getName());
        existing.setCity(hotel.getCity());
        existing.setAddress(hotel.getAddress());
        existing.setPricePerNight(hotel.getPricePerNight());
        return repository.save(existing);
    }

    public void delete(Long id) { repository.delete(findById(id)); }
}
