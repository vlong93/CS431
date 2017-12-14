package cs431.p2;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.util.Scanner;
import java.nio.file.StandardCopyOption;
import java.nio.file.Paths;

public class OperatingSystem {


    private int clock_ptr;

    public int handlePageFault(String va, physicalMemory pm, pageTable vpt) throws IOException {

        boolean evicted = false;
        int dbit = 0;

        while (evicted == false) {
            if (vpt.getR((int)pm.getPysMem(clock_ptr, 0)) == 1) {
                vpt.setR((int)pm.getPysMem(clock_ptr, 0), 0);
            } else {
                if (vpt.getD((int)pm.getPysMem(clock_ptr, 0)) == 1){
                    String hex = Integer.toHexString((int)pm.getPysMem(clock_ptr, 0));
                    if (hex.length() == 1) {
                        hex = "0" + hex;
                    }

                    File file = getPageFile(hex);
                    PrintWriter pw = new PrintWriter(new FileWriter(file));

                    for (int i = 1; i < 256; i++) {
                        if (pm.getPysMem(clock_ptr, i) != -1) {
                            pw.print(pm.getPysMem(clock_ptr, i) + "\n");
                        }
                    }
                    dbit = 1;
                    pw.close();
                }
                int vpNum = Integer.parseInt(va.substring(0, 2), 16);
                pm.setPhysMem(clock_ptr,0,vpNum);
                File file = getPageFile(va.substring(0,2));
                Scanner keyboard = new Scanner(file);
                for (int i = 1; i < 256; i++ ) {
                    pm.setPhysMem(clock_ptr, i, keyboard.nextDouble());
                }

                vpt.setPageFrame(vpNum, clock_ptr);
                vpt.setV(vpNum,1);
                vpt.setD(vpNum,0);
                vpt.setR(vpNum,1);

                evicted = true;
                keyboard.close();
            }
            clock_ptr++;
            if (clock_ptr == 16) {
                clock_ptr = 0;
            }
        }

        return dbit;
    }

    public void resetTables(TLBentries[] tlb, pageTable vpt) {
        for (int i = 0; i < tlb.length; i++) {
            tlb[i].setR(0);
        }
        vpt.resetTble();
    }
    private File getPageFile(String hex) throws IOException{
        String src = "src/cs431/p2/page_files/original/" + hex + ".pg";
        String dest = "src/cs431/p2/page_files/copy/" + hex + ".pg";
        Files.copy(Paths.get(src),Paths.get(dest),StandardCopyOption.REPLACE_EXISTING);
        return new File(dest);
    }
}
