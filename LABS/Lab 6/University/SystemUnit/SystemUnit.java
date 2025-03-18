package University.SystemUnit;

public class SystemUnit{

	private String cpuName;
	private String lcdModel;
	private double ramSize;
	private double diskSize;
	static private String systemId;
	private int idCount = 1;

	public SystemUnit(String cpuName, String lcdModel, double ramSize, double diskSize){
		setCpuName(cpuName);
		setLcdModel(lcdModel);
		setRamSize(ramSize);
		setDiskSize(diskSize);
		this.systemId = String.format("CUI-PC-" + idCount);
		idCount++;		
	}

	public void setCpuName(String cpuName){
		this.cpuName = cpuName;
	}

	public void setSystemId(String systemId){
		this.systemId = systemId;
	}

	public void setLcdModel(String lcdModel){
		this.lcdModel = lcdModel;
	}

	public void setRamSize(double ramSize){
		this.ramSize = ramSize;
	}

	public void setDiskSize(double diskSize){
		this.diskSize = diskSize;
	}

	public String getCpuName(){
		return this.cpuName;
	}

	public String getSystemid(){
		return this.systemId;
	}

	public String getLcdModel(){
		return this.lcdModel;
	}	

	public double getRamSize(){
		return this.ramSize;
	}

	public double getDiskSize(){
		return this.diskSize;
	}

	public String toString(){
		return String.format("System details:\nCPU Name: %s\nLCD Model: %s\nSysten ID: %s\nRAM Size: %f\nDisk Size:%f", cpuName, lcdModel, systemId, ramSize, diskSize);
	}
}
