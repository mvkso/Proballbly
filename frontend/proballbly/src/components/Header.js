import React, {useState} from "react";
import "./css/Header.css"
import logo from '../logo_black.png';
import {Link, useHistory} from "react-router-dom";
import authentication from "../scripts/authentication";
import Hamburger from 'hamburger-react'
import Nav from "./Navigation";

const Header = ({loggedUser, setLoggedUser}) => {
     
      const history = useHistory();
      const [isOpen, setOpen] = useState(false)

      
      
    

        console.log(isOpen)
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
                   
                <div className="logout-panel">
                    <Link className="logout-link" to="/"
                           onClick={ () => {
                               authentication.logout();
                               setLoggedUser(null);
                           }}>Logout</Link>
                </div>
                
            </div> }
            <Hamburger toggled={isOpen} toggle={setOpen} />
                <div className={ isOpen ? "navbar-open" : "navbar-close"}>
                {loggedUser && <div className="hamburger-text-panel">Hi, {loggedUser && loggedUser.username.toUpperCase()}!</div>}
                {!loggedUser && <div className="hamburger-text-panel"><Link to="login" className="linktext">Join us today!</Link></div>}
                
                <div className={loggedUser ? "links" : "links-unlogged"}>
                    
                <Link to="/" >Strona główna</Link>   
              <Link to="/bpl">Premier League</Link>
              <Link to="laliga">La Liga</Link>
              <Link to="bundesliga">Bundesliga</Link>
              <Link to="ligue1">Ligue 1</Link>
              <Link to="allteams" >All teams</Link>
              {loggedUser && loggedUser.roles[0] === "ROLE_ADMIN" && <Link to="adminpanel">Admin panel</Link>}
              <Link to="/" onClick={ () => {
                               authentication.logout();
                               setLoggedUser(null);
                           }}>Logout</Link>

               
               </div>
                </div>
      </header>
      );

}
export default Header;
  
