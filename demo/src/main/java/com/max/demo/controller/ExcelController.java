package com.max.demo.controller;

import com.max.demo.service.ExcelService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

/**
 * @Project demo
 * @Author: xiaoyinglan
 * @Date: 2024/01/26/15:55
 * @Description:
 * @Version 1.0
 */
@RestController
public class ExcelController {

    @Resource
    private ExcelService service;

    @PostMapping("/get")
    public String getCodeMapping(@RequestParam("filePath") String filePath, @RequestParam("sheetName") String sheetName) {
        return service.getExcelData(filePath, sheetName);
    }

}
