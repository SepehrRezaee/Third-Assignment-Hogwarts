import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Account {

    private String username;
    private byte[] hashedPassword;
    private UUID accountID;

    public Account(String username, String password) {
        this.username = username;
        this.accountID = UUID.randomUUID();
        this.hashPassword(password);
    }

    private void hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(password.getBytes());
            this.hashedPassword = md.digest();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean validatePassword(String enteredPassword) {
        byte[] enteredHashedPassword = hashString(enteredPassword);
        return MessageDigest.isEqual(this.hashedPassword, enteredHashedPassword);
    }

    @Override
    public void changeUsername(String newUsername) {
        this.username = newUsername;
    }

    @Override
    public void changePassword(String newPassword) {
        this.hashPassword(newPassword);
    }

    private byte[] hashString(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(input.getBytes());
            return md.digest();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }
}
