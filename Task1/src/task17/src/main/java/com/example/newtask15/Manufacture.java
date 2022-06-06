package com.example.newtask15;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "manufactures")
@NoArgsConstructor
@Getter
@Setter
public class Manufacture {

    @Id
//    @SequenceGenerator(name = "manufactures_seq", sequenceName = "manufactures_sequence", allocationSize = 1)
//    @GeneratedValue(generator = "manufactures_seq", strategy = GenerationType.SEQUENCE)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "card_number")
    private String card_number;

    @Column(name = "code")
    private String code;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="card_id")
    @JsonIgnore
    private Card card;

}