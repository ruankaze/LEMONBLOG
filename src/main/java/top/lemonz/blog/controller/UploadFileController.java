package top.lemonz.blog.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.Calendar;

/**
 * Created by IntelliJ IDEA.
 *
 * @author NingZe
 * description:
 * path: LEMONBLOG-top.lemonz.blog.controller-FileController
 * date: 2019/6/26 0026 11:15
 * version: 02.06
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping("file")
public class UploadFileController {

    /**
     * 保存路径
     */
    @Value("${nz.imagesPath}")
    private String imagesPath;

    /**
     * 访问路径
     */
    @Value("${nz.imgVisitPath}")
    private String imgVisitPath;

    /**
     * 日志
     */
    private final static Logger logger = LoggerFactory.getLogger(UploadFileController.class);

    @RequestMapping("fileUpload")
    @ResponseBody
    public String fileUpload(@RequestParam(value = "editormd-image-file", required = false) MultipartFile[] file, HttpServletRequest request) throws Exception {

        // 循环上传
        for (int i = 0; i < file.length; i++) {

            // 判断文件是否为空
            if (!file[i].isEmpty()) {

                // 获得原文件名
                String fileName = file[i].getOriginalFilename();
                //File.separator表示在 UNIX 系统上，此字段的值为 /；在 Windows 系统上，它为 \，如：C:\tmp\test.txt和tmp/test.txt
                String filePath = imagesPath;

                // 获得当前日期
                Calendar ca = Calendar.getInstance();
                // 拼接日期文件夹
                String dateFile = (ca.get(Calendar.YEAR) + "/" + cl(ca.get(Calendar.MONTH) + 1) + "/" + cl(ca.get(Calendar.DATE)));
                File dateDir = new File(filePath + dateFile);

                //判断当前日期文件夹是否存在，不存在创建
                if (!dateDir.exists()) {
                    dateDir.mkdirs();
                }

                // 文件名由客户端IP地址 + 系统当前毫秒数组成
                String imgName = "/" + request.getRemoteAddr().replace(":", "") + System.currentTimeMillis() + fileName.substring(fileName.lastIndexOf("."));

                // 生成路径
                filePath += dateFile + imgName;

                // 复制本地文件到服务器
                FileCopyUtils.copy(file[i].getBytes(), new File(filePath));

                return "{\"success\":1,\"message\":\"上传成功\",\"url\":\"" + imgVisitPath + dateFile + imgName + "\"}";

            } else {

                logger.error("文件上传异常");

            }

        }
        return "{\"success\":0,\"message\":\"上传失败\",\"url\":\"\"}";
    }

    /**
     * 处理小于10的数字
     * @param number
     * @return
     */
    public String cl(int number) {
        return number < 10 ? "0" + number : number + "";
    }

}

