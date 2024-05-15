package ejemplo2.test;

import ejemplo2.dao.IDao;
import ejemplo2.dao.impl.AvionDAOEnMemoria;
import ejemplo2.dao.impl.AvionDAOH2;
import ejemplo2.model.Avion;
import ejemplo2.service.AvionService;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class AvionServiceTest {

    private static IDao<Avion> avionDaoEnMemoria = new AvionDAOEnMemoria(new ArrayList<>());
    private static IDao<Avion> avionDaoH2 = new AvionDAOH2();
    private static AvionService avionService = new AvionService();

    @BeforeClass
    public static void cargarAviones() {
        //H2
        avionService.setAvionDao(avionDaoH2);

        avionService.guardarAvion(new Avion(1L, "Fabricante", "2024", "FA-101", "2024-05-13"));
        avionService.guardarAvion(new Avion(2L, "Airbus", "2020","CHX13-0", "2020-01-01"));
        avionService.guardarAvion(new Avion(3L, "ATR", "2021","OJP9-123", "2021-01-01"));
        avionService.guardarAvion(new Avion(4L, "Boeing", "2019","AABN-410", "2019-01-01"));

        //En memoria
        avionService.setAvionDao(avionDaoEnMemoria);

        avionService.guardarAvion(new Avion(1L, "Fabricante", "2024", "FA-101", "2024-05-13"));
        avionService.guardarAvion(new Avion(2L, "Airbus", "2020","CHX13-0", "2020-01-01"));
        avionService.guardarAvion(new Avion(3L, "ATR", "2021","OJP9-123", "2021-01-01"));
        avionService.guardarAvion(new Avion(4L, "Boeing", "2019","AABN-410", "2019-01-01"));
    }

    @Test
    public void guardarYBuscarAvionesTest() {
        //H2
        avionService.setAvionDao(avionDaoH2);

        avionService.guardarAvion(new Avion(5L, "Bombardier", "2025", "CIA-140", "2025-01-01"));
        Avion avionH2 = avionDaoH2.buscar(5L);
        Assert.assertNotNull(avionH2);
        Assert.assertEquals(avionH2.getMarca(), "Bombardier");

        //En memoria
        avionService.setAvionDao(avionDaoEnMemoria);

        avionService.guardarAvion(new Avion(5L, "McDonnell-Douglas", "2025", "CIA-140", "2025-01-01"));
        Avion avionMemoria = avionDaoEnMemoria.buscar(5L);
        Assert.assertNotNull(avionMemoria);
        Assert.assertEquals(avionMemoria.getMarca(), "McDonnell-Douglas");
    }

    @Test
    public void traerTodosLosAvionesTest() {
        //H2
        avionService.setAvionDao(avionDaoH2);

        List<Avion> avionesH2 = avionDaoH2.buscarTodos();
        Assert.assertTrue(avionesH2.size() > 0);

        //En memoria
        avionService.setAvionDao(avionDaoEnMemoria);

        List<Avion> avionesMemoria = avionDaoEnMemoria.buscarTodos();
        Assert.assertTrue(avionesMemoria.size() > 0);
    }

    @Test
    public void eliminarEstudiantesTest() {
        //H2
        avionService.setAvionDao(avionDaoH2);

        avionDaoH2.eliminar(1L);
        Assert.assertEquals(avionDaoH2.buscar(1L),null);
        avionDaoH2.eliminar(2L);
        Assert.assertEquals(avionDaoH2.buscar(2L),null);
        avionDaoH2.eliminar(3L);
        Assert.assertEquals(avionDaoH2.buscar(3L),null);
        avionDaoH2.eliminar(4L);
        Assert.assertEquals(avionDaoH2.buscar(4L),null);
        avionDaoH2.eliminar(5L);
        Assert.assertEquals(avionDaoH2.buscar(5L),null);

        //En memoria
        avionService.setAvionDao(avionDaoEnMemoria);

        avionDaoEnMemoria.eliminar(1L);
        Assert.assertEquals(avionDaoEnMemoria.buscar(1L),null);
        avionDaoEnMemoria.eliminar(2L);
        Assert.assertEquals(avionDaoEnMemoria.buscar(2L),null);
        avionDaoEnMemoria.eliminar(3L);
        Assert.assertEquals(avionDaoEnMemoria.buscar(3L),null);
        avionDaoEnMemoria.eliminar(4L);
        Assert.assertEquals(avionDaoEnMemoria.buscar(4L),null);
        avionDaoEnMemoria.eliminar(5L);
        Assert.assertEquals(avionDaoEnMemoria.buscar(5L),null);
    }

}