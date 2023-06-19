package com.kibernumacademy.devops;

import com.kibernumacademy.devops.entitys.Student;
import com.kibernumacademy.devops.repositories.IStudentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


import java.util.Optional;

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



}
