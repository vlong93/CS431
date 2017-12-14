package cs431.p2;

public class physicalMemory {
    private double ram[][] = new double[16][256];

    public physicalMemory(){
        for (int i = 0; i < 16; i++) {
            for (int j = 0; j < 256; j++) {
                if (j == 0) {
                    ram[i][j] = i;
                } else {
                    ram[i][j] = -1;
                }
            }
        }
    }

    public double getPysMem(int r, int c){return ram[r][c];}
    public void setPhysMem(int r,int c, double value){ram[r][c] = value;}



}