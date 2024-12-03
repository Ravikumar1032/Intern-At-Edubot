import React, { useState } from 'react';
import { Link, useNavigate } from 'react-router-dom';
import '@fortawesome/fontawesome-free/css/all.min.css';
import 'bootstrap/dist/css/bootstrap.min.css';
import './LoginForm.css';

// Import UsersData from usersData.js
import { UsersData } from '../UsersData/usersData';

const LoginForm = ({ onLoginSuccess }) => {
  const navigate = useNavigate();

  const [validated, setValidated] = useState(false);
  const [emailError, setEmailError] = useState('');
  const [passwordError, setPasswordError] = useState('');
  const [loginMessage, setLoginMessage] = useState({ message: '', color: '' });

  const validateForm = (event) => {
    event.preventDefault();
    event.stopPropagation();

    const form = event.currentTarget;
    const email = form.email.value.trim();
    const password = form.password.value.trim();

    let valid = true;

    // Email validation
    const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]{2,}$/;
    if (!emailRegex.test(email)) {
      setEmailError('Please enter a valid email address.');
      valid = false;
    } else {
      setEmailError('');
    }

    // Password validation
    if (!password) {
      setPasswordError('Please enter your password.');
      valid = false;
    } else {
      setPasswordError('');
    }

    setValidated(true);

    if (valid) {
      // Check if the email and password match the data in UsersData
      const user = UsersData.find((user) => user.email === email && user.password === password);

      if (user) {
        setLoginMessage({ message: 'Login successful!', color: 'green' });
        onLoginSuccess(user); // Pass the user object to the parent component
        setTimeout(() => {
          navigate('/password-generator'); // Redirect to PasswordGenerator.jsx component
        }, 1000);
      } else {
        setLoginMessage({ message: 'Invalid email or password', color: 'red' });
      }
    }
  };

  return (
    <div className="container">
      <div className="myCard">
        <div className="row">
          <div className="col-md-6">
            <div className="myRightCtn">
              <div className="box">
                <header>Welcome to the Random Password Generator App</header>
                <p>
                  Welcome to our Random Password Generator App! In today's digital age, securing your online presence is more important than ever. Our application is designed to help you create strong, random passwords to keep your accounts safe and secure. Whether you're setting up a new account or updating an existing password, our generator provides you with unique, complex passwords that are hard to crack.
                </p>
                <input type="button" className="butt_out" value="Learn More" />
              </div>
            </div>
          </div>
          <div className="col-md-6">
            <div className="myLeftCtn">
              <form
                className={`myForm text-center ${validated ? 'was-validated' : ''}`}
                noValidate
                onSubmit={validateForm}
              >
                <header>Login</header>
                <div className="form-group">
                  <i className="fas fa-envelope"></i>
                  <input
                    className="myInput"
                    type="email"
                    name="email"
                    placeholder="Email"
                    required
                  />
                  <div className="invalid-feedback">{emailError || 'Please fill out this field.'}</div>
                </div>
                <div className="form-group">
                  <i className="fas fa-lock"></i>
                  <input
                    className="myInput"
                    type="password"
                    name="password"
                    placeholder="Password"
                    required
                  />
                  <div className="invalid-feedback">{passwordError || 'Please fill out this field.'}</div>
                </div>
                <input type="submit" className="butt" value="LOGIN" />
                <div className="mt-3">
                  <small>
                    If you don't have an account, <br /><Link to="/signup">Create new account</Link>
                  </small>
                </div>
              </form>
              {loginMessage.message && (
                <div className="alert mt-3" style={{ color: loginMessage.color }}>
                  {loginMessage.message}
                </div>
              )}
            </div>
          </div>
        </div>
      </div>
    </div>
  );
};

export default LoginForm;
