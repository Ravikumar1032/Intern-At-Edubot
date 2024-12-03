import React, { useState } from 'react';
import { Navigate } from 'react-router-dom'; // Import Navigate for redirection
import ModalBox from './ModalBox'; // Adjust the path as per your file structure
import './PasswordGenerator.css';

const PasswordGenerator = () => {
  const [password, setPassword] = useState('');
  const [passwordLength, setPasswordLength] = useState(12);
  const [includeUpperCase, setIncludeUpperCase] = useState(true);
  const [includeLowerCase, setIncludeLowerCase] = useState(true);
  const [includeNumbers, setIncludeNumbers] = useState(true);
  const [includeSpecialChars, setIncludeSpecialChars] = useState(true);
  const [includeDuplicates, setIncludeDuplicates] = useState(false);
  const [attempts, setAttempts] = useState(0);
  const MAX_ATTEMPTS = 5;
  const [showModal, setShowModal] = useState(false);
  const [showMaxAttemptsMessage, setShowMaxAttemptsMessage] = useState(false);

  const generatePassword = () => {
    const chars = generateCharset();
    let newPassword = '';
    let usedChars = '';
    for (let i = 0; i < passwordLength; i++) {
      let randomChar = chars.charAt(Math.floor(Math.random() * chars.length));
      if (!includeDuplicates) {
        while (usedChars.includes(randomChar)) {
          randomChar = chars.charAt(Math.floor(Math.random() * chars.length));
        }
        usedChars += randomChar;
      }
      newPassword += randomChar;
    }
    setPassword(newPassword);
  };

  const generateCharset = () => {
    let charset = '';
    if (includeUpperCase) charset += 'ABCDEFGHIJKLMNOPQRSTUVWXYZ';
    if (includeLowerCase) charset += 'abcdefghijklmnopqrstuvwxyz';
    if (includeNumbers) charset += '0123456789';
    if (includeSpecialChars) charset += '!@#$%^&*()_+';
    return charset;
  };

  const copyToClipboard = () => {
    navigator.clipboard.writeText(password);
    alert('Password copied to clipboard!');
  };

  const handleLengthChange = (e) => {
    const length = parseInt(e.target.value);
    setPasswordLength(length);
  };

  const handleCheckboxChange = (e) => {
    const { id, checked } = e.target;
    switch (id) {
      case 'upperCase':
        setIncludeUpperCase(checked);
        break;
      case 'lowerCase':
        setIncludeLowerCase(checked);
        break;
      case 'numbers':
        setIncludeNumbers(checked);
        break;
      case 'specialChars':
        setIncludeSpecialChars(checked);
        break;
      case 'includeDuplicates':
        setIncludeDuplicates(checked);
        break;
      default:
        break;
    }
  };

  const handleGenerateClick = () => {
    if (attempts >= MAX_ATTEMPTS) {
      setShowModal(true);
      return;
    }
   
    generatePassword();
    setAttempts(attempts + 1);

    if (attempts  >= MAX_ATTEMPTS) {
      alert("You have reached the maximum login attempts. If you want more chances to login.");
      setShowMaxAttemptsMessage(true);
    }
  };

  const closeModal = () => {
    setShowModal(false);
    setAttempts(0); // Reset attempts after modal is closed
    setShowMaxAttemptsMessage(false); // Hide max attempts message after modal is closed
  };

  // Redirect to login page after 5 attempts
  if (attempts >= MAX_ATTEMPTS) {
    alert("You reach max attempt please login.");
    return <Navigate to="/login" />;
  }

  return (
    <div className="password-generator-container">
      <h2 className='header'>Random Password Generator App</h2><br />
      <div className="password-display">
        <input type="text" value={password} readOnly />
        <button onClick={copyToClipboard}>Copy</button>
      </div>

      <div className="password-controls">
        <center><label>Password Length:</label></center>
        <input
          id="pass-range"
          type="range"
          min="6"
          max="20"
          value={passwordLength}
          onChange={handleLengthChange}
        />
        <span>{passwordLength}</span>
      </div>

      <div className="checkbox-group">
        <label>
          <input
            id="upperCase"
            type="checkbox"
            className="styled-checkbox"
            checked={includeUpperCase}
            onChange={handleCheckboxChange}
          />
          Include Uppercase Letters
        </label>
        
        <label>
          <input
            id="lowerCase"
            type="checkbox"
            className="styled-checkbox"
            checked={includeLowerCase}
            onChange={handleCheckboxChange}
          />
          Include Lowercase Letters
        </label>

        <label>
          <input
            id="numbers"
            type="checkbox"
            className="styled-checkbox"
            checked={includeNumbers}
            onChange={handleCheckboxChange}
          />
          Include Numbers
        </label>

        <label>
          <input
            id="specialChars"
            type="checkbox"
            className="styled-checkbox"
            checked={includeSpecialChars}
            onChange={handleCheckboxChange}
          />
          Include Special Characters
        </label>
        
        <label>
          <input
            id="includeDuplicates"
            type="checkbox"
            className="styled-checkbox"
            checked={includeDuplicates}
            onChange={handleCheckboxChange}
          />
          Include Duplicates
        </label>
      </div>
      <br/>

      <button
        className="generate-button"
        onClick={handleGenerateClick}
        disabled={attempts >= MAX_ATTEMPTS}
      >
        Generate Password
      </button>

      {showMaxAttemptsMessage && (
        <p style={{ color: 'red' }}>You have reached the maximum attempts limit.</p>
      )}

      <p>Attempts: {attempts} / {MAX_ATTEMPTS}</p>

      <ModalBox isOpen={showModal} onClose={closeModal} />
    </div>
  );
};

export default PasswordGenerator;
