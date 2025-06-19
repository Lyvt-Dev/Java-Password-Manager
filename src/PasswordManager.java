import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class PasswordManager {
    private final String fileName;
    private final String secretKey;
    private List<PasswordEntry> entries;

    public PasswordManager(String fileName, String secretKey) {
        this.fileName = fileName;
        this.secretKey = secretKey;
        this.entries = loadEntries();
    }

    public void addEntry(PasswordEntry entry) {
        entries.add(entry);
    }

    public List<PasswordEntry> loadEntries() {
        try {
            File file = new File(fileName);
            if (!file.exists()) return new ArrayList<>();

            byte[] encryptedData = Files.readAllBytes(file.toPath());
            byte[] decrypted = decrypt(encryptedData);
            ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(decrypted));
            return (List<PasswordEntry>) ois.readObject();
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public void saveEntries() {
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(entries);
            byte[] encrypted = encrypt(baos.toByteArray());
            Files.write(new File(fileName).toPath(), encrypted);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private byte[] encrypt(byte[] data) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        SecretKeySpec key = new SecretKeySpec(secretKey.getBytes(), "AES");
        cipher.init(Cipher.ENCRYPT_MODE, key);
        return cipher.doFinal(data);
    }

    private byte[] decrypt(byte[] data) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        SecretKeySpec key = new SecretKeySpec(secretKey.getBytes(), "AES");
        cipher.init(Cipher.DECRYPT_MODE, key);
        return cipher.doFinal(data);
    }
}
