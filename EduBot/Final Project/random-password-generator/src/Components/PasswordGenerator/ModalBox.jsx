// ModalBox.jsx
import React from 'react';
import Modal from 'react-modal';
import './ModalBox.css';

const ModalBox = ({ isOpen, onClose }) => {
  return (
    <Modal
      isOpen={isOpen}
      onRequestClose={onClose}
      contentLabel="Login Modal"
      className="modal"
      overlayClassName="overlay"
    >
      <div className="modal-content">
        <button className="close" onClick={onClose}>&times;</button>
        <h2>Login</h2>
        <form>
          <label>
            Username:
            <input type="text" name="username" />
          </label>
          <br />
          <label>
            Password:
            <input type="password" name="password" />
          </label>
          <br />
          <button type="submit">Login</button>
        </form>
      </div>
    </Modal>
  );
};

export default ModalBox;
