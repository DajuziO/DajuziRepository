package bg.mf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author lanyang
 * @description:
 * @create: 2019-10-16 15:09
 **/
@Controller
public class TestController {



    @RequestMapping("index")
    public String index(){

        return "index";
    }

    @PostMapping("/upload")
    public String upload(@RequestParam("file") MultipartFile file, Model model){
        if (file.isEmpty()){
            model.addAttribute("message", "The file is empty!");
            return "/uploadStatus";
        }
        try{
            byte[] bytes = file.getBytes();
            File file1 = new File("");
            String filePath = file1.getCanonicalPath();
            Path path = Paths.get(filePath + "\\testdata/" +  file.getOriginalFilename());
            System.out.println(filePath);
            Files.write(path, bytes);
            model.addAttribute("message", "success");

        }catch (Exception e){
            e.printStackTrace();
            model.addAttribute("message", "fail");
        }
        return "/uploadStatus";
    }
}
