import React from "react";
import "./css/Header.css"
import logo from '../logo_black.png';
import {Link, useHistory} from "react-router-dom";
import authentication from "../scripts/authentication";

const Header = ({loggedUser, setLoggedUser}) => {
     
      const history = useHistory();
    

      const goToUserProfilePage = () => {
            history.push('/');
        }
    

      return(
     <header className="header">Proballbly
           { !loggedUser &&
               <div className="links-account">
                   <Link to="login" className="linktext">Join us today!</Link>
               </div>
            }
            { loggedUser &&
            <div className="loggedPanel">
                <div className="text-panel">Hi, {loggedUser && loggedUser.username.toUpperCase()}!</div>
                    <img src="/account.png" alt="account icon" onClick={goToUserProfilePage}/>
                <div className="logout-panel">
                    <Link className="logout-link" to="/"
                           onClick={ () => {
                               authentication.logout();
                               setLoggedUser(null);
                           }}>Logout</Link>
                </div>
            </div> }
      </header>
      );

}
export default Header;
  
