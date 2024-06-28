package dh.backend.clinicamvc.controller;

import dh.backend.clinicamvc.service.IOdontologoService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest()
@AutoConfigureMockMvc
class OdontologoControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private IOdontologoService odontologoService;

    @Test
    @DisplayName("Testear la obtención de un odontólogo")
    void obtenerOdontologo() throws Exception {
        mockMvc.perform(get("/odontologos/2")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nombre").value("CARLOS"))
                .andExpect(jsonPath("$.apellido").value("ARANGO"))
                .andExpect(jsonPath("$.nroMatricula").value("123"));
    }

    @Test
    @DisplayName("Testear que un odontólogo no exista")
    void noObtenerOdontologo() throws Exception {
        mockMvc.perform(get("/odontologos/99")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isNotFound());
    }

    @Test
    @DisplayName("Testear que se agregue un odontólogo")
    void registrarOdontologo() throws Exception {
        String odontologo = "{\"nombre\": \"JUAN\",\"apellido\": \"PEREZ\",\"nroMatricula\": \"3108\"}";

        mockMvc.perform(post("/odontologos")
                .contentType(MediaType.APPLICATION_JSON)
                .content(odontologo))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.nombre").value("JUAN"))
                .andExpect(jsonPath("$.apellido").value("PEREZ"))
                .andExpect(jsonPath("$.nroMatricula").value("3108"));
    }

    @Test
    @DisplayName("Testear que se modifique un odontólogo")
    void modificarOdontologo() throws Exception {
        String odontologo = "{\"id\": \"2\",\"nombre\": \"CALICHE\",\"apellido\": \"ARANGUITO\",\"nroMatricula\": \"321\"}";

        mockMvc.perform(put("/odontologos")
                .contentType(MediaType.APPLICATION_JSON)
                .content(odontologo))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message").value("Odontólogo modificado"));
    }

    @Test
    @DisplayName("Testear que se elimine un odontólogo")
    void eliminarOdontologo() throws Exception {
        mockMvc.perform(delete("/odontologos/3")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message").value("Odontólogo eliminado"));
    }

    @Test
    @DisplayName("Testear que no se elimine un odontólogo")
    void noEliminarOdontologo() throws Exception {
        mockMvc.perform(delete("/odontologos/99")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.message").value("Odontólogo no encontrado"));
    }

}