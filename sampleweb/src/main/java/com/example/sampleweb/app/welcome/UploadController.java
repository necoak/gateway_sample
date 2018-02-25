package com.example.sampleweb.app.welcome;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.terasoluna.gfw.common.message.ResultMessages;
import sun.misc.Request;

import java.io.*;

@RequestMapping(value = "/upload")
@Controller
public class UploadController {

    private static final Logger logger = LoggerFactory
    .getLogger(HelloController.class);

    @Value("${upload.allowableFileSize}")
    private int uploadAllowableFileSize;

    @ModelAttribute
    public FileUploadForm setFileUploadForm() {
        return new FileUploadForm();
    }

    @RequestMapping(method = RequestMethod.GET)
    public String uploadForm() {
        return "upload/upload";
    }
    @RequestMapping(method = RequestMethod.POST)
    public String postUpload(@Validated FileUploadForm form,
                             BindingResult result, RedirectAttributes redirectAttributes) {

        logger.info("postLoad");

        if(result.hasErrors()) {
            return "upload/upload";
        }

        MultipartFile uploadFile = form.getFile();

        if(!StringUtils.hasLength(uploadFile.getOriginalFilename())) {
            result.rejectValue(uploadFile.getName(), "e.xx.at.6002");
            return "upload/upload";
        }

        // (5)
        if (uploadFile.isEmpty()) {
            result.rejectValue(uploadFile.getName(), "e.xx.at.6003");
            return "upload/upload";
        }

        // (6)
        if (uploadAllowableFileSize < uploadFile.getSize()) {
            result.rejectValue(uploadFile.getName(), "e.xx.at.6004",
                    new Object[] { uploadAllowableFileSize }, null);
            return "upload/upload";
        }

        // Save

        File of = new File("C:\\tmp\\" + uploadFile.getOriginalFilename());
        try (
                BufferedOutputStream bo = new BufferedOutputStream(new FileOutputStream(of));
                ) {
            bo.write(uploadFile.getBytes());
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        // (8)
        redirectAttributes.addFlashAttribute(ResultMessages.success().add(
                "i.xx.at.0001"));

        // (9)
        return "redirect:/upload?complete";
    }

    @RequestMapping(method = RequestMethod.GET, params = "complete")
    public String uploadComplete() {
        return "upload/uploadComplete";
    }


}
