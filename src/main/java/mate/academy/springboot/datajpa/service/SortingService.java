package mate.academy.springboot.datajpa.service;

import org.springframework.data.domain.PageRequest;

public interface SortingService {
    PageRequest getPageRequest(int page, int size, String sortBy);
}
