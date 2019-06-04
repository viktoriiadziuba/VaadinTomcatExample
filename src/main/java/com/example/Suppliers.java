package com.example;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.dependency.StyleSheet;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLink;

@Route("suppliers")
@StyleSheet("frontend://styles/styles.css")
public class Suppliers extends VerticalLayout {
	
	public Suppliers() {
		// HEADER
		Icon drawer = VaadinIcon.MENU.create();
		Span title = new Span("My application");
		Tab exit = new Tab(VaadinIcon.SIGN_OUT.create(), new RouterLink("Sign out", SignIn.class));	
		HorizontalLayout header = new HorizontalLayout(drawer, title, exit);
		header.expand(title);
		header.setPadding(true);
		header.setWidth("100%");

		// WORKSPACE
		VerticalLayout workspace = new VerticalLayout(createSupplier(), createSupplier(), createSupplier(), createSupplier(), createSupplier(), createSupplier(), createSupplier(), createSupplier());
		workspace.addClassName("workspace");
		workspace.setSizeFull();

		// FOOTER
		Tab actionButton1 = new Tab(VaadinIcon.HOME.create(), new RouterLink("Home", MyUI.class));
		Tab actionButton2 = new Tab(VaadinIcon.USERS.create(), new RouterLink("Suppliers", Suppliers.class));
		Tab actionButton3 = new Tab(VaadinIcon.PACKAGE.create(), new RouterLink("Products", Products.class));
		actionButton1.setClassName("tab");
		actionButton2.setClassName("tab");
		actionButton3.setClassName("tab");
		Tabs buttonBar = new Tabs(actionButton1, actionButton2, actionButton3);
		HorizontalLayout footer = new HorizontalLayout(buttonBar);
		footer.setJustifyContentMode(JustifyContentMode.CENTER);
		footer.setWidth("100%");

		// MENU
		VerticalLayout sideMenu = new VerticalLayout();
		sideMenu.addClassName("sideMenu");
		sideMenu.setHeight("100%");
		sideMenu.setWidth("auto");
		sideMenu.setSpacing(false);
		drawer.getElement().addEventListener("click", ev->sideMenu.getStyle().set("left", "0px"));
		Icon avatar = VaadinIcon.USER.create();
		avatar.setSize("4em");
		sideMenu.add(avatar, new Span("Username"),new RouterLink("User profile", UserPage.class));
		sideMenu.setAlignItems(Alignment.CENTER);

		// CONTAINER
		setSizeFull();
		setMargin(false);
		setSpacing(false);
		setPadding(false);
		add(sideMenu, header, workspace, footer);
	}

	private Component createSupplier() {
		Span supplier1Label = new Span("Supplier");
		FlexLayout supplier = new FlexLayout(supplier1Label);
		supplier.addClassName("card");
		supplier.setAlignItems(Alignment.CENTER);
		supplier.setJustifyContentMode(JustifyContentMode.CENTER);
		supplier.setWidth("100%");
		supplier.setHeight("100px");
		return supplier;
	}
	
}
