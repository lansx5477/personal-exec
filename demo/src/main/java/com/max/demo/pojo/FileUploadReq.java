package com.max.demo.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.web.multipart.MultipartFile;

import java.beans.Transient;
import java.io.Serializable;

/**
 * @author xiaoyinglan
 */
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class FileUploadReq implements Serializable {
    private static final long serialVersionUID = 1L;

    private String appId;

    @JsonIgnore
    private MultipartFile fileUploadForm;

    private String businessCode;

    private transient Integer fileType;

    private String userId;

    private Integer keepDays;
}