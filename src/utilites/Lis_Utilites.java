package utilites;

import java.io.IOException;
import java.util.Properties;

public class Lis_Utilites {
	private Properties prop;
	private String nomFichier;

	public Lis_Utilites(String nomFichier) {
		this.nomFichier=nomFichier;
		this.prop = new Properties();
		try{
			this.prop.load(getClass().getClassLoader().getResourceAsStream(this.nomFichier));
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	public String getValeurProperties(String cle){
		return prop.getProperty(cle);
	}
	
}
