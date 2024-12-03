// Navbar.js
import React from 'react';
import 'bootstrap/dist/css/bootstrap.min.css';

const Navbar = ({ onSignUpClick, onLoginClick }) => {
  return (
    <nav className="navbar navbar-expand-lg navbar-light bg-light">
      <span className="navbar-brand">Password Generator</span>
      <div className="collapse navbar-collapse" id="navbarNav">
        <ul className="navbar-nav ml-auto">
          <li className="nav-item">
            <button className="btn btn-primary" onClick={onSignUpClick}>Sign Up</button>
          </li>
          <li className="nav-item">
            <button className="btn btn-secondary" onClick={onLoginClick}>Login</button>
          </li>
        </ul>
      </div>
    </nav>
  );
};

export default Navbar;
