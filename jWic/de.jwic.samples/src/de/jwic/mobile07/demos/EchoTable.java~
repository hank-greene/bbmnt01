package de.jwic.mobile05.demos;

import de.jwic.mobile05.MobileDemoModule;
import de.jwic.base.Control;
import de.jwic.base.ControlContainer;
import de.jwic.base.IControlContainer;

import de.jwic.events.ElementSelectedEvent;
import de.jwic.events.ElementSelectedListener;
import de.jwic.events.SelectionEvent;
import de.jwic.events.SelectionListener;

import de.jwic.demo.tbv.BasicTBVDemo;
import de.jwic.demo.tbv.DemoTaskContentProvider;
import de.jwic.demo.tbv.DemoTask;
import de.jwic.demo.tbv.LabelProvider;

import java.util.ArrayList;
import java.util.List;

import de.jwic.controls.tableviewer.TableViewer;
import de.jwic.controls.tableviewer.TableModel;
import de.jwic.controls.tableviewer.TableModelAdapter;
import de.jwic.controls.tableviewer.TableColumn;
import de.jwic.controls.tableviewer.TableModelEvent;
import de.jwic.controls.tableviewer.MobileTableRenderer;

import de.jwic.controls.actions.Action;
import de.jwic.controls.actions.IAction;

import de.jwic.controls.Button;
import de.jwic.controls.ToolBar;
import de.jwic.controls.ToolBarGroup;

import java.util.Iterator;
import de.jwic.base.ImageRef;
import de.jwic.demo.ImageLibrary;

public class EchoTable extends MobileDemoModule implements ElementSelectedListener {

	public EchoTable() {
		super("Echo Table");
	}
	
	private ControlContainer container;
	private TableViewer table;
	private DemoTaskContentProvider contentProvider;

	private IAction flagRed;
	private IAction flagBlue;
	private IAction deleteTask;

	private class DemoTableViewerListener implements ElementSelectedListener {
		public void elementSelected(ElementSelectedEvent event) {
			System.out.println("EchoTable.DemoTableViewerListener.elementSelected");
			if (event.getElement() == null) {
				refreshActions(null);
			} else {
				System.out.println("EchoTable.DemoTableViewerListener.elementSelected << "+(String)event.getElement());
				DemoTask task = contentProvider.getObjectFromKey((String)event.getElement());
				if (task != null) {
					refreshActions(task);
					if (event.isDblClick()) {
						container.getSessionContext().notifyMessage("Element Selected: " + task.title);
					}
				}
			}
		}
	}

	@Override
	public Control createPage(IControlContainer controlContainer) {
		container = new ControlContainer(controlContainer, "container");

		table = new TableViewer(container, "table1");
		contentProvider = new DemoTaskContentProvider(createDemoData());
		table.setContentProvider(contentProvider);
		table.setTableLabelProvider(new LabelProvider());
		table.setScrollable(true);
		table.setShowStatusBar(true);
		table.setResizeableColumns(true);
		table.setSelectableColumns(true);
		table.setWidth(250);
		table.setHeight(250);

		TableModel model = table.getModel();
		model.setSelectionMode(TableModel.SELECTION_SINGLE);
		model.setColumnBtnText("Columns Button");
		
		DemoTableViewerListener listener = new DemoTableViewerListener();
		
		// add listener to demonstrate sorting/images
		model.addTableModelListener(new TableModelAdapter() {
			public void columnSelected(TableModelEvent event) {
				handleSorting(event.getTableColumn());
			}
		});
		model.setSelectionMode(TableModel.SELECTION_SINGLE);
		createColumns(table);

		// add listener to demonstrate sorting/images
		model.addTableModelListener(new TableModelAdapter() {
			public void columnSelected(TableModelEvent event) {
				handleSorting(event.getTableColumn());
			}
		});
		model.setSelectionMode(TableModel.SELECTION_SINGLE);
		//createColumns();
		createActions();
		
		// create the toolbar
		//ToolBar tb = new ToolBar(this, "toolbar");
		ToolBar tb = new ToolBar(container, "toolbar");
		tb.setCssClass("j-toolbar ui-corner-top");
		ToolBarGroup group = tb.addGroup();
		Button btNew = group.addButton();
		btNew.setTitle("Add Task");
		btNew.setIconEnabled(ImageLibrary.IMG_ADD);
		btNew.addSelectionListener(new SelectionListener() {
			@Override
			public void objectSelected(SelectionEvent event) {
				
				System.out.println("addSelectionListener "+
					                 "objectSelected ... addDemoTask");
				
				//addDemoTask();
			}
		});
		
		// Add the listener after all other controls have been created
		model.addElementSelectedListener(listener);
		//model.addElementSelectedListener(this);
				
		return container;
	}
	

	public void elementSelected(ElementSelectedEvent event) {
		System.out.println("EchoTable.elementSelected");
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
	 * 
	 */
	private void createActions() {
		
		flagRed = new Action() {
			@Override
			public void run() {
				handleFlagRed();
			}
		};
		flagRed.setTitle("Mark Completed");
		flagRed.setIconEnabled(new ImageRef("icons/flag_red.png"));

		flagBlue = new Action() {
			@Override
			public void run() {
				handleFlagBlue();
			}
		};
		flagBlue.setTitle("Mark for Review");
		flagBlue.setIconEnabled(new ImageRef("icons/flag_blue.png"));

		deleteTask = new Action() {
			public void run() {
				container.getSessionContext().notifyMessage("Sorry, not implemented", "error");
			}
		};
		deleteTask.setTitle("Delete");
		deleteTask.setIconEnabled(ImageLibrary.IMG_CROSS);

		refreshActions(null);
	}

	/**
	 * 
	 */
	protected void addDemoTask() {
		/***
		AddDemoTaskDialog dialog = new AddDemoTaskDialog(viewer.getContainer());
		dialog.addDialogListener(new DialogAdapter() {
			public void dialogFinished(DialogEvent event) {
				AddDemoTaskDialog dialog = ((AddDemoTaskDialog) event.getEventSource());
				DemoTask task = dialog.getDemoTask();
				contentProvider.addElement(task);
				
				table.setRequireRedraw(true);
			}
		});
		dialog.openAsPage();
		***/
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
		for (int i = 1; i < 105; i++) {
			DemoTask demoTask = new DemoTask();
			demoTask.done = i % 5 == 0;
			demoTask.completed = i;
			demoTask.title = "Task " + i;
			demoTask.owner = "?";
			data.add(demoTask);
		}
		return data;
	}


	/**
	 * 
	 */
	protected void handleFlagBlue() {
		String key = table.getModel().getFirstSelectedKey();
		if (key != null) {
			DemoTask task = contentProvider.getObjectFromKey(key);
			container.getSessionContext().notifyMessage("Task '" + task.title + "' marked for review.", "info");
		}
	}

	/**
	 * 
	 */
	protected void handleFlagRed() {
		String key = table.getModel().getFirstSelectedKey();
		if (key != null) {
			DemoTask task = contentProvider.getObjectFromKey(key);
			if (task != null) {
				task.completed = 100;
				task.done = true;
				table.requireRedraw();
			}
		}
	}
	
	protected void handleSorting(TableColumn tableColumn) {
		System.out.println("Echotable.handleSorting");
		if (tableColumn.getSortIcon() == TableColumn.SORT_ICON_NONE) {
			// clear all columns
			for (Iterator<TableColumn> it = table.getModel().getColumnIterator(); it.hasNext(); ) {
				TableColumn col = it.next();
				col.setSortIcon(TableColumn.SORT_ICON_NONE);
			}
		}
		boolean up = true;
		switch (tableColumn.getSortIcon()) {
		case TableColumn.SORT_ICON_NONE: 
			tableColumn.setSortIcon(TableColumn.SORT_ICON_UP);
			break;
		case TableColumn.SORT_ICON_UP:
			tableColumn.setSortIcon(TableColumn.SORT_ICON_DOWN);
			up = false;
			break;
		case TableColumn.SORT_ICON_DOWN:
			// once sorted, the list can not be displayed in the
			// original order as we sort the original table,
			// therefor loosing the original order.
			tableColumn.setSortIcon(TableColumn.SORT_ICON_UP);
			//tableColumn.setSortIcon(TableColumn.SORT_ICON_NONE);
			break;
		}
		
		// do the sort
		contentProvider.sortData((String)tableColumn.getUserObject(), up);
		
		table.setRequireRedraw(true);
		
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