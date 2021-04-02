import React from "react";
import "./Navigation.css"

export default class Nav extends React.Component {

  render() {
    return (
      <div className="league-bar">
            <button className="main-button">Premier League</button>
            <button className="main-button">La Liga</button>
            <button className="main-button">Ekstraklasa</button>
            <button className="main-button">LM</button>
      </div>
    );
  }
}