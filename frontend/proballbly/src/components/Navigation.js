import React from "react";
import {Link} from "react-router-dom";
import "./css/Navigation.css"

const Nav = () => {
  return (
      <nav className="navbar">
          <div className="links">
              <Link to="/" style={{marginLeft: "0px"}}>Strona główna</Link>
              <Link to="/bpl">Premier League</Link>
              <Link to="laliga">La Liga</Link>
              <Link to="bundesliga">Bundesliga</Link>
              <Link to="ligue1">Ligue 1</Link>
              <Link to="allteams" style={{marginRight: "0px"}}>All teams</Link>
          </div>
      </nav>
  )

}

export default Nav;

