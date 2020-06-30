module Parking {
	requires javafx.fxml;
	requires javafx.controls;
	requires javafx.graphics;
	requires javafx.web;
	requires javafx.base;
	requires java.sql;
	
	opens application;
	opens view;
	opens controller;
	opens model.entities;
}