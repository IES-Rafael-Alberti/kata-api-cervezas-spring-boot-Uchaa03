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
    @JoinColumn(name = "breweryId")
    private brewerie brewery;

    private String name;

    @ManyToOne
    @JoinColumn(name = "categoryId")
    private category category;

    @ManyToOne
    @JoinColumn(name = "styleId")
    private style style;

    private Float abv;
    private Float ibu;
    private Float upc;
    private String filepath;
    private String description;
    private Long add_user;
    private LocalDateTime last_mod;


}