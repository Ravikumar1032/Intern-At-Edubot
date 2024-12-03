// src/Components/UsersData/usersData.js

let UsersData = [
  {
    id: 1,
    username: "Mouli",
    email: "moulii@gmail.com",
    password: "password",
  },
  {
    id: 2,
    username: "Ravikumar",
    email: "ravi@gmail.com",
    password: "password",
  },
  {
    id: 3,
    username: "testing",
    email: "test@gmail.com",
    password: "1",
  },
];

const addUser = (formData) => {
  const newUser = {
    id: UsersData.length + 1,
    username: formData.username,
    email: formData.email,
    password: formData.password,
  };

  UsersData.push(newUser);
};

export { UsersData, addUser }; // Export UsersData and addUser functions
