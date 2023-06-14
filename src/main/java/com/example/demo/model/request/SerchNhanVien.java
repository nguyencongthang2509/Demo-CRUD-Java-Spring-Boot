package com.example.demo.model.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SerchNhanVien {

    private String maSearch;

    private String sdtSearch;

    private String diaChiSearch;

    private Integer pageNo = 0;
}
