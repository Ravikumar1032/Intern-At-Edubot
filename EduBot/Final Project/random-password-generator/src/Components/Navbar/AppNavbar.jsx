import React from 'react';
import { Navbar, Nav, Container } from 'react-bootstrap';
import { LinkContainer } from 'react-router-bootstrap';
import './AppNavbar.css';  // Import the CSS file

const AppNavbar = ({ isAuthenticated }) => {
  return (
    <Navbar bg="dark" variant="dark" expand="lg">
      <Container>
        <LinkContainer to="/">
          <Navbar.Brand>MyApp</Navbar.Brand>
        </LinkContainer>

        <Navbar.Toggle aria-controls="basic-navbar-nav" />
        <Navbar.Collapse id="basic-navbar-nav">
          <Nav className="ml-auto">
          <LinkContainer to="/userdetails">
              <Nav.Link>User Details</Nav.Link>
            </LinkContainer>
            <LinkContainer to="/user/:userId">
              <Nav.Link>User Detail Page</Nav.Link>
            </LinkContainer>
            
            {isAuthenticated && (
              <LinkContainer to="/password-generator">
                <Nav.Link>Password Generator</Nav.Link>
              </LinkContainer>
            )}

            {!isAuthenticated && (
              <>
                <LinkContainer to="/login">
                  <Nav.Link>Login</Nav.Link>
                </LinkContainer>
                <LinkContainer to="/signup">
                  <Nav.Link>Sign Up</Nav.Link>
                </LinkContainer>
              </>
            )}
            <LinkContainer to="/login">
                  <Nav.Link>Logout</Nav.Link>
                </LinkContainer>
          </Nav>
        </Navbar.Collapse>
      </Container>
    </Navbar>
  );
};

export default AppNavbar;
