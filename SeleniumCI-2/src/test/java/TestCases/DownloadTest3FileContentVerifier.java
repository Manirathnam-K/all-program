package TestCases;

import org.apache.commons.io.FileUtils;
import org.testng.Assert;

import java.io.File;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class DownloadTest3FileContentVerifier {
    public static String getFileChecksum(File file) throws NoSuchAlgorithmException, IOException {
        MessageDigest digest = MessageDigest.getInstance("MD5");
        byte[] fileBytes = FileUtils.readFileToByteArray(file);
        byte[] hashBytes = digest.digest(fileBytes);
        
        StringBuilder sb = new StringBuilder();
        for (byte b : hashBytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }

    public static void verifyDownloadedFile() throws Exception {
        File downloadedFile = new File("path/to/downloaded/file");
        
        // Verify file exists and not empty
        Assert.assertTrue(downloadedFile.exists(), "File not found");
        Assert.assertTrue(downloadedFile.length() > 0, "File is empty");
        
        // Verify checksum (compare with known hash if available)
        String fileHash = getFileChecksum(downloadedFile);
        // Assert.assertEquals(fileHash, "expected_md5_hash", "File content doesn't match");
    }
}