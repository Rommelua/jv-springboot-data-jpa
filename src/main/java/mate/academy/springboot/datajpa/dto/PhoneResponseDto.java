package mate.academy.springboot.datajpa.dto;

import java.math.BigDecimal;
import lombok.Data;

@Data
public class PhoneResponseDto {
    private Long id;
    private String title;
    private BigDecimal price;
    private ManufacturerResponseDto manufacturerResponseDto;
}
