import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

public abstract class Account implements AccountManagement {
    private String name;
    private byte[] hashedPassword;
    private UUID accountID;

    public Account(String name, String password) {
        this.name = name;
        this.hashedPassword = hashPassword(password);
        this.accountID = UUID.randomUUID();
    }

    private static byte[] hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            return md.digest(password.getBytes(StandardCharsets.UTF_8));
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error hashing password", e);
        }
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean validatePassword(String enteredPassword) {
        byte[] hashedEnteredPassword = hashPassword(enteredPassword);
        return MessageDigest.isEqual(hashedEnteredPassword, this.hashedPassword);
    }

    @Override
    public void changeUsername(String newUsername) {
        this.name = newUsername;
    }

    @Override
    public void changePassword(String newPassword) {
        this.hashedPassword = hashPassword(newPassword);
    }
}
