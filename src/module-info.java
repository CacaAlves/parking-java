module Parking {
	requires javafx.fxml;
	requires javafx.controls;
	requires javafx.graphics;
	requires javafx.web;
	requires javafx.base;
	
	opens application;
	opens view;
	opens controller;
//	opens model;
}