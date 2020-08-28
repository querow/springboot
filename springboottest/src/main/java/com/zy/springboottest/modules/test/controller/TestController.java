package com.zy.springboottest.modules.test.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.nio.file.Paths;


@Controller
@RequestMapping("/test")
public class TestController {
    private final static Logger LOGGER = LoggerFactory.getLogger(TestController.class);
    @Value("${server.port}")
    private int port;
    @Value("${com.name}")
    private String name;
    @Value("${com.age}")
    private int age;
    @Value("${com.desc}")
    private String desc;
    @Value("${com.random}")
    private String random;

    @GetMapping("/logTest")
    @ResponseBody
    public String logTest(){
        LOGGER.trace("This is trace log");
        LOGGER.debug("This is debug log");
        LOGGER.info("This is info log");
        LOGGER.warn("This is warn log");
        LOGGER.error("This is error log");
        return "This is a big da";
    }
    @GetMapping("/index")
    public String indexPage(ModelMap modelMap){
        modelMap.addAttribute("template","test/index");
        modelMap.addAttribute("name","ahahahah~");
        modelMap.addAttribute("changType","button");
        return "index";
    }

    @GetMapping("/testDesc")
    @ResponseBody
    public String testDesc(HttpServletRequest request,
                           @RequestParam(value = "paramKey") String paramValue) {
        String paramValue2 = request.getParameter("paramKey");
        return "This is test module desc." + paramValue + "==" + paramValue2;
    }
    @PostMapping(value = "/file",consumes = "multipart/form-data")
    public String upLoadFile(MultipartFile file, RedirectAttributes redirectAttributes){
        if(file.isEmpty()){
            redirectAttributes.addFlashAttribute("message","Please select file");
        } else {
            String direction = "E:/upload/" + file.getOriginalFilename();
            File destFile = new File(direction);
            try {
                file.transferTo(destFile);
                redirectAttributes.addFlashAttribute("message", "upload success");
            } catch (IOException e) {
                e.printStackTrace();
                redirectAttributes.addFlashAttribute("message", "upload file failse");
            }
        }
        return "redirect:/test/index";
    }

    @PostMapping(value = "/files",consumes = "multipart/form-data")
    public String upLoadFiles(MultipartFile[] files,RedirectAttributes redirectAttributes){
        boolean flage = false;
        for(MultipartFile file:files){
            if(!file.isEmpty()){
                flage = true;
                try {
                    file.transferTo(new File("E:/upload/" + file.getOriginalFilename()));
                } catch (IOException e) {
                    e.printStackTrace();
                    redirectAttributes.addFlashAttribute("message","upload failse");
                }
            }
        }
        if(flage)
            redirectAttributes.addFlashAttribute("message","upload succcess");
        else
            redirectAttributes.addFlashAttribute("message","upload failse");
        return "redirect:/test/index";
    }
    @GetMapping(value = "/file" )
    public ResponseEntity<Resource> downloadFile(@RequestParam String fileName){
        Resource resource = null;
        try {
            resource = new UrlResource(Paths.get("E:/upload/"+fileName).toUri());
            if(resource.exists()&&resource.isReadable()){
                String aa = new String(fileName.getBytes("utf-8"), "ISO-8859-1");
                return ResponseEntity.ok()
                        .header(HttpHeaders.CONTENT_TYPE,"application/octet-stream")
                        .header(HttpHeaders.CONTENT_DISPOSITION,
                                String.format("attachment; filename=\"%s\"", resource.getFilename()))
                        .body(resource);
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return null;
    }
}
