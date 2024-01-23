import com.machinezoo.sourceafis.FingerprintImage;
import com.machinezoo.sourceafis.FingerprintImageOptions;
import com.machinezoo.sourceafis.FingerprintMatcher;
import com.machinezoo.sourceafis.FingerprintTemplate;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        /*  String path1 = "A:\\Work\\W3\\W3\\Finger_Base-408\\BASE_Finger\\" + "00" + Integer.toString(1) + "_" + Integer.toString(3) + "_" + Integer.toString(1) + ".png";
        String path2 = "A:\\Work\\W3\\W3\\Finger_Base-408\\BASE_Finger\\" + "00" + Integer.toString(2) + "_" + Integer.toString(3) + "_" + Integer.toString(2) + ".png";

        FingerprintTemplate probe = new FingerprintTemplate(
                new FingerprintImage(
                        Files.readAllBytes(Paths.get(path1)),
                        new FingerprintImageOptions()
                                .dpi(500)));

        FingerprintTemplate candidate = new FingerprintTemplate(
                new FingerprintImage(Files.readAllBytes(Paths.get(path2)),
                        new FingerprintImageOptions()
                                .dpi(500)));
        double score = new FingerprintMatcher(probe).match(candidate);
        System.out.println(score);*/
        List<Double> genuine = new ArrayList<Double>();
        for (int m = 1; m < 8; m++) {//50   //
            for (int i = 3; i < 9; i++) {//8
                for (int l = 1; l < 8; l++) {//8
                    for (int j = l + 1; j < 9; j++) {//8
                        //String path = "A:\\Work\\W3\\W3\\Finger_Base-408\\BASE_Finger\\001_3_1.png";
                        String path1 = "A:\\Work\\W3\\W3\\Finger_Base-408\\BASE_Finger\\" + "00" + Integer.toString(m) + "_" + Integer.toString(i) + "_" + Integer.toString(l) + ".png";

                        //String path2 = "A:\\Work\\W3\\W3\\Finger_Base-408\\BASE_Finger\\001_3_2.png";
                        String path2 = "A:\\Work\\W3\\W3\\Finger_Base-408\\BASE_Finger\\" + "00" + Integer.toString(m) + "_" + Integer.toString(i) + "_" + Integer.toString(j) + ".png";
                        //System.out.println(path1+""+path2);
                        FingerprintTemplate probe = new FingerprintTemplate(
                                new FingerprintImage(
                                        Files.readAllBytes(Paths.get(path1)),
                                        new FingerprintImageOptions()
                                                .dpi(500)));
                        //  probe.toString();

                        FingerprintTemplate candidate = new FingerprintTemplate(
                                new FingerprintImage(
                                        Files.readAllBytes(Paths.get(path2)),
                                        new FingerprintImageOptions()
                                                .dpi(500)));
                        double score = new FingerprintMatcher(probe)
                                .match(candidate);
                        boolean matches = score >= 40;

                        // if (matches) {
                           System.out.println(score + "__00" + Integer.toString(m) + "_" + Integer.toString(i) + "_" + Integer.toString(l) + "  " + "00" + Integer.toString(m) + "_" + Integer.toString(i) + "_" + Integer.toString(j));
                        // }
                        genuine.add(score);

                        //
                    }
                }
            }

        }
        System.out.println(Collections.max(genuine));
        System.out.println(Collections.min(genuine));

    }
}
