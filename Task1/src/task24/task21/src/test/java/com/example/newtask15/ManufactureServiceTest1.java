package com.example.newtask15;

import com.example.newtask15.services.EmailService;
import com.example.newtask15.services.ManufactureService;
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
public class ManufactureServiceTest1 {

    @Mock
    private EmailService emailService;
    @Mock
    private ManufactureRepository manufactureRepository;
    private ManufactureService underTest;

    @BeforeEach
    public void setUp() {
        underTest = new ManufactureService(manufactureRepository, emailService);
    }

    @Test
    public void create() {
        // given
        Manufacture manufacture = new Manufacture();
        manufacture.setCard_number(1234);
        manufacture.setCode(1111);

        // when
        underTest.create(manufacture);

        // then
        ArgumentCaptor<Manufacture> manufactureArgumentCaptor =
                ArgumentCaptor.forClass(Manufacture.class);

        Mockito.verify(manufactureRepository).save(manufactureArgumentCaptor.capture());
        Mockito.verify(emailService).sendNotification(manufactureArgumentCaptor.capture());

        Manufacture capturedManufacture = manufactureArgumentCaptor.getValue();
        Assertions.assertThat(capturedManufacture).isEqualTo(manufacture);
    }

    @Test
    public void readAll() {
        // given
        Manufacture manufacture = new Manufacture();
        manufacture.setCard_number(1234);
        manufacture.setCode(1111);

        Mockito.when(manufactureRepository.findAll()).thenReturn(List.of(manufacture));

        // when
        List<Manufacture> expected = underTest.readAll();

        // then
        Mockito.verify(manufactureRepository).findAll();
        Assertions.assertThat(expected).isNotNull();
        Assertions.assertThat(expected.size()).isEqualTo(1);
        Assertions.assertThat(expected.get(0).getCard_number()).isEqualTo(manufacture.getCard_number());
        Assertions.assertThat(expected.get(0).getCode()).isEqualTo(manufacture.getCode());

    }

    @Test
    public void update() {
        // given
        Manufacture manufacture = new Manufacture();
        manufacture.setCard_number(1234);
        manufacture.setCode(1111);
        manufacture.setId(1);

        // when
        underTest.update(manufacture, manufacture.getId());

        // then
        Mockito.verify(manufactureRepository).save(manufacture);
    }

    @Test
    public void delete() {
        // given
        Manufacture manufacture = new Manufacture();
        manufacture.setCard_number(1234);
        manufacture.setCode(1111);
        manufacture.setId(1);

        // when
        underTest.delete(manufacture.getId());

        // then
        Mockito.verify(manufactureRepository).deleteById(manufacture.getId());
    }

    @Test
    public void findManufacturesByCardNumber() {
        // given
        Manufacture manufacture = new Manufacture();
        manufacture.setCard_number(1234);
        manufacture.setCode(1111);

        Mockito.when(manufactureRepository.findAllByCode(manufacture.getCode())).thenReturn(List.of(manufacture));

        // when
        List<Manufacture> existed = underTest.findManufacturesByCode(manufacture.getCode());

        // then
        Assertions.assertThat(existed).isNotNull();
        Assertions.assertThat(existed.size()).isEqualTo(1);
        Assertions.assertThat(existed.get(0).getCard_number()).isEqualTo(manufacture.getCard_number());
        Assertions.assertThat(existed.get(0).getCode()).isEqualTo(manufacture.getCode());
    }

    @Test
    public void findManufacturesByCode() {
        // given
        Manufacture manufacture = new Manufacture();
        manufacture.setCard_number(1234);
        manufacture.setCode(1111);

        Mockito.when(manufactureRepository.findAllByCode(manufacture.getCode())).thenReturn(List.of(manufacture));

        // when
        List<Manufacture> existed = underTest.findManufacturesByCode(manufacture.getCode());

        // then
        Assertions.assertThat(existed).isNotNull();
        Assertions.assertThat(existed.size()).isEqualTo(1);
        Assertions.assertThat(existed.get(0).getCard_number()).isEqualTo(manufacture.getCard_number());
        Assertions.assertThat(existed.get(0).getCode()).isEqualTo(manufacture.getCode());
    }
}
