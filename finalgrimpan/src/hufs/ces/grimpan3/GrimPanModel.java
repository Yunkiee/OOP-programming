package hufs.ces.grimpan3;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Point;
import java.awt.Shape;
import java.awt.Stroke;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

public class GrimPanModel {

	public static final int SHAPE_REGULAR = 0;
	public static final int SHAPE_OVAL = 1;
	public static final int SHAPE_POLYGON = 2;
	public static final int SHAPE_LINE = 3;
	public static final int SHAPE_PENCIL = 4;
	public static final int EDIT_MOVE = 5;
	
	private BasicStroke shapeStroke = null;
	private Color strokeColor = null;
	private Color fillColor = null;
	private boolean shapeFill = false;
	private int editState = SHAPE_LINE;
	
	public ArrayList<GrimShape> shapeList = null;
	
	private Point mousePosition = null;
	private Point clickedMousePosition = null;
	private Point lastMousePosition = null;
	
	public Shape curDrawShape = null;
	private int selectedShape = -1;
	
	public ArrayList<Point> polygonPoints = null;

	private int nPolygon = 3;
	
	private File saveFile = null;

	public ArrayList<HashMap<String, String>> attsMapList = null;
	
	public GrimPanModel(){
		this.shapeList = new ArrayList<GrimShape>();
		this.shapeStroke = new BasicStroke();
		this.polygonPoints = new ArrayList<Point>();
	}

	public BasicStroke getShapeStroke() {
		return shapeStroke;
	}

	public void setShapeStroke(BasicStroke shapeStroke) {
		this.shapeStroke = shapeStroke;
	}

	public Color getStrokeColor() {
		return strokeColor;
	}

	public void setStrokeColor(Color strokeColor) {
		this.strokeColor = strokeColor;
	}

	public Color getFillColor() {
		return fillColor;
	}

	public void setFillColor(Color fillColor) {
		this.fillColor = fillColor;
	}

	public boolean isShapeFill() {
		return shapeFill;
	}

	public void setShapeFill(boolean shapeFill) {
		this.shapeFill = shapeFill;
	}

	public int getEditState() {
		return editState;
	}

	public void setEditState(int editState) {
		this.editState = editState;
	}

	public Point getMousePosition() {
		return mousePosition;
	}

	public void setMousePosition(Point mousePosition) {
		this.mousePosition = mousePosition;
	}

	public Point getClickedMousePosition() {
		return clickedMousePosition;
	}

	public void setClickedMousePosition(Point clickedMousePosition) {
		this.clickedMousePosition = clickedMousePosition;
	}

	public Point getLastMousePosition() {
		return lastMousePosition;
	}

	public void setLastMousePosition(Point lastMousePosition) {
		this.lastMousePosition = lastMousePosition;
	}

	public File getSaveFile() {
		return saveFile;
	}

	public void setSaveFile(File saveFile) {
		this.saveFile = saveFile;
	}

	public int getSelectedShape() {
		return selectedShape;
	}

	public void setSelectedShape(int selectedShape) {
		this.selectedShape = selectedShape;
	}

	public int getNPolygon() {
		return nPolygon;
	}

	public void setNPolygon(int nPolygon) {
		this.nPolygon = nPolygon;
	}
	
}
