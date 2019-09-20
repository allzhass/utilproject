package util.qrcode;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Base64;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

public class QRGenerator {

    public static void main(String[] args) throws IOException, WriterException {
        String base64QRCode = Base64.getEncoder().encodeToString(getQRCodeImage("PNG","Olzhas Zhetpisbayev", 300, 300));
        System.out.println(base64QRCode);

    }

    /*
    This method takes the text to be encoded, the width and height of the QR Code,
    and returns the QR Code in the form of a byte array.
    */
    private static byte[] getQRCodeImage(String format, String text, int width, int height) throws WriterException, IOException {
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, width, height);

        ByteArrayOutputStream pngOutputStream = new ByteArrayOutputStream();
        MatrixToImageWriter.writeToStream(bitMatrix, format, pngOutputStream);
        byte[] pngData = pngOutputStream.toByteArray();
        return pngData;
    }

}