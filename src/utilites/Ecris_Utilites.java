package utilites;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

public class Ecris_Utilites {
	private Properties prop=new Properties();
	private String nomFichier;

	public Ecris_Utilites(String nomFichier) {
                this.nomFichier=nomFichier;
		try {
                    InputStream is=getClass().getClassLoader().getResourceAsStream(this.nomFichier);
                    this.prop.load(is);
                    is.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
	}
	public void setValeurProperties(String cle,String valeur){
		this.prop.setProperty(cle, valeur);
	}
	
	public void saveProperties(){                
		try {
                    OutputStream os=new FileOutputStream(new File(nomFichier));
                    prop.store(os, null);
                    os.close();                    
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
	}	
}
