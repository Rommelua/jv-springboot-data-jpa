package mate.academy.springboot.datajpa.dto.mapper;

import mate.academy.springboot.datajpa.dto.ManufacturerResponseDto;
import mate.academy.springboot.datajpa.dto.PhoneRequestDto;
import mate.academy.springboot.datajpa.dto.PhoneResponseDto;
import mate.academy.springboot.datajpa.model.Manufacturer;
import mate.academy.springboot.datajpa.model.Phone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PhoneMapper {
    private final ManufacturerMapper manufacturerMapper;

    @Autowired
    public PhoneMapper(ManufacturerMapper manufacturerMapper) {
        this.manufacturerMapper = manufacturerMapper;
    }

    public PhoneResponseDto toResponseDto(Phone phone) {
        PhoneResponseDto responseDto = new PhoneResponseDto();
        responseDto.setId(phone.getId());
        responseDto.setTitle(phone.getTitle());
        responseDto.setPrice(phone.getPrice());
        ManufacturerResponseDto manDto = manufacturerMapper.toResponseDto(phone.getManufacturer());
        responseDto.setManufacturerResponseDto(manDto);
        return responseDto;
    }

    public Phone toModel(PhoneRequestDto requestDto) {
        Phone phone = new Phone();
        phone.setTitle(requestDto.getTitle());
        phone.setPrice(requestDto.getPrice());
        Manufacturer manufacturer = new Manufacturer();
        manufacturer.setId(requestDto.getManufacturerId());
        phone.setManufacturer(manufacturer);
        return phone;
    }
}
