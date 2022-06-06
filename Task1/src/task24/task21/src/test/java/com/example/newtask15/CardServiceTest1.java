package com.example.newtask15;

import com.example.newtask15.services.EmailService;
import com.example.newtask15.services.CardService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
class CardServiceTest1 {

    @Mock
    private EmailService emailService;
    @Mock
    private CardRepository cardRepository;
    private CardService underTest;

    @BeforeEach
    public void setUp() {
        underTest = new CardService(cardRepository, emailService);
    }

    @Test
    void create() {
        // given
        Card card = new Card();
        card.setCard_number(12345);
        card.setCode(123);

        // when
        underTest.create(card);

        // then
        ArgumentCaptor<Card> cardArgumentCaptor =
                ArgumentCaptor.forClass(Card.class);

        Mockito.verify(cardRepository).save(cardArgumentCaptor.capture());
        Mockito.verify(emailService).sendNotification(cardArgumentCaptor.capture());

        Card capturedCard = cardArgumentCaptor.getValue();
        Assertions.assertThat(capturedCard).isEqualTo(card);
    }

    @Test
    void readAll() {
        // given
        Card card = new Card();
        card.setCard_number(123456);
        card.setCode(1234);

        Mockito.when(cardRepository.findAll()).thenReturn(List.of(card));

        // when
        List<Card> expected = underTest.readAll();

        // then
        Mockito.verify(cardRepository).findAll();
        Assertions.assertThat(expected).isNotNull();
        Assertions.assertThat(expected.size()).isEqualTo(1);
        Assertions.assertThat(expected.get(0).getCard_number()).isEqualTo(card.getCard_number());
        Assertions.assertThat(expected.get(0).getCode()).isEqualTo(card.getCode());
    }

    @Test
    void update() {
        // given
        Card card = new Card();
        card.setCard_number(1234567);
        card.setCode(12344);
        card.setId(1L);

        // when
        underTest.update(card, card.getId());

        // then
        Mockito.verify(cardRepository).save(card);
    }

    @Test
    void delete() {
        // given
        Card card = new Card();
        card.setCard_number(1234567);
        card.setCode(12344);
        card.setId(1L);

        // when
        underTest.delete(card.getId());

        // then
        Mockito.verify(cardRepository).deleteById(card.getId());
    }

    @Test
    void findCardsByNumber() {
        // given
        Card card = new Card();
        card.setCard_number(123321);
        card.setCode(123);

        Mockito.when(cardRepository.findAllByCode(card.getCode())).thenReturn(List.of(card));

        // when
        List<Card> existed = underTest.findCardsByCode(card.getCode());

        // then
        Assertions.assertThat(existed).isNotNull();
        Assertions.assertThat(existed.size()).isEqualTo(1);
        Assertions.assertThat(existed.get(0).getCard_number()).isEqualTo(card.getCard_number());
        Assertions.assertThat(existed.get(0).getCode()).isEqualTo(card.getCode());
    }

    @Test
    void findCardsByCode() {
        // given
        Card card = new Card();
        card.setCard_number(123321);
        card.setCode(123);

        Mockito.when(cardRepository.findAllByCode(card.getCode())).thenReturn(List.of(card));

        // when
        List<Card> existed = underTest.findCardsByCode(card.getCode());

        // then
        Assertions.assertThat(existed).isNotNull();
        Assertions.assertThat(existed.size()).isEqualTo(1);
        Assertions.assertThat(existed.get(0).getCard_number()).isEqualTo(card.getCard_number());
        Assertions.assertThat(existed.get(0).getCode()).isEqualTo(card.getCode());
    }
}
