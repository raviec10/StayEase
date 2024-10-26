@RunWith(SpringRunner.class)
@SpringBootTest
public class HotelControllerTest {
    
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetAllHotels() throws Exception {
        mockMvc.perform(get("/hotels"))
               .andExpect(status().isOk())
               .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    public void testCreateHotel() throws Exception {
        Hotel hotel = new Hotel("Test Hotel", "Location", "Description", 10);
        mockMvc.perform(post("/hotels")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(hotel)))
               .andExpect(status().isCreated());
    }

    @Test
    public void testBookRoom() throws Exception {
        Booking booking = new Booking();
        // Set necessary booking details
        
        mockMvc.perform(post("/hotels/1/book")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(booking)))
               .andExpect(status().isOk());
    }
}
