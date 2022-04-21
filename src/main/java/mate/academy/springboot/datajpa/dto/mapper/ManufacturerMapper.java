package mate.academy.springboot.datajpa.dto.mapper;

import mate.academy.springboot.datajpa.dto.ManufacturerRequestDto;
import mate.academy.springboot.datajpa.dto.ManufacturerResponseDto;
import mate.academy.springboot.datajpa.model.Manufacturer;
import org.springframework.stereotype.Component;

@Component
public class ManufacturerMapper {

    public ManufacturerResponseDto toResponseDto(Manufacturer manufacturer) {
        ManufacturerResponseDto dto = new ManufacturerResponseDto();
        dto.setId(manufacturer.getId());
        dto.setName(manufacturer.getName());
        return dto;
    }

    public Manufacturer toModel(ManufacturerRequestDto requestDto) {
        Manufacturer manufacturer = new Manufacturer();
        manufacturer.setName(requestDto.getName());
        return manufacturer;
    }
}
