@Component
public class JWTUtil {
    private String secret = "secretKey"; // Use a strong secret in production

    public String generateToken(String email) {
        // Implement token generation logic
    }

    public boolean validateToken(String token, String email) {
        // Implement token validation logic
    }
}
