package ucha_barrera.kata_api.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Builder
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class beer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "brewery_id")
    private brewerie brewery_id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "cat_id")
    private category cat_id;

    @ManyToOne
    @JoinColumn(name = "style_id")
    private style style_id;

    private Float abv;
    private Float ibu;
    private Float upc;
    private String filepath;
    private String description;
    private Long add_user;
    private LocalDateTime last_mod;


}