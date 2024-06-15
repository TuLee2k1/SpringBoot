package poly.com.service;

import org.springframework.stereotype.Service;
import jakarta.servlet.http.HttpSession;

@Service
public class SesionService {

    private final HttpSession httpSession;

    public SesionService(HttpSession httpSession) {
        this.httpSession = httpSession;
    }

    // Phương thức để lưu trữ dữ liệu vào session
    public void set(String key, Object value) {
        httpSession.setAttribute(key, value);
    }

    // Phương thức để lấy dữ liệu từ session
    @SuppressWarnings("unchecked")
    public <T> T get(String key) {
        return (T) httpSession.getAttribute(key);
    }

    // Phương thức để xóa dữ liệu khỏi session
    public void remove(String key) {
        httpSession.removeAttribute(key);
    }
}
