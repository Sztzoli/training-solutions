package iozip.transactions;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Locale;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class TransactionFileManager {


    public void saveTransactions(Path path, List<Transaction> transactionList) {
        Locale.setDefault(Locale.US);
        try (ZipOutputStream outputStream = new ZipOutputStream(new BufferedOutputStream(Files.newOutputStream(path)))) {
            for (Transaction transaction : transactionList) {
                outputStream.putNextEntry(new ZipEntry(Long.toString(transaction.getId())));
//                outputStream.write(transaction.getTime().toString().getBytes(StandardCharsets.UTF_8));
//                outputStream.write("\n".getBytes(StandardCharsets.UTF_8));
//                outputStream.write(transaction.getAccount().getBytes(StandardCharsets.UTF_8));
//                outputStream.write("\n".getBytes(StandardCharsets.UTF_8));
//                outputStream.write(Double.toString(transaction.getAmount()).getBytes(StandardCharsets.UTF_8));
                String outPut = String.format("%s\n%s\n%.1f",
                        transaction.getTime().toString(), transaction.getAccount(), transaction.getAmount());
                outputStream.write(outPut.getBytes(StandardCharsets.UTF_8));
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("can not write file");
        }
    }
}
