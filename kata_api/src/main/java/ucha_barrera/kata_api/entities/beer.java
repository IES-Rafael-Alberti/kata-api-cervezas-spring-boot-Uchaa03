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

    @Column(name = "brewery_id") //Solo queremos pillar el id
    private Long brewery_id;

    private String name;

    @Column(name = "cat_id")
    private Long cat_id;

    @Column(name = "style_id")
    private Long style_id;

    private Float abv;
    private Float ibu;
    private Float upc;
    private String filepath;
    private String descript;
    private Long add_user;
    private LocalDateTime last_mod;


}