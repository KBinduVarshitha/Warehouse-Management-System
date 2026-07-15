package com.wms.enterprisewms.service;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.oned.Code128Writer;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;

@Service
public class BarcodeService {

    public byte[] generateBarcode(String text) {

        try {

            Code128Writer writer = new Code128Writer();

            BitMatrix matrix = writer.encode(
                    text,
                    BarcodeFormat.CODE_128,
                    300,
                    100
            );

            ByteArrayOutputStream stream = new ByteArrayOutputStream();

            MatrixToImageWriter.writeToStream(
                    matrix,
                    "PNG",
                    stream
            );

            return stream.toByteArray();

        } catch (Exception e) {
            throw new RuntimeException("Unable to generate barcode");
        }
    }
}