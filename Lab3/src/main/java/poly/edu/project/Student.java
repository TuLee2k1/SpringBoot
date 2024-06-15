package poly.edu.project;

import java.util.List;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    @NotBlank(message = "Vui lòng nhập họ và tên")
    private String name;

    @NotBlank(message = "Vui lòng nhập địa chỉ email")
    @Email(message = "Vui lòng nhập đúng định dạng email")
     private String email;

    @Min(value = 0, message = "Điểm phải lớn hơn hoặc bằng 0")
    @Max(value = 10, message = "Điểm phải nhỏ hơn hoặc bằng 10")
    @NotNull(message = "Vui lòng nhập điểm")
    private Double marks;

    @NotNull(message = "Vui lòng chọn giới tính")
    private Boolean gender;

    @NotBlank(message = "Vui lòng chọn khoa")
    private String faculty;

    @NotEmpty(message = "Vui lòng chọn sở thích")
    List<String> hobbies;
}
