@RestController
@RequestMapping("/hotels")
public class HotelController {
    @Autowired
    private HotelService hotelService;

    @GetMapping
    public List<Hotel> getAllHotels() {
        return hotelService.findAllHotels();
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public Hotel createHotel(@RequestBody Hotel hotel) {
        return hotelService.saveHotel(hotel);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('HOTEL_MANAGER')")
    public Hotel updateHotel(@PathVariable Long id, @RequestBody Hotel hotel) {
        hotel.setId(id);
        return hotelService.updateHotel(hotel);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void deleteHotel(@PathVariable Long id) {
        hotelService.deleteHotel(id);
    }
}
