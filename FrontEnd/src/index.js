/*
 * FILENAME:        index.js
 * AUTHOR:          Ethan Harness, Karl Devlin
 * VERSION:         1.0
 * DATE:            10/10/2022
 * SPECIFICATION:   This is where our root is housed in order to run and render 
 *                  the frontend aspects of the application.
 * CLASS:           CS 3368 Introduction to Artificial Intelligence Section 001
 */
import React from "react";
import ReactDOM from "react-dom/client";
import "./index.css";
import App from "./App";
import reportWebVitals from "./reportWebVitals";
import { store } from "./store/store";
import { Provider } from "react-redux";
import { Route, BrowserRouter, Routes } from "react-router-dom";

//Root renders our appliaction as well as provides the redux store to the application
const root = ReactDOM.createRoot(document.getElementById("root"));
root.render(
  <Provider store={store}>
    <App />
  </Provider>
);

reportWebVitals();
