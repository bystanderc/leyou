package com.leyou.upload.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author bystander
 * @date 2018/9/16
 */
public interface UploadService {

    String uploadImage(MultipartFile file);
}
