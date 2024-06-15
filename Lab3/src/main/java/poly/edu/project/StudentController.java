package poly.edu.project;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.*;

@Controller
public class StudentController {
    @RequestMapping("/student/form")
    public String form(@ModelAttribute("sv") Student sv) {
        return "form";
    }

    @RequestMapping("/student/save")
    public String save(@ModelAttribute("sv") Student sv) {
        return "form";
    }
    
    @ModelAttribute("genders")
    public Map<Boolean, String> getGenders() {
        Map<Boolean, String> map = new HashMap<>();
        map.put(true, "Male");
        map.put(false, "Female");
        return map;
    }

    @ModelAttribute("faculties")
    public List<String> getFaculties() {
        return Arrays.asList("CNTT", "DLNHKS", "QTDN");
    }

    @ModelAttribute("hobbies")
    public Map<String, String> getHobbies() {
        Map<String, String> map = new HashMap<>();
        map.put("T", "Travelling");
        map.put("M", "Music");
        map.put("F", "Food");
        map.put("O", "Other");
        return map;
    }
    
    @PostMapping("/student/save-with-validation")
    public String saveWithValid(@Validated @ModelAttribute("sv") Student sv, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("message", "Vui lòng sửa các lỗi sau:");
            return "form";
        } else {
            model.addAttribute("message", "Chúc mừng, bạn đã nhập đúng");
            return "form";
        }
        
    }
}
