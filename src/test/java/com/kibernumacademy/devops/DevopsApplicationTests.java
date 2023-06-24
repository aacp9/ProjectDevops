package com.kibernumacademy.devops;

import com.kibernumacademy.devops.entitys.Student;
import com.kibernumacademy.devops.repositories.IStudentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIfSystemProperties;
import org.junit.jupiter.api.condition.EnabledIfSystemProperty;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.commons.JUnitException;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.boot.test.context.SpringBootTest;


import java.util.Map;
import java.util.Optional;
import java.util.Properties;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class DevopsApplicationTests {

  Student estudiante;
  @BeforeEach
  void setUp(){
    this.estudiante = new Student("Alejandro", "Cabrera", "acabrera@gmail.com");

  }
  @Test
  void TestNombreEstudiante() {
    //cuerpo del test
    String nombreEsperado = "Alejandro";
    String nombreExistente= estudiante.getName();
    assertEquals(nombreEsperado, nombreExistente, "Nombre no encontrado");
  }

  @Test
  void TestCorreoEstudiante() {
    //cuerpo del test
    String emailEsperado = "acabrera@gmail.com";
    String emailExistente= estudiante.getEmail();
    assertEquals(emailEsperado, emailExistente, "Email no encontrado");
  }
  //test de sistema
  @Test
  @EnabledOnOs(OS.WINDOWS)
  void testSoloWindows(){

  }
  @Test
  @EnabledIfSystemProperty(named="user.language", matches = "es")
  void porSystemProperties(){
    Properties properties = System.getProperties();
    properties.forEach((k,v)-> System.out.println(k + ": "+v));
    System.out.println("======================= ENV");
    Map<String, String> env=System.getenv();
    env.forEach((k,v)-> System.out.println(k + ": "+v));

  }

//Test Exception

}
