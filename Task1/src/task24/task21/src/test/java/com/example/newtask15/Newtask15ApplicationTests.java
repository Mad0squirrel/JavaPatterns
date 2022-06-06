package com.example.newtask15;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@RunWith(Suite.class)
@Suite.SuiteClasses({
        ManufactureServiceTest1.class,
        UserServiceImplTest1.class
})
class Newtask15ApplicationTests {
    @Test
    void contextLoads() {
    }
}
