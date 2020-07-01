module Parking {
	requires javafx.fxml;
	requires javafx.controls;
	requires javafx.graphics;
	requires javafx.web;
	requires javafx.base;
	requires java.sql;
	requires mysql.connector.java;
	
	opens application;
	opens view;
	opens controller;
	opens model.entities;
}