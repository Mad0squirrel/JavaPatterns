package com.example.newtask15;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "card")
@Getter
@Setter
@NoArgsConstructor
public class Card {
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "card_number")
    private int card_number;

    @Column(name = "code")
    private int code;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "card")
    private List<Manufacture> manufactures;
}
