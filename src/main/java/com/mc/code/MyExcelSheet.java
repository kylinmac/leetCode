package com.mc.code;


import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class MyExcelSheet {

    private String sheetName;

    private Map<String, String> aliasMap;

    private List dataList;
}