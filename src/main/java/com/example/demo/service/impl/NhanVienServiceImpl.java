package com.example.demo.service.impl;

import com.example.demo.entity.NhanVien;
import com.example.demo.model.request.CreateNhanVien;
import com.example.demo.model.request.SerchNhanVien;
import com.example.demo.model.respone.NhanVienRespone;
import com.example.demo.repository.CuaHangRepository;
import com.example.demo.repository.NhanVienRepository;
import com.example.demo.service.NhanVienService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class NhanVienServiceImpl implements NhanVienService {

    @Autowired
    private NhanVienRepository repository;

    @Autowired
    private CuaHangRepository cuaHangRepository;

    @Override
    public List<NhanVien> getAll1() {
        return repository.findAll();
    }

    @Override
    public Page<NhanVienRespone> search(SerchNhanVien serchNhanVien) {
        Pageable pageable = PageRequest.of(serchNhanVien.getPageNo(), 5);
        return repository.search(serchNhanVien, pageable);
    }

    @Override
    public Page<NhanVienRespone> getCustom(Integer pageNo) {
        Pageable pageable = PageRequest.of(pageNo, 10);
        return repository.customProveti(pageable);
    }

    @Override
    public NhanVien getOne(UUID id) {
        return repository.findById(id).get();
    }


    @Override
    public NhanVien add(@Valid CreateNhanVien nhanVien, BindingResult result) {
        if (result.hasErrors()) {
            return null;
        }
        NhanVien x = NhanVien.builder()
                .ma(nhanVien.getMa())
                .ten(nhanVien.getTen())
                .gioiTinh(nhanVien.getGioiTinh())
                .sdt(nhanVien.getSdt())
                .diaChi(nhanVien.getDiaChi())
                .cuaHang(cuaHangRepository.findById(nhanVien.getIdCH()).get())
                .build();
        return repository.save(x);
    }

    @Override
    public NhanVien update(CreateNhanVien nhanVien, UUID id) {
//        Optional<NhanVien> nhanVienUpdate = repository.findById(id);
//            nhanVienUpdate.get().setMa(nhanVien.getMa());
//            nhanVienUpdate.get().setTen(nhanVien.getTen());
//            nhanVienUpdate.get().setGioiTinh(nhanVien.getGioiTinh());
//            nhanVienUpdate.get().setSdt(nhanVien.getSdt());
//            nhanVienUpdate.get().setDiaChi(nhanVien.getMa());
//            nhanVienUpdate.get().setCuaHang(cuaHangRepository.findById(nhanVien.getIdCH()).get());
//            repository.save(nhanVienUpdate.get());
        NhanVien edit = repository.findById(id).get();
        edit = NhanVien.builder()
                .id(id)
                .ma(nhanVien.getMa())
                .ten(nhanVien.getTen())
                .gioiTinh(nhanVien.getGioiTinh())
                .sdt(nhanVien.getSdt())
                .diaChi(nhanVien.getDiaChi())
                .cuaHang(cuaHangRepository.findById(nhanVien.getIdCH()).get())
                .build();
        return repository.save(edit);
    }

    @Override
    public void remove(UUID id) {
        repository.delete(repository.findById(id).get());
    }
}
