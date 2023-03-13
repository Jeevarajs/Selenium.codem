import java.io.IOException;
import java.util.ArrayList;

public class sample {
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		dataDriven d=new dataDriven();
		ArrayList data=d.getData("T01");
		
		System.out.println(data.get(3));
//		ArrayList dat=d.getData("Test Case Id");
//		System.out.println(dat.get(0));
//		System.out.println(dat.get(1));
		
	}

}
