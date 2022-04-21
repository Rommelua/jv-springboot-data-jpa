package mate.academy.springboot.datajpa.repository.specification.phone;

import javax.persistence.criteria.Predicate;
import mate.academy.springboot.datajpa.model.Phone;
import mate.academy.springboot.datajpa.repository.specification.SpecificationProvider;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
public class PhoneTitleContainsSpecification implements SpecificationProvider<Phone> {
    private static final String FILTER_KEY = "titleContains";
    private static final String FIELD_NAME = "title";

    @Override
    public String getFilterKey() {
        return FILTER_KEY;
    }

    @Override
    public Specification<Phone> getSpecification(String[] params) {
        return ((root, query, cb) -> {
            Predicate predicate = cb.like(root.get(FIELD_NAME), "%" + params[0] + "%");
            return cb.and(predicate);
        });
    }
}
