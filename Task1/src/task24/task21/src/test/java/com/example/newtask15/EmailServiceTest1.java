package com.example.newtask15;

import com.example.newtask15.services.EmailService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@ExtendWith(MockitoExtension.class)
class EmailServiceTest1 {

    @Mock
    private JavaMailSenderImpl javaMailSenderImpl;
    private EmailService underTest;

    @BeforeEach
    void setUp() {
        underTest = new EmailService(javaMailSenderImpl);
    }

    @Test
    void sendNotification() {

        // given
        Card card = new Card();
        card.setCard_number(12345);
        card.setCode(2007);
        Mockito.doNothing().when(javaMailSenderImpl).send(Mockito.any(SimpleMailMessage.class));

        // when
        underTest.sendNotification(card);

        // then
        Mockito.verify(javaMailSenderImpl).send(Mockito.any(SimpleMailMessage.class));



    }
}
