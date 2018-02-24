package com.example.sampleweb.app.welcome;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value= "/download")
public class DownloadController {

    @RequestMapping(method = {RequestMethod.GET})
    public String download() {
    return "download/download";
    }

    @RequestMapping(method = {RequestMethod.POST}, params = "filedownload")
    public String postDownload() {

        return "xmlFileDownloadView";
    }

}


