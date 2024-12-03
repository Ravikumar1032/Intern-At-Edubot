import React, { useState } from 'react';
import { Link, useNavigate } from 'react-router-dom';
import '@fortawesome/fontawesome-free/css/all.min.css';
import 'bootstrap/dist/css/bootstrap.min.css';
import './SignUpForm.css';

// Import the addUser function and UsersData array from usersData.js
import { addUser, UsersData } from '../UsersData/usersData';

const SignUpForm = () => {
  const [formData, setFormData] = useState({
    username: '',
    email: '',
    password: '',
    agreeTerms: false,
  });
  const [validated, setValidated] = useState(false);
  const [errorMessage, setErrorMessage] = useState('');
  const [buttonDisabled, setButtonDisabled] = useState(false); // State to disable button
  const navigate = useNavigate();

  const handleInputChange = (e) => {
    const { id, value, type, checked } = e.target;
    setFormData((prevData) => ({
      ...prevData,
      [id]: type === 'checkbox' ? checked : value,
    }));
  };

  const handleSubmit = (event) => {
    event.preventDefault();
    const form = event.currentTarget;
    const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;

    if (form.checkValidity() === false) {
      event.stopPropagation();
    } else if (!emailRegex.test(formData.email)) {
      setErrorMessage('Please enter a valid email address.');
      setButtonDisabled(true);
      return;
    } else {
      // Check if username or email already exists
      if (UsersData.some(user => user.username === formData.username || user.email === formData.email)) {
        setButtonDisabled(true); // Disable button if user exists
        setErrorMessage('Username or email already exists. Please choose another.');
        return;
      }

      // Add user to UsersData
      addUser(formData);

      // Reset form and state after successful signup
      setFormData({
        username: '',
        email: '',
        password: '',
        agreeTerms: false,
      });
      setValidated(true);
      setButtonDisabled(false);
      setErrorMessage(''); // Clear any previous error message

      // Redirect to login page with form data
      navigate('/login');
    }
  };

  return (
    <div className="container">
      <div className="myCard">
        <div className="row">
          <div className="col-md-6">
            <div className="myLeftCtn">
              <form
                className={`myForm text-center needs-validation ${validated ? 'was-validated' : ''}`}
                noValidate
                onSubmit={handleSubmit}
              >
                <header>Create new account</header>
                {errorMessage && <div className="alert alert-danger">{errorMessage}</div>}
                <div className="form-group">
                  <i className="fas fa-user"></i>
                  <input
                    className="myInput"
                    type="text"
                    placeholder="Username"
                    id="username"
                    value={formData.username}
                    onChange={handleInputChange}
                    required
                  />
                  <div className="invalid-feedback">Please fill out this field.</div>
                </div>
                <div className="form-group">
                  <i className="fas fa-envelope"></i>
                  <input
                    className="myInput"
                    type="email"
                    placeholder="Email"
                    id="email"
                    value={formData.email}
                    onChange={handleInputChange}
                    required
                  />
                  <div className="invalid-feedback">Please fill out this field.</div>
                </div>
                <div className="form-group">
                  <i className="fas fa-lock"></i>
                  <input
                    className="myInput"
                    type="password"
                    id="password"
                    placeholder="Password"
                    value={formData.password}
                    onChange={handleInputChange}
                    required
                  />
                  <div className="invalid-feedback">Please fill out this field.</div>
                </div>
                <div className="form-group">
                  <label>
                    <input
                      id="agreeTerms"
                      type="checkbox"
                      checked={formData.agreeTerms}
                      onChange={handleInputChange}
                      required
                    />
                    <small> I read and agree to Terms & Conditions</small>
                    <div className="invalid-feedback">You must check the box.</div>
                  </label>
                </div>
                <input
                  type="submit"
                  className="butt"
                  value="CREATE ACCOUNT"
                  disabled={buttonDisabled}
                />
                <div className="mt-3">
                  <small>
                    If you already have an account, <Link to="/login">Login</Link>
                  </small>
                </div>
              </form>
            </div>
          </div>
          <div className="col-md-6">
            <div className="myRightCtn">
              <div className="box">
                <header>Welcome to the Random Password Generator App</header>
                <p>
                  Our mission is to make your digital life safer. Thank you for choosing our Random Password Generator App. Stay secure and protected with our reliable password solutions.
                </p>
                <input type="button" className="butt_out" value="Learn More" />
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
};

export default SignUpForm;
