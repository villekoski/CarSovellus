package com.example.CarSovellus;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import hh.swd20.CarSovellus.webcontroller.CarController;

import hh.swd20.CarSovellus.webcontroller.OwnerController;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class CarSovellusApplicationTests {
@Autowired
private OwnerController controller;
@Test
public void contextLoads() {
assertThat(controller).isNotNull();
}
}	