package by.netcracker.hotel.dao.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import by.netcracker.hotel.entities.Hotel;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/spring-test/root-context.xml", "/spring-test/mysql-datasource.xml",
        "/spring-test/servlet-context.xml" })
@WebAppConfiguration
public class HotelDAOImplTest {

    @Autowired
    private HotelDAOImpl hotelDAO;
    private List<Hotel> list;
    private Hotel testHotel;
    Hotel retrievedHotel;
    Hotel retrievedHotel2;

    @Before
    public void setup() {
        testHotel = new Hotel("testCountry", "testCity", "testAddress", "testName", 5, "testDescription", true,
            "http://res.cloudinary.com/netcrackerhotel/image/upload/c_fit,h_300,w_600/BTTELV.jpg");
    }

    @After
    public void end() {
        if (retrievedHotel != null) {
            hotelDAO.deleteByID(retrievedHotel.getId());
        }
        if (retrievedHotel2 != null) {
            hotelDAO.deleteByID(retrievedHotel2.getId());
        }
    }

    // adding testHotel to db and getting back to new variable
    private Hotel getAddedHotel(Hotel hotel) {
        hotelDAO.add(hotel);
        retrievedHotel = hotelDAO.getByName(hotel.getName());
        return retrievedHotel;
    }

    @Test
    public void addTest() {
        retrievedHotel = hotelDAO.getByName(testHotel.getName());
        assertTrue("database contains testing hotel", retrievedHotel == null);
        retrievedHotel = getAddedHotel(testHotel);
        testHotel.setId(retrievedHotel.getId()); // testHotel doesn't
                                                 // contains id by default
        assertEquals("Reviews are not equal while adding review!", testHotel, retrievedHotel);
    }

    @Test
    public void deleteByIDTest() {
        retrievedHotel = getAddedHotel(testHotel);
        testHotel.setId(retrievedHotel.getId());
        assertEquals("Reviews are not equal while adding review!", testHotel, retrievedHotel);
        hotelDAO.deleteByID(retrievedHotel.getId());
        retrievedHotel2 = hotelDAO.getByID(retrievedHotel.getId());
        assertEquals(retrievedHotel2.getId(), 0);
        assertNull(retrievedHotel2.getName());
        assertNull(retrievedHotel2.getDescription());
    }

    @Test
    public void updateTest() {
        retrievedHotel = getAddedHotel(testHotel);
        assertEquals("retrievedHotel has wrong name", retrievedHotel.getName(), "testName");
        retrievedHotel.setName("newName");
        retrievedHotel.setDescription("newDescription");
        retrievedHotel.setEnabled(false);
        hotelDAO.update(retrievedHotel);
        Hotel retrievedHotel2 = hotelDAO.getByID(retrievedHotel.getId());
        assertEquals("name is not changed", "newName", retrievedHotel2.getName());
        assertEquals("descrition is not changed", "newDescription", retrievedHotel2.getDescription());
        assertEquals("enabled is not changed", false, retrievedHotel2.getEnabled());
    }

}
