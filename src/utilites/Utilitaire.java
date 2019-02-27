/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package utilites;

import java.awt.Container;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeModel;

/**
 *
 * @author daniel
 */
public class Utilitaire {

    public void chargeCombo(JComboBox C,Vector<String> V){
        
        if (C.getItemCount()>0)
        	C.removeAllItems();
        for(int i=0; i<V.size(); i++){
            C.addItem(V.elementAt(i));
        }
        Container c =C.getParent();
        c.validate();
    }

    /* permet l'auto completion depuis une liste d'element contenu dans le combo c, en se basant sur la chaine ch*/
    public String getAutoCompletion(String ch,JComboBox c){
        StringBuffer result=new StringBuffer();
        result.append("");
        String item;
        int nbreItem=c.getItemCount();
        for(int i=0; i<nbreItem; i++){
            item=(String)c.getItemAt(i);
            if(item.indexOf(ch)==0){
                c.setSelectedItem(item);
                c.getParent().validate();
                result.append(item);
                result.append("\n");
                
            }
        }
        return result.toString();
    }

   //actver les champs de text
    
    public void activeJTextField(JTextField[] tf){
    	for(int i=0; i<tf.length; i++)
    		tf[i].setEditable(true);
    }

   //desactive text field
    public void desactiveJTextField(JTextField[] tf){
    	for(int i=0; i<tf.length; i++){
    		tf[i].setText("");
    		tf[i].setEditable(false);
    	}
    		
    }
    //vide text field
    public void videJTextField(JTextField[] tf){
    	for(int i=0; i<tf.length; i++){
    		tf[i].setText("");
    		
    	}
    		
    }
    //active button
    public void activeJButton(JButton[] b){
    	for(int i=0; i<b.length; i++)
    		b[i].setEnabled(true);
    }

   //desactive text field
    public void desactiveJButton(JButton[] tf){
    	for(int i=0; i<tf.length; i++)
    		tf[i].setEnabled(false);
    }

   public  String convertStreamToString(InputStream is) throws Exception {
    BufferedReader reader = new BufferedReader(new InputStreamReader(is));
    StringBuilder sb = new StringBuilder();
    String line = null;
    while ((line = reader.readLine()) != null) {
      sb.append(line + "\n");
    }
    is.close();
    return sb.toString();
  }


public  File inputStreamToFile(InputStream is) {

    try {


	// write the inputStream to a FileOutputStream
	OutputStream out = new FileOutputStream(new File("fic"));

	int read = 0;
	byte[] bytes = new byte[1024];

	while ((read = is.read(bytes)) != -1) {
		out.write(bytes, 0, read);
	}

	is.close();
	out.flush();
	out.close();

	System.out.println("New file created!");
    } catch (IOException e) {
	System.out.println(e.getMessage());
    }
    return new File("fic");
  }

 public  String delete(String dir)
  // create a new directory or delete the contents of an existing one
  {
    File dirF = new File(dir);
    if (dirF.isDirectory()) {

      for (File f : dirF.listFiles())
        deleteFile(f);
    }
    return dirF.getAbsolutePath();
  }

   private  void deleteFile(File f)
  {
    if (f.isFile()) {
      boolean deleted = f.delete();
    if(deleted)
        System.out.println("  deleted: "+ f.getName() );
   
    }
  }
   
 
   //charger une vector avec un fichier properties
   public Vector chargeVectorFromPropertiesFile(String cheminPropertiesFile, String prefixeCle){
       Vector v=new Vector();
       Lis_Utilites lu=new Lis_Utilites(cheminPropertiesFile);
       int nombre=Integer.parseInt(lu.getValeurProperties("nombre"));
       for(int i=0; i<nombre; i++){
           v.addElement(lu.getValeurProperties(prefixeCle+i));
       }       
       return v;
   }
   
   public String heureFinFromPropertiesFile(String cheminPropertiesFile, String prefixeCle){
      
       Lis_Utilites lu=new Lis_Utilites(cheminPropertiesFile);
         return lu.getValeurProperties(prefixeCle).toString();
   }
   
   //methode qui extrait la date de l'arbre du planning
   public String extraitDate(String date){
       int index=date.indexOf("(");
       return date.substring(0, index);
       
   }
   public String extraiHeureDeb(String heure){
        int index=heure.indexOf("-");
        return heure.substring(0, index);   
   }
   public String extraiHeureFin(String heure){
        int index=heure.indexOf("-");
        return heure.substring(index+1, heure.indexOf("("));   
   }
     
   public String extraiNomProc(String Nom){
        int index=Nom.indexOf("(");
        return Nom.substring(0, index);   
   }
  }
