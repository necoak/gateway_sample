package com.example.sampleweb.app.welcome;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.File;

@Controller
@RequestMapping(value= "/download")
public class DownloadController {

    private static final Logger logger = LoggerFactory
            .getLogger(HelloController.class);

    @RequestMapping(method = {RequestMethod.GET})
    public String download(Model model) {
        File dir = new File("C:/tmp/");
        File[] files = dir.listFiles();
        model.addAttribute("downloadfiles", files);
        logger.info(files.toString());
        return "download/download";
    }

    @RequestMapping(method = {RequestMethod.POST}, params = "filedownload")
    public String postDownload(@RequestParam("filedownload") String downloadFilename, Model model) {

        model.addAttribute("filename", downloadFilename);
        return "xmlFileDownloadView";
    }

}


