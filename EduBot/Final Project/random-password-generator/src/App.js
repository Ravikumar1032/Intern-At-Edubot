import React, { useState } from 'react';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import 'bootstrap/dist/css/bootstrap.min.css';
import LoginForm from './Components/LoginForm/LoginForm';
import SignUpForm from './Components/SignUpForm/SignUpForm';
import UserDetails from './Components/Table/UserDetails';
import UserDetailPage from './Components/Table/UserDetailPage';
import AppNavbar from './Components/Navbar/AppNavbar';
import PasswordGenerator from './Components/PasswordGenerator/PasswordGenerator';
import PasswordApp from './Components/PasswordApp/PasswordGenerator';
import { UsersData, addUser } from './Components/UsersData/usersData';
import ProtectedRoute from './Components/ProtectedRoute/ProtectedRoute';

const App = () => {
  const [users, setUsers] = useState(UsersData);
  const [isLoggedIn, setIsLoggedIn] = useState(false);

  const handleSignUp = (formData) => {
    addUser(formData);
    setUsers([...users, formData]);
  };

  const handleLoginSuccess = () => {
    setIsLoggedIn(true);
  };

  return (
    <Router>
      <AppNavbar isAuthenticated={isLoggedIn} />
      <Routes>
        <Route path="/" element={<PasswordGenerator />} />
        <Route path="/login" element={<LoginForm onLoginSuccess={handleLoginSuccess} />} />
        <Route path="/signup" element={<SignUpForm onSignUp={handleSignUp} />} />
        <Route
          path="/userdetails"
          element={
            <ProtectedRoute isLoggedIn={isLoggedIn}>
              <UserDetails users={users} />
            </ProtectedRoute>
          }
        />
        <Route
          path="/user/:userId"
          element={
            <ProtectedRoute isLoggedIn={isLoggedIn}>
              <UserDetailPage users={users} />
            </ProtectedRoute>
          }
        />
        <Route
          path="/password-generator"
          element={
            <ProtectedRoute isLoggedIn={isLoggedIn}>
              <PasswordApp />
            </ProtectedRoute>
          }
        />
      </Routes>
    </Router>
  );
};

export default App;
