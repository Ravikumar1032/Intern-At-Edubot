import React, { useState, useEffect } from 'react';
import Table from 'react-bootstrap/Table';
import { UsersPasswords } from '../UsersData/usersPasswords';
import { UsersData } from '../UsersData/usersData';  // Import UsersData
import './UserDetailPage.css';

const UserDetailPage = ({ userId }) => {
  const [passwords, setPasswords] = useState([]);
  const [username, setUsername] = useState('');  // State for storing the username

  useEffect(() => {
    // Fetch passwords for the specific user
    const userPasswords = UsersPasswords.find(user => user.userId === userId);
    setPasswords(userPasswords?.passwords || []);

    // Fetch username for the specific user
    const user = UsersData.find(user => user.id === userId);
    setUsername(user?.username || '');  // Set username if found
  }, [userId]);

  return (
    <div className="user-details-container">
      <h2>{username} Generated Passwords</h2>
      <Table striped bordered hover className="user-details-table">
        <thead>
          <tr>
            <th>ID</th>
            <th>Password</th>
          </tr>
        </thead>
        <tbody>
          {passwords.map(password => (
            <tr key={password.id}>
              <td>{password.id}</td>
              <td>{password.password}</td>
            </tr>
          ))}
        </tbody>
      </Table>
    </div>
  );
};

export default UserDetailPage;
