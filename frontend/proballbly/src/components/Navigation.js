import React, {useState} from "react";
import {Link} from "react-router-dom";
import "./css/Navigation.css"


const Nav = ({loggedUser}) => {

  const [isOpen, setOpen] = useState(true)
    
  return (
      <nav className= {isOpen ? "navbar" : "navbar-close"}>
              { loggedUser && <div className= { isOpen ? "links" : "link-close"}>
              <Link to="/" >Strona główna</Link>   
              <Link to="/bpl">Premier League</Link>
              <Link to="laliga">La Liga</Link>
              <Link to="bundesliga">Bundesliga</Link>
              <Link to="ligue1">Ligue 1</Link>
              <Link to="allteams" >All teams</Link>
               {loggedUser && loggedUser.roles[0] === "ROLE_ADMIN" && <Link to="adminpanel">Admin panel</Link>}
              </div>
            }
              {!loggedUser && <div className="links">
              <Link to="login">Log in</Link>
                  </div>}
          
      </nav>
  )

}

export default Nav;

