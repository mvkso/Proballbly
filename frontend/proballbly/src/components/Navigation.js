import React from "react";
import {Link} from "react-router-dom";
import "./css/Navigation.css"

const Nav = ({loggedUser}) => {

    
  return (
      <nav className="navbar">
          
              { loggedUser && <div className="links">
              <Link to="/" style={{marginLeft: "0px"}}>Strona główna</Link>
              <Link to="/bpl">Premier League</Link>
              <Link to="laliga">La Liga</Link>
              <Link to="bundesliga">Bundesliga</Link>
              <Link to="ligue1">Ligue 1</Link>
              <Link to="allteams" >All teams</Link>
              <Link to="twitter" >Twitter news</Link>
               {loggedUser && loggedUser.roles[0] === "ROLE_USER" && <Link to="adminpanel">Admin panel</Link>}
              </div>
            }
              {!loggedUser && <div className="links">
                  <Link to="login"> Log in to see navigation bar</Link>
                  </div>}
          
      </nav>
  )

}

export default Nav;

