@Service
public class BookingService {
    @Autowired
    private BookingRepository bookingRepository;

    public Booking bookRoom(Booking booking) {
        return bookingRepository.save(booking);
    }

    public void cancelBooking(Long bookingId) {
        bookingRepository.deleteById(bookingId);
    }
}
