/**
 * Created on 2014. 11. 25.
 * @author cskim -- hufs.ac.kr, Dept of CSE
 * Copy Right -- Free for Educational Purpose
 */
package hufs.ces.svgtreedraw;

import java.io.File;

import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeModel;

public class SVGTreeDrawModel {

	public SVGTreeDrawView view = null;
	
	private File selectedFile = null;
	
	private TreeModel saxTreeModel = null;
	
	public SVGTreeDrawModel(SVGTreeDrawView view){
		this.view = view;
	}

	public File getSelectedFile() {
		return selectedFile;
	}

	public void setSelectedFile(File selectedFile) {
		this.selectedFile = selectedFile;
	}

	public TreeModel getSaxTreeModel() {
		return saxTreeModel;
	}

	public void setSaxTreeModel(TreeModel xmlTreeModel) {
		this.saxTreeModel = xmlTreeModel;
	}
}
