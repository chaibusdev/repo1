package softuni.restaurant.model.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UniqueCategoryNameValidator.class)
public @interface UniqueCategoryName {
    String message() default "Category name is not unique";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
