package cs431.p2;

public class pageTable {
	private page[] vPageTable = new page[256];

	public pageTable(){
		for(int i = 0; i < 256; ++i){
			page entry = new page(i);
			vPageTable[i] = entry;
		}
	}
	public void setV(int entry, int valid){ vPageTable[entry].setV(valid);}
	public void setR(int entry, int read){vPageTable[entry].setR(read);}
	public void setD(int entry, int dirty){vPageTable[entry].setD(dirty);}
	public void setPageFrame(int entry,int p){vPageTable[entry].setPageFrame(p);}
	public int getV(int entry){return vPageTable[entry].getV();}
	public int getR(int entry){return vPageTable[entry].getR();}
	public int getD(int entry){return vPageTable[entry].getD();}
	public int getPageFrame(int entry){return vPageTable[entry].getPageFrame();}
	public void resetTble(){
		for (int i = 0; i < vPageTable.length; i++) {
			vPageTable[i].setR(0);
		}

	}
}