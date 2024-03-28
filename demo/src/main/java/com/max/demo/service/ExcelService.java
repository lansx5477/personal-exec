package com.max.demo.service;

import org.springframework.stereotype.Service;

/**
 * @Project demo
 * @Author: xiaoyinglan
 * @Date: 2024/01/26/16:35
 * @Description:
 * @Version 1.0
 */
@Service
public interface ExcelService {

    /**
     * 读取excel中的渠道映射
     * @param filePath
     * @param sheetName
     * @return
     * @Author: xiaoyinglan
     * @Date: 2024/01/26/16:35
     */
    String getExcelData(String filePath, String sheetName);
}
