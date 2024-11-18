package ucha_barrera.kata_api.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class style {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "cat_id")
    private Long cat_id;

    private String style_name;
    private LocalDate last_mod;

    @OneToMany(mappedBy = "style_id")
    private List<beer> beers;
}
//`id` int(11) NOT NULL auto_increment,
//  `cat_id` int(11) NOT NULL default '0',
//  `style_name` varchar(255) character set utf8 collate utf8_unicode_ci NOT NULL default '',
//  `last_mod` datetime NOT NULL default '0000-00-00 00:00:00',