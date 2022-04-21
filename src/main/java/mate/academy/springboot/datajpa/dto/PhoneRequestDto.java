package mate.academy.springboot.datajpa.dto;

import java.math.BigDecimal;
import lombok.Data;

@Data
public class PhoneRequestDto {
    private String title;
    private BigDecimal price;
    private Long manufacturerId;
}
