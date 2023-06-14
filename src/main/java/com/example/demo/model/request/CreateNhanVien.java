package com.example.demo.model.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Nationalized;
import org.hibernate.validator.constraints.Length;

import java.util.UUID;

@Getter
@Setter
public class CreateNhanVien {

    @NotBlank
    @Length(max = 20)
    private String ma;

    @NotBlank
    @Nationalized
    @Length(max = 20)
    private String ten;

    @NotNull
    private String gioiTinh;

    @NotBlank
    @Length(max = 10)
    private String sdt;

    @NotBlank
    private String diaChi;

    @NotNull
    private UUID idCH;

}
