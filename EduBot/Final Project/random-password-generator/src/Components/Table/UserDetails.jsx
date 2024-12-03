import React from 'react';
import Table from 'react-bootstrap/Table';
import { useNavigate } from 'react-router-dom';
import './UserDetails.css';

const UserDetails = ({ users, tableWidth, isLoggedIn }) => {
  const navigate = useNavigate();

  const handleRowClick = (userId) => {
    navigate(`/user/${userId}`);
  };

  // Render user details if logged in
  return (
    <div className="user-details-container" style={{ width: tableWidth }}>
      <Table className="user-details-table" striped bordered hover>
        <thead>
          <tr>
            <th>User ID</th>
            <th>Username</th>
            <th>Email</th>
          </tr>
        </thead>
        <tbody>
          {users.map((user) => (
            <tr key={user.id} onClick={() => handleRowClick(user.id)} style={{ cursor: 'pointer' }}>
              <td>{user.id}</td>
              <td>{user.username}</td>
              <td>{user.email}</td>
            </tr>
          ))}
        </tbody>
      </Table>
    </div>
  );
};

export default UserDetails;
