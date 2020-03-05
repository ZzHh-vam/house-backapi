package com.team.house.housebackapi.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * @Author ZzHh
 * @Classname FileUploadUtil
 * @Description TODO
 * @Date: Created in 2020/2/11 11:29
 * @Create By IntelliJ IDEA
 **/

public class FileUploadUtil {

    /**
     *@Function: upload
     *@Description: 文件上传
     *@Param: file  表示上传的文件
     *@Param: path  表示上传文件的保存位置:绝对路径
     *@Return:  保存文件名称
     **/
    public static String upload(MultipartFile file, String path) throws IOException {
        //设置保存文件
        String uploadFileName = file.getOriginalFilename();
        //获取文件扩展名
        String expname = uploadFileName.substring(uploadFileName.lastIndexOf("."));
        //生成唯一文件名
        String fileName = System.currentTimeMillis() + expname;
        //设置文件保存路径和名称
        String savePos = path + "/" + fileName;
        //创建保存文件
        File saveFile = new File(savePos);
        //上传
        file.transferTo(saveFile);
        //返回文件名称
        return fileName;
    }
}
