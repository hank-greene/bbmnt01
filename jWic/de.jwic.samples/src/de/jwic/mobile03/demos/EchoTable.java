package de.jwic.mobile03.demos;

import de.jwic.mobile03.MobileDemoModule;
import de.jwic.base.Control;
import de.jwic.base.ControlContainer;
import de.jwic.base.IControlContainer;

// from de.jwic.demo.tbv.BasicTBVDemo
import de.jwic.base.ImageRef;
import de.jwic.controls.Button;
import de.jwic.controls.ToolBar;
import de.jwic.controls.ToolBarGroup;
import de.jwic.controls.actions.Action;
import de.jwic.controls.actions.IAction;
import de.jwic.controls.dialogs.DialogAdapter;
import de.jwic.controls.dialogs.DialogEvent;
import de.jwic.controls.menu.Menu;

//import de.jwic.controls.tableviewer.TableColumn;
//import de.jwic.controls.tableviewer.TableModel;
//import de.jwic.controls.tableviewer.TableModelAdapter;
//import de.jwic.controls.tableviewer.TableModelEvent;
//import de.jwic.controls.tableviewer.TableViewer;

import de.jwic.mobile03.demos.tbv.TableColumn;
import de.jwic.mobile03.demos.tbv.TableModel;
import de.jwic.mobile03.demos.tbv.TableModelAdapter;
import de.jwic.mobile03.demos.tbv.TableModelEvent;
import de.jwic.mobile03.demos.tbv.TableViewer;

import de.jwic.demo.ImageLibrary;
import de.jwic.events.ElementSelectedEvent;
import de.jwic.events.ElementSelectedListener;
import de.jwic.events.SelectionEvent;
import de.jwic.events.SelectionListener;

import de.jwic.mobile03.demos.tbv.DemoTaskContentProvider;
import de.jwic.mobile03.demos.tbv.DemoTask;
import de.jwic.mobile03.demos.tbv.LabelProvider;
import de.jwic.mobile03.demos.tbv.MobileTableRenderer;

import java.util.ArrayList;
import java.util.List;


//public class EchoTable extends MobileDemoModule implements ElementSelectedListener {
public class EchoTable extends MobileDemoModule implements ElementSelectedListener {

	public EchoTable() {
		super("Echo Table");
	}
	
	private TableViewer viewer;
	private DemoTaskContentProvider contentProvider;

	private IAction flagRed;
	private IAction flagBlue;
	private IAction deleteTask;

	/****
	private class DemoTableViewerListener implements ElementSelectedListener {
		public void elementSelected(ElementSelectedEvent event) {
			
			if (event.getElement() == null) {
				refreshActions(null);
			} else {
				DemoTask task = contentProvider.getObjectFromKey((String)event.getElement());
				if (task != null) {
					refreshActions(task);
					if (event.isDblClick()) {
						getSessionContext().notifyMessage("Element Selected: " + task.title);
					}
				}
			}
		}
	}
	****/
	//private ControlContainer container = new ControlContainer(controlContainer, "container");
	private ControlContainer container;


	@Override
	public Control createPage(IControlContainer controlContainer) {
		container = new ControlContainer(controlContainer, "container");

		final TableViewer table = new TableViewer(container, "table1");
		//DemoTaskContentProvider contentProvider = new DemoTaskContentProvider(createDemoData());
		contentProvider = new DemoTaskContentProvider(createDemoData());
		table.setContentProvider(contentProvider);
		table.setTableLabelProvider(new LabelProvider());
		table.setTableRenderer(new MobileTableRenderer());

		TableModel model = table.getModel();

		model.setSelectionMode(TableModel.SELECTION_SINGLE);
		model.setColumnBtnText("Columns Button");
		createColumns(table);
		/*****/

		return container;
	}
	
	
	public void elementSelected(ElementSelectedEvent event) {
		
		if (event.getElement() == null) {
			refreshActions(null);
		} else {
			DemoTask task = contentProvider.getObjectFromKey((String)event.getElement());
			if (task != null) {
				refreshActions(task);
				if (event.isDblClick()) {
					container.getSessionContext().notifyMessage("Element Selected: " + task.title);
				}
			}
		}
	}
		
		
	/**
	 * @param task
	 */
	public void refreshActions(DemoTask task) {
		
		deleteTask.setEnabled(task != null);
		flagBlue.setEnabled(task != null);
		flagRed.setEnabled(task != null && !task.done);
		
	}
	
		
	/**
	 * @return
	 */
	private List<DemoTask> createDemoData() {
		List<DemoTask> data = new ArrayList<DemoTask>();
		data.add(new DemoTask("Implement Demo", "Sam", 0));
		DemoTask task = new DemoTask("Write Docu", "Mark", 0);
		task.done = true;
		data.add(task);
		data.add(new DemoTask("Setup buildserver", "Ronny", 20));
		data.add(new DemoTask("Update jwic homepage", "?", 0));
		data.add(new DemoTask("Unknown", "", 0));
		data.add(new DemoTask("Change default implementation", "Sam", 10));
		data.add(new DemoTask("Evaluate library XYZ for relevance", "Mark", 50));
		
		/****
		for (int i = 1; i < 105; i++) {
			DemoTask demoTask = new DemoTask();
			demoTask.done = i % 5 == 0;
			demoTask.completed = i;
			demoTask.title = "Task " + i;
			demoTask.owner = "?";
			data.add(demoTask);
		}
		*****/
		return data;
	}

	/**
	 * 
	 */
	private void createColumns(TableViewer viewer) {

		TableModel model = viewer.getModel();
		// add Columns
		TableColumn col = new TableColumn("Check");
		col.setWidth(20);
		col.setUserObject("done");
		model.addColumn(col);

		col = new TableColumn("Task");
		col.setUserObject("title");
		col.setWidth(250);
		model.addColumn(col);

		col = new TableColumn("Owner");
		col.setUserObject("owner");
		col.setWidth(120);
		model.addColumn(col);

		col = new TableColumn("Complete");
		col.setUserObject("completed");
		col.setWidth(80);
		model.addColumn(col);

	}
	
}