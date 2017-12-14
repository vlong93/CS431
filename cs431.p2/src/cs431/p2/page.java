package cs431.p2;

public class page {
    private int pageFrame;
    private int v;
    private int r;
    private int d;

    page(int p){
        pageFrame = p;
        v = 0;
        r = 0;
        d = 0;
    }
    public void setV( int valid){ v = valid; }
    public void setR(int read){ r = read; }
    public void setD(int dirty){ d = dirty; }
    public void setPageFrame(int p){ pageFrame = p; }
    public int getV(){return v;}
    public int getR(){return r;}
    public int getD(){return d;}
    public int getPageFrame(){return pageFrame;}
}
