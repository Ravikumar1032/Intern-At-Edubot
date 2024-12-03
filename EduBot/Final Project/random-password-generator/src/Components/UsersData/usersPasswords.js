// usersPasswords.js

// Function to generate a random password
function generateRandomPassword() {
  const length = 12; // Length of the generated password
  const charset = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%^&*()_+~`|}{[]:;?><,./-=";
  let password = "";
  for (let i = 0; i < length; i++) {
    const randomIndex = Math.floor(Math.random() * charset.length);
    password += charset[randomIndex];
  }
  return password;
}

// Array of users with random passwords
const UsersPasswords = [
  {
    userId: 1,
    passwords: [
      { id: 1, password: generateRandomPassword() },
      { id: 2, password: generateRandomPassword() },
      { id: 3, password: generateRandomPassword() },
    ]
  },
  {
    userId: 2,
    passwords: [
      { id: 4, password: generateRandomPassword() },
      { id: 5, password: generateRandomPassword() },
      { id: 6, password: generateRandomPassword() },
    ]
  },
  {
    userId: 3,
    passwords: [
      { id: 7, password: generateRandomPassword() },
      { id: 8, password: generateRandomPassword() },
      { id: 9, password: generateRandomPassword() },
    ]
  }
];

// Function to add a password for a user
const addPasswordForUser = (userId, newPassword) => {
  const userPasswords = UsersPasswords.find(user => user.userId === userId);
  if (userPasswords) {
    const newId = userPasswords.passwords.length > 0 
      ? Math.max(...userPasswords.passwords.map(p => p.id)) + 1 
      : 1;
    userPasswords.passwords.push({ id: newId, password: newPassword });
  } else {
    UsersPasswords.push({
      userId,
      passwords: [{ id: 1, password: newPassword }],
    });
  }
};

// Function to delete a password for a user
const deletePasswordForUser = (userId, passwordId) => {
  const userPasswords = UsersPasswords.find(user => user.userId === userId);
  if (userPasswords) {
    userPasswords.passwords = userPasswords.passwords.filter(password => password.id !== passwordId);
  }
};

export { UsersPasswords, addPasswordForUser, deletePasswordForUser };
