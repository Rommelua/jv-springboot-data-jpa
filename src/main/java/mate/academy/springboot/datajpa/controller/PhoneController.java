package mate.academy.springboot.datajpa.controller;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import mate.academy.springboot.datajpa.dto.PhoneRequestDto;
import mate.academy.springboot.datajpa.dto.PhoneResponseDto;
import mate.academy.springboot.datajpa.dto.mapper.PhoneMapper;
import mate.academy.springboot.datajpa.model.Phone;
import mate.academy.springboot.datajpa.service.InjectService;
import mate.academy.springboot.datajpa.service.PhoneService;
import mate.academy.springboot.datajpa.service.SortingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/phones")
public class PhoneController {
    private final PhoneService phoneService;
    private final InjectService injectService;
    private final PhoneMapper phoneMapper;
    private final SortingService sortingService;

    @Autowired
    public PhoneController(PhoneService phoneService, InjectService injectService,
                           PhoneMapper phoneMapper, SortingService sortingService) {
        this.phoneService = phoneService;
        this.injectService = injectService;
        this.phoneMapper = phoneMapper;
        this.sortingService = sortingService;
    }

    @GetMapping("/inject")
    public String inject() {
        return injectService.inject();
    }

    @PostMapping
    public PhoneResponseDto create(@RequestBody PhoneRequestDto requestDto) {
        Phone phone = phoneMapper.toModel(requestDto);
        phone = phoneService.save(phone);
        return phoneMapper.toResponseDto(phone);
    }

    @GetMapping
    public PhoneResponseDto getById(@RequestParam Long id) {
        Phone phone = phoneService.getById(id);
        return phoneMapper.toResponseDto(phone);
    }

    @DeleteMapping
    public void delete(@RequestParam Long id) {
        phoneService.delete(id);
    }

    @PutMapping
    public PhoneResponseDto update(@RequestBody PhoneRequestDto requestDto,
                                   @RequestParam Long id) {
        Phone phone = phoneMapper.toModel(requestDto);
        phone.setId(id);
        phone = phoneService.save(phone);
        return phoneMapper.toResponseDto(phone);
    }

    @GetMapping("/price-between")
    public List<PhoneResponseDto> getAllBetweenPrice(@RequestParam BigDecimal from,
                                                     @RequestParam BigDecimal to) {
        return phoneService.findAllByPriceBetween(from, to).stream()
                .map(phoneMapper::toResponseDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/search")
    public List<PhoneResponseDto> getAllByParams(@RequestParam Map<String, String> params) {
        return phoneService.findAllByParams(params).stream()
                .map(phoneMapper::toResponseDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/all")
    public List<PhoneResponseDto> findAll(@RequestParam(defaultValue = "0") Integer page,
                                          @RequestParam(defaultValue = "20") Integer size,
                                          @RequestParam(defaultValue = "id") String sortBy) {
        PageRequest pageRequest = sortingService.getPageRequest(page, size, sortBy);
        return phoneService.findAll(pageRequest).stream()
                .map(phoneMapper::toResponseDto)
                .collect(Collectors.toList());
    }

}
