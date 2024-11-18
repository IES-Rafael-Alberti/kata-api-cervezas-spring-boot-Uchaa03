package ucha_barrera.kata_api.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class brewerie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String address1;
    private String address2;
    private String city;
    private String state;
    private String code;
    private String country;
    private String phone;
    private String website;
    private String filepath;
    private String descript;
    private Long add_user;
    private LocalDateTime last_mod;

    @OneToMany(mappedBy = "brewery_id")
    private List<beer> beers;
}