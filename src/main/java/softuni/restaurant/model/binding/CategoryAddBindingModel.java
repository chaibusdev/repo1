package softuni.restaurant.model.binding;

import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import softuni.restaurant.model.validator.UniqueCategoryName;

public class CategoryAddBindingModel {
    @NotBlank
    @UniqueCategoryName
    @Size(min = 2, max = 20, message = "The category name must contain at least 2 symbols")
    private String name;
    private String description;
    private MultipartFile picture;

    public CategoryAddBindingModel() {
    }

    public String getName() {
        return name;
    }

    public CategoryAddBindingModel setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public CategoryAddBindingModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public MultipartFile getPicture() {
        return picture;
    }

    public CategoryAddBindingModel setPicture(MultipartFile picture) {
        this.picture = picture;
        return this;
    }
}
