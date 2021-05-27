import axios from "axios";

const API_URL = "http://localhost:8080/api/auth/";

const authenticationHeader = () => {
    const user = JSON.parse(localStorage.getItem('user'));
  
    if (user && user.accessToken) {
      return { Authorization: 'Bearer ' + user.accessToken }; 
    } else {
      return {};
    }
}


const register = (username, email, password) => {
  return axios.post(API_URL + "signup", {
    username,
    email,
    password,
  });
};

const login = (username, password) => {
  return axios
    .post(API_URL + "signin", {
      username,
      password,
    })
    .then((response) => {
      if (response.data.accessToken) {
        localStorage.setItem("user", JSON.stringify(response.data));
      }
      return response.data;
    });
};

const logout = () => {
  localStorage.removeItem("user");
  console.log("usuwam token")
};

const getCurrentUser = () => {
  return JSON.parse(localStorage.getItem("user"));
};

export default {
  authenticationHeader,
  register,
  login,
  logout,
  getCurrentUser,
};