package iodatastream.bank;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class BankAccountManager {

    public void saveAccount(BankAccount account, Path folder) {
        Path file = folder.resolve(account.getAccountNumber() + ".dat");
        try (DataOutputStream outputStream = new DataOutputStream(new BufferedOutputStream(Files.newOutputStream(file)))) {
            outputStream.writeUTF(account.getAccountNumber());
            outputStream.writeUTF(account.getOwner());
            outputStream.writeDouble(account.getBalance());
        } catch (IOException e) {
            throw new IllegalStateException("cannot write file", e);
        }
    }

    public BankAccount loadAccount(InputStream inputStream) {
        try (DataInputStream dataInputStream = new DataInputStream(new BufferedInputStream(inputStream))) {
            return new BankAccount(dataInputStream.readUTF(), dataInputStream.readUTF(), dataInputStream.readDouble());
        } catch (IOException ioe) {
            throw new IllegalStateException("can not read file", ioe);
        }
    }
}
