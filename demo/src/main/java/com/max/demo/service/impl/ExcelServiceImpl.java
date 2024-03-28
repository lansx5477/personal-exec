package com.max.demo.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.max.demo.service.ExcelService;
import jakarta.annotation.Resource;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;

import static org.apache.poi.ss.usermodel.CellType.STRING;

/**
 * @Project demo
 * @Author: xiaoyinglan
 * @Date: 2024/01/26/15:57
 * @Description:
 * @Version 1.0
 */
@Service
public class ExcelServiceImpl implements ExcelService {

    @Resource
    private ObjectMapper mapper;

    private Logger logger = LoggerFactory.getLogger("excel");

    public String getExcelData(String filePath, String sheetName) {

        XSSFWorkbook workbook = null;
        XSSFSheet sheet = null;

        try (FileInputStream fls = new FileInputStream(filePath)) {
            workbook = new XSSFWorkbook(fls);
        } catch (Exception exception) {
            logger.error(exception.getMessage(), exception);
        }
        sheet = workbook.getSheet(sheetName);

        Map<String, String> channelMapping = new HashMap<>(256);

        if (sheet != null) {

            for (int i = 1; i < sheet.getLastRowNum(); ++i) {
                XSSFRow row = sheet.getRow(i);
                if (row == null) {
                    continue;
                }

                String kdnCode = "";
                String channelCode = "";

                XSSFCell cell = row.getCell(2, Row.MissingCellPolicy.RETURN_BLANK_AS_NULL);
                if (cell == null) {
                    continue;
                }
                cell.setCellType(STRING);
                channelCode = cell.getStringCellValue();
                if (StringUtils.isBlank(channelCode)) {
                    continue;
                }

                cell = row.getCell(3, Row.MissingCellPolicy.RETURN_BLANK_AS_NULL);
                if (cell == null) {
                    continue;
                }
                cell.setCellType(STRING);
                kdnCode = cell.getStringCellValue();
                if (StringUtils.isBlank(kdnCode)) {
                    continue;
                }
                channelMapping.put(kdnCode.trim(), channelCode.trim());
            }
        }

        if (!CollectionUtils.isEmpty(channelMapping)) {
            try {
                return mapper.writeValueAsString(channelMapping);
            } catch (JsonProcessingException e) {
                return "";
            }
        }
        return "";
    }

}
