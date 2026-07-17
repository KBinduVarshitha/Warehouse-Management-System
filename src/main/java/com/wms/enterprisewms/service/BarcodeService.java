package com.wms.enterprisewms.service;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.oned.Code128Writer;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

@Service
public class BarcodeService {

    public byte[] generateBarcode(String sku)
            throws WriterException, IOException {

        Code128Writer writer = new Code128Writer();

        BitMatrix bitMatrix = writer.encode(
                sku,
                BarcodeFormat.CODE_128,
                350,
                120
        );

        ByteArrayOutputStream outputStream =
                new ByteArrayOutputStream();

        MatrixToImageWriter.writeToStream(
                bitMatrix,
                "PNG",
                outputStream
        );

        return outputStream.toByteArray();
    }
}