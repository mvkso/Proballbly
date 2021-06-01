import React, {useState, useRef} from "react";
import { useHistory } from "react-router-dom";
import Authentication from "../scripts/authentication";
import "./css/Signup.css"

const Signup = (props) => {
    const togglePanel = () => {
        history.push("/");
      };

    const form = useRef();
    const checkBtn = useRef();
    const history = useHistory();
    const [username, setUsername] = useState("");
    const [register_usernamme,setRegisterUsername] = useState("");
    const [register_password,setRegisterPassword] = useState("")
    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");
    const [successful, setSuccessful] = useState(false);
    const [message, setMessage] = useState("");
    const [registerToggle, setRegisterToggle] = useState(false);
    const [loginToggle, setLoginToggle] = useState(true);


      const onClickButton = () => {
        setLoginToggle(!loginToggle);
        setRegisterToggle(!registerToggle);
        
      }
    
      const onChangeUsername = (e) => {
        const username = e.target.value;
        setUsername(username);
      };
    
      const onChangeRegisterUsername = (e) => {
        const register_username = e.target.value;
        setRegisterUsername(register_username);
      };

      const onChangeRegisterPassword = (e) => {
        const register_password = e.target.value;
        setRegisterPassword(register_password);
      };


      const onChangeEmail = (e) => {
        const email = e.target.value;
        setEmail(email);
      };
    
      const onChangePassword = (e) => {
        const password = e.target.value;
        setPassword(password);
      };
    
      const handleRegister = (e) => {
        e.preventDefault();
    
        setMessage("");
        setSuccessful(false);

        
      Authentication.register(register_usernamme, email, register_password).then(
        (response) => {
          setMessage(response.data.message);
          setSuccessful(true);
          alert("Udana rejestracja. Przeniesienie na stronę logowania");
          history.push("/login");
          window.location.reload();
        },
        (error) => {
          const resMessage =
            (error.response &&
              error.response.data &&
              error.response.data.message) ||
            error.message ||
            error.toString();
            alert("Błąd z rejestracją. Powrót na stronę glówną");
            history.push('/');
          setMessage(resMessage);
          setSuccessful(false);
        }
      );
    };

    const handleLogin = (e) => {
      e.preventDefault();
        Authentication.login(username, password).then(
          () => {
            props.setLoggedUser(Authentication.getCurrentUser());
            alert("Udane logowanie. Przeniesienie na stronę głowna");
            history.push("/");
            window.location.reload();
          },
          (error) => {
            const resMessage =
              (error.response &&
                error.response.data &&
                error.response.data.message) ||
              error.message ||
              error.toString();
              alert("Błąd logowania");
              setMessage(resMessage);
              setSuccessful(false);
          }
        );
    };

      return(
            <section className="signup-section">
                <div class="login-page">
  <div class="form-login">
    {registerToggle ? <form class="register-form" onSubmit={handleRegister} >
      <input id='username' type="username" name="username" placeholder="username" onChange={onChangeRegisterUsername} value={register_usernamme}/>
      <input id="password" type="password" name="password" placeholder="password" onChange={onChangeRegisterPassword} value={register_password}/>
      <input id="email" type="email" placeholder="email address" onChange={onChangeEmail} value={email}/>
      <button type='submit'>create</button>
      <p class="message" >Already registered? <a onClick={onClickButton}>Sign In</a></p>
    </form> :null}
    {loginToggle?
    <form class="login-form" onSubmit={handleLogin}>
      <input id='username' type="username" name="username" placeholder="username" onChange={onChangeUsername} value={username}/>
      <input id="password" type="password" name="password" placeholder="password" onChange={onChangePassword} value={password}/>
      <button type='submit'>login</button>
      <p class="message" >Not registered? <a onClick={onClickButton}>Create an account</a></p>
    </form>:null}
  </div>
</div>
               
            </section>
      );
    
};
export default Signup;