import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import App from './App';
import 'bootstrap/dist/css/bootstrap.min.css';
import { BrowserRouter as Router, Route, Link, Routes, BrowserRouter} from "react-router-dom";
import LoginPage from './component/LoginPage';
import RegisterPage from './component/RegisterPage';

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <React.StrictMode>
    <BrowserRouter>    
      <Routes>
        <Route exact path="/login" element = {<LoginPage/>} />
        <Route exact path="/home" element = {<App/>} />
        <Route exact path="/register" element = {<RegisterPage/>} />
      </Routes>
    </BrowserRouter>
  </React.StrictMode>
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals

