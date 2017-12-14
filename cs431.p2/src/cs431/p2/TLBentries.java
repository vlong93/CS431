package cs431.p2;

public class TLBentries {
    private int vPnum, pFrameNum;
    private int v,r,d;

    public TLBentries(){
        v = 0;
        r = 0;
        d = 0;
        vPnum = -1;
        pFrameNum = -1;
    }
    public int getV(){return v;}
    public int getR(){return r;}
    public int getD(){return d;}
    public int getVirtualPageNum(){return vPnum;}
    public int getPageFrame(){return pFrameNum;}
    public void setV(int valid){valid = v;}
    public void setR(int read){read = r;}
    public void setD(int dirty){dirty = d;}
    public void setVPN(int vpn){vpn = vPnum;}
    public void setPageFrame(int page){page = pFrameNum;}
}