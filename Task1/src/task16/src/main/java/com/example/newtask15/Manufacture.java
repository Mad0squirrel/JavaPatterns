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
    @Column(name = "ID")
    private long id;

    @Column(name = "card_number")
    private int card_number;

    @Column(name = "code")
    private int code;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="card_id")
    @JsonIgnore
    private Card card;

}
