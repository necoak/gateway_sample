package com.example.sampleweb.app.welcome;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.PathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;
import org.terasoluna.gfw.web.download.AbstractFileDownloadView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

@Component
public class XmlFileDownloadView extends AbstractFileDownloadView {  // (2)

    @Override
    protected InputStream getInputStream(Map<String, Object> model,
                                         HttpServletRequest request) throws IOException {  // (3)

        // Resource resource = new PathResource("C:/tmp/abc.txt");
        Resource resource = new PathResource("C:/tmp/" + model.get("filename"));
        return resource.getInputStream();
    }

    @Override
    protected void addResponseHeader(Map<String, Object> model,
                                     HttpServletRequest request, HttpServletResponse response) {  // (4)

        response.setHeader("Content-Disposition","attachment; filename=" + model.get("filename"));
        response.setContentType("text/plain");

    }
}