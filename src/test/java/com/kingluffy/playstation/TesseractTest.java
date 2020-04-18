package com.kingluffy.playstation;

import org.bytedeco.javacpp.BytePointer;
import org.bytedeco.javacpp.lept;
import org.bytedeco.javacpp.tesseract;
import org.junit.Test;

import static org.bytedeco.javacpp.lept.pixDestroy;
import static org.bytedeco.javacpp.lept.pixRead;

public class TesseractTest {
    @Test
    public void tesserTest() {
        BytePointer outText;

        tesseract.TessBaseAPI api = new tesseract.TessBaseAPI();
        // Initialize tesseract-ocr with English, without specifying tessdata path
        if (api.Init("/usr/local/share/tessdata", "eng") != 0) {
            System.err.println("Could not initialize tesseract.");
            System.exit(1);
        }

        // Open input image with leptonica library
        lept.PIX image = pixRead("/Users/king_luffy_pc/Documents/Develop/pythonProject/tesserocr-client/test/0148936275_white.png");
        api.SetImage(image);
        // Get OCR result
        outText = api.GetUTF8Text();
        System.out.println("OCR output:\n" + outText.getString());

        // Destroy used object and release memory
        api.End();
        outText.deallocate();
        pixDestroy(image);
    }
}
