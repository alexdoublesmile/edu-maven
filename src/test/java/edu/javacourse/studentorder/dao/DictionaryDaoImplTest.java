package edu.javacourse.studentorder.dao;

import edu.javacourse.studentorder.domain.CountryArea;
import edu.javacourse.studentorder.domain.PassportOffice;
import edu.javacourse.studentorder.domain.RegisterOffice;
import edu.javacourse.studentorder.domain.Street;
import edu.javacourse.studentorder.exception.DaoException;
import org.junit.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class DictionaryDaoImplTest {

    private static final Logger logger = LoggerFactory.getLogger(DictionaryDaoImplTest.class);

    @BeforeClass
    public static void startUp() throws Exception {
        DBInit.startUp();
    }

    @Test
    public void testStreet() throws DaoException {
        LocalDateTime dt1 = LocalDateTime.now();
        LocalDateTime dt2 = LocalDateTime.now();
        logger.info("TEST {} {}", dt1, dt2);

        List<Street> streetList = new DictionaryDaoImpl().findStreets("про");
        Assert.assertTrue(streetList.size() == 2);
    }

    @Test
    public void testPassportOffice() throws DaoException {
        List<PassportOffice> poList = new DictionaryDaoImpl().findPassportOffices("010020000000");
        Assert.assertTrue(poList.size() == 2);
    }

    @Test
    public void testRegisterOffice() throws DaoException {
        List<RegisterOffice> roList = new DictionaryDaoImpl().findRegisterOffices("010010000000");
        Assert.assertTrue(roList.size() == 2);
    }

    @Test
    public void testArea() throws DaoException {
        List<CountryArea> caList1 = new DictionaryDaoImpl().findAreas("");
        Assert.assertTrue(caList1.size() == 2);
        List<CountryArea> caList2 = new DictionaryDaoImpl().findAreas("020000000000");
        Assert.assertTrue(caList2.size() == 2);
        List<CountryArea> caList3 = new DictionaryDaoImpl().findAreas("020010000000");
        Assert.assertTrue(caList3.size() == 2);
        List<CountryArea> caList4 = new DictionaryDaoImpl().findAreas("020010010000");
        Assert.assertTrue(caList4.size() == 2);
    }
}