package com.example.demo.service;

import com.example.demo.entity.NhanVien;
import com.example.demo.model.request.CreateNhanVien;
import com.example.demo.model.request.SerchNhanVien;
import com.example.demo.model.respone.NhanVienRespone;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.validation.BindingResult;

import java.util.List;
import java.util.UUID;

public interface NhanVienService {

    List<NhanVien> getAll1();

    Page<NhanVienRespone> getCustom(Integer pageNo);

    NhanVien getOne(UUID id);

    Page<NhanVienRespone> search(SerchNhanVien serchNhanVien);

    NhanVien add(@Valid CreateNhanVien nhanVien, BindingResult result);

    NhanVien update(CreateNhanVien nhanVien, UUID id);

    void remove(UUID id);
}
