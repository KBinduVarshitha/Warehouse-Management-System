package com.wms.enterprisewms.controller;

import com.google.zxing.WriterException;
import com.wms.enterprisewms.service.BarcodeService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/api/barcodes")
public class BarcodeController {

    private final BarcodeService barcodeService;

    public BarcodeController(BarcodeService barcodeService) {
        this.barcodeService = barcodeService;
    }

    @GetMapping(value = "/{sku}",
            produces = MediaType.IMAGE_PNG_VALUE)
    public ResponseEntity<byte[]> generateBarcode(
            @PathVariable String sku)
            throws WriterException, IOException {

        byte[] barcode =
                barcodeService.generateBarcode(sku);

        return ResponseEntity
                .ok()
                .contentType(MediaType.IMAGE_PNG)
                .body(barcode);
    }
}