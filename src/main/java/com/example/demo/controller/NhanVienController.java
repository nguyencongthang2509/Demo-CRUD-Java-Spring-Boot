package com.example.demo.controller;

import com.example.demo.model.request.CreateNhanVien;
import com.example.demo.model.request.SerchNhanVien;
import com.example.demo.service.CuaHangService;
import com.example.demo.service.NhanVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/nhan-vien")
@CrossOrigin({"*"}) // chấp nhận yêu cầu từ bên khác
public class NhanVienController {

    @Autowired
    private NhanVienService service;

    @Autowired
    private CuaHangService cuaHangService;

    @GetMapping("/show")
    public ResponseEntity hienThi(final SerchNhanVien serchNhanVien) {
        return new ResponseEntity(service.search(serchNhanVien), HttpStatus.OK);
    }

    @GetMapping("/cuahangs")
    public ResponseEntity hienThi() {
        return new ResponseEntity(cuaHangService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/find-all")
    public ResponseEntity hienThiNew() {
        return new ResponseEntity(service.getAll1(), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity add(@RequestBody CreateNhanVien nhanVien, BindingResult result) {
        return new ResponseEntity(service.add(nhanVien, result), HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public void update(@PathVariable("id") String id, @RequestBody CreateNhanVien nhanVien) {
        service.update(nhanVien, UUID.fromString(id));
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity detail(@PathVariable UUID id) {
        return new ResponseEntity(service.getOne(id), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable UUID id) {
        service.remove(id);
    }

}
