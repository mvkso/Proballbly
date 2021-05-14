import React from "react";
import {Link} from "react-router-dom";
import "./Navigation.css"

const Nav = () => {
  return (
      <nav className="navbar">
          <div className="links">
              <Link to="/" style={{marginLeft: "0px"}}>Strona główna</Link>
              <Link to="/bpl">Premier League</Link>
              <Link to="laliga">La Liga</Link>
              <Link to="bundesliga">Bundesliga</Link>
              <Link to="ligue1" style={{marginRight: "0px"}}>Ligue 1</Link>
          </div>
      </nav>
  )

}

export default Nav;

