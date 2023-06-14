package com.example.demo.model.respone;

import org.springframework.beans.factory.annotation.Value;

import java.util.UUID;

public interface SearchRespone {

    @Value("#{target.idNhanVien}")
    UUID getId();

    @Value("#{target.tenNhanVien}")
    String getTenNhanVien();

    @Value("#{target.tenCuaHang}")
    String getTenCuaHang();


}
