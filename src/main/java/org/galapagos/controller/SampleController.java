package org.galapagos.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import org.galapagos.domain.SampleDTO;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import lombok.extern.log4j.Log4j;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/sample/")
@Log4j
public class SampleController {
    @RequestMapping("")
    public void basic() {
        log.info("basic .... ");
    }


    @RequestMapping(value = "/basic",
            method = {RequestMethod.GET, RequestMethod.POST})
    public void basicGet() {
        log.info("basic get............");
        // return "sample/basic"
    }


    @GetMapping("/basicOnlyGet")
    public void basicGet2() {
        log.info("basic get only get............");
    }

    @GetMapping("/ex01")
    public String ex01(SampleDTO dto) {
        log.info(dto);
        return "ex01";
    }


    @GetMapping("/ex02")
    public String ex02(@RequestParam("name") String name,
                       @RequestParam("age") int age) {
        log.info("name: " + name);
        log.info("age: " + age);

        return "ex02";
    }

    @GetMapping("/ex02List")
    public String ex02List(@RequestParam("ids") ArrayList<String> ids) {
        log.info("ids: " + ids);

        return "ex02List";
    }

    @GetMapping("/ex04")
    public String ex04(
            @ModelAttribute("sample") SampleDTO dto,
            @ModelAttribute("page") int page,
            Model model) {
        log.info("dto: " + dto);
        log.info("page: " + page);

        model.addAttribute("now", new Date());

        return "ex04";
    }

    @GetMapping("/ex06")
    public @ResponseBody SampleDTO ex06() {
        log.info("/ex06........");

        SampleDTO sampleDTO = new SampleDTO();
        sampleDTO.setAge(10);
        sampleDTO.setName("홍길동");

        return sampleDTO;
    }

    @GetMapping("/ex07")
    public ResponseEntity<String> ex07() {
        log.info("/ex07........................");

        //{name:"홍길동"}
        String msg = "{\"name\":\"홍길동\"}";

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json;charset=UTF-8");

        return new ResponseEntity<>(msg, headers, HttpStatus.OK);
    }

    @GetMapping("/exUpload")// sample/exUpload
    public void exUpload() {
        log.info("/exUpload.................");
    }

    @PostMapping("/exUploadPost")
    public void exUploadPost(ArrayList<MultipartFile> files) {
        for (MultipartFile file : files) {
            log.info("-------------------------------------");
            log.info("name : " + file.getOriginalFilename());
            log.info("size : " + file.getSize());
            //저장
            File dest = new File("d:/upload", file.getOriginalFilename());//파일의 원래 이름으로 경로잡기
            try {
                file.transferTo(dest);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @GetMapping("/ex10")
    public void ex10(){
//        throw new RuntimeException("예외실험");
    }

}
