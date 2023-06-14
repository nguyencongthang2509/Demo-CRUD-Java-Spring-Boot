package com.example.demo.service.impl;

import com.example.demo.entity.CuaHang;
import com.example.demo.repository.CuaHangRepository;
import com.example.demo.service.CuaHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CuaHangServiceimpl implements CuaHangService {
    @Autowired
    private CuaHangRepository repository;

    @Override
    public List<CuaHang> getAll() {
        return repository.findAll();
    }
}
