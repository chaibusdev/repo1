package softuni.restaurant.model.binding;

import org.springframework.web.multipart.MultipartFile;
import softuni.restaurant.model.validator.UniqueCategoryName;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class CategoryBindingModel {
    @NotBlank
    @UniqueCategoryName
    @Size(min = 2, max = 20, message = "The category name must contain at least 2 symbols")
    private String name;
    private String description;
    private MultipartFile picture;

    public CategoryBindingModel() {
    }

    public String getName() {
        return name;
    }

    public CategoryBindingModel setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public CategoryBindingModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public MultipartFile getPicture() {
        return picture;
    }

    public CategoryBindingModel setPicture(MultipartFile picture) {
        this.picture = picture;
        return this;
    }
}