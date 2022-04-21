package mate.academy.springboot.datajpa.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class SortingServiceImpl implements SortingService {
    @Override
    public PageRequest getPageRequest(int page, int size, String sortBy) {
        List<Sort.Order> orders = new ArrayList<>();
        String[] sortArray = sortBy.split(";");
        for (String sortItem : sortArray) {
            Sort.Order order;
            if (sortItem.contains(":")) {
                String[] fieldAndDirection = sortItem.split(":");
                order = new Sort.Order(Sort.Direction.valueOf(fieldAndDirection[1]),
                        fieldAndDirection[0]);
            } else {
                order = new Sort.Order(Sort.Direction.ASC, sortItem);
            }
            orders.add(order);
        }
        Sort sort = Sort.by(orders);
        return PageRequest.of(page, size, sort);
    }
}
