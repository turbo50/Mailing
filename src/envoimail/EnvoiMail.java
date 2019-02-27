/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package envoimail;

import chrriis.common.UIUtils;
import chrriis.dj.nativeswing.swtimpl.NativeInterface;
import chrriis.dj.nativeswing.swtimpl.components.JHTMLEditor;
import chrriis.dj.nativeswing.swtimpl.components.JHTMLEditor.HTMLEditorImplementation;
import gui.JF_EnvoieMail;
import java.awt.BorderLayout;
import java.awt.Toolkit;

/**
 *
 * @author LENGUE
 */
public class EnvoiMail {
     public static JHTMLEditor htmlEditor;
    /**
     * @param args the command line arguments
     */
    public static void demarrer(){
            UIUtils.setPreferredLookAndFeel();
            NativeInterface.open();
            final String configurationScript =
              "FCKConfig.ToolbarSets[\"Default\"] = [\n" +
              "['Source','DocProps','-','Save','NewPage','Preview','-','Templates'],\n" +
              "['Cut','Copy','Paste','PasteText','PasteWord','-','Print','SpellCheck'],\n" +
              "['Undo','Redo','-','Find','Replace','-','SelectAll','RemoveFormat'],\n" +
              "['Form','Checkbox','Radio','TextField','Textarea','Select','Button','ImageButton','HiddenField'],\n" +
              "'/',\n" +
              "['Style','FontFormat','FontName','FontSize'],\n" +
              "['TextColor','BGColor'],\n" +
              "'/',\n" +
              "['Bold','Italic','Underline','StrikeThrough','-','Subscript','Superscript'],\n" +
              "['OrderedList','UnorderedList','-','Outdent','Indent','Blockquote'],\n" +
              "['JustifyLeft','JustifyCenter','JustifyRight','JustifyFull'],\n" +
              "['Link','Unlink','Anchor'],\n" +
              "['Image','Flash','Table','Rule','Smiley','SpecialChar','PageBreak', '-', 'ShowBlocks'],\n" +
              "];\n" +
              "FCKConfig.ToolbarCanCollapse = false;\n";
                java.awt.EventQueue.invokeLater(new Runnable() {
                    public void run() {
                        htmlEditor = new JHTMLEditor(HTMLEditorImplementation.FCKEditor,JHTMLEditor.FCKEditorOptions.setCustomJavascriptConfiguration(configurationScript));
                        JF_EnvoieMail jfe = new JF_EnvoieMail();
                        jfe.setSize(Toolkit.getDefaultToolkit().getScreenSize());
                        jfe.add(htmlEditor,BorderLayout.CENTER);
                        jfe.setLocationByPlatform(true);
                        jfe.setVisible(true);
                    }
                });
            
    }
    public static void main(String[] args) {
        // TODO code application logic here
        demarrer();
    }
    
}
