@RestController
@RequestMapping("/bookings")
public class BookingController {
    @Autowired
    private BookingService bookingService;

    @PostMapping("/{hotelId}/book")
    public ResponseEntity<?> bookRoom(@PathVariable Long hotelId, @RequestBody Booking booking) {
        return ResponseEntity.ok(bookingService.bookRoom(booking));
    }

    @DeleteMapping("/{bookingId}")
    @PreAuthorize("hasRole('HOTEL_MANAGER')")
    public ResponseEntity<?> cancelBooking(@PathVariable Long bookingId) {
        bookingService.cancelBooking(bookingId);
        return ResponseEntity.ok("Booking cancelled");
    }
}
