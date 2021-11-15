package softuni.restaurant.model.view;

import org.springframework.web.multipart.MultipartFile;
import softuni.restaurant.model.entity.enums.TypeEnum;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class ItemViewModel {
    private Long id;
    private String name;

    private TypeEnum type;

    private String producer;

    private Set<String> categories = new HashSet<>();

    private PictureViewModel picture;

    private Integer volume;

    private Integer weight;

    private BigDecimal price;

    private Set<String> products = new HashSet<>();

    private String description;

    private boolean isActive;

    private Set<PictureViewModel> allergens;

    public ItemViewModel() {
    }

    public Long getId() {
        return id;
    }

    public ItemViewModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public ItemViewModel setName(String name) {
        this.name = name;
        return this;
    }

    public Set<PictureViewModel> getAllergens() {
        return allergens;
    }

    public ItemViewModel setAllergens(Set<PictureViewModel> allergens) {
        this.allergens = allergens;
        return this;
    }

    public TypeEnum getType() {
        return type;
    }

    public ItemViewModel setType(TypeEnum type) {
        this.type = type;
        return this;
    }

    public String getProducer() {
        return producer;
    }

    public ItemViewModel setProducer(String producer) {
        this.producer = producer;
        return this;
    }

    public Set<String> getCategories() {
        return categories;
    }

    public ItemViewModel setCategories(Set<String> categories) {
        this.categories = categories;
        return this;
    }

    public PictureViewModel getPicture() {
        return picture;
    }

    public ItemViewModel setPicture(PictureViewModel picture) {
        this.picture = picture;
        return this;
    }

    public Integer getVolume() {
        return volume;
    }

    public ItemViewModel setVolume(Integer volume) {
        this.volume = volume;
        return this;
    }

    public Integer getWeight() {
        return weight;
    }

    public ItemViewModel setWeight(Integer weight) {
        this.weight = weight;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public ItemViewModel setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public Set<String> getProducts() {
        return products;
    }

    public ItemViewModel setProducts(Set<String> products) {
        this.products = products;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ItemViewModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public boolean isActive() {
        return isActive;
    }

    public ItemViewModel setActive(boolean active) {
        isActive = active;
        return this;
    }

    @Override
    public String toString() {
        return String.format("Ingerients: %s.%n %s",
                String.join(", ", getProducts()), getDescription());
    }
}