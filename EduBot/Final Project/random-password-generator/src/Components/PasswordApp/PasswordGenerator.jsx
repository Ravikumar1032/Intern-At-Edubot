import React, { useState } from 'react';
import { addPasswordForUser } from '../UsersData/usersPasswords';
import './PasswordGenerator.css';

const PasswordGenerator = ({ userId }) => {
  const [password, setPassword] = useState('');
  const [passwordLength, setPasswordLength] = useState(12);
  const [includeUpperCase, setIncludeUpperCase] = useState(true);
  const [includeLowerCase, setIncludeLowerCase] = useState(true);
  const [includeNumbers, setIncludeNumbers] = useState(true);
  const [includeSpecialChars, setIncludeSpecialChars] = useState(true);
  const [includeDuplicates, setIncludeDuplicates] = useState(false);

  const generatePassword = () => {
    const charset = generateCharset();
    let newPassword = '';
    let usedChars = '';
    for (let i = 0; i < passwordLength; i++) {
      let randomChar = charset.charAt(Math.floor(Math.random() * charset.length));
      if (!includeDuplicates) {
        while (usedChars.includes(randomChar)) {
          randomChar = charset.charAt(Math.floor(Math.random() * charset.length));
        }
        usedChars += randomChar;
      }
      newPassword += randomChar;
    }
    setPassword(newPassword);
    addPasswordForUser(userId, newPassword); // Add password to UsersPasswords
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
          Allow Duplicate Characters
        </label>
      </div>

      <button 
        className='generate-button'
        onClick={generatePassword}
      >
        Generate Password
      </button>
    </div>
  );
};

export default PasswordGenerator;
