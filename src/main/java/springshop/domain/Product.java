package springshop.domain;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "products")

public class Product {
    private static final String SEQ_NAME = "product-seq";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUIENCE, generator = SEQ_NAME)
    @SequenceGenerator(name = SEQ_NAME, sequenceName = SEQ_NAME, allocationSize = 1)
    private Long id;
    private String title;
    private BigDecimal price;
    @JoinTable(name = "products_categories",
            joincolumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "category__id"))
    private List<Category> categories;
}
