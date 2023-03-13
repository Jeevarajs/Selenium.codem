package resources;

import java.util.ArrayList;
import java.util.List;

import pojo.Addplace;
import pojo.Location;

public class TestDataBuild {
	
	
public Addplace addPlace(String name, String language,String address) {
	Addplace p=new Addplace();
	 p.setAccuracy(50);
	 p.setAddress(address);
	 p.setLanguage(language);
	 Location pt=new Location();
	 pt.setLat(-38.383494);
	 pt.setLng(33.427362);
	 p.setLocation(pt);
	 p.setName(name);
	 p.setPhone_number("(+91) 983 893 3937");
	 List<String>gg= new ArrayList<String>();
	 gg.add("shoe park");
	 gg.add("shop");
	 p.setTypes(gg);
	 p.setWebsite("https://rahulshettyacademy.com");
     return p;
}

public String deletePlacePayload(String placeId)
{
	return "{\r\n    \"place_id\":\""+placeId+"\"\r\n}";
}


}
