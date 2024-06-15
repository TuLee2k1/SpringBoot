package poly.com.paramservice;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ParseException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import jakarta.servlet.http.HttpServletRequest;

@Service
public class ParamService {
    @Autowired
    HttpServletRequest request;

    public String getString(String name, String defaultValue) {
        String value = request.getParameter(name);
        return value != null ? value : defaultValue;
    }

    public int getInt(String name, int defaultValue) {
        String value = request.getParameter(name);
        return value != null ? Integer.parseInt(value) : defaultValue;
    }

    public double getDouble(String name, double defaultValue) {
        String value = request.getParameter(name);
        return value != null ? Double.parseDouble(value) : defaultValue;
    }

    public boolean getBoolean(String name, boolean defaultValue) {
        String value = request.getParameter(name);
        return value != null ? Boolean.parseBoolean(value) : defaultValue;
    }

    public Date getDate(String name, String pattern) throws java.text.ParseException {
        String value = request.getParameter(name);
        if (value != null) {
            try {
                SimpleDateFormat sdf = new SimpleDateFormat(pattern);
                return sdf.parse(value);
            } catch (ParseException e) {
                throw new RuntimeException("Invalid date format", e);
            }
        }
        return null;
    }

    public File save(MultipartFile file, String path) {
        if (file != null) {
            try {
                File dir = new File(request.getSession().getServletContext().getRealPath(path));
                if (!dir.exists()) {
                    dir.mkdirs();
                }
                File savedFile = new File(dir, file.getOriginalFilename());
                file.transferTo(savedFile);
                return savedFile;
            } catch (IOException e) {
                throw new RuntimeException("Error saving file", e);
            }
        }
        return null;
    }
}
